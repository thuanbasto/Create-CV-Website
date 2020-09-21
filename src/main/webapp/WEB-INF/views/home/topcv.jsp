<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav aria-label="...">
	<ul class="pagination">
		<c:choose>
			<c:when test="${page > 1}">
				<li class="page-item">
					<a class="page-link" href='<c:url value="/topcv?page=${page-1}"/>' tabindex="-1" aria-disabled="true">Previous</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
		    <c:choose>
		        <c:when test="${page == i.index}">
		        	<li class="page-item active" aria-current="page">
						<a class="page-link" href="#">${i.index} <span class="sr-only">(current)</span></a>
					</li>
		        </c:when>
		        <c:otherwise>
			        <li class="page-item">
						<a class="page-link" href='<c:url value="/topcv?page=${i.index}"/>'>${i.index}</a>
					</li>
		        </c:otherwise>
		    </c:choose>
		</c:forEach>

		<c:choose>
			<c:when test="${page + 1 <= maxPages}">
				<li class="page-item">
					<a class="page-link" href='<c:url value="/topcv?page=${page+1}"/>'  aria-disabled="true">Next</a>
				</li>
			</c:when>
			<c:otherwise>
				<li class="page-item disabled">
					<a class="page-link" href="#" tabindex="-1" aria-disabled="true">Next</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>
<table class="table">
  <thead>
    <tr>
      <th scope="col">STT</th>
      <th scope="col">Name</th>
      <th scope="col">Username</th>
      <th scope="col">email</th>
      <th scope="col">Likes</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach begin="0" items="${users}" var="user" step="1" varStatus="i">
	    <tr>
	      <th scope="row">${i.index+1+stt}</th>
	      <td>${user.name}</td>
	      <td><a href='<c:url value="/${user.username}"/>'>${user.username}</a></td>
	      <td>${user.email}</td>
	      <td>${user.likes}</td>
	    </tr>
	</c:forEach>
  </tbody>
</table>