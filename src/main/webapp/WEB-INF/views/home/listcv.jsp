<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<head>
   <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
</head>

<div class="row">
	<label>Career</label>
	<select class="listCareer browser-default custom-select">
		<option value="all" selected>All</option>
		<c:forEach items="${careers}" var="career">
			<option value="${career}">${career}</option>	
		</c:forEach>
	</select>
	
	<label>Age</label>
	<select class="listAge browser-default custom-select">
		<option value="0" selected>All</option>
		<option value="20"><20</option>
		<option value="30"><30</option>
		<option value="40"><40</option>
		<option value="65"><65</option>
	</select>
	
	<label>City</label>
	<select class="listCity browser-default custom-select mb-3">
	    <option selected value="all">All</option>
	</select>
	
	<button type="submit" class="search btn btn-success" value="<c:url value='/listcv'/>">Search</button>
</div>

<table class="table mt-3">
  <thead>
    <tr>
      <th scope="col">STT</th>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">Career</th>
      <th scope="col">City</th>
      <th scope="col">State</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${listUser}" var="user" begin="0" step="1" varStatus="i">
	    <tr>
	      <td>${i.index+1}</td>
	      <td>${user.name}</td>
	      <td>
	      	<a style="text-decoration: none" href='<c:url value="/${user.username}"/>'>${user.username}</a>
	      </td>
	      <td>${user.career}</td>
	      <td>${user.address}</td>
	      <td>
		      <c:if test="${user.state == 0}">
		      	<span class="badge badge-primary">Waiting</span>
		      </c:if>
		      <c:if test="${user.state == 1}">
		      	<span class="badge badge-danger">Working</span>
		      </c:if>
	      </td>
	    </tr>
	</c:forEach>
  </tbody>
</table>

<script src='<c:url value="/static/js/listcv.js"></c:url>'></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<!-- <script src="https://unpkg.com/axios/dist/axios.min.js"></script> -->