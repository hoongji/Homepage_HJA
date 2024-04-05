<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// TODO : "userid님, 환영합니다" 라고 화면에 출력 
		
		// TODO : 회원 정보 보기 버튼 생성
		// TODO : 로그아웃 버튼 생성
	%>
	
	<!-- 회원정보 보기 / 로그아웃 
		location.href로 이동하면 servlet에서 doGet()을 호출 
		ㄴ GET방식으로 동작
	-->
	<% 
	String userid = (String)session.getAttribute("userid");
	// LoginSevlet 에서 session이 안만들어졌고, GET 방식을 사용하지 않아서 null 값이 나온거였음.
	// 1. loginServlet에서 세션이 만들어지지 않아서 
	// 2. id 가 제대로 있는 지 없는 지 filter로 
	%>
	
	<h2><%=userid%>님, 환영합니다. </h2><br>
	
	<button onclick="location.href='select.do'">회원정보</button> 
	<button onclick="location.href='logout.do'">로그아웃</button>
	
</body>
</html>