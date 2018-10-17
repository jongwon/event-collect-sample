# event-collect-sample

이 샘플은 redis를 이용해 이벤트를 등록하고, 카운트 하고, 업데이트 하는 기능을 세대의 서버에서 처리하도록 만든 것입니다.


## event-data-model
서버들 끼리 서로 공유할 데이터 모델을 정의한 모듈.
나머지 서버들은 모두 이 Event 데이터 모델로 통신한다.


## event-regist-server
Event 를 생성해서 등록하는 서버.
(기본포트 : 3988)
eventId는 Redis 서버에 있는 sequece 를 사용한다.

## event-count-server
Event를 조회하는 서버.
(기본포트 : 3987)
이벤트 조회가 발생하면 카운트를 increment 하고 조회 이벤트를 redis를 통해 publish 한다.


## event-receive-server
이벤트 조회가 발생하면 해당 내용을 받아서 로그에 뿌리는 작업을 한다.
(기본포트 : 3986)




