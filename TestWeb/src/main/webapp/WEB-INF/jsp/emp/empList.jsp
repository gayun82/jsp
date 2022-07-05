<%@page import="co.micol.prj.emp.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empList</title>
</head>
<body>
<h3>사원목록</h3>
<a href="/TestWeb/empInsert">사원등록</a><br><!-- href="http://TestWeb/empInsert" 가능 -->
<form>
 	<input name="departmentId">
 	<button>검색</button>
</form>

	<table>
		<thead>
			<tr>
				<th>사번</th>
				<th>이름</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="vo" items="${list}"><%--for() --%>
			<tr>
				<td>${vo.employeeId}</td>
				<td>${vo.firstName}</td>
				<td>${vo.salary}</td>
				<td></td>
			</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>