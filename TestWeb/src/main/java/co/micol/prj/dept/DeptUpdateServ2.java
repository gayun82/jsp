package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;


@WebServlet("/DeptUpdate")
public class DeptUpdateServ2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
   
	//수정페이지 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String departmentId = request.getParameter("departmentId");
		//부서번호로 단건조회
		DeptDAO deptDAO = new DeptDAO();
		request.setAttribute("dept", deptDAO.selectOne(departmentId));
		request.getRequestDispatcher("WEB-INF/jsp/dept/deptUpdate.jsp")
		.forward(request, response);
	
	}
	
	
	//DB등록 수정 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//파라미터를 VO 담고
		String id = request.getParameter("departmentId");
		String name = request.getParameter("departmentName");
		
		DeptVO vo = new DeptVO();
		vo.setDepartmentId(id);
		vo.setDepartmentName(name);
		//DB처리
		DeptDAO deptDAO = new DeptDAO();
		int cnt = deptDAO.update(vo);
		//결과출력		
		response.getWriter()
		.append(id)
		.append(name);
	}

}
