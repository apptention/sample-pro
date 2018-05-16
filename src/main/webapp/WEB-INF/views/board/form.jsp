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
<c:set var="menu" value="board" />
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h3>게시글 등록폼</h3>
	<form id="board-form" class="well" method="post" action="add.do" enctype="multipart/form-data">
		<div class="form-group has-warning has-feedback">
			<label class="control-label">제목</label>
			<input type="text" class="form-control" name="title" />
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display: none;"></span>
		</div>
		<div class="form-group has-warning has-feedback">
			<label class="control-label">내용</label>
			<textarea rows="4" class="form-control" name="contents"></textarea>
			<span class="glyphicon glyphicon-remove form-control-feedback" style="display: none;"></span>
		</div>
		<div class="form-group">
			<label>첨부파일</label>
			<input type="file" class="form-control" name="uploadFile" />
		</div>
		<div class="text-right">
			<button class="btn btn-primary" >등록</button>
		</div>
	</form>
</div>
</body>
<script>
$(function(){
	
	var $title = $(':input[name=title]');
	var $contents = $(':input[name=contents]');

	function valid($tag){
		
		return $tag;
	}
	
	function invalid($tag){
		
		return $tag;
	}
	
	$title.parents('.form-group').keyup(function(){
		if($title.val().trim() == ""){
			$title.parents('.form-group').addClass('has-warning').removeClass('has-success').find('span').show();
		} else {
			$title.parents('.form-group').addClass('has-success').removeClass('has-warning').find('span').hide();
		}
	});
	
	$contents.parents('.form-group').keyup(function(){
		if($contents.val().trim() == ""){
			$contents.parents('.form-group').addClass('has-warning').find('span').show();
		} else {
			$contents.parents('.form-group').removeClass('has-warning').find('span').hide();
		}
	});
	
	$('#board-form').submit(function(){
		if($title.parents('.form-group').hasClass('has-warning')){
			alert('제목을 입력하세요...')
			$title.focus();
			return false;
		}
		if($contents.parents('.form-group').hasClass('has-warning')){
			alert('내용을 입력하세요...')
			$contents.focus();
			return false;
		}		

		return true;
	});
});
</script>
</html>