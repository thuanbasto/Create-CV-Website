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
      <th scope="col">Email</th>
      <th scope="col">State</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${listUser}" var="user">
	    <tr>
	      <th scope="row">${user.user_ID}</th>
	      <td>${user.name}</td>
	      <td><a href='<c:url value="/${user.username}"/>'>${user.username}</a></td>
	      <td>${user.email}</td>
	      <td>
		      <c:if test="${user.state == 0}">
		      	<span class="badge badge-primary">Waiting</span>
		      </c:if>
		      <c:if test="${user.state == 1}">
		      	<span class="badge badge-danger">Working</span>
		      </c:if>
	      </td>
	      <td>
	      	<a href='<c:url value="/admin/userInformation/${user.user_ID}"/>'><i class="fas fa-edit"></i></a>
	      	<a href='<c:url value="/admin/deleteUser/${user.user_ID}"/>'
	      		onclick="return confirm('Are you sure want to delete this user?')"
	      	><i class="fas fa-trash-alt"></i></a>
	      </td>
	    </tr>
	</c:forEach>
  </tbody>
</table>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>