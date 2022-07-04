<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
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
	<h3>사원등록</h3>
	<form action="emp" name="empFrm" method="post" enctype="multipart/form-data">

        <label for="employeeId">사원번호</label>
        <input type="number" name="employeeId" id="employeeId"><br>
        <!--파라메타-->
        <label for="fistName">이름</label>
        <input type="text" name="fistName" id="fistName"><br>

        <label for="email">이메일</label>
        <input type="text" name="email" id="email"><br>

        <label for="hireDate">입사일</label>
        <input type="text" name="hireDate" id="hireDate"><br>

        <label for="jobId">부서</label>
        <input type="text" name="jobId" id="jobId"><br>

		<label for="salary">급여</label>
        <input type="number" name="salary" id="salary"><br>


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
                    <th>급여</th>


                </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</body>
</html>