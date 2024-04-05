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
		// TODO : 로그인된 사용자 아이디를 저장
		// TODO : form action="update.do" method="post" 생성
		// TODO : userid를 제외한 모든 정보 수정 가능하도록 input 태그 생성 
		//		  userid는 읽기만 가능하도록 input 태그 생성
		String userid = (String)session.getAttribute("userid");//로그인된 = (session)
		
	%>

	<h2>회원 정보 수정</h2>
	
	<form action="update.do" method="post">
	
	<label for="userid">사용자 ID:</label>
    <input type="text" id="userid" value="<%=userid %>" readonly="readonly"><br>
    
    <label for="password">비밀번호:</label>
    <input type="password" id="password" name="password" required="required"><br>
    
    <label for="email">이메일:</label>
    <input type="email" id="email" name="email" ><br>
    
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