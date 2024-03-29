<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>

<script>
function validateForm(){
	if(window.document.empFrm.employeeId.value == ""){
		alert("사번입력");
		empFrm.employeeId.focus();
		return false;
	}
	if(window.document.empFrm.lastName.value == ""){
		alert("이름입력");
		empFrm.lastName.focus();
		return false;
	}
	if(window.document.empFrm.email.value == ""){
		alert("메일주소 입력");
		empFrm.email.focus();
		return false;
	}
	if(window.document.empFrm.hireDate.value == ""){
		alert("입사일 입력");
		empFrm.hireDate.focus();
		return false;
	}
	if(window.document.empFrm.jobId.value == ""){
		alert("부서입력");
		empFrm.jobId.focus();
		return false;
	}
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(regExp.test(empfrm.email.value) == false){
		alert("이메일 형식");
		empFrm.email.focus();
	}
	return true;
}
</script>
<style>
	body {
	
	}
	 form {
            border-top: 2px solid slateblue;
            
        }

        form>label {
            display: inline-block;
            width: 15%;
            background-color: darkgrey;
        }
</style>
</head>
<body>
<jsp:include page="/WEB-INF/jsp/header.jsp"></jsp:include>
	<h3>사원등록</h3>
	<form action="empInsert" name="empFrm" method="post" onsubmit="return validateForm()">

        <label for="employeeId">사원번호</label>
        <input type="number" name="employeeId" id="employeeId"><br>
        <!--파라메타-->
        <label for="lastName">이름</label>
        <input type="text" name="lastName" id="lastName"><br>

        <label for="email">이메일</label>
        <input type="text" name="email" id="email"><br>

        <label for="hireDate">입사일</label>
        <input type="text" name="hireDate" id="hireDate"><br>

        <label>부서</label>
        <%
        ArrayList<DeptVO> depts = (ArrayList<DeptVO>)request.getAttribute("depts");
        for(DeptVO dept : depts){
        %>
       
        <input type="radio" name="departmentId" value="<%=dept.getDepartmentId()%>">
       				 <%=dept.getDepartmentName()%>
       <%} %>
<br>
	
 
 
        <label>부서번호</label>
        	<select name="jobId">
        <% ArrayList<JobsVO> jobs = (ArrayList<JobsVO>)request.getAttribute("jobs");
       		 for(JobsVO job : jobs){ %>
       	 	<option value="<%=job.getJobId()%>"><%=job.getJobTitle()%>
        	<%} %>
        	</select>
        <br>
        
        <input type="submit" value="저장">
        <input type="button" value="선택삭제" id="deleteSel">

	</form>
	<div id="show">
        <table border="1">
            <!-- <caption>도서리스트</caption> -->
            <thead>
                <tr>
                    <!-- <th><input type="checkbox" name="checkbox"></th> -->
                    <th>사원번호</th>
                    <th>이름</th>
                    <th>이메일</th>
                    <th>입사일</th>
                    <th>부서</th>
                  


                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</body>
</html>