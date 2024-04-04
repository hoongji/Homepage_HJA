package edu.web.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestFilter extends HttpFilter implements Filter{

	public TestFilter() {
		System.out.println("TestFilter 생성자");
	}
	
	@Override
	public void init() throws ServletException {
		
	}
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 클라이언트로부터 IP얻기
			String ipAddress = req.getRemoteAddr();
			req.setCharacterEncoding("UTF-8");
		//현재 시간과 IP 주소 출력
			System.out.println("IP : " + ipAddress + 
						", Time : " + new Date().toString());
			chain.doFilter(req, res);
	}
	
	@Override
	public void destroy() {
		
	}
	
	
}
