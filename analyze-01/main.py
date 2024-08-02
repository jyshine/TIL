import os
import pandas as pd
from datetime import datetime

# 파일이 저장된 디렉토리 경로
directory = '/Users/jun/data/bithumb'

# 결과 파일이 저장될 디렉토리 경로
output_dir = '/Users/jun/dev/analyze-01/data'

# 디렉토리 내에서 'XRP_'로 시작하는 모든 파일 이름 리스트를 가져오기
file_names = [file for file in os.listdir(directory) if file.startswith('XRP_') and file.endswith('.csv')]

# 데이터프레임을 저장할 리스트 초기화
dfs = []

# 각 파일을 읽어 데이터프레임 리스트에 추가
for file_name in file_names:
    file_path = os.path.join(directory, file_name)
    df = pd.read_csv(file_path)
    dfs.append(df)

# 모든 데이터프레임을 하나로 합침
merged_df = pd.concat(dfs, ignore_index=True)

# 'candle_date_time_kst' 열을 기준으로 정렬
merged_df = merged_df.sort_values(by='candle_date_time_kst')

# 현재 날짜와 시간을 가져와 형식 지정
now = datetime.now().strftime('%Y-%m-%d_%H-%M-%S')

# 저장할 디렉토리 경로와 파일명을 결합하여 완전한 파일 경로 생성
output_file = os.path.join(output_dir, f'merged_XRP_data_{now}.csv')

# 합쳐진 데이터를 새로운 CSV 파일로 저장
merged_df.to_csv(output_file, index=False)

print(f"Merged and sorted file saved as {output_file}")
