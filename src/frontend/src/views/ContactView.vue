<template>
  <header class='masthead'>
    <p class='masthead-intro'>Hi I'm</p>
    <h1 class='masthead-heading'>UGO!</h1>
  </header>

  <section class="introduction-section">


    <img class="float-" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcwu1kR%2FbtqZUWqCwQ6%2FIv1isDN8uFi66G6yIzmVEk%2Fimg.jpg" width="150" height="100" alt="">
    <h1>Introduction</h1>
    <hr class="my-2">
    <p>요리사였고 지금은 백엔드 프로그래머인 황경욱(UGO) 입니다. </p>
    <p><strong>internet</strong>과 <strong>programming</strong>을 사랑하며 ,그 둘을 활용하여 무언가 만들어 내는 것을 좋아합니다</p>
    <p>블로그의 이름인 'almost there' 이란 등산할때 필수 레파토리인 '거의 다 왔어!'를 뜻하며
      한참을 올라가도 제자리인 것 같고 저 위에선 거의 다 왔다고 놀리는 것 같은 기분 같은 기분에서 떠올렸습니다.</p>
  </section>

  <section class="questions-section">

    <h2>취미는 ?</h2>
    <p>요즘 관심사는 주식 , 프로그래밍  오래된 취미는 걷는 것을 좋아하여 ,스페인 카미노 ,스웨덴 쿵스레덴 , 제주도 올레길을 걷기도 함 </p>
    <h2>목표 하는 것은?</h2>
    <p>좋은 경험을 쌓아 애플리케이션 뿐만 아닌 나만의 서비스를 만들어 내고 싶다.</p>
    <h2>사는곳</h2>
    <p>경기도 양주시에 거주 중이며 일 구하면 바로이사</p>
    <h2>개발자가 되고 싶은 이유</h2>
    <p>엄청난 목표보다는 재미를 느끼고, 이것으로 해보고 싶은 것들이 계속 생겨난다는 것이 가장 큰 이유인 것 같다.</p>
    <h2>사용기술</h2>
    <pre class="jumbotron">
      <strong class="text-primary">Language</strong>

      [ JAVA ] [ JAVASCRIPT ] [JSP]

      * JAVA의 기본 개념, 문법에 대해 숙지하고 있고 꾸준히 공부하고 있음
      * Javascript의 기본 개념, 문법들을 숙지하고 있음
      * JSP/servlet을 통한 프로젝트 경험

      <strong class="text-primary">FRAMWORK</strong>

      [SPRING] [SPRINGBOOT] [SPRING-SEQURITY]

      *Spring을 통한 MVC 패턴의 팀 프로젝트 경험
      *Spring-boot를 통한 개인프로젝트
      *Spring-Sequerity를 통한 사용자인증,권한,보안처리 구현 경험


      <strong class="text-primary">Version-Control</strong>

      [ Git , GitHub ]

      *Git/GitHub를 통한 프로젝트 협업 , 버전관리 경험

      <strong class="text-primary">ORM</strong>

      [ JPA/Hibernate ] [ Spring-data-JPA] [ QueryDSL ]

      *JPA 작동 원리, 사용법 대해 이해하고 있음
      *Spring-data-JPA QueryDSL을 활용한 JPA 사용법 숙지

      <strong class="text-primary">DataBase</strong>

      [Oracle Database] [Maria DB] [H2 Database]

      * 프로젝트 요구사항에 따른 데이터 모델링과 쿼리 작성 가능

      <strong class="text-primary">Library</strong>

      [ Bootstrap ] [ JQuery ]

      * Bootstrap 웹페이지 디자인 경험

      <strong class="text-primary">front-end framework</strong>

      [ Angular js ] [ Vue.js]

      * Vue.js - spring-boot 프로젝트 경험
      * Angular js, JQuery를 활용한 웹 프런트엔드 개발 경험

      <strong class="text-primary">IDE</strong>

      [INTELLI J] [ECLIPSE]

      *해당 IDE로 프로젝트 경험을 갖고 있으며 사용법을 숙지하고 있음

      <strong class="text-primary">Test</strong>

      [JUNIT]

       *JUNIT을 통한 테스트 코드 작성법 숙지

      <strong class="text-primary">배포</strong>

      [AWS EC2 , AWS RDS ]

       * AWS EC2 와 RDS를 활용하여 스프링 부트 + Vue.js + JPA
        애플리케이션 배포 경험 (Domain, https 인증서 적용)

    </pre>
  </section>
</template>


<script>
export default {
  name: "ContactView"
}
</script>

<style scoped>
body {
  /* Typography Declarations */
  color: #444343;
  font-size: 1em;
  font-family: "Open Sans", "Helvetica Neue", sans-serif;
}

.content-footer,
.masthead-heading,
.masthead-intro {
  text-align: center;
}

.masthead-intro {
  /* Layout Declarations */
  margin-bottom: 0.1em;
  /* Typography Declarations */
  font-family: "Gentium Book Basic", Georgia, serif;
  font-size: 2em;
}

.masthead-heading {
  /* Layout Declarations */
  color: #F1C863;
  margin-top: -0.2em;
  /* Typography Declarations */
  font-family: "Open Sans", "Helvetica Neue", sans-serif;
  font-weight: bold;
  font-size: 6em;
  letter-spacing: -0.02em;
  text-transform: uppercase;
}

.introduction-section,
.location-section,
.questions-section {
  max-width: 38em;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2em;
}
.introduction-section{
  position: relative;
}
img{
  position: absolute;
  right: 10px;
  bottom: 155px;
  border-radius: 150px;
}

pre,
.introduction-section > p,
.location-section > p,
.questions-section,
.content-footer > p {
  /* Typography Declarations */
  font-weight: bold;
  letter-spacing: 0.05em;
  font-family:'Noto Sans KR', sans-serif;
}
.questions-section > h2,
.introduction-section > h1{
  color: tomato; ;
  font-family: 'Black Han Sans', sans-serif;
  font-size: 1.5em;
  font-weight: bold;
  /* Layout */
  margin: 2em 0 1em 0;
}

section > h1 {
  margin-top: 2em;
}

.content-footer,
.masthead-heading,
.masthead-intro {
  text-align: center;
}

.masthead {
  padding: 6em 0;
  background-image: url('https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrMfTt%2FbtqZV58tZbi%2FKka87ElFpPHuk7DjbZLqhK%2Fimg.jpg');
  background-size: cover;
  background-repeat: no-repeat;
}

.masthead-intro {
  margin-bottom: 0.1em;
  font-family: "Gentium Book Basic", Georgia, serif;
  font-size: 2em;
}

.masthead-heading {
  margin-top: -0.2em;
  font-family: "Open Sans", "Helvetica Neue", sans-serif;
  font-weight: bold;
  font-size: 6em;
  letter-spacing: -0.02em;
  text-transform: uppercase;
}
.introduction > p,
.location > p,
.content-footer > p {
  /* Typography Declarations */
  font-weight: 300;
  letter-spacing: 0.05em;
}
h2 {
  /* Typography Declarations */
  font-family: "Gentium Book Basic", Georgia, serif;
  font-size: 1.2em;
  font-weight: bold;
}

.introduction-section,
.location-section,
.questions-section {
  max-width: 38em;
  margin-left: auto;
  margin-right: auto;
  margin-top: 2em;
}
.content-footer {
  margin: 50px 0;
  padding: 20px 0;
  text-align: center;
  background-color: #73A8C2;
  text-decoration: none;
}
.social > li {
  display: inline-block;
  margin: 0 5px;
}
.content-footer > p {
  color: #F7EDE1;
}
a {
  font-weight: bold;
  text-decoration: none;
  color: #F1C863;
}

@media only screen and (max-width: 500px) {
  .masthead {
    padding: 3em 0;
  }
  .masthead-heading {
    font-size: 3em;
  }
  .content-footer {
    padding: 2em 2.5em;
  }
}
</style>