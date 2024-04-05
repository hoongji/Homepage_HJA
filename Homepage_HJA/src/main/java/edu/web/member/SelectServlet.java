package edu.web.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		ArrayList<MemberVO> list = dao.select(); // 로그인된 사용자의 정보를 DB에서 select
		
		// MemberVO 불러와서 
		request.setAttribute("list",list);
		request.getRequestDispatcher("/memberResult.jsp"); // memberResult.jsp로 전송
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
