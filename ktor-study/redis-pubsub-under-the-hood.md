# Redis Pub/Sub
- 일반적으로 레디스는 Key-Value DB로 많이 알려져있다.
- 뿐만아니라 메시지 서버 역할도 할 수 있음.
- 클라이언트는 레디스 서버와 TCP 연결후 “SUBSCRIBE donuts”라는 명령어로, "donuts" 채널을 구독할 수 있음.
- “PUBLISH donuts 3-for-$1" 명령어로, "donuts" 채널 구독자에게 '3-for-$1' 메시지를 보낼 수 있음.
- 레디스는 Global 변수인 'pubsub_channels'을 사용한다.
  - Map으로 구성되어 있음
  - Key : 채널명
  - Value : 구독중인 클라이언트 목록(Set)
- "SUBSCRIBE" 명령어를 사용하면, 특정 채널명을 반환받음.
- "PUBLISH" 명령어를 사용하면, pubsub_channels 맵에서 구독자를 조회하고, 각 구독중인 클라이언트 소켓에 메시지를 전송함.

---

## Handling disconnections
- 클라이언트 connection은 모종의 사유로 끊어질 수 있음
  - 네트워크 이슈 등
- 예를들어 A 클라이언트가 연결을 끊으면, 레디스는 모든 채널을 순회하며 각 채널의 구독 목록에서 A 클라이언트를 지워야 한다.
- 모든 채널을 순회하는것은 비효율적임.
  - "donuts" 채널만 방문하여 A 클라이언트를 지워야함.
  - 이렇게 하기 위해서 클라이언트 A가 구독하고 있는 Channel Set를 만들어둠.
  - Channel Set은 pubsub_channels 동기시켜야 함.
  - 

---

## Getting concrete
- pubsub_channels은 논리적으로 Map<ChannelName, Set<Client>> 으로 정의되어 있음.
  - 실제로 hash table임
  - 채널명은 2^n 크기 배열의 위치로 해시됨.
  - 해시 충돌시 "hash chaining"으로 해결(각 버킷은 Linked List 채널을 가리킴).
  - Key는 채널명(String), Value는 클라이언트 목록(Set)
- 클라이언트의 Channel Set은 논리적으로 Set<ChannelName>으로 정의되어 있음.
- 

---
## API 설계
- 

## 데이터 모델
- 위치 정보 캐시
  - '주변 친구' 기능을 활성화한 친구의 최근 위치 정보 저장
    - Key/Value : 사용자 ID | {위도, 경도, 시각}
    - 사용자의 현재 위치만 필요하고, 영속성 보장이 필요없기 때문에 RDB를 사용하지 않음.
- 위치 이동 이력 데이터배이스
  - user_id | latitude | longiude | timestamp 저장
  - write 연산이 많으며, scale-up이 가능해야하므로 카산드라가 적합.

---
## 규모 확장성
- API 서버 : Stateless하기 때문에 scale-out 하기 쉽다.
- 웹소켓 서버 : 웹소켓 서버 또한 scale-out하기 용이하다. 그렇지만 기존 서버를 제거할때는 주의해야한다.
  - 노드 제거시 : 기존 연결부터 종료, 노드 상태를 연결 종료중 으로 변경
- 레디스 펍/섭 서버 : 레디스 펍/섭 채널은 비용이 저렴하다.
  - 채널 하나를 유지할때 hash table, linked list를 필요로하는데 소량의 메모리만 사용함.
---
