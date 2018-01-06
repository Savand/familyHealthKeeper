<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
<title>Person's page</title>
</head>
<body>
  <c:out value="${ person.fullName }"></c:out><br>
  Person measurements
  
<table class="table table-hover table-dark">
  <thead>
    <tr>
      <th>Date of measurement</th>
      <th>Measurement type</th>
      <th>Value</th>
    </tr>
  </thead>
  <tbody>
     <c:forEach var = "measurement" items="${person.measurementList}">
	    <tr>
	      <fmt:parseDate value="${ measurement.measureDateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"  type="both"/>
	      <td><fmt:formatDate pattern="HH:mm dd MMM, yy" value = "${parsedDateTime}" /></td>
	      <td>${measurement.measurementType}</td>
	      <td>${measurement.indicatorValue}</td>
	    </tr>
     </c:forEach>
  </tbody>
</table>
	
</body>
</html>

