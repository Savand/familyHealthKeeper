
$(function() {
	$('[data-toggle="tooltip"]').tooltip();
	$('#measurement-data-table').DataTable({
		"order" : [ [ 1, "desc" ],[ 0, "desc" ]  ]
	});
	$('#sickness-data-table').DataTable({
		"order" : [[ 0, "desc" ]  ]
	});

	$('.dtp-start').val(new Date().toLocaleString('en-US'));

	$('.appdatetimepicker').datetimepicker();

	$("#tempeatureSection").show();
	$("#pressureSection").hide();

	$('select').on('change', function() {
		
		if (this.value === "BLOOD_PRESSURE_MMHG") {
			$("#tempeatureSection").hide();
			$("#pressureSection").show();
		} else {
			$("#tempeatureSection").show();
			$("#pressureSection").hide();
			if(this.value === "TEMPERATURE_C"){
				$('#indicatorValue').attr( "min", "34" );
				$('#indicatorValue').attr( "max", "43" );
				$('#indicatorValue').val(36.6);
			} else {
				$('#indicatorValue').attr( "min", "96" );
				$('#indicatorValue').attr( "max", "106" );
				$('#indicatorValue').val(98.6);
			}

		}
	});
	
	function getDateWithZeroZone(date) {
		var date = new Date(date);
		date.setHours(date.getHours() - date.getTimezoneOffset() / 60)
		return date;
	}

	function readData() {
		var measurementType = $('#measurementType').val();
		var indicatorValue = $('#indicatorValue').val();
		if (measurementType === 'BLOOD_PRESSURE_MMHG') {
			var sysPressure = $('#sysPressure').val();
			var diaPressure = $('#diaPressure').val();
			indicatorValue = diaPressure + "/" + sysPressure;
		}



		var measurementJson = {
			person : personUri,
			measureDateTime : getDateWithZeroZone($('#datetimepicker-measurement').val()),
			measurementType : $('#measurementType').val(),
			indicatorValue : indicatorValue
		};

		return strMeasurement = JSON.stringify(measurementJson);
	}

	$('#addMeasurementForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url : 'api/measurements',
			contentType : "application/json",
			dataType : 'json',
			type : 'POST',
			data : readData(),
			success : function(data) {
				window.location.href = 'personPage?id=' + personId;
			},
			error : function(data) {
				alert('Oops, smth went wrong');
			}
		});
	});
});

function deleteMeasurement(id) {
	$.ajax({
		url : 'api/measurements/' + id,
		contentType : "application/json",
		dataType : 'json',
		type : 'DELETE',
		data : id,
		success : function(data) {
			window.location.href = 'personPage?id=' + personId;
		},
		error : function(data) {
			alert('Oops, smth went wrong');
		}
	});
}