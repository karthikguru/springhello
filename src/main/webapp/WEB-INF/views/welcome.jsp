<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<t:main>	
		<h1>The user name is ${fullUser.nickname}</h1>
		<input type="hidden" id ="nickName" value="${fullUser.nickname}"/>
		
		 <section id="contents">
    	<legend> Play Ajax Samples </legend>
      <fieldset>
                      <input type="text" id="username" name="username" placeholder="Enter your name">
                      
            <div class="actions">
                           <input type="button" class="btn" value="Say Hello!" onClick="sayAjaxGetHello()">
            </div>
      </fieldset>      
      
      <br/>
      <br/>
      <br/>
    
      <div class="lead" id="sayHello"></div>
      </section>
      
    <script src="/resources/js/sayhello.js" type="text/javascript"></script>   
</t:main>