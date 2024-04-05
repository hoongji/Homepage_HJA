package edu.web.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// TODO : memberUpdate.jsp에서 전송된 데이터로 DB 회원 정보 수정 
//		  회원 정보 수정에 성공하면 memberResult.jsp에 MemberVO 데이터 전송하여 출력

@WebServlet("/update.do")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static MemberDAO dao;   
    
    public UpdateServlet() {
        dao = MemberDAOImple.getInstance();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
	    String userid = request.getParameter("userid");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String emailAgree = request.getParameter("emailAgree");
	    String[] interest = request.getParameterValues("interest"); // 여러 개의 값을 받기 위해 getParameterValues 사용
	    String phone = request.getParameter("phone");
	    String introduce = request.getParameter("introduce");
	    
	    
	    // 받아온 데이터를 MemberVO 객체에 저장
	    MemberVO member = new MemberVO(userid, password, email, emailAgree, interest, phone, introduce);
	    // 꼭 찍어야 하는 로그 (택배가 오면 잘 왔는지 확인) 
	    System.out.println(member);
	    
	    int result = dao.update(member);
	    System.out.println(result);
	    
	    if(result == 1) {
	    	RequestDispatcher dispatcher = 
	    			request.getRequestDispatcher("memberResult.jsp");
	    	request.setAttribute("member", member);
	    	dispatcher.forward(request, response);
	    }
	    
	}

}
