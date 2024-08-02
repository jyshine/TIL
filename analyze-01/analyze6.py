import os

import pandas as pd
import numpy as np
from sklearn.preprocessing import MinMaxScaler
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import LSTM, Dense, Dropout
from sklearn.metrics import mean_squared_error
import matplotlib.pyplot as plt

output_dir = os.getenv("DIR_OUT")
output_file = os.getenv("FILE_OUT")

# 파일 경로
csv_file_path = output_dir+"/"+output_file

# 데이터 로드
df = pd.read_csv(csv_file_path)

# 'candle_date_time_kst' 열을 datetime 형식으로 변환
df['candle_date_time_kst'] = pd.to_datetime(df['candle_date_time_kst'])

# 시계열 데이터 정렬
df = df.sort_values('candle_date_time_kst')

# 예측할 열 선택
data = df[['trade_price']].copy()

# 데이터 정규화
scaler = MinMaxScaler(feature_range=(0, 1))
data['trade_price'] = scaler.fit_transform(data[['trade_price']])

# 데이터셋 생성 함수
def create_dataset(dataset, look_back=1):
    X, Y = [], []
    for i in range(len(dataset) - look_back - 1):
        a = dataset[i:(i + look_back), 0]
        X.append(a)
        Y.append(dataset[i + look_back, 0])
    return np.array(X), np.array(Y)

# 하이퍼파라미터 설정
look_back = 60  # 과거 60개 데이터 포인트를 기반으로 예측

# 데이터셋 생성
data_values = data['trade_price'].values.reshape(-1, 1)
X, Y = create_dataset(data_values, look_back)

# 데이터셋 분할
split_percent = 0.80
split = int(split_percent * len(X))
X_train = X[:split]
Y_train = Y[:split]
X_test = X[split:]
Y_test = Y[split:]

# 데이터 형태 변경
X_train = X_train.reshape(X_train.shape[0], X_train.shape[1], 1)
X_test = X_test.reshape(X_test.shape[0], X_test.shape[1], 1)

# 모델 구성
model = Sequential([
    LSTM(50, input_shape=(look_back, 1), return_sequences=True),
    Dropout(0.2),
    LSTM(50, return_sequences=False),
    Dropout(0.2),
    Dense(1)
])

# 모델 컴파일
model.compile(optimizer='adam', loss='mean_squared_error')

# 모델 훈련
model.fit(X_train, Y_train, epochs=200, batch_size=128, verbose=1, validation_data=(X_test, Y_test))

# 다음 1시간 후의 값을 예측
next_time_frame = model.predict(X[-1].reshape(1, look_back, 1))

# 예측 결과 역정규화
predicted_price = scaler.inverse_transform(next_time_frame)

print(f'1시간 후 예측된 가격: {predicted_price[0][0]}')
