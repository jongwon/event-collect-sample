# event-collect-sample

이 샘플은 redis를 이용해 이벤트를 등록하고, 카운트 하고, 업데이트 하는 기능을 세대의 서버에서 처리하도록 만든 것입니다.
기본적으로 redis 서버가 있어야 한다. 
redis 서버는 3971을 master로 3972를 slave 로 설정해서 구동시킨다.


```$xslt
// redis master config
port 3971
pidfile /var/run/redis_3971.pid
dbfilename dump-cluster01.rdb
```

```$xslt
// redis slave config
port 3972
pidfile /var/run/redis_3972.pid
dbfilename dump-cluster02.rdb

slaveof 127.0.0.1 3971
```


## event-data-model
서버들 끼리 서로 공유할 데이터 모델을 정의한 모듈.
나머지 서버들은 모두 이 Event 데이터 모델로 통신한다.


## event-regist-server
Event 를 생성해서 등록하는 서버.
(port : 3988)
eventId는 Redis 서버에 있는 sequece 를 사용했다.
redis 서버는 3971 번 마스터 노드를 이용한다.

이벤트 생성 url
```$xslt
http://localhost:3988/event/new
```

## event-count-server
Event를 조회하는 서버.
(port : 3987)
이벤트 조회가 발생하면 카운트를 increment 하고 조회 이벤트를 redis를 통해 publish 한다.
redis 서버는 3971 번 마스터 노드를 이용한다.

이벤트 조회 URL 
```$xslt
http://localhost:3987/event/view/1
```


## event-receive-server
이벤트 조회가 발생하면 해당 내용을 받아서 로그에 뿌리는 작업을 한다.
(port : 3986)
redis 서버는 3972 번 슬레이브 노드를 이용한다.

로그를 통해 이벤트를 확인함.



