MVC 기본설정 
============================================================
이해...(듣는거) 외우기...(적어보기) 응용...(적어보기)

=============================================================
Controller -> 주소 맵핑
Service -> 기능구현..
regist() .. 해당하는 USER 검색 by email
USER 저장..
Repository -> JPA
insert select update delete
Entity
-> DB Table 설계
Dto
-> 프론트쪽에서 넘어오는 파라메타 설계
=============================================================
-> DTO -> ENTITY
Builder of 함수를 호출해서
BeanUtils.copyproperties() 속성값복사
ModelMapper속성값 복사
<dependency>
    <groupId>org.modelmapper</groupId>
    <artifactId>modelmapper</artifactId>
    <version>3.2.0</version>
</dependency>
=============================================================
프론트 쪽에서 데이터인 DTO 클래스를 넘겨줄때... 유효성검사를 도와주는 클래스
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
DTO 클래스 안에... NotNull Max Min
=============================================================
@ControllerAdvice
AOP 활용한...
예외 발생했을때에 프론트 쪽에 어떤 결과를 보내는 역활..
ErrorResponse 객체 생성
 ErrorCode 있는 내용으로 설정해서 보냅니다.

================================================================
CorsConfig --> 다른 504호 PC 에서 404호 서버에 요청시에
크롬브라우저 허용하지않는데... CORS  
@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
    .allowedOrigins("*")
    .allowedMethods("GET","POST","PUT","DELETE")
    .allowedHeaders("*");
}
==================================================================
get http://localhost:8080/users   리스트
-> 빈리스트가 보내지는건..
get http://localhost:8080/users/1 한명의유저
-> 에러다 그해당하는 유저가 없다.
post http://localhost:8080/users
json {
"username": "qwer",
"password": "qwerqwerqwer",
"email":"qwer@naver.com",
"gender":"Male"
}
==================================================================
UserController -> UserService
( 
에러 발생시에
Throw new LogException (ErrorCode)
Throw new UserException (ErrorCode)
)
->
GlobalExceptionHandler
LogException -> hanleLogException (Exception e)
Exception -> handleException (Exception e)
=====================================================================
@RequestParam 
http://localhost:8080/users?user=홍길동&password=1234
@RequestBody
json 문자열 요청되서 들어오는것을 UserDto 변경



======================================================================
user PK 자동증가
@GeneratedValue(strategy = GenerationType.IDENTITY)

user_seq 테이블 생성해서 pk 관리
nextval
1
user 테이블에 행을 넣게 되면 user_seq 테이블이 update 구문 실행
@GeneratedValue(strategy = GenerationType.SEQUENCE)

insert into users (email, gender, password, username, wdate,id)
values ('aaa@naver.com', 'MALE', '12341234', '홍길동', now(),1);
update user_seq set nextval = 2;

insert into users (email, gender, password, username, wdate)
values ('bbb@naver.com', 'MALE', '12341234', '김길동', now());
insert into users (email, gender, password, username, wdate)
values ('ccc@naver.com', 'MALE', '12341234', '이길동', now());




