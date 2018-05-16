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
<script>
$(function(){
	
	var $tbody = $('#tbody-boards');
	
	$tbody.on('click', 'tr', function(event){
		event.stopPropagation();
		window.location = 'detail.do?no=' + $(this).find('td:first').text();
	});
	
	$tbody.on('click', 'tr td span:eq(0)', function(event){
		event.stopPropagation();
		window.location = 'del.do?no=' + $(this).parents('tr:eq(0)').find('td:first').text();
	});
	
	$tbody.on('click', 'tr td span:eq(1)', function(event){
		event.stopPropagation();
		window.location = 'modify.do?no=' + $(this).parents('tr:eq(0)').find('td:first').text();
	});
	
	$('#btn-new').click(function(){
		window.location = "form.do";
	});
	
});
</script>
</head>
<body>
<c:set var="menu" value="board" />
<%@ include file="../include/nav.jsp" %>
<div class="container">
	<h1>게시글 리스트</h1>
	<table class="table table-hover">
		<colgroup>
			<col style="width: 10%" >
			<col style="width: *" >
			<col style="width: 10%" >
			<col style="width: 15%" >
			<col style="width: 15%" >
		</colgroup>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="tbody-boards">
		<c:choose>
			<c:when test="${empty boards }">
				<tr>
					<td class="text-center" colspan="5">검색된 게시글이 존재하지 않습니다.</td>
				</tr>	
			</c:when>
			<c:otherwise>
				<c:forEach var="board" items="${boards }">
					<tr>
						<td><c:out value="${board.no }"></c:out></td>
						<td><c:out value="${board.title }"></c:out></td>
						<td><c:out value="${board.nick }"></c:out></td>
						<td><fmt:formatDate value="${board.createDate }"/></td>
						<td>
							<c:if test="${board.nick eq LOGIN_USER.nick }">
								<span class="btn btn-danger btn-xs">삭제</span>
								<span class="btn btn-warning btn-xs">수정</span>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<div class="text-right">
		<span id="btn-new" class="btn btn-default">새 글</span>
	</div>
</div>
</body>
</html>