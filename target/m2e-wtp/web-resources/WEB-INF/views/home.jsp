<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:main>
    <h1>Welcome</h1>
    <p>${fullUser.nickname}</p>
    
    <input type="hidden" id ="nickName" value="${fullUser.nickname}"/>
    
    <P>  The time on the server is ${serverTime}. </P>
    <!-- 1. The 'widget' div element will contain the upload widget.
         The 'player' div element will contain the player IFrame. -->
         
         
	<div id="widget"></div>
	<br/><br/>
    <div id="player"></div>
    
    
    <div class="lead" id="sayHello"></div>
    
    
  <script src="/resources/js/sayhello.js" type="text/javascript"></script>   
  <script src="/resources/js/youtube.js" type="text/javascript"></script>   
</t:main>
