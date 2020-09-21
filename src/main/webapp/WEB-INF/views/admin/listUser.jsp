<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1 class="text-center">List User</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">email</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${listUser}" var="user">
	    <tr>
	      <th scope="row">${user.user_ID}</th>
	      <td>${user.name}</td>
	      <td>${user.username}</td>
	      <td>${user.email}</td>
	      <td>
	      	<a href='<c:url value="/admin/userInformation/${user.user_ID}"/>'>Detail</a>
	      	<a href='<c:url value="/admin/deleteUser/${user.user_ID}"/>'>Delete</a>
	      	<a href='<c:url value="/admin/editUser/${user.user_ID}"/>'>Edit</a>
	      </td>
	    </tr>
	</c:forEach>
  </tbody>
</table>