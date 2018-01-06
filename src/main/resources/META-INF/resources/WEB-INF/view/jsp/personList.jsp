<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
<title>Persons</title>
</head>
<body>
<table class="table table-hover table-dark">
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
	
</body>
</html>

