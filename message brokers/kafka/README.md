# Kafka

- - - -
- Topic
Partition으로 구성된 일련의 로그파일
RDBMS Table과 유사
Key와 Value 기반 메시지 구조
Seralization 만 가능하면 어떤 타입도 가능
로그파일 처럼 연속적으로 발생하는 데이터.
(시간의 흐름에 따라 메시지가 **순차적**으로 물리적인 파일에 write 됨)

Topic - Partition
Topic이 Partition은 Kafa 의 병렬성능과 가용성 기능의 핵심 요소
메시지는 병렬 성능과 가용성을 고려한 개별 파티션에 분산 저장됨
단일 카프카 브로커 뿐만 아니라 여러 개의 카프카 브로커들에게 분산 저장

개별 파티션은 정렬되고
변경할 수 없는 (immutable) 일련의 레코드로 구성된 로그 메시지
개별 레코드는 offset 으로 불리는 일련 번호를 할당 받음
개별 파티션은 개별 파티션과 완전히 독립적임
개별 파티션내에서 정렬되고 offset 이 할당됨

						     [Kafca cluster}
Produser	(send)->		[Broker1]	[Broker2]
						Topic A		Topic A
						parition #0	parition #1	(Leader)
					-------------------------------------------------- ( 복제  replication) 
						parition #1	parition #0	(Follower)

replication-factor = 2
복제가 되기 때문에 가용성을 보장 받을 수 있다. 
하지만 복제 데이터를 가져야하기 때문에 용량이  * 복제 대상 만큼 필요하다.

- - - -
- Topic 생성 및 정보 확인하기
하나의 Topic은 여러개의 partition을 가질 수 잇음
Topic default patition은 1개

생성한 로그는 파티션 별로 저장됨
```
$ data/kafka-logs ls

# 로그 삭제
$ kafka-topics --bootstrap-server localhost:9092 --delete --topic [name]

```


- - - -
- Producer 와 Consumer 개요

Producer 는 Topic 에 메시지를 보냄(write)
Producer 는 성능/로드밸런싱/가용성/업무 정합성등을 고려하여 
어떤 브로커의 파티션을 메시지를 보내야 할지 **전략적** 결정

![](README/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-01-24%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.05.29.png)
ProducerRecod(Client)
	**-Topic**
	-Partition
	-key
	**-value**
	-header

Consumer는 Topic에서 메시지를 읽어 들임
여러 개의 Consumer들로 구성될 경우 어떤 브로커의 파티션에서 메시지를 읽어들일지 **전략적**으로 결정

![](README/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA%202023-01-24%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%206.06.03.png)

<kafka-console-producer / kafka-console-consumer>
테스트/디버깅 용도로 kafka-console-producer와 kafka-console-consumer를 제공
console 상에서 comman를 통해 producer 의 메시지 전송과 consume의 메시지 읽기 수행














#kafka