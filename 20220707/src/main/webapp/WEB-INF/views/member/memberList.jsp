<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${list}" var="m">
		${m.memberId} : ${m.memberName} : ${m.memberAuthor}<br>
	</c:forEach>
	<div>
	
	
	</div>
</body>
</html>