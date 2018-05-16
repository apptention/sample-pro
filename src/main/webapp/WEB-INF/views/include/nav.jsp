<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<style>
	.no-radius {
		border-radius: 0px;
	}

	.spot-on {
		margin: 0px;
		padding: 0px;
	}
	
	.thin {
		height: 22px;
	}
	
	.selected { 
		background-color: rgb(60, 60, 60);
	}
</style>
<nav class="navbar navbar-inverse spot-on no-radius" >
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand" href="/home.do">Simple Board</a>
		</div>
		<ul class="nav navbar-nav">
			<li ${menu eq 'home' ? "class='selected'" : '' } ><a href="/home.do"><spring:message code="nav.menu.label.home" /></a></li>
			<li ${menu eq 'board' ? "class='selected'" : '' } ><a href="/board/list.do"><spring:message code="nav.menu.label.board" /></a></li>
			<li ${menu eq 'book' ? "class='selected'" : '' } ><a href="/book/form.do"><spring:message code="nav.menu.label.book" /></a></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${empty LOGIN_USER }">
					<li><a ${menu eq 'register' ? "class='selected'" : '' } href="/user/form.do"><spring:message code="nav.menu.label.register" /></a></li>
					<li><a ${menu eq 'login' ? "class='selected'" : '' } href="/user/login.do"><spring:message code="nav.menu.label.login" /></a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/user/logout.do"><spring:message code="nav.menu.label.logout" /></a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav> 
<div class="row thin spot-on" align="center" >
	<c:if test="${not empty LOGIN_USER }">
		<div class="alert spot-on thin no-radius" style="background-color: #625750; color: rgb(180,180,180);">
			<p class="spot-on"><strong>${LOGIN_USER.nick }</strong>님 <spring:message code="nav.menu.welcome.msg" /></p>
		</div>
	</c:if>
</div>
