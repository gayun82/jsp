<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>message.jsp</title>
<style>
div {
	background-color: cyan;
	font-size: 30px;
}
</style>
</head>
<body>
<script>
alert('<%=request.getAttribute("msg")%>')
location.href='empList'
</script>
	<%-- <jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include> --%>
	<%-- <%=request.getAttribute("msg")%> --%>
</body>
</html>