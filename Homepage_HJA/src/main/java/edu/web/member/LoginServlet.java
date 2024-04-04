package edu.web.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * TODO : login.jsp에서 입력받은 아이디, 패스워드를 DB의 데이터와 비교해서 
 * 데이터가 일치하면 - 로그인 세션 생성 및 로그인 성공(loginResult.jsp)로 이동 
 * (아이디 값에 대한 세션 생성. 세션 만료 시간 60초)
 * 데이터가 일치하지 않으면 - login.jsp로 이동(심심하면 실패 alert 띄우기)
 */

@WebServlet("/loginAuth.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static MemberDAO dao; // DB 연결
	
    public LoginServlet() {
    	dao = MemberDAOImple.getInstance(); // DB 연결하려면 DAOImple에 연결
    	System.out.println("LoginServlet()");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // 세션 가져오기
		
		System.out.println("login.jsp 에서 id,pw 읽어오기");
		String  id = request.getParameter("userid");
		String  pw = request.getParameter("password");
		
		
		// DB 저장된 아이디랑 비밀번호 읽어오기
		
		 System.out.println("id = " +  id + " , Userid = " + dao.getId(id));
		 System.out.println("pw = " + pw + " , Password = " + dao.getPw(pw));
		
		 
		 
		 // 처음 DB에 들어간 값만 읽어옴(?)
		if(id.equals(dao.getId(id)) && pw.equals(dao.getPw(pw))) {
			System.out.println("id 세션을 생성(만료 시간은 자유롭게 설정)"); 	
			session.setAttribute("userid", id);;  	
			session.setMaxInactiveInterval(60); // 60초
			response.sendRedirect("/Homepage_HJA/loginResult.jsp");
			
		}else {
			System.out.println("로그인 실패!");
			response.sendRedirect("/Homepage_HJA/login.jsp");
		}
		
	}

}
