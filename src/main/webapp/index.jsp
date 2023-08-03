<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	로그인이 성공했으면 보여요 : ${sessionScope.memberId }
	<h1>또 멤버 웹</h1>
	<h2>로그인 페이지</h2>
		<a href="/member/Logout.do">로그아웃</a>
		<a href="/member/myinfo.do?memberId=${memberId}">마이페이지</a>
		<fieldset>
			<legend>로그인</legend>
	<form action="/member/login.do" method="post">
				<input type="text" name="member-id"><br> <input
					type="password" name="member-pw">
				<div>
					<input type="submit" value="로그인"> <input type="reset"
						value="취소">
						<a href="/member/enroll.jsp">회원가입</a>
				</div>
			</form>
			<br>
		</fieldset>
</body>
</html>