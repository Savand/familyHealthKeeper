<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file="fragments/header.jsp" %> 

<table class="table table-hover table-dark" style="margin-top: 8em">
  <thead>
    <tr>
      <th>Name</th>
      <th>Date of birth</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach var = "person" items="${personList}">
     	<c:set var = "personUri" scope = "page" value = "personPage?id=${person.id}"/>
	    <tr style="cursor:pointer" onclick="window.location='${personUri}';">
	      <td>${person.fullName}</td>
	      <fmt:parseDate value="${ person.birthDate }" pattern="yyyy-MM-dd" var="parsedDateTime" />
	      <td><fmt:formatDate value = "${parsedDateTime}" /></td>
	    </tr>
     </c:forEach>
  </tbody>
</table>

<%@ include file="fragments/footer.jsp" %>  
	


