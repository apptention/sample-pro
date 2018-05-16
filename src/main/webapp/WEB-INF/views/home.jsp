<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
	.nowrap {
		white-space: pre-line;
	}
</style>
</head>
<body>
<c:set var="menu" value="home" />
<%@ include file="include/nav.jsp" %>
<div class="container">
	<div class="jumbotron">
		<h1>스프링 심플 게시판</h1>
		<p class="nowrap">
			<span class="nowrap">본 사이트를 방문해 주셔서 감사합니다.</span>
			<span class="nowrap">회원가입, 로그인, 로그아웃, </span>
			<span class="nowrap">게시판, 첨부파일 업로드/다운로드 </span>
			<span class="nowrap">등등의 기능이 포함된 심플 게시판입니다.</span>
		</p>
	</div>
</div>
</body>
</html>