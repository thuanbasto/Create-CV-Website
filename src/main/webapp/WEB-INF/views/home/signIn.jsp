<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:url value="/signIn" var="url"/>

<div class="mx-auto" style="width:50%;">
	<h1 class="mx-auto">Sign In</h1>
	<div style="width: 70%;">
	<form action="${url}" method="POST">
	  <div class="form-group">
	    <label>Username</label>
	    <input name="username" class="form-control" placeholder="Enter username" required/>
	  </div>
	  <div class="form-group">
	    <label>Password</label>
	    <input name="password" type="password" class="form-control" placeholder="Password" required/>
	  </div>
	  <p style="color:red">${msg}</p>
	  <button id="submit" type="submit" class="btn btn-primary">Sign in</button>
	</form>
	</div>
</div>
