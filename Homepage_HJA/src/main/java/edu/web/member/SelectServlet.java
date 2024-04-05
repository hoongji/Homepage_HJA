package edu.web.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// TODO : loginResult.jsp에서 이동
// 로그인된 사용자의 정보를 DB에서 select
// select된 MemberVO 데이터를 memberResult.jsp로 전송

@WebServlet("/select.do")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;  // DB 연결하려면 DAOImple에 연결   
    
	
    public SelectServlet() {
    	dao = MemberDAOImple.getInstance(); // DB 연결하려면 DAOImple에 연결
    	System.out.println("SelectServlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("userid");
		
		if(userid != null) { // session에 id가 있다면
			MemberVO vo = dao.select(userid);
			System.out.println(vo);
			
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("memberResult.jsp"); //경로에 /가 있음 : 컨텍스트 루트(context root)부터의 절대 경로
																//반면에 /가 없는 경우에는 현재 요청한 서블릿의 경로를 기준으로 상대 경로
			request.setAttribute("vo",vo);
			dispatcher.forward(request,response); // 포워딩 방식 : request에 싸서 보냄
		}
		
		//ArrayList<MemberVO> list = dao.select(); // 로그인된 사용자의 정보를 DB에서 select
		
		// MemberVO 불러와서 
		//request.setAttribute("list",list);
		//request.getRequestDispatcher("/memberResult.jsp"); // memberResult.jsp로 전송
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
