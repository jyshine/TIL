import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, LSTM, Input
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
        Y.append(dataset[i + look_back, 0])  # trade_price를 예측 대상
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
model.add(LSTM(50, return_sequences=True))
model.add(LSTM(50))
model.add(Dense(1))

# 모델 컴파일
model.compile(optimizer='adam', loss='mean_squared_error')

# 모델 훈련
# model.fit(X_train, Y_train, epochs=20, batch_size=32, verbose=1)
model.fit(X_train, Y_train, epochs=50, batch_size=32, verbose=1)  # 에포크 수 증가

# 예측
train_predict = model.predict(X_train)
test_predict = model.predict(X_test)

# 데이터 역정규화
train_predict = scalers['trade_price'].inverse_transform(train_predict)
Y_train = scalers['trade_price'].inverse_transform([Y_train])
test_predict = scalers['trade_price'].inverse_transform(test_predict)
Y_test = scalers['trade_price'].inverse_transform([Y_test])

# 평가
train_score = np.sqrt(mean_squared_error(Y_train[0], train_predict[:, 0]))
test_score = np.sqrt(mean_squared_error(Y_test[0], test_predict[:, 0]))

print(f'Train RMSE: {train_score}')
print(f'Test RMSE: {test_score}')

# 결과 시각화
train_predict_plot = np.empty_like(data.values)
train_predict_plot[:, :] = np.nan
train_predict_plot[look_back:len(train_predict) + look_back, 0] = train_predict[:, 0]

test_predict_plot = np.empty_like(data.values)
test_predict_plot[:, :] = np.nan
# 적절한 인덱스 범위로 test_predict_plot 수정
test_start = len(train_predict) + (look_back * 2) + 1
test_end = test_start + len(test_predict)
if test_end > len(test_predict_plot):
    test_end = len(test_predict_plot)
    test_predict = test_predict[:(test_end - test_start), :]
test_predict_plot[test_start:test_end, 0] = test_predict[:, 0]

plt.figure(figsize=(14, 8))
plt.plot(df['candle_date_time_kst'], scalers['trade_price'].inverse_transform(data['trade_price'].values.reshape(-1, 1)), label='Actual Prices', color='blue')
plt.plot(df['candle_date_time_kst'], train_predict_plot[:, 0], label='Train Prediction', color='red')
plt.plot(df['candle_date_time_kst'], test_predict_plot[:, 0], label='Test Prediction', color='green')
plt.xlabel('Date Time KST')
plt.ylabel('Trade Price')
plt.title('KRW-XRP Trade Price Prediction with LSTM')
plt.legend()
plt.grid(True)
plt.xticks(rotation=45)
plt.tight_layout()
plt.show()
