<%@page import="edu.web.member.MemberVO"%>
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
		// TODO : 회원 정보 출력 
		// TODO : 회원 수정 버튼 생성(경로 : memberUpdate.jsp)
		// TODO : 회원 탈퇴 버튼 생성(경로 : delete.do)
		MemberVO vo = (MemberVO)request.getAttribute("vo");
	%>
	
	
	<h2>회원 정보 출력</h2><br>
	
	<p>아이디 : <%=vo.getUserid() %></p>
	<p>비밀번호 : <%=vo.getPassword() %></p>
	<p>이메일 : <%=vo.getEmail() %></p>
	<p>이메일 수신 여부 : <%=vo.getEmailAgree() %></p>
	<p>관심사항 : </p>
	
	<p><%=vo.getInterestJoin() %></p>
	
	<p>핸드폰 : <%=vo.getPhone() %></p>
	<p>자기소개 : </p>
	<p> <%=vo.getIntroduce() %></p>
	
	<button onclick="location.href='memberUpdate.jsp'">회원 수정</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
	
</body>
</html>