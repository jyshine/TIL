from datetime import datetime

import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, LSTM, Dropout, Input
from sklearn.metrics import mean_squared_error
import matplotlib.pyplot as plt

# 파일 경로 설정
csv_file_path = '/Users/jun/dev/analyze-01/data/merged_XRP_data.csv'

# CSV 파일 읽기
df = pd.read_csv(csv_file_path)

# 'candle_date_time_kst' 열을 datetime 형식으로 변환
df['candle_date_time_kst'] = pd.to_datetime(df['candle_date_time_kst'])

# 필요한 열만 선택
data = df[['trade_price', 'candle_acc_trade_volume', 'high_price', 'low_price']].copy()

# 데이터 정규화
scalers = {}
for column in data.columns:
    scalers[column] = MinMaxScaler(feature_range=(0, 1))
    data[column] = data[column].astype('float64')
    data.loc[:, column] = scalers[column].fit_transform(data[column].values.reshape(-1, 1))

# 데이터셋 생성 함수
def create_dataset(dataset, look_back=1):
    X, Y = [], []
    for i in range(len(dataset) - look_back - 1):
        a = dataset[i:(i + look_back), :]
        X.append(a)
        Y.append(dataset[i + look_back, :])  # 모든 특성을 예측 대상
    return np.array(X), np.array(Y)

look_back = 60
X, Y = create_dataset(data.values, look_back)

# 데이터셋 분할
train_size = int(len(X) * 0.8)
test_size = len(X) - train_size
X_train, X_test = X[:train_size], X[train_size:]
Y_train, Y_test = Y[:train_size], Y[train_size:]

# LSTM 입력 형태로 변환 [samples, time steps, features]
X_train = np.reshape(X_train, (X_train.shape[0], X_train.shape[1], X_train.shape[2]))
X_test = np.reshape(X_test, (X_test.shape[0], X_test.shape[1], X_test.shape[2]))

# LSTM 모델 생성
model = Sequential()
model.add(Input(shape=(look_back, X_train.shape[2])))
model.add(LSTM(100, return_sequences=True))  # LSTM 유닛 수 증가
model.add(Dropout(0.3))  # 드롭아웃 비율 증가
model.add(LSTM(100))
model.add(Dropout(0.3))  # 드롭아웃 비율 증가
model.add(Dense(Y_train.shape[1]))  # 출력 노드를 Y_train.shape[1]로 변경하여 모든 특성을 예측

# 모델 컴파일
model.compile(optimizer='adam', loss='mean_squared_error')

# 모델 훈련
model.fit(X_train, Y_train, epochs=100, batch_size=128, verbose=1)  # 에포크 수와 배치 크기 증가

# 예측
train_predict = model.predict(X_train)
test_predict = model.predict(X_test)

# 데이터 역정규화
for i, column in enumerate(data.columns):
    train_predict[:, i] = scalers[column].inverse_transform(train_predict[:, i].reshape(-1, 1)).reshape(-1)
    Y_train[:, i] = scalers[column].inverse_transform(Y_train[:, i].reshape(-1, 1)).reshape(-1)
    test_predict[:, i] = scalers[column].inverse_transform(test_predict[:, i].reshape(-1, 1)).reshape(-1)
    Y_test[:, i] = scalers[column].inverse_transform(Y_test[:, i].reshape(-1, 1)).reshape(-1)

# 평가
train_score = np.sqrt(mean_squared_error(Y_train, train_predict))
test_score = np.sqrt(mean_squared_error(Y_test, test_predict))

print(f'Train RMSE: {train_score}')
print(f'Test RMSE: {test_score}')

# 다음날 시간별 예측 생성
def predict_next_day(model, last_sequence, look_back, steps):
    predictions = []
    current_sequence = last_sequence[-look_back:].reshape((1, look_back, last_sequence.shape[1]))
    for _ in range(steps):
        next_value = model.predict(current_sequence)
        predictions.append(next_value[0])
        current_sequence = np.append(current_sequence[:, 1:, :], [next_value], axis=1)
    return np.array(predictions)

last_sequence = data.values[-look_back:]
next_day_predictions = predict_next_day(model, last_sequence, look_back, steps=24)

# 예측 결과 역정규화
for i, column in enumerate(data.columns):
    next_day_predictions[:, i] = scalers[column].inverse_transform(next_day_predictions[:, i].reshape(-1, 1)).reshape(-1)

# 예측 결과 시각화
fig, axes = plt.subplots(nrows=2, ncols=2, figsize=(20, 14), sharex=True)

features = ['trade_price', 'candle_acc_trade_volume', 'high_price', 'low_price']
colors = ['blue', 'orange', 'green', 'red']

for ax, feature, color in zip(axes.flatten(), features, colors):
    ax.plot(df['candle_date_time_kst'], scalers[feature].inverse_transform(data[feature].values.reshape(-1, 1)), label=f'Actual {feature}', color=color, linewidth=2)
    test_time = df['candle_date_time_kst'].iloc[-len(test_predict):]
    ax.plot(test_time, test_predict[:, features.index(feature)], label=f'Test Prediction {feature}', color='purple', linestyle='dashed')
    next_day_time = pd.date_range(start=df['candle_date_time_kst'].iloc[-1] + pd.Timedelta(hours=1), periods=24, freq='h')
    ax.plot(next_day_time, next_day_predictions[:, features.index(feature)], label=f'Next Day Prediction {feature}', color='black', linestyle='dotted')
    ax.set_title(f'{feature} Prediction', fontsize=16)
    ax.legend(fontsize=14)
    ax.grid(True)
    ax.tick_params(axis='both', which='major', labelsize=14)

fig.suptitle('KRW-XRP Prediction with LSTM', fontsize=22)
fig.autofmt_xdate(rotation=45)
plt.tight_layout(rect=[0, 0, 1, 0.96])


now = datetime.now().strftime('%Y-%m-%d_%H-%M-%S')

# 그래프를 크게 저장
output_path = now+'_prediction_plot.png'  # 현재 디렉토리에 저장
plt.savefig(output_path, bbox_inches='tight')
plt.show()
