package co.micol.prj.emp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.dept.DeptDAO;

@WebServlet("/empInsert")
public class EmpInsertServ extends HttpServlet{
	//등록페이지로 이동
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//db조회
		//jobs, 부서, 사원
		EmpDAO empDAO = new EmpDAO();
		request.setAttribute("jobs", empDAO.selectJobs());
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("depts", deptDAO.selectAll());
		
		request.getRequestDispatcher("/WEB-INF/jsp/emp/empInsert.jsp")
			   .forward(request, response);
	}

	

	//등록처리
	// doPost
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		
		
		String id = request.getParameter("employeeId");
		String name = request.getParameter("lastName");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");
		String jobId = request.getParameter("jobId");
		
		EmpVO vo =new EmpVO();
		vo.setEmployeeId(id);
		vo.setLastName(name);
		vo.setEmail(email);
		vo.setHireDate(hireDate);
		vo.setJobId(jobId);
		
		EmpDAO empDAO = new EmpDAO();
		int cnt = empDAO.insert(vo);
		System.out.println(cnt +"건등록 완료");
		
		response.getWriter()
		.append(id)
		.append(name)
		.append(email)
		.append(hireDate)
		.append(jobId);
	}
}
