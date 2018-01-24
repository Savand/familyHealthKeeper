
$(function() {
	
	var from = getURLParameter('from');
	
	if(from === 'sickness'){
		$('div#collapseOne').removeClass('show');
		$('div#collapseTwo').addClass('show');
	}
	
	
	$('[data-toggle="tooltip"]').tooltip();
	$('#measurement-data-table').DataTable({
		"order" : [ [ 1, "desc" ],[ 0, "desc" ]  ]
	});
	$('#sickness-data-table').DataTable({
		"order" : [[ 0, "desc" ]  ]
	});

	$('.dtp-start').val(new Date().toLocaleString('en-US'));

    $('.dp-start').val(new Date().toLocaleDateString('en-US'));
    $('.appdatetimepicker').datetimepicker();
    $('.appdatepicker').datetimepicker({
        timepicker: false,
        format: 'm/d/Y',
    });

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

	function readMeasurementData() {
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
	
	function readSicknessData() {

		var sicknessJson = {
			person : personUri,
			startDate : getDateWithZeroZone($('#datetimepicker-sickness-start').val()),
			endDate : getDateWithZeroZone($('#datetimepicker-sickness-end').val()),
			description : $('#sickness-description').val()
		};

		return strMeasurement = JSON.stringify(sicknessJson);
	}

	$('#addMeasurementForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url : 'api/measurements',
			contentType : "application/json",
			dataType : 'json',
			type : 'POST',
			data : readMeasurementData(),
			success : function(data) {
				window.location.href = 'personPage?id=' + personId;
			},
			error : function(data) {
				alert('Oops, smth went wrong');
			}
		});
	});
	
	$('#addSicknessForm').submit(function(e) {
		e.preventDefault();
		$.ajax({
			url : 'api/sicknesses',
			contentType : "application/json",
			dataType : 'json',
			type : 'POST',
			data : readSicknessData(),
			success : function(data) {
				window.location.href = 'personPage?id=' + personId + '&from=sickness';
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

function deleteSickness(id) {
	$.ajax({
		url : 'api/sicknesses/' + id,
		contentType : "application/json",
		dataType : 'json',
		type : 'DELETE',
		data : id,
		success : function(data) {
			window.location.href = 'personPage?id=' + personId + '&from=sickness';
		},
		error : function(data) {
			alert('Oops, smth went wrong');
		}
	});
}

function getURLParameter(sParam){
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++){
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam){
            return sParameterName[1];
        }
    }
}