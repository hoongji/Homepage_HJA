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
	%>
	<%= request.setCharacterEncoding("UTF-8") %>
	<jsp:useBean id="member" class="edu.web.member.MemberVO" />
	<jsp:setProperty property="*" name="member" />
	
	
	<h2>회원 정보 출력</h2><br>
	
	<p>아이디 : <%=member.getUserid() %></p>
	<p>비밀번호 : <%=member.getPassword() %></p>
	<p>이메일 : <%=member.getEmail() %></p>
	<p>이메일 수신 여부 : <%=member.getEmailAgree() %></p>
	<p>관심사항 : <%=member.getInterest() %></p>
	
	<%=member.getInterestJoin() %>
	
	<p>핸드폰 : <%=member.getPhone() %></p>
	<p>자기소개 : <%=member.getIntroduce() %></p>
	
	<button onclick="location.href='memberUpdate.jsp'">회원 수정</button>
	<button onclick="location.href='delete.do'">회원 탈퇴</button>
	
</body>
</html>