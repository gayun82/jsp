package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리
		HttpSession session = request.getSession();//서버가 만들어 놓은 세션을 가져온다.
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = memberDao.memberLogin(vo);
		if(vo.getMemberName() != null) {
			session.setAttribute("id", vo.getMemberId());//세션에 담는다 
			session.setAttribute("author", vo.getMemberAuthor());
			session.setAttribute("name", vo.getMemberName());
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		}else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		return "member/memberLogin";
	}

}
