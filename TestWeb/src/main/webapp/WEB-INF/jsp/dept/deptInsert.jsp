<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	funcion validationForm(){
		if(empFrm.departmentId.value == ""){
			alert("부서번호 입력");
			return;
		}
		empFrm.submit();// 폼 전송(submit 버튼 클릭과 같음)
	}
</script>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<form action="DeptInsert" method="get">
		부서번호<input name="departmentId"><br>
		부서명<input name="departmentName">
		<button type="button" onclick="validationForm()">부서등록</button>
	</form>

</body>
</html>