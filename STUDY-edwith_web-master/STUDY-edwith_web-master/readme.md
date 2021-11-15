# EDWITH [부스트코스] 웹 프로그래밍
기존에 주먹구구식으로 접했던 Web 관련 기술들을 보다 체계적으로 배우기 위해, edwith의 '[부스트코스] 웹 프로그래밍' 강의를 수강하였다. Front-End의 html, css, javascript 부터 Back-End의 sevlet, jsp, jdbc, Spring 까지 전반적인 기초 기술들을 학습하였다.
## Ch2. DB 연결 웹 앱
### ch2-1. JavaScript 
ES6버전의 javacript에서는 var, let, const로 변수를 선언할 수 있다. var은 변수의 유효범위가 함수, let과 const는 괄호이다. const는 값을 초기화하면 변경 할 수 없다. 선언한 변수의 타입은 실행 중에 결정된다. javascript는 변수 호이스팅이라는 개념이 있는데, 함수에 변수의 선언문이 있으면 필요한 변수들을 미리 만들어 두는 것을 말한다.

다른 언어들과 마찬가지로 수학 연산자, 삼항 연산자, 비교 연산자 등 다양한 연산자가 존재한다. 다만, 비교 연산자는 ==, === 으로 두가지 연산자가 존재한다. == 연산자는 비교하려는 두 변수의 타입이 다를 경우 자동 형변환이 이루어지고, === 연산자는 그렇지 않다.

비교문, 반복문을 위한 if, switch, while, for, forEach등 다양한 방법이 존재한다. 또, 문자열 처리를 위한 split, replace, trim 등 다양한 함수가 존재한다.

함수는 기본적으로 가변인자를 받고, 이는 arguments 라는 자동생성되는 변수에 저장된다. 또 모든 함수는 값을 반환하며, 아무것도 반환하지 않으면 undefined가 반환되는 것과 같다.

javascript는 기본적으로 Single Thread로 동작하며, 모든 함수는 Call Stack과 Task Queue에 의해 관리되고 실행된다.

### ch2-2. WEB UI 개발
window 객체는 브라우저에서 제공하는 기본 전역 객체로 브라우저의 정보와, setTimeout, setInternval 등 다양한 기능을 제공한다. 자주 사용하는 document 객체 역시 window 객체의 속성 중 하나이다. 

document 객체는 html 페이지의 DOM 트리구조에서 최상위 루트이며, DOM API에서 제공하는 getElementById(), querySelector() 등을 사용하여 원하는 태그를 찾을 수 있다. 

브라우저에서 일어나는 다양한 이벤트가 발생하고, addEventListener()를 통해 콜백 함수를 지정할 수 있다.

ajax, 즉 비동기 통신을 위한 XMLHttpRequest가 존재한다.

### ch2-3. JSP
JSP(Java Servlet Page)는 기존 Servlet 기술의 불편함을 해소하기 위해 등장한 기술이다. 마치 html 페이지 처럼 jsp파일을 생성하면 selvet파일로 자동 변환되어 동작한다. 선언문 <%! %>, 스크립트릿 <% %>, 표현식 <%= %>, 주석 <!-- --> 을 사용하여 자바 코드를 표현한다.

jsp에는 request, response, pageContext, session, application 등 다양한 내장 객체가 존재한다.

### ch2-4. redirect & forward
redirect는 사용자가 서버에 요청을 보내고, 서버는 사용자에게 URL을 보내고, 사용자가 해당 URL로 다시 요청을 보내고, 서버가 이에 응답하는 동작으로 이루어진다. 사용자는 서버에게 두번의 요청을 보내게 된다.

forward는 사용자가 서버에 요청을 보내고, 서버는 해당 요청에 맵핑된 Servlet이 다른 Servlet에게 요청을 넘기고 응답하는 동작으로 이루어진다. 사용자는 서버에게 한번의 요청을 보내게 된다.

```java
RequestDispatcher rd = request.getRequestDispatcher("/next");
rd.forward(request, response);
```

### ch2-5. Scope
JSP에는 Application, Session, Request, Page 4개의 Scope가 있고, 각각 다른 주기와 유효범위를 가지고 있다. 
* Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
* Session : 웹 브라우저 별로 변수가 관리되는 경우 사용
* Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용
* Page : 페이지 내에서 지역변수처럼 사용

### ch2-6. EL, JSTL
JSP 파일에서 HTML 태그와 JAVA 코드를 함께 사용하다 보면 어색한 부분이 많다. EL은 <%= request.getAttribute("num") %> 대신 ${num}과 같이 더 간편하게 변수를 표현 할 수 있게해준다. JSTL은 <% for(int i = 0; i < 10; i++) %> 대신 <c:for var="i" begin="1" end="1"> 과 같이 로직을 더 자연스럽게 표현해준다.

### ch2-8. SQL
SQL이란 Structured Query Language의 약자로 RDB에서 데이터를 조작하고 관리하는 표준 언어이다. DML(insert, update, delete, select)로 데이터를 조작하고, DDL(create, drop, alter)로 테이블을 관리하고, DCL(grant, revoke)로 권한, 동작 흐름 등을 관리한다.

### ch2-9. Maven
웹 개발을 위해서는 다양한 라이브러리를 사용하고, 이 라이브러리들이 많아질수록 관리하는 일이 어려워졌다. maven은 빌드부터 의존성 관리까지 프로젝트 개발에 필요한 작업들을 손쉽게 할 수 있도록 도와준다. 이 중 라이브러리 관리 기능이 maven을 사용하는 가장 큰 이유이다. pom.xml에 사용할 라이브러리를 작성하면, maven이 알아서 다운받고 관리해준다.

### ch2-10. JDBC
JDBC는 JAVA에서 각 DB에 접속하고 동작을 수행하는 방법과 절체에 관한 규약으로, DB에 관련한 표준 API들을 제공한다.
```xml
<dependency>   
  <groupId>mysql</groupId>   
  <artifactId>mysql-connector-java</artifactId>
  <version>5.1.45</version>
</dependency>
```
```java
import java.sql.*;
Class.forName( "com.mysql.jdbc.Driver" );
String dburl  = "jdbc:mysql://localhost/dbName";
Connection con =  DriverManager.getConnection ( dburl, ID, PWD );
```

### ch2-11. WEB API
API란 Application Programming Interface의 약자로, 프로그램의 기능을 사용하기위한 일종의 약속을 뜻합니다. API를 알면 내부 동작을 몰라도, 원하는 기능을 실행시킬 수 있습니다.

Rest API란 REpresentational State Transfer의 약자로, 핵심 컨텐츠 및 기능을 외부 서비스에서 활용할 수 있도록 제공되는 API이다. REST API의 창시자가 말한 REST API의 조건은 다음과 같다.
* client-server
* stateless
* cache
* uniform interface
* layered system
* code-on-demand (optional)
