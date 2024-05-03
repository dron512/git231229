# DevConfig
DevContainer + Spring Cloud Config

### Architecture
<img src="./image/System.png" width="1000"></img>


### Spring App initializr

#### - App1
<img src="./image/App1.png" width="1000"></img>


### Cloud Config initializr

#### - Server
<img src="./image/Cloud Config Server.png" width="1000"></img>

#### - Client
<img src="./image/Cloud Config Client.png" width="1000"></img>

#### - Client Import (application.yml)
```
spring:
  config:
    import: optional:configserver:http://localhost:8888
```


### Resources

| Path             | Description  |
|------------------|--------------|
| /{app}/{profile} | Configuration data for app in Spring profile (comma-separated).|
| /{app}/{profile}/{label} | Add a git label |
| /{app}/{profile}{label}/{path} | An environment-specific plain text config file (at "path") |


----
### Spring Project
> * [Spring initializr](https://start.spring.io/)
> * [Application Properties](https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html)

> * [Cloud Config](https://spring.io/projects/spring-cloud-config)
> * [Cloud Config Docs](https://docs.spring.io/spring-cloud-config/docs/4.0.3-SNAPSHOT/reference/html/)


----
### YouTube Link

> * [1. Cloud 소개](https://youtu.be/mlJWoXJm034)
> * [2. Config 설정하기 1부](https://youtu.be/65PwJMJbKYQ)
> * [3. Config 설정하기 2부](https://youtu.be/8Y2OSavfizo)
