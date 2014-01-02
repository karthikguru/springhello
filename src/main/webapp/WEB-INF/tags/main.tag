<%@tag description="Simple Wrapper Tag" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
    	<meta charset="utf-8">
    	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<title>Hello</title>
    	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.css">
    	<link rel="stylesheet" type="text/css" href="/resources/css/bootstrap-theme.css">
    	<link rel="stylesheet" type="text/css" href="/resources/css/starter-template.css">
    </head>
	<body>
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		      <div class="container">
		        <div class="navbar-header">
		         <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
           			<span class="sr-only">Toggle navigation</span>
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
            		<span class="icon-bar"></span>
          		 </button>
		          <a class="navbar-brand" href="/">Vitter</a>
		        </div>
		        <div class="collapse navbar-collapse">
		          <ul class="nav navbar-nav">
		            <li class="active"><a href="/">Home</a></li>
		            <li><a href="/welcome">Welcome</a></li>
		            <li><a href="${logoutURL}">Logout</a></li>
		          </ul>
       			 </div><!--/.nav-collapse -->
     		 </div>
    	</div>
    	<div class="container">
  			<jsp:doBody/>
  		</div>
  		 <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
  		 <script src="/resources/js/bootstrap.min.js"></script>	
	</body>
</html>