<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">
	<%-- <link rel="stylesheet" href="<c:url value="/static/vendor/datatables/jquery.dataTables.min.css"/>"> --%>
</head>
<div class="container-fluid">

<!-- Page Heading -->
<h1 class="h3 mb-2 text-gray-800">Admin Page</h1>

<!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h2 class="m-0 font-weight-bold text-primary">List User</h2>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>State</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Username</th>
                            <th>Email</th>
                            <th>State</th>
                            <th>Action</th>
                        </tr>
                    </tfoot>
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
            </div>
        </div>
    </div>
</div>
<script src="<c:url value="/static/vendor/jquery/jquery.min.js"/>"></script>
<script src="<c:url value="/static/vendor/jquery/jquery.slim.min.js"/>"></script>
<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> -->
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
<script src='<c:url value="/static/js/listUser.js"></c:url>'></script>
