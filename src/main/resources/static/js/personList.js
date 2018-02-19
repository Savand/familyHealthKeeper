function getDateWithZeroZone(date) {
    var date = new Date(date);
    date.setHours(date.getHours() - date.getTimezoneOffset() / 60)
    return date;
}
function updatePersonData() {
    var personJson = {
        fullName : $('#person-name-update').val(),
        birthDate : getDateWithZeroZone($('#person-birthday-update').val())
    };
    return prsUpdate = JSON.stringify(personJson);
}

function updatePerson(id) {

    $.ajax({
        url: 'api/persons/' + id,
        contentType: 'application/json',
        dataType: 'json',
        type: 'get',
        success: function (person) {
            $('#person-name-update').val(person.fullName);
            $('#person-birthday-update').val(person.birthDate);

            $('#updatePersonForm').submit(function(e) {
                e.preventDefault();
                $.ajax({
                    url: 'api/persons/' + id,
                    contentType: 'application/json',
                    dataType: 'json',
                    type: 'put',
                    data: updatePersonData(),

                    success: function(data){
                    window.location.href = 'persons?';

                    },
                    error: function(data) {
                        alert('Oops, smth went wrong');
                    }
                })
            })
        },

        error: function(data){
            alert('Smth wrong in updatePerson')
        }
    });
}



