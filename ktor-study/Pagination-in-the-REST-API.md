# [Pagination in the REST API](https://developer.atlassian.com/server/confluence/pagination-in-the-rest-api/)

# What is REST API pagination?
- 목록 조회 API를 호출할때 응답 결과를 페이지 단위로 구성하는 API Design이다.
- 주로 GET 메서드에서 사용되며 응답 본문의 payload가 큰 경우 유용하다.
- 클라이언트가 요청한 데이터를 한 번에 모두 응답하는게 아니라, 필요한 양의 데이터를 여러번의 요청을 통해 점진적으로 응답하는 방식.

# Why pagination?
- 네트워크 비용을 줄일 수 있음.
  - 한 번에 전송하는 데이터양을 제한하여 네트워크 부하를 감소시킴.
  - 작은 데이터를 분할하여 여러번에 걸쳐 전송하는게, 대량 데이터를 한번에 보내는것보다 효율적임.
    - 대량의 데이터를 한번에 보내는 것은 대역폭을 많이 사용함.
- 클라이언트 & 서버 둘다 좋음
  - 공통 : 처리하는 데이터가 줄어들기 때문에, 메모리와 CPU 자원의 효율성 증가.
  - 클라이언트 : 처리할 수 있는 데이터만큼 요청할 수 있음.
  - 서버 : 조회하는 데이터가 줄어들기 떄문에 DB 부하를 줄일 수 있음.
- 부하 분산 가능 (어느 서버로 요청할지는 로드밸런서가 결정하겠지만요)
  - 1 Page -> A 서버
  - 2 Page -> B 서버
  - 3 Page -> C 서버
- 결론 : 성능 향상의 이점이 있음.
  - 대량의 데이터를 페이징하여 클라이언트에게 필요한 데이터만 전달하면되므로 성능을 향상 시킬 수 있음.

# Offset pagination
- 데이터 집합에서 특정 위치부터 일정한 개수의 데이터를 가져오는 방식.
- 데이터의 순서가 유지되어야하는 경우에 사용.
- 2가지 매개변수를 사용함.
  - offset : 데이터 집합의 시작점. 
  - limit : 집합에 포함되는 데이터의 개수.
> GET /v1/movies?offset=0&limit=3
```json
{
  "_links": {
    ...
  },
  "paging": {
    "prev_offset": 0,
    "next_offset": 3,
    "limit": 3,
  },
  "data": [
    {
      "id": 1,
      "title": "파묘"
    },
    {
      "id": 2,
      "title": "듄: 파트2"
    },
    {
      "id": 3,
      "title": "웡카"
    }
  ]
}
```
- 장점
  - 구현이 간단함.
  - 다양한 정렬 방식 
- 단점
  - 데이터를 조회할때, (추가 or 삭제)가 발생한 경우 데이터가 (중복 or 유실) 될수 있음.
  - 대규모 데이터인경우 offset이 클수록 DB 성능 이슈가 발생함.

# Cursor pagination
- 목록 전체를 검색하지 않고 cursor를 기준으로 일정량의 데이터만 가져오는 방식.
  - cursor : 조회 된 데이터의 마지막 부분을 가리키는 포인터.
  - unique하고 sequential 해야한다. (e.g auto-increment id)
> GET /v1/movies?cursor=3&limit=3
```json
{
  "_links": {
    ...
  },
  "paging": {
    "prev_cursor": 3,
    "next_cursor": 6,
    "limit": 3,  
  },
  "data": [
    {
      "id": 4,
      "title": "파묘"
    },
    {
      "id": 5,
      "title": "듄: 파트2"
    },
    {
      "id": 6,
      "title": "웡카"
    }
  ]
}
```

- 장점
  - 일관 된 성능을 제공
  - 다양한 정렬 방식
- 단점
  - 정렬이 제한됨.

```
- 추가) Facebook API에서는 cursor를 base64로 인코딩하여 응답함.
  - 어떤 이점이 있는걸까?
    - cursor의 세부 구현을 숨길 수 있음.
    - cursor에 여러 컬럼이 포함 될 경우?
```json
{
  "data": [
     ... Endpoint data is here
  ],
  "paging": {
    "cursors": {
      "after": "MTAxNTExOTQ1MjAwNzI5NDE=",
      "before": "NDMyNzQyODI3OTQw"
    },
    "previous": "https://graph.facebook.com/me/albums?limit=25&before=NDMyNzQyODI3OTQw"
    "next": "https://graph.facebook.com/me/albums?limit=25&after=MTAxNTExOTQ1MjAwNzI5NDE="
  }
}
```
