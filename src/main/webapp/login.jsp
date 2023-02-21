<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="test.css">
</head>
<body class="login-page-body"> 
  
    <div class="login-page">
    
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h1>Welcome!</h1>
            <%if(request.getAttribute("error") != null){%>
            	<p class="text-danger">Please check your data again.</p>
            <%} %> 
            
          </div>
        </div>
        <form class="login-form" action="loginServlet" method="post" name="confirm">
          <input type="text" placeholder="User ID" name="name"  />
          <input type="password" placeholder="Password" name="password" />
          <button type="submit">login</button>
          <p class="message">Not registered? <a href="register.jsp">Create an account</a></p>
        </form>
      </div>
    </div>
</body>
</html>