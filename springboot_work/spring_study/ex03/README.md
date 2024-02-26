Map 객체 안에
email key 값이
Member value 값으로 등록

MemberController
MemberService
MemberRepository

스프링 프로그래밍을 하는것은
Controller와 html 파일을 만드는 것이다.

resources
static
http:/localhost:8081/   -> index.html

templates
http:/localhost:8081/aa   -> aa.html
http:/localhost:8081/regist  -> regist.html
http:/localhost:8081/list   -> list.html

IOC 객체 두개 주입되어있음..
MemberService
MemberRepository

-> @Autowired
객체가져오기...

1. http://localhost:8081/regist
   HashMap<email,member>
   웹화면.. 등록되었습니다.

2. http://localhost:8081/list
   HashMap.. 웹화면.. 출력..

IOC 컨테이너...

주소맵핑
@Controller
@GetMapping

환경설정
@Configuration
객체 주입
@Bean
객체 불러오기
@Autowired

C# 윈도우앱
java 웹앱 jframe




![image](https://github.com/dron512/git231229/assets/57881372/267864ce-6bd2-472b-afdd-9ccb548e2a36)

