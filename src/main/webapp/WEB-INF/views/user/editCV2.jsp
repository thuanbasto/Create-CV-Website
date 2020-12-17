<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Ubuntu" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/javascript.util/0.12.12/javascript.util.min.js"></script>
    <link rel="stylesheet" href="<c:url value="/static/css/cvUser.css"/>">
</head>
<body>
	<div class="customize p-0">
        <nav class="navbar navbar-expand-lg navbar-light bg-light m-0 p-2">
            <div class="navbar-collapse" id="navbarText">
                <ul class="navbar-nav mr-auto">
                    <!-- <li class="nav-item m-1">
                        <div class="icon dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Icon
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            </div>
                          </div>
                    </li>
                    <li class="nav-item m-1">
                        <div class="font dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Font
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            </div>
                          </div>
                    </li>
                    <li class="nav-item m-1">
                        <div class="color dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Color
                            </button>
                            <div class="dropdown-menu m-auto p-auto" aria-labelledby="dropdownMenuButton">
                              <button class="dropdown-item" value="#479099" onclick="changeColor(this)">Green</button>
                              <button class="dropdown-item" value="#1a9fc1" onclick="changeColor(this)">Blue</button>
                              <button class="dropdown-item" value="Black" onclick="changeColor(this)">Black</button>
                            </div>
                          </div>
                    </li> -->
                    <li class="nav-item m-1">
                        <div class="typecv dropdown">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                Type CV
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                <a style="text-decoration: none;" href="<c:url value='/user/editCV/1'/>"><button class="dropdown-item" value="1" onclick="changeTypeCV(this)">Type CV 1</button></a>
                                <a style="text-decoration: none;" href="<c:url value='/user/editCV/2'/>"><button class="dropdown-item" value="2" onclick="changeTypeCV(this)">Type CV 2</button></a>
                            </div>
                          </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <div class="bg-white">
        <div class="typeCV2 m-0 p-0">
         	<input type="hidden" id="typecv_ID" value="2">
            <div class="row m-4">
                <div class="col information">
                    <div class="row m-4">
                        <div class="row-auto ml-3">
                            <img class="rounded-circle" width="120px" height="120px" src="<c:url value="/static/image/${user.imageUrl}"/>">
                        </div>
                    </div>
                    <div class="row-auto ml-3">
                        <div class="row-auto">
                            <h2 class="row name font-weight-bold">${user.name}</h2>
                            <h4 class="row text-primary ">${user.career}</h4>
                            <p class="row">${user.maxim}</p>
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="midrow ml-4 border rounded">
                            <p class="ml-4 mt-2 mr-4 text-white"><i class="far fa-envelope"></i> ${user.email}</p>
                            <p class="ml-4 mt-2 mr-4 text-white"><i class="fas fa-mobile-alt"></i> ${user.phone}</p>
                            <p class="ml-4 mt-2 mr-4 text-white"><i class="fas fa-map-marker-alt"></i> ${user.address}</p>
                            <p class="ml-4 mt-2 mr-4 text-white"><i class="far fa-calendar-alt"></i> ${user.birthday}</p>
                            <p class="ml-4 mt-2 mr-4 text-white"><i class="fab fa-facebook-f"></i> ${user.facebook}</p>
                        </div>
                    </div>
                </div>
                <div class="col detail mt-4">
                    <button type="button" onclick="addSkill(this)" class="btnAddRight mb-3 btn btn-outline-success">Add</button>
	                <button type="button" value="cardSkill" onclick="saveAll(this)" class="saveAll mb-3 btn btn-outline-success float-right">Save All</button>
	                <c:forEach items="${user.skills}" var="skill">
	                <c:if test="${skill.indexDisplay == 1}">
		                <div class="cardSkill mb-3 left">
		                	<div class='form-inline'>
	        					<input value="${skill.skillName}" class='skillInput form-control' placeholder='Skill. Ex: Language, Technical, Exp'/>
	        					<div class='form-group m-1'>
	        						<select class='form-control typeDisplay'>
						        		<option ${skill.typeDisplay == 1 ? 'selected' : ''}>1</option>
						        		<option ${skill.typeDisplay == 2 ? 'selected' : ''}>2</option>
						        		</select>
						        </div>
								<button id='deleteSkill' onclick='deleteSkill(this)' class='m-1 btn btn-danger'>X</button>
	    					</div>
		    				<ul>
		    					<c:forEach items="${skill.detailSkills}" var="detailSkill" varStatus="loop">
			        				<li class='form-inline'>
						            	<input id='detailSkill' class='mt-2 form-control mb-2 mr-sm-2' placeholder='Detail of skill' value="${detailSkill.detailSkill}"/>
						            	<button id='deleteDetailSkill' onclick='deleteDetailSkill(this)' class='btn btn-danger'>X</button>
						            	<c:if test="${loop.last}">
						            		<button id='addDetailSkill' onclick='addDetailSkill(this)' class='ml-2 btn btn-success'>+</button>
						            	</c:if>
						        	</li>
								</c:forEach>	        
					    	</ul>
		                </div>
	        		</c:if>
	                </c:forEach>
	                <c:forEach items="${user.skills}" var="skill">
	                <c:if test="${skill.indexDisplay == 2}">
		                <div class="cardSkill mb-3 right">
		                	<div class='form-inline'>
	        					<input value="${skill.skillName}" class='skillInput form-control' placeholder='Skill. Ex: Language, Technical, Exp'/>
	        					<div class='form-group m-1'>
	        						<select class='form-control typeDisplay'>
	        						<c:if test=""></c:if>
						        		<option ${skill.typeDisplay == 1 ? 'selected' : ''}>1</option>
						        		<option ${skill.typeDisplay == 2 ? 'selected' : ''}>2</option>
					        		</select>
						        </div>
						        <button id='deleteSkill' onclick='deleteSkill(this)' class='m-1 btn btn-danger'>X</button>
	    					</div>
		    				<ul>
		    					<c:forEach items="${skill.detailSkills}" var="detailSkill" varStatus="loop">
			        				<li class='form-inline'>
						            	<input id='detailSkill' class='mt-2 form-control mb-2 mr-sm-2' placeholder='Detail of skill' value="${detailSkill.detailSkill}"/>
						            	<button id='deleteDetailSkill' onclick='deleteDetailSkill(this)' class='btn btn-danger'>X</button>
					    				<c:if test="${loop.last}">
						            		<button id='addDetailSkill' onclick='addDetailSkill(this)' class='ml-2 btn btn-success'>+</button>
						            	</c:if>
						        	</li>
								</c:forEach>	        
					    	</ul>
		                </div>
	        		</c:if>
	                </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <div class="popup" aria-live="polite" aria-atomic="true" style="position: relative; min-height: 100px;">
        <div style="position: absolute; top: 50%; right: 50%; transform: translate(40%,-50%); z-index: 2;">
            <div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="2000">
                <div class="toast-header">
                    <strong class="mr-auto">Notice</strong>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="toast-body text-success">
                    Saved successfully.
                </div>
            </div>
        </div>
    </div>
    <script src="<c:url value="/static/js/editCV.js"/>"></script>
    <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/js/all.min.js"></script>
</body>
</html>