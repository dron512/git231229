1조 
진영호, 정종철
백엔드 2명
http://back.green-coffee.shop/swagger-ui/index.html
https://github.com/sdqwe12/green-coffee


2조
프론트
http://onezo.hellomh.site/
https://github.com/zuicy99/alcohol
권수민, 조정진, 박준재, 정은희, 고찬우, 신지훈, 최은재
백엔드 7명
http://two.hellomh.site/swagger-ui/index.html
https://github.com/jeongjinjo/OCB-two


3조 
http://threefront.hellomh.site
https://github.com/soyeon0504/onezo
강보성, 김상의, 정영웅, 김형진, 송하린
백엔드 5명
http://threeback.hellomh.site/swagger-ui/index.html
https://github.com/joungyw/alcoholshopping


maven 

FROM openjdk:17-jdk-slim AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:17-jdk-slim
WORKDIR demo
COPY --from=build target/*.jar demo.jar
ENTRYPOINT ["java", "-jar", "demo.jar"]