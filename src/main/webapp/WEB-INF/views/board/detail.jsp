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
	.pre-wrap {
		white-space: pre-wrap;
	}
</style>
<script>
$(function(){
	
	var boardNo = $('#board-no').text();
	
	$('#btn-download').click(function(){
		window.location = "down.do?no=" + boardNo;
	});
	
	$('#btn-like').click(function(){
		window.location = "like.do?no=" + boardNo;
	});
	
	$('#btn-list').click(function(){
		window.location = "list.do";
	});
	
});
</script>
</head>
<body>
<c:set var="menu" value="board" />
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>게시글 정보</h1>
	
	<table class="table table-bordered table-striped table-condensed">
		<tbody>
			<tr>
				<th>번호</th>
				<td id="board-no"><c:out value="${board.no }" /></td>
				<th>등록일</th>
				<td><fmt:formatDate value="${board.createDate }"/></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><c:out value="${board.title }" /></td>
				<th>추천수</th>
				<td><c:out value="${board.likes }"/></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<c:choose>
						<c:when test="${not empty board.filename }">
							<c:out value="${board.filename }" /> <span id="btn-download" class="btn btn-info btn-xs">받기</span>
						</c:when>
						<c:otherwise>
							없음
						</c:otherwise>
					</c:choose>
				</td>
				<th>닉네임</th>
				<td><c:out value="${board.nick }" /></td>
			</tr>
			<tr>
				<td class="pre-wrap" colspan="4"><c:out value="${board.contents }" /></td>
			</tr>
		</tbody>
	</table>
	<div>
		<c:if test="${board.nick ne LOGIN_USER.nick }">
			<span id="btn-like" class="btn btn-success">추천</span>
		</c:if>
		<span id="btn-list" class="btn btn-primary">목록</span>
	</div>
</div>
</body>
</html>