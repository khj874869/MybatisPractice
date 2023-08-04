<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>공지사항 수정</title>
	</head>
<body>
<h1>공지사항 작성</h1>
	<form action="/notice/update.do" method="post">
	<fieldset>
	<input type="hidden" name="noticeNo"value="${notice.noticeNo }">
		<legend>공지사항 수정</legend>
			<ul>
			<li>
				<label>제목</label>
				<input type="text" id="" name="noticeSubject" value= "${notice.noticeSubject }">
			</li>
				<li>
				<label>내용</label>
				<textarea rows="30" cols="40" name="noticeContent" value="${notice.noticeContent }"></textarea>
				</li>
			</ul>

	</fieldset>
	<div>
		<input type ="submit" value="작성">
		<input type="reset"value="초기화">
	</div>
	</form>
</body>
</html>