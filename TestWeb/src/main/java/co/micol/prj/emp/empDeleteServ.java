package co.micol.prj.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/empDelete")
public class empDeleteServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public empDeleteServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		//파라미터
		String id = request.getParameter("employeeId");
		//dao =>delete메서드
		EmpDAO dao = new EmpDAO();
		int cnt = dao.delete(id);
		
		response.getWriter()
				.append("<script>")
				.append("alert('"+cnt+"건 삭제 완료');")
				.append("location.href='empList';")
				.append("</script>");
		//request.setAttribute("msg", cnt + "삭제됨");
		//request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
