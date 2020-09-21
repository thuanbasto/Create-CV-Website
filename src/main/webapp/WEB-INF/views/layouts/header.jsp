<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<head>
	<link rel="stylesheet" type="text/css" href='<c:url value="/static/css/header.css"/>'>
</head>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNavDropdown">
		<ul class="navbar-nav">
			<li class="nav-item active">
				<a class="nav-link" href="<c:url value='/home'/>">Home <span class="sr-only">(current)</span></a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="https://www.facebook.com/thuanbasto" target="_blank">Contact</a>
			</li>
			<security:authorize access="isAuthenticated()">
				<security:authentication property="principal" var="user" />
					<li class="nav-item">
						<a class="nav-link" href="<c:url value='/${user.username}'/>">My CV</a>
					</li>
			</security:authorize>
			<li class="nav-item">
				<a class="nav-link" href="<c:url value='/topcv'/>">Top CV</a>
			</li>
		</ul>
		<ul class="nav navbar-nav ml-auto">
			<security:authorize access="!isAuthenticated()">
				<li class="nav-item">
					<a class="nav-link" href="<c:url value='/signIn'/>">Sign In</a>
				</li>
				<li class="nav-item">
					<a class="signIn nav-link text-info" href="<c:url value='/signUp'/>">Sign Up</a>
				</li>
			</security:authorize>
			<security:authorize access="isAuthenticated()">
				<security:authentication property="principal" var="user" />
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle text-info" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
							${user.username}
						</a>
						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="<c:url value='/user/information'/>">My information</a> 
							<security:authorize access="hasAuthority('ROLE_ADMIN')">
							<a class="dropdown-item" href="<c:url value='/admin/listUser'/>">Manager</a> 
							</security:authorize>
							<a class="dropdown-item" href="<c:url value='/user/editCV'/>">Edit CV</a> 
							<a class="dropdown-item" href="<c:url value='/logout'/>">Logout</a>
						</div>
					</li>
			</security:authorize>
		</ul>
	</div>
</nav>
<script src="<c:url value="/static/js/header.js"/>"></script>
