package co.micol.prj.dept;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeptList")
public class DeptListServ extends HttpServlet {
 private static final long serialVersionUID = 1L;
    public DeptListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("list", new DeptDAO().selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/dept/deptList2.jsp").forward(request, response);
	}

}
