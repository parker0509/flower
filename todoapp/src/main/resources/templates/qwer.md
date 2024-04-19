# 2024.03.26
DB의 username을 조회하는 오류 발생 

!! 해결 !!
1. Getmapping() 은 클라이언트 -> 서버   
   즉 서버에게 던지는 것(보내는 응답)
2. Postmapping()은 서버 -> 클라이언트

&비 로그인 상태 -> 로그인 

#### 개념적인 부분과 이용하는 방법 이해 필요<Spring Security를 이용!>

&회원가입() -> JPA -> Entity Factory -> Entity Manager -> DB Query -> DBMS -> DB

@@회원가입 이후 DB에 있는 UserName, Password가 같은지 .equals 를 통해 확인

1.검증 상태에서 객체 user를 부르고 password만 equals를 통해 확인
2.user.username까지 확인

@@ 구분 할 줄 알아야한다. 그리고 뭐가 다른지 알아야함.


# 2024.03.27

1. https://fakestoreapi.com/ api를 만드는 방법, 과정 필요
2. 회원정보는 DB로 보고 로그인과 로그아웃의 상태가 서로 다른 페이지를 보고 있다면 문제
두가지의 웹사이트를 만드는 과정이라 서버에 부담이 가는거아닌가 ?

GPT -> 세션 관리 Spring Security!! 