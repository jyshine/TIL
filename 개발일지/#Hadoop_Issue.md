#Hadoop_Issue

```
2022-07-26 07:49:30,588 INFO client.RMProxy: Connecting to ResourceManager at resourcemanager/172.22.0.2:8032
2022-07-26 07:49:33,332 INFO client.AHSProxy: Connecting to Application History server at historyserver/172.22.0.6:10200
2022-07-26 07:49:36,046 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 0 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:37,049 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 1 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:38,057 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 2 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:39,060 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 3 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:40,062 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 4 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:41,065 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 5 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:42,066 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 6 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:43,068 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 7 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:44,071 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 8 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
2022-07-26 07:49:45,074 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 9 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
^X2022-07-26 07:49:46,250 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 0 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)
^C2022-07-26 07:49:47,255 INFO ipc.Client: Retrying connect to server: resourcemanager/172.22.0.2:8032. Already tried 1 time(s); retry policy is RetryUpToMaximumCountWithFixedSleep(maxRetries=10, sleepTime=1000 MILLISECONDS)

```



```
$ hadoop namenode -format
$ exit

$ docker inspect namenode | grep IPAddress
$ docker inspect historyserver | grep IPAddress
$ docker inspect nodemanager | grep IPAddress
$ docker inspect resourcemanager | grep IPAddress
$ docker inspect datanode | grep IPAddress


Creating namenode        ... done  		172.21.0.6
Creating historyserver   ... done 		172.21.0.5
Creating nodemanager     ... done			172.21.0.3
Creating resourcemanager ... done			172.21.0.2
Creating datanode        ... done			172.21.0.4
```

```
# namenod hostname 확인

$ hostname --fqdn

# 해당 hostname으로 로컬 ip 설정 127.0.0.1

```
![](%23Hadoop_Issue/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202022-07-26%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.30.56.png)
hostname 에 맞춰 ip 변경

/etc/hosts 변경






[Hadoop 테스트 : 네이버 블로그](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=dark1997&logNo=70183006325)
[ConnectionRefused - HADOOP2 - Apache Software Foundation](https://cwiki.apache.org/confluence/display/HADOOP2/ConnectionRefused)

#Hadoop