# 배달 어플 구현하기

## REST API 설계(URL, HTTP method)
## [사용자 기준]
### 회원
- 회원가입 - `POST /users`
- 로그인 - `POST /login`
- 로그아웃 - `GET /logout`
- 개인정보조회 - `GET /users/{userId}`
- 개인정보수정 - `PUT(or PATCH) /users/{userId}`

### 메인화면
- 음식 카테고리 - `GET /category`
    - 한식, 중식, 일식... 등
    - 메인은 그냥 /main 으로 필요한 데이터를 한번에 보내야하나?

### 음식점 
- 카테코리 별 음식점 조회 - `GET /stores/category/{category}`
- 특정 음식점 조회(선택) - `GET /stores/{storeId}`

### 음식
- 특정 매장의 음식 전체 조회 - `GET /foods/stores/{storeId}`
- 음식 상세 조회 - `GET /foods/{foodId}`

### 주문 
- 주문하기 - `POST /orders`
- 주문조회 - `GET /orders/{orderId}`
- 나의 전체 주문 조회 - `GET /orders/users/{userId}`
  - order 테이블의 user_id를 식별자로 쓴다는 개념으로 orders 뒤로 users 둬서 계층 표현({}안에 값이 userId라는 것을 명시하기 위해)

### 리뷰 
- 리뷰등록 - `POST /reviews`
- 리뷰상세조회 - `GET /reviews/{reviewId}`
- 내가 등록한 리뷰 내역 조회 - `GET /reviews/users/{userId}`
  - /reviews로 하고 {userId}는 URL에 명시하지 않고 세션이나 쿠키같은걸로 내부 로직에서 분기처리해야하나?
- 리뷰수정 - `PUT /reviews/{reviewId}`
- 리뷰삭제 - `DELETE /reviews/{reviewId}`


## [매장기준]
### 매장회원 
- 회원가입 - `POST /users`
  - 권한정보를 일반사용자와 매장회원을 구분해서 전달
- 로그인 - `POST /login`
- 로그아웃 - `GET /logout`
- 개인정보조회 - `GET /users/{userId}`
- 개인정보수정 - `PUT(or PATCH) /users/{userId}`

### 음식점
- 음식점 등록 - `POST /stores`
- 음식점 수정 - `PUT /stores`
- 음식점 조회 - `GET /stores/{storeId}`
- 음식점 삭제 - `DELETE /stores/{storeId}`
  - 삭제기능을 제공하나?

### 음식점 별 음식등록(메뉴)
- 음식등록 - `POST /foods`
- 음식전체조회 - `GET /foods/stores/{storeId}`
- 음식조회 - `GET /foods/{foodId}`

### 주문관리 
- 주문전체확인 - `GET /orders/stores/{storeId}`
- 특정주문 - `GET /orders/{orderId}`
- 주문처리 - `POST /orders/{orderId}`
  - 주문수락/삭제에 대한 상태값 전달