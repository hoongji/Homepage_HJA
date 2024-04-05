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
	String userId = (String)session.getAttribute("userId");
	// 제대로 전달이 안됨!
	%>
	
	<h2><%=userId%>님, 환영합니다. </h2><br>
	
	<button onclick="location.href='select.do'">회원정보</button>
	<button onclick="location.href='logout.do'">로그아웃</button>
	
</body>
</html>