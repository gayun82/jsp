package co.micol.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.member.command.AjaxMemeberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;


@WebServlet("*.do")//모든 .do요청은 내가 처리한다.
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, Command> map = new HashMap<>();//요청과 실행문을 매핑하기 위해
    
    public FrontController() {//생성자
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		//초기화하는 메소드(Mapping 하는 부분)
		map.put("/main.do", new MainCommand()); //처음 접속하는 페이지 mainCommand가 구현체
		map.put("/memberLoginForm.do", new MemberLoginForm());//로그인 폼 호출
		map.put("/memberLogin.do",new MemberLogin());//로그인 처리
		map.put("/memberLogout.do", new MemberLogout());//로그아웃
		map.put("/memberList.do", new MemberList());//회원목록보기
		map.put("/memberJoinForm.do", new MemberJoinForm());//회원가입화면
		map.put("/ajaxMemberIdCheck.do", new AjaxMemeberIdCheck());//ajax를 이용한
		map.put("/memberJoin.do",new MemberJoin());//회원가입 처리
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실행하는 메소드(서비스 해주는 것)
		request.setCharacterEncoding("utf-8"); //한글깨짐 방지
		String uri = request.getRequestURI();// 요청된 URI를 확인한다.
		String contextPath = request.getContextPath(); //요청 URL로 부터 contextPath를 확인한다.(값을 가지고와서 담는것)
		String page = uri.substring(contextPath.length());//실제 요청 페이지 
		
		Command command = map.get(page); //실제 수행할 Command를 찾음 new MainCommand();
		String viewPage = command.exec(request, response);//요청 Command를 수행하고 결과를 받음 .
		
		//viewResolve
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			if(viewPage.startsWith("ajax:")) {//ajax를 처리하는 뷰 리졸브
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp";//시스템에서 접근 가능한 폴더를 더해주고 
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);//원하는 페이지를 호출해서 전달함
		}else {
			response.sendRedirect(viewPage);//.do로 권한 위임 처리
		}
		
	}

}

