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
</head>
<body>
<c:set var="menu" value="book" />
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<form class="well" method="post" action="search.do" >
		<div class="row">
			<div class="form-group">
				<select class="form-control" name="status">
					<option value="N" >판매중</option>
					<option value="Y" >절판</option>
				</select>
			</div>
		</div>
		<div class="row">
			<div class="form-group col-sm-1">
				<label class="control-label">과학</label>
				<input class="form-control" type="checkbox" name="categories" value="과학" >
			</div>
			<div class="form-group col-sm-1 col-sm-offset-1">
				<label class="control-label">소설</label>
				<input class="form-control" type="checkbox" name="categories" value="소설" >
			</div>
			<div class="form-group col-sm-1 col-sm-offset-1">
				<label class="control-label">인문</label>
				<input class="form-control" type="checkbox" name="categories" value="인문" >
			</div>
		</div>
		<div class="row">
			<div class="form-group">
				<label class="control-label">제목</label>
				<input class="form-control" type="text" name="title" >
			</div>
			<div class="form-group">
				<label class="control-label">저자</label>
				<input class="form-control" type="text" name="author" >
			</div>
			<div class="form-group">
				<label class="control-label">출판사</label>
				<input class="form-control" type="text" name="publisher" >
			</div>
		</div>
		<div class="text-right">
			<button class="btn btn-default" >검색</button>
		</div>
	</form>
</div>
</body>
</html>