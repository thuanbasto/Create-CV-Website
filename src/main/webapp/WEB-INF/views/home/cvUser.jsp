<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
    <link rel="stylesheet" href="<c:url value="/static/css/cvUser.css"/>">
    <title>CV Online</title>
</head>
<body>
	<div class="like bg-white">
        <label>${user.likes}</label>
        <security:authorize access="isAuthenticated()">
			<button type="button" onclick="likeCV(this)" class="btnLike btn btn-primary">Like</button>
		</security:authorize>
		<security:authorize access="!isAuthenticated()">
			<button type="button" disabled="disabled" title="Sign in to like" class="btn btn-primary">Like</button>
		</security:authorize>
		<input type="hidden" id="checkLike" value="${checkLike}"> 
    </div>
    <div class="bg-white">
        <div class="row m-4 pt-5">
        	<input type="hidden" id="user_ID" value="${user.user_ID}">
            <div class="col-auto"> 
                <img class="rounded-circle" width="120px" height="120px" src="<c:url value="/static/image/${user.imageUrl}"/>">
            </div>
            <div class="col ml-3">
                <h2 class="font-weight-bold">${user.name}</h2>
                <h4 class="text-primary ">${user.career}</h4>
                <p>${user.maxim}</p>
            </div>
        </div>
        <ul class="midrow nav justify-content-center">
            <li class="nav-item">
                <p class="col-auto ml-4 m-2 text-white"><i class="far fa-envelope"></i> ${user.email}</p>
            </li>
            <li class="nav-item">
                <p class="col ml-3 m-2 text-white"><i class="fas fa-mobile-alt"></i> ${user.phone}</p>
            </li>
            <li class="nav-item">
                <p class="col ml-3 m-2 text-white"><i class="fas fa-map-marker-alt"></i> ${user.address}</p>
            </li>
            <li class="nav-item">
                <p class="col ml-3 m-2 text-white"><i class="far fa-calendar-alt"></i> ${user.birthday}</p>
            </li>
            <li class="nav-item">
                <p class="col-auto m-2 mr-4 text-white"><i class="fab fa-facebook-f"></i> ${user.facebook}</p>
            </li>
        </ul>
        <div class="row m-1 mt-3">
            <div class="col">
            	<c:forEach items="${user.skills}" var="skill">
                <c:if test="${skill.indexDisplay == 1}">
                	<c:set var="skillName" value="${skill.skillName}"/>
                	<h3>${fn:toUpperCase(skillName)}</h3>
   					<c:if test="${skill.typeDisplay == 1}"> 
	    				<ul class="display1">
	    					<c:forEach items="${skill.detailSkills}" var="detailSkill">
		        				<li class="font-weight-bold">${detailSkill.detailSkill}</li>
							</c:forEach>
				    	</ul>
   					</c:if>
   					<c:if test="${skill.typeDisplay == 2}"> 
        				<ul class="infor mb-3 nav justify-content-left">
	    					<c:forEach items="${skill.detailSkills}" var="detailSkill">
		                        <li class="nav-item">
		                            <p class="col m-2 text-white">${detailSkill.detailSkill}</p>
		                        </li>
							</c:forEach>
                    	</ul>
   					</c:if>
        		</c:if>
                </c:forEach>
            </div>
            <div class="col ml-3">
                <c:forEach items="${user.skills}" var="skill">
                <c:if test="${skill.indexDisplay == 2}">
                	<c:set var="skillName" value="${skill.skillName}"/>
                	<h3>${fn:toUpperCase(skillName)}</h3>
   					<c:if test="${skill.typeDisplay == 1}"> 
	    				<ul class="display1">
	    					<c:forEach items="${skill.detailSkills}" var="detailSkill">
		        				<li class="font-weight-bold">${detailSkill.detailSkill}</li>
							</c:forEach>
				    	</ul>
   					</c:if>
   					<c:if test="${skill.typeDisplay == 2}"> 
        				<ul class="infor mb-3 nav justify-content-left">
	    					<c:forEach items="${skill.detailSkills}" var="detailSkill">
		                        <li class="nav-item">
		                            <p class="col m-2 text-white">${detailSkill.detailSkill}</p>
		                        </li>
							</c:forEach>
                    	</ul>
   					</c:if>
        		</c:if>
                </c:forEach>
            </div>
        </div>
    </div>
    <script src='<c:url value="/static/js/cvUser.js"></c:url>'></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
</body>
</html>