<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}

<c:if test="${error}">
    <span><fmt:message key="login.invalido"/></span>
</c:if>

	<h3>Login with Username and Password</h3>
<form name="f" action="<c:url value="j_spring_security_check" />" method="post">
 <table>
    <tr><td>User:</td><td><input type="text" name="j_username" value=""></td></tr>
    <tr><td>Password:</td><td><input type="password" name="j_password"/></td></tr>
    <tr><td colspan="2"><input name="submit" type="submit" value="Login"/></td></tr>
  </table>
</form>
</body>
</html>