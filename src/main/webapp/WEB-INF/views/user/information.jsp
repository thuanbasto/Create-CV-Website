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
		<input class="url" type="hidden" value='<c:url value="/"/>'>
		<h2 class="text-primary">Information</h2>
		<form:form action="${url}" modelAttribute="userDTO" method="POST" cssClass="row" enctype="multipart/form-data">
			<form:hidden path="user_ID"/>
			<form:hidden path="imageUrl"/>
			<div class="col-auto">
				<c:choose>
				    <c:when test="${!empty userDTO.imageUrl && userDTO.imageUrl != 'null'}">
	                	<img id="avatar" class="rounded-circle" width="120px" height="120px" src="<c:url value="/static/image/${userDTO.imageUrl}"/>">
				    </c:when>    
				    <c:otherwise>
	                	<img id="avatar" class="rounded-circle" width="120px" height="120px" src="<c:url value="/static/image/default-avatar.jpg"/>">
				    </c:otherwise>
				</c:choose>
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
				    <label>City</label>
				    <span class="span ml-4">${userDTO.address}</span>
				    <form:select path="address" class="form-control browser-default custom-select listCity ml-4" required="required">
				    	<form:option value="${userDTO.address}" selected="selected">${userDTO.address}</form:option>
				    </form:select>
			  	</div>
			  	<div class="form-inline mb-3">
				    <label>Career</label>
				    <span class="span ml-4">${userDTO.career}</span>
				    <form:input path="career" class="form-control ml-4" required="required"/>
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
			  	<div class="form-inline mb-3">
			  		<label>Working</label>
					<label class="switch ml-3">
					<c:if test="${userDTO.state == 0}">
					  <input class="state" onchange="changeState(this)" type="checkbox">
					</c:if>
					<c:if test="${userDTO.state == 1}">
					  <input class="state" onchange="changeState(this)" type="checkbox" checked="checked">
					</c:if>
					  <span class="slider round"></span>
					</label>
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
<script src="<c:url value="/static/vendor/axios/axios.min.js"/>"></script>
<!-- <script src="https://unpkg.com/axios/dist/axios.min.js"></script> -->
<script src="<c:url value="/static/js/information.js"/>"></script>
<link rel="stylesheet" type="text/css" href="<c:url value="/static/css/information.css"/>">