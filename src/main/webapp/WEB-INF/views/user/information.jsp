<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:url value="/user/editInformation" var="url"/>

<div class="row">
	<div class="col-auto ml-3 p-4 pr-5 border border-light bg-white">
		<a href='<c:url value="/user/information"/>'>Information</a>
		<br>
		<a href='<c:url value="/user/changePassword"/>'>Change password</a>
	</div>
	<div class="col ml-3 pt-3 border border-light bg-white">
		<h2 class="text-primary">Information</h2>
		<form:form action="${url}" modelAttribute="userDTO" method="POST" cssClass="row" enctype="multipart/form-data">
			<form:hidden path="user_ID"/>
			<form:hidden path="imageUrl"/>
			<div class="col-auto">
				<div>
					<img src="<c:url value="/static/image/${userDTO.imageUrl}"/>" id="avatar" width="100px" height="100px" class="rounded-circle"/>
				</div>
				<div class="divUploadFile file btn btn-lg btn-primary mt-2">
      				Upload
                    <form:input type="file" path="file" onchange="document.getElementById('avatar').src = window.URL.createObjectURL(this.files[0])"/>
                </div>
			</div>
			<div class="form-group col">
				<div class="form-inline mb-3">
				    <label>Name<span style="color:red">*</span></label>
				    <span class="span ml-4">${userDTO.name}</span>
				    <form:input path="name" class="form-control ml-4" required="required"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Birthday<span style="color:red">*</span></label>
				    <span class="span ml-4">${userDTO.birthday}</span>
				    <form:input path="birthday" class="form-control ml-4" placeholder="YYYY/MM/DD" maxlength="10" required="required"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Phone</label>	
				    <span class="span ml-4">${userDTO.phone}</span>
				    <form:input path="phone" class="form-control ml-4"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Address</label>
				    <span class="span ml-4">${userDTO.address}</span>
				    <form:input path="address" class="form-control ml-4"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Career</label>
				    <span class="span ml-4">${userDTO.career}</span>
				    <form:input path="career" class="form-control ml-4"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Maxim</label>
				    <span class="span ml-4">${userDTO.maxim}</span>
				    <form:input path="maxim" class="form-control ml-4"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Email<span style="color:red">*</span></label>
				    <span class="span ml-4">${userDTO.email}</span>
				    <form:input path="email" class="form-control ml-4" type="email" required="required"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Username</label>
				    <span class="span ml-4" >${userDTO.username}</span>
				    <form:input path="username" class="form-control ml-4" disabled="true"/>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Facebook</label>
				    <a class="tagfb ml-4" target="_blank" href="https://${userDTO.facebook}">${userDTO.facebook}</a>
				    <form:input path="facebook" class="form-control ml-4" placeholder="fb.com/abcxyz"/>
			  	</div>
			  	<div class="form-inline pl-5">
				    <button id="edit" class="btn btn-danger ml-5" >Edit</button>
				    <button id="cancel" class="btn btn-danger ml-5" >Cancel</button>
				    <button id="save" type="submit" class="btn btn-success ml-5" autofocus="autofocus">Save</button>
			  	</div>
			</div>
		</form:form>
	</div>
</div>
<script src="<c:url value="/static/js/information.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/information.css"/>">