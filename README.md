# Leisurvation - MyBatis,Thymeleaf 팀 프로젝트

## Team 와장창
**이수민**(팀장) : 
디비설계, Github 세팅 및 관리, 리뷰 페이지에 관한 CRUD, 프론트<br/>
**남기문** : 
레져, 거래처(컴퍼니) 페이지에 관한 CRUD, 프론트<br/>
**이승준** : 
예약, 마이페이지에 관한 CRUD, 프론트<br/>
**박찬미** : 
로그인, 카카오로그인, 회원가입, 권한에관한 CRUD, 메인, 헤더 프론트

> 개발기간 2023-03-20 ~ 2023-04-10


## 기술 스택 ##

에디터 : IntelliJ</br>
개발 툴 : SpringBoot 3.0.2</br>
자바 : JAVA 17</br>
빌드 : Maven 4.0</br>
서버 : localhost</br>
데이터베이스 : MySql</br>
필수 라이브러리 : SpringBoot Web, MySQL, Lombok, Spring Security6.0, Spring Boot DevTools, Thymeleaf, Validation 


## 개발환경 
- 사용기술 : [![HTML5](https://img.shields.io/badge/HTML5-E34F26?style=flat-square&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5) [![CSS3](https://img.shields.io/badge/CSS3-1572B6?style=flat-square&logo=css3&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/CSS) [![JavaScript](https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript) [![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jquery&logoColor=white)](https://jquery.com/) [![JSON](https://img.shields.io/badge/JSON-000000?style=flat-square&logo=json&logoColor=white)](https://www.json.org/json-en.html) [![Ajax](https://img.shields.io/badge/Ajax-009090?style=flat-square&logo=ajax&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/Guide/AJAX) [![Bootstrap 4.0](https://img.shields.io/badge/Bootstrap-563D7C?style=flat-square&logo=bootstrap&logoColor=white)](https://getbootstrap.com/docs/4.0/getting-started/introduction/) [![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)](https://www.java.com/) [![Spring](https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/) [![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?style=flat-square&logo=spring&logoColor=white)](https://spring.io/projects/spring-security) [![Maven](https://img.shields.io/badge/Maven-C71A36?style=flat-square&logo=apache-maven&logoColor=white)](https://maven.apache.org/) [![JDBC](https://img.shields.io/badge/JDBC-FF6600?style=flat-square&logo=java&logoColor=white)](https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html) [![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=mysql&logoColor=white)](https://dev.mysql.com/doc/) [![DBeaver](https://img.shields.io/badge/DBeaver-000000?style=flat-square&logo=dbeaver&logoColor=white)](https://dbeaver.io/) [![MyBatis](https://img.shields.io/badge/MyBatis-4B0082?style=flat-square&logo=mybatis&logoColor=white)](https://mybatis.org/mybatis-3/) [![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000?style=flat-square&logo=intellij-idea&logoColor=white)](https://www.jetbrains.com/idea/)
 [![Apache Tomcat](https://img.shields.io/badge/Apache_Tomcat-F8DC75?style=flat-square&logo=apache-tomcat&logoColor=black)](http://tomcat.apache.org/) [![Lombok](https://img.shields.io/badge/Lombok-339933?style=flat-square&logo=lombok&logoColor=white)](https://projectlombok.org/) [![Thymeleaf](https://img.shields.io/badge/Thymeleaf-005F0F?style=flat-square&logo=thymeleaf&logoColor=white)](https://www.thymeleaf.org/)

## 프로젝트
📺 프로젝트 메인페이지

<img width="800" src="https://github.com/namgimun99/Leisurvation/assets/124684039/89b3d7cd-508b-44f8-a98b-9a71953cf200">

<img width="800" src="https://github.com/namgimun99/Leisurvation/assets/124684039/a1a0cdc8-83bc-4206-a491-c7eaf56e6b3b">


## 🔍 프로젝트 특징 및 기능
- 사용자가 레져를 예약, 관리, 후기등을 쉽게할 수 있고 나아가 비즈니스까지 할 수 있는 웹 사이트
- Spring Framework를 이용해 더 편리하고 쉽게 개발하였습니다.
- 주요 개발 기능
    - 회원가입, 로그인, kakao 로그인
    - 레져스포츠 예약 가능
    - Qna 작성
    - 리뷰 작성
    - 마이페이지
      
  **일반유저**</br>
  - 레져스포츠를 등록 할 수 있는 권한 등록 후 레져스포츠 등록 가능
  
 
  **레져스포츠 권한을 가진 유저**</br>
  - 레져스포츠 등록 가능


  **최상위 관리자**</br>
  - 적절치 못한 리뷰, qna 삭제
</br>

📋 ERD 및 로직 프로세스

<br>
<img width="800" src="https://github.com/namgimun99/Leisurvation/assets/124684039/adac6b66-5f21-4549-a3c2-9110b9f61d86">

<br>
<img width="800" src="https://github.com/namgimun99/Leisurvation/assets/124684039/b2807a37-10e2-4978-a9dc-5ed407bc5534">



### 🛠️ API

![image](https://github.com/Hongmebuilding/Leisurvation/assets/87316411/3cf7e575-66df-463a-8c68-933b5822f3c1) 
<br>소셜 로그인


### 📖 Story Board
- 회원가입, 로그인페이지
- 관리자, 메인 페이지
- 마이페이지<br>
 	-관리자<br>
 	-일반유저<br>
 	-사업자<br>
- 레져 예약 페이지
- 레져 목록 페이지
- 레져 상세 페이지
- 후기 작성 페이지
- 코멘트 모두 보기, 상세 페이지
- 코멘트 팝업창, 코멘트 댓글 팝업
- 레져 등록 페이지

### 📊 Flow Chart
<br>
회원가입, 로그인
<br>
<img width="800" src="https://github.com/Hongmebuilding/Leisurvation/assets/87316411/99ab4a2e-cd30-464b-babe-dac0002ecec8">
<br>
회사등록, 레져등록
<br>
<img width="800" src="https://github.com/Hongmebuilding/Leisurvation/assets/87316411/2990092a-289b-4db3-8686-ff2916dfbaf3">
<br>
레져 예약, 리뷰등록
<br>
<img width="800" src="https://github.com/Hongmebuilding/Leisurvation/assets/87316411/fe1aca73-e7e2-4da0-a1e5-da7a35aa05c6">
<br>
문의사항, 문의관리
<br>
<img width="800" src="https://github.com/Hongmebuilding/Leisurvation/assets/87316411/04802b3e-2129-4f0c-8b21-4d88f5417f46">
