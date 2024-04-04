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
		// TODO : 회원 가입 form 생성. action="register.do" method="post"
	%>
	
	<h2>회원 가입하기</h2>
	<form action="register.do" method="post">
	
	<label for="userid">사용자 ID:</label>
    <input type="text" id="userid" name="userid"><br>
    
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password"><br>
    
    <label for="email">이메일:</label>
    <input type="email" id="email" name="email"><br>
    
    <label for="emailAgree">이메일 수신 동의:</label>
    <input type="checkbox" id="emailAgree" name="emailAgree" value="agree"><br>
    
    <label for="interest">관심사:</label><br>
    <input type="checkbox" id="interest_sports" name="interest" value="서버 개발">
    <label for="interest_sports">서버 개발</label><br>
    <input type="checkbox" id="interest_music" name="interest" value="앱 개발">
    <label for="interest_music">앱 개발</label><br>
    <!-- 다른 관심사에 대해서도 유사하게 생성 가능 -->
    
    <label for="phone">전화번호:</label>
    <input type="tel" id="phone" name="phone"><br>
    
    <label for="introduce">자기 소개:</label><br>
    <textarea id="introduce" name="introduce" rows="4" cols="50"></textarea><br>
    
    <input type="submit" value="제출">
		
	</form>
	
</body>
</html>