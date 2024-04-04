package edu.web.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



// TODO : memberRegister.jsp에서 전송된 데이터를 DB에 저장
// DB 저장 후에 login.jsp로 이동(심심하면 alert도 띄우기)

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao;  // DB 연결하려면 DAOImple에 연결   
    
	
    public RegisterServlet() {
    	dao = MemberDAOImple.getInstance(); // DB 연결하려면 DAOImple에 연결
    	System.out.println("RegisterServlet()");
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // 요청으로부터 파라미터를 읽어옴
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
	    
	
	    // DB 연결하려면 DAOImple에 연결 
	    int result = dao.insert(member);
	    System.out.println(result);
	    
	    if(result == 1) {
			response.sendRedirect("/Homepage_HJA/login.jsp");
			}
		
	}

}
