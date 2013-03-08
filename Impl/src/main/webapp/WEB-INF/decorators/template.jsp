<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><decorator:title default="Base Project" /></title>
<link href="<c:url value="/resources/css/main.css"/>"/>
<decorator:head />
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="<c:url value="/usuario/" />">Usu&aacute;rios</a></li>
			<sec:authorize ifNotGranted="ROLE_ANONYMOUS">
			<li><a href="<c:url value="/logout" />">Logout</a></li>
			</sec:authorize>
		</ul>
	</div>
	<div id="sub-conteudo">
		<decorator:body />
	</div>
</body>
</html>