<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/user/changePassword" var="url"/>

<div class="row">
	<div class="col-auto ml-3 p-4 pr-5 border border-light bg-white">
		<a href='<c:url value="/user/information"/>'>Information</a>
		<br>
		<a href='<c:url value="/user/changePassword"/>'>Change password</a>
	</div>
	<div class="col ml-3 pt-3 border border-light bg-white">
		<h2 class="text-primary">Change Password</h2>
		<form action="${url}" method="POST">
			<div class="form-group">
			    <p>Current password</p>
			    <input name="password" id="password" type="password" class="form-control" placeholder="Enter current password" required/>
		  	</div>
			<div class="form-group">
			    <p>New Password</p>
			    <input id="newPassword" name="newPassword" type="password" class="form-control" placeholder="Enter new password" required/>
		 	</div>
		 	<div class="form-group">
			    <p>Confirm New Password</p>
			    <input id="confirmNewPassword" name="confirmNewPassword" type="password" class="form-control" placeholder="Confirm new password" required/>
		 	</div>
		 	<p id="passwordErrorMatch" style="color:red">- New passwords do not match</p>
		 	<p class="msg text-success"></p>
		 	<button id="submit" type="submit" class="btn btn-primary mb-3 float-right">Change</button>
		</form>
	</div>
</div>
<script src="<c:url value="/static/js/changePassword.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/changePassword.css"/>">