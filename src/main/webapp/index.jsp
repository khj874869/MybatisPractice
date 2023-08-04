<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>슈퍼컨덕터 멤버 웹</h1>
	<h2>로그인 페이지</h2>
	<c:if test="${sessionScope.memberId ne null }">
	${memberName } 님 환영합니다. <br>
		<a href="/member/Logout.do">로그아웃</a>
		<a href="/member/myinfo.do?memberId=${memberId}">마이페이지</a>
		<fieldset>
				</c:if>
		
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