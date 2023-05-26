## 올바른 dependencies를 implement 하지 않아서 서버 실행이 되지 않은 경우
```
implementation 'org.springframework.boot:spring-boot-starter-data-jpa:3.0.4'
implementation 'org.springframework.boot:spring-boot-starter-data-jdbc:3.0.4'
```
위 두 dependencies는 Springboot용 Spring Data JPA 추상화 라이브러리로, 
버전에 맞추어 자동으로 JPA관련 라이브러리 버전을 관리해주는 역할을 한다.
저 둘을 implement 했더니(해당 dependency가 필요한 기능을 구현하지는 않음) 다음과 같은 에러를 뱉으면서 서버 실행 자체가 되지 않고 죽어버렸다. 뒤의 버전 info를 지워도 마찬가지.

```
***************************
APPLICATION FAILED TO START
***************************

Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class

Action:

Consider the following:
	If you want an embedded database (H2, HSQL or Derby), please put it on the classpath.
	If you have database settings to be loaded from a particular profile you may need to activate it (no profiles are currently active).

Execution failed for task ':MvcApplication.main()'.
> Process 'command 'C:/Users/msong/.jdks/temurin-17.0.7/bin/java.exe'' finished with non-zero exit value 1

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.
```

위의 두 dependency 와 더불어 `runtimeOnly 'com.h2database:h2'` 를 추가하니 서버가 정상적으로 실행이 되었다. 

## 테스트 코드 잘 작성했는데 코드를 못 찾는 경우.
```
Execution failed for task ':test'. > There were failing tests.
```
Settings -> Build, Execution, Deployment  -> Gradle -> Build and run Using 과 run tests using 을 IntelliJ IDEA로 바꾼다.

이 방법으로도 해결이 안 됐는데 Gradle refresh 하니까 해결됐다.