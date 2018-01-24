<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="fragments/header.jsp"%>

<c:set var="personUri" value="${ appRootPath }/api/persons/${ person.id }" />

<section style="margin-top:2em">
	
	<h3>
		<span class="label label-default"> Personal data for ${ person.fullName }</span>
	</h3>
	
	<div class="jumbotron">
	
		<div id="accordion">
		  <!-- Measurements card -->
		  <div class="card">
		    <div class="card-header">
		      <a class="card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseOne">
		        Measurements
		      </a>
		    </div>
		    <div id="collapseOne" class="collapse show">
		      <div class="card-body">
				
				<!-- Modal -->
				<div id="myModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Add new record</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form id="addMeasurementForm">
									<div class="form-group row">
										<label for="datetimepicker-measurement" class="col-sm-2 col-form-label">Date</label>
										<div class="col-sm-10">
											<input id="datetimepicker-measurement" class="appdatetimepicker dtp-start" type='text' class="form-control"
												required />
										</div>
									</div>
									<div class="form-group row">
										<label for="measurementType" class="col-sm-2 col-form-label">Type</label>
										<div class="col-sm-10">
											<select class="form-control" id="measurementType">
												<option value="TEMPERATURE_C">Temperature, C&deg;</option>
												<option value="TEMPERATURE_F">Temperature, F&deg;</option>
												<option value="BLOOD_PRESSURE_MMHG">Blood
													pressure, mmHg</option>
											</select>
										</div>
									</div>
									<div id="tempeatureSection" class="form-group row">
										<label for="indicatorValue" class="col-sm-2 col-form-label">Value</label>
										<div class="col-sm-10">
											<input type="number" id="indicatorValue" min="34" max="43"
												step="0.1" value="36.6" class="form-control" required>
										</div>
									</div>
									<div id="pressureSection" class="form-group row">
										<label for="diaPressure" class="col-sm-2 col-form-label">DIA</label>
										<div class="col-sm-10">
											<input id="diaPressure" type="number" class="form-control"
												value="80" />
										</div>
										<label for="sysPressure" class="col-sm-2 col-form-label">SYS</label>
										<div class="col-sm-10">
											<input id="sysPressure" type="number" class="form-control"
												value="120" />
										</div>
									</div>
									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">Add</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#myModal" style="margin: 5px">Add new
					record</button>
				<div class="table-responsive">
					<table id="measurement-data-table" class="display">
						<thead>
							<tr>
								<th>Date of measurement</th>
								<th>Measurement type</th>
								<th>Value</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="measurement"
								items="${ person.measurementList }">
								<tr>
									<fmt:parseDate value="${ measurement.measureDateTime }"
										pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime"
										type="both" />
									<td><fmt:formatDate pattern="dd MMM yyyy, HH:mm "
											value="${ parsedDateTime }" /></td>
									<td>${ measurement.measurementType.fieldDescription }</td>
									<td>${ measurement.indicatorValue }</td>

									<td><button
											oncLick="deleteMeasurement(${measurement.id})"
											type="button" class="btn btn-danger">Delete</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				
			  </div>
		    </div>
		  </div>
		<!-- Sickness history card -->
		  <div class="card">
		    <div class="card-header">
		      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">
		        Sickness history
		      </a>
		    </div>
		    <div id="collapseTwo" class="collapse">
		      <div class="card-body">
				<!-- Modal -->
				<div id="addSicknessModal" class="modal fade" role="dialog">
					<div class="modal-dialog">
						<!-- Modal content-->
						<div class="modal-content">
							<div class="modal-header">
								<h4 class="modal-title">Add new record</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>
							<div class="modal-body">
								<form id="addSicknessForm">
									<div class="form-group row">
										<label for="datetimepicker-sickness-start" class="col-sm-2 col-form-label">Start date</label>
										<div class="col-sm-10">
											<input id="datetimepicker-sickness-start" class="appdatepicker dp-start" type='text' class="form-control"
												required />
										</div>
									</div>
									<div class="form-group row">
										<label for="datetimepicker-sickness-end" class="col-sm-2 col-form-label">End date</label>
										<div class="col-sm-10">
											<input id="datetimepicker-sickness-end" class="appdatepicker" type='text' class="form-control" />
										</div>
									</div>
								 	<div class="form-group row">
										<label for="sickness-description" class="col-sm-2 col-form-label">Sickness description</label>
										<div class="col-sm-10">
											<input type="text" id="sickness-description" class="form-control" required>
										</div>
									</div>

									<div class="modal-footer">
										<button type="submit" class="btn btn-primary">Add</button>
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
				<button type="button" class="btn btn-success" data-toggle="modal"
					data-target="#addSicknessModal" style="margin: 5px">Add new
					record</button>
				<div class="table-responsive">
					<table id="sickness-data-table" class="display">
						<thead>
							<tr>
								<th>Start date</th>
								<th>End date</th>
								<th>Description</th>
								<th>Doctor visit(s)</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="sickness"
								items="${ person.sicknessList }">
								<tr>
									<fmt:parseDate value="${ sickness.startDate }"
										pattern="yyyy-MM-dd" var="parsedStartDate" />
									<td><fmt:formatDate pattern="dd MMM yyyy"
											value="${ parsedStartDate }" /></td>
									<fmt:parseDate value="${ sickness.endDate }"
										pattern="yyyy-MM-dd" var="parsedEndDate" />
									<td><fmt:formatDate pattern="dd MMM yyyy"
											value="${ parsedEndDate }" /></td>
									<td class="text-info">${ sickness.description }</td>
									<td><button
											onclick="console.log('currently not available')"
											type="button" class="btn btn-info"  data-toggle="tooltip" data-placement="top" title="Currently not available. In design progress">Visits</button></td>
									<td><button
											onclick="updateSickness(${sickness.id})"
											type="button" class="btn btn-warning">Update</button></td>

									<td><button
											onclick="deleteSickness(${sickness.id})"
											type="button" class="btn btn-danger">Delete</button></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>


		      </div>
		    </div>
		  </div>
		
		  <div class="card">
		    <div class="card-header">
		      <a class="collapsed card-link" data-toggle="collapse" data-parent="#accordion" href="#collapseThree">
		        Collapsible Group Item #3
		      </a>
		    </div>
		    <div id="collapseThree" class="collapse">
		      <div class="card-body">
		        Lorem ipsum..
		      </div>
		    </div>
		  </div>
		
		</div>
	
	
	
	
		
		
		
		
		
		
		
	</div>

</section>


<%@ include file="fragments/footer.jsp"%>
<script>
 var personId = ${ person.id };
 var personUri = '${ appRootPath }/api/persons/${ person.id }';
</script>
<script src="js/personPage.js"></script>



