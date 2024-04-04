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
		// TODO : <a> 태그를 이용하여 memberRegister.jsp 이동 링크 생성 
		// TODO : 로그인 form 생성. action="loginAuth.do" method="post"
		
	%>
	
	<a href="memberRegister.jsp">memberRegister.jsp 이동하기</a>
	
	<form action="loginAuth.do" method="post">
	
	
	<label for="userid">사용자 ID:</label>
    <input type="text" id="userid" name="userid"><br>
    
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password"><br><br>
    
	<input type="submit" value="제출"><br>
	</form>
	
</body>
</html>