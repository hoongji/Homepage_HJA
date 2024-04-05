package edu.web.member;

import java.io.IOException;
import java.io.PrintWriter;

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
		 //  memberRegister.jsp에서 전송된 데이터를 DB에 저장
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
	
	    // DB 연결하려면 DAOImple에 연결 
	    int result = dao.insert(member);
	    System.out.println(result);
	    
	    // DB 저장에 성공하면 login.jsp 페이지로 이동 => sendRedirect로 이동(페이지 변경) 
//	    if(result == 1) {
//			response.sendRedirect("/Homepage_HJA/login.jsp"); // sendRedirect는 실행되면 alert 안뜨고 걍 페이지 이동댐 
//			}
		
	    PrintWriter out = response.getWriter();
	    if(result == 1) {
	    	out.print("<script>alert('등록 성공!');</script>");
	    	out.print("<script>location.href='login.jsp';</script>");
	    }
	    
	}

}
