# #Hadoop
HDFS 
Hadoop Distributed File System
빅데이터의 저장과 분석을 위한 분산 컴퓨팅 솔루션

더그 커팅이라는 개발자.
하둡의 로고는 노란색 아기 코끼리로 표시한다.
자신의 아이가 가지고 놀던 장남감 코끼리의 이름을 따서 하둡이라고 이름을 지었다. 

빅데이터 : 
한대의 컴퓨터로는 저장하거나 연산하기 어려운  규모의 거대 데이터

분산 : 
여러대의 컴퓨터로 나눠서 일을 처리함.

저장 :
여러대의 컴퓨터에 나눠서 저장한다.

분석 :
데이터가 저장된 컴퓨터에서 데이터를 분석하고 그 결과를 합친다.

가상머신
          [네임노드] : 파일을 쪼개서 어느 데이터 노드에 저장되어 있는지 기록 metadata
[데이터노드]    [데이터노드] : 실제 사용자가 업로드한 데이터를 쪼개진 형태로 보관


HDFS product git clone
```
$ mkdir project_dir_name
$ git clone https://github.com/big-data-europe/docker-hadoop 
```

HDFS 세팅을 위해 필요한 images 다운로드

`$ docker-compose up -d`

```
Creating namenode        ... done 
Creating historyserver   ... done
Creating nodemanager     ... done
Creating resourcemanager ... done
Creating datanode        ... done
```


실행 중인 docker containers 확인
`$ docker container ls`


namenode에 접속
```
# Enter inside namenode and open its bash
$ docker exec -it namenode /bin/bash
```


테스트 데이터 생성 후 namenode 복사
```
$ docker cp sample.txt namenode:/tmp/
$ docker exec -it namenode /bin/bash
$ cd temp 
$ ls -al
```


Map Reduce Job 테스트 준비 
```
# HDFS list commands to show all the directories in root "/"
$  hdfs dfs -ls /

# Create a new directory inside HDFS using mkdir tag.
$ hdfs dfs -mkdir -p /user/root

# Checking created directories
$  hdfs dfs -ls /

# Copy the files to the input path in HDFS.
$ cd temp
$ hdfs dfs -put sample.txt /user/root/input

2022-07-21 16:39:55,194 INFO sasl.SaslDataTransferClient: SASL encryption trust check: localHostTrusted = false, remoteHostTrusted = false

# Have a look at the content of your input file.
# hdfs dfs -cat /user/root/input/

```

Run Hadoop Map Reduce Jobs
Example : hadoop jar word_counter.jar
기본적으로 분석 작업 테스트 도움을 위해 word_counter.jar 모듈을 제공.
단어의 숫자를 계산해주는 java program package 가 jar 파일로 있다.
하둡은 자바 기반으로 만들어짐.
하지만  하둡스트리밍 기술로 꼭 자바 말고 php, python, shell script 로 제어 가능.
하둡 스트리밍은 스크립트 언어를 하둡에서 실행하게 해주는 인터페이스.

```

# Run map reduce job from the path where you have the jar.
$ hadoop jar <jar_file_name> <class_name> input output

$ cd /opt/hadoop-3.2.1/share/hadoop/mapreduce
$ hadoop jar hadoop-mapreduce-examples-3.2.1.jar org.apache.hadoop.examples.WordCount input output


$ docker cp  hadoop-mapreduce-examples-2.7.1-sources.jar namenode:/tmp
$ hadoop jar hadoop-mapreduce-examples-2.7.1-sources.jar org.apache.hadoop.examples.WordCount input output


# ouput 확인
$ hdfs dfs -cat /user/root/output/*


```

[Namenode information](http://localhost:9870/dfshealth.html#tab-overview)

![](%23Hadoop/02.png)


![](%23Hadoop/061114_0930_Introductio1.png)

참고 자료
- [HDFS Simple Docker Installation Guide for Data Science Workflow | by Paras Varshney | Towards Data Science](https://towardsdatascience.com/hdfs-simple-docker-installation-guide-for-data-science-workflow-b3ca764fc94b)
- [GitHub - big-data-europe/docker-hadoop: Apache Hadoop docker image](https://github.com/big-data-europe/docker-hadoop)
- https://www.youtube.com/watch?v=dLTI2HN9Ejg
- [YouTube](https://www.youtube.com/watch?v=HCR1ILMROfI)
- [MapReduce - Wikipedia](https://en.wikipedia.org/wiki/MapReduce)
- [하둡 맵리듀스(MapReduce) 이해하기](https://12bme.tistory.com/154)
- [Apache Hadoop 및 MapReduce란 - Azure HDInsight | Microsoft Docs](https://docs.microsoft.com/ko-kr/azure/hdinsight/hadoop/apache-hadoop-introduction)
- [Apache Hadoop 3.2.1 – MapReduce Tutorial](https://hadoop.apache.org/docs/r3.2.1/hadoop-mapreduce-client/hadoop-mapreduce-client-core/MapReduceTutorial.html)