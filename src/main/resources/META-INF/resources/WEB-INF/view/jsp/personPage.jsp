<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="fragments/header.jsp" %> 

  <c:out value="${ person.fullName }"></c:out><br>
  Person measurements<br><br>
<section>
	<div class="table-responsive">
		<button type="button" class="btn btn-success pull-right"
		 data-toggle="modal" data-target="#myModal" style = "margin: 5px">Add measurement</button>
		<p>The context path is: ${appRootPath}.</p>
		<!-- Modal -->
		<div id="myModal" class="modal fade" role="dialog">
		  <div class="modal-dialog">
		
		    <!-- Modal content-->
		    <div class="modal-content">
		      <div class="modal-header">
		        <h4 class="modal-title">Add measurement</h4>
		        <button type="button" class="close" data-dismiss="modal">&times;</button>
		      </div>
		      <div class="modal-body">
				<form id="addMeasurementForm">
				  <c:set var = "personUri" value = "${ appRootPath }/api/persons/${ person.id }"/>
			      <input id="person" type="text" name="person" value="${personUri}" hidden="true">
				  <div class="form-group row">
				    <label for="datetimepicker" class="col-sm-2 col-form-label">Date</label>
				    <div class="col-sm-10">
		               <input id="datetimepicker" type='text' class="form-control"/>
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for="measurementType" class="col-sm-2 col-form-label">Measurement type</label>
				    <div class="col-sm-10">
				      <select class="form-control" id="measurementType">
					    <option>TEMPERATURE_C</option>
					    <option>TEMOERATURE_F</option>
					    <option>BLOOD_PREASSURE_MMHG</option>
					  </select>
				    </div>
				  </div>
				  <div class="form-group row">
				    <label for=indicatorValue class="col-sm-2 col-form-label">Value</label>
				    <div class="col-sm-10">
		               <input id="indicatorValue" type="number" class="form-control"/>
				    </div>
				  </div>
				    
				  
				  <div class="form-group row">
				    <div class="col-sm-10">
				      <button type="submit" class="btn btn-primary">Add</button>
				    </div>
				  </div>
				</form>
		      </div>
		      
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		      </div>
		    </div>
		
		  </div>
		</div>
		
		<table class="table table-hover table-dark" >
		  <thead>
		    <tr>
		      <th>Date of measurement</th>
		      <th>Measurement type</th>
		      <th>Value</th>
		      <th>Update</th>
		      <th>Delete</th>
		    </tr>
		  </thead>
		  <tbody>
		     <c:forEach var = "measurement" items="${person.measurementList}">
			    <tr>
			      <fmt:parseDate value="${ measurement.measureDateTime }" pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"  type="both"/>
			      <td><fmt:formatDate pattern="HH:mm dd MMM, yy" value = "${parsedDateTime}" /></td>
			      <td>${measurement.measurementType}</td>
			      <td>${measurement.indicatorValue}</td>
			      <td><button oncLick="deleteMeasurement(${measurement.id})" type="button" class="btn btn-primary">Update</button></td>
			      <td><button oncLick="updateMeasurement(${measurement.id})" type="button" class="btn btn-danger">Delete</button></td>
			    </tr>
		     </c:forEach>
		  </tbody>
		</table>
	</div>
</section>
	

<%@ include file="fragments/footer.jsp" %> 
<script>

   
   $(function(){
	   $.datetimepicker.setLocale('en');
	   $('#datetimepicker').datetimepicker();
	   
	   
	   function readData() {
		   var measurementJson = {
				   person : $('#person').val(),
				   measureDateTime: new Date($('#datetimepicker').val()),
				   measurementType: $('#measurementType').val(),
				   indicatorValue: $('#indicatorValue').val()
			   };
		  return strMeasurement = JSON.stringify(measurementJson, null, 4);
	   }
	   
       $('#addMeasurementForm').on('submit', function(e){
           e.preventDefault();
           $.ajax({
               url: 'api/measurements',
               contentType: "application/json",
               dataType: 'json',
               type: 'POST',
               data: readData(),
               success: function(data){
           	   	window.location.href = 'personPage?id=${person.id}';  
               },
               error: function(data){
            	   	console.log(strMeasurement);
            	   	console.log("${ personUri }");
            	   	console.log("${ctx}");
            	   	console.log(window.location.origin);
            	   	window.location.href = 'personPage?id=${person.id}';
            	   	
       
               }
               
           	   
           });
       });
   });
   
</script>
	

