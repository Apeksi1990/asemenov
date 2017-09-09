loadCars();
function loadCars() {
    $.ajax('./cars', {
        method : 'get',
        complete: function(data) {
            var cars = JSON.parse(data.responseText);
            createTable(cars);
        }
    });
}

function createTable(cars) {
    var tableBody = $('#table-body');
    tableBody.empty();
    cars.forEach(function(car) {
        tableBody.append($('<tr>')
                .append($('<td>').append($('<input>', {type: 'hidden', value: car.id})))
                .append($('<td>', { class: 'divImg'}).append($('<img>', { src: 'foto.jpg', class: 'img'})))
                .append($('<td>').append($('<p>', {text: car.mark.name}))
                                 .append($('<p>', {text: car.body.name}))
                                 .append($('<p>', {text: car.transmission.name}))
                                 .append($('<p>', {text: car.engine.name}))
                                 .append($('<p>', {text: car.capacity}))
                )
                .append($('<td>').append($('<h4>', {text: car.price, class: 'inline'}))
                                 .append($('<p>', {text: 'руб.', class: 'inline'}))
                )
                .append($('<td>').append($('<h4>', {text: car.year, class: 'inline'}))
                                 .append($('<p>', {text: 'г.', class: 'inline'}))
                )
                .append($('<td>').append($('<h4>', {text: car.distance, class: 'inline'}))
                                 .append($('<p>', {text: 'км.', class: 'inline'}))
                )
            );
    });
}

$(document).ready(function() {
    $('#table-body').on('click', 'tr', function() {
        getCar($(this).find('input[type="hidden"]').val());
    });
});

function getCar(id) {
    $.ajax('./cars', {
        method : 'get',
        data: {
            id: id
        },
        complete: function(data) {
            var car = JSON.parse(data.responseText);
            setModalFrame(car)
        }
    });
}

function setModalFrame(car) {
    $('.modal-title').empty().append(car.mark.name + ' ' + car.model.name);
    $('#mBody').empty().val(car.body.name);
    $('#mEngine').empty().val(car.engine.name);
    $('#mTransmission').empty().val(car.transmission.name);
    $('#mCapacity').empty().val(car.capacity);
    $('#mYear').empty().val(car.year);
    $('#mDistance').empty().val(car.distance);
    $('#mPrice').empty().val(car.price);
    $('#myModal').modal('show');
}

getUser();
function getUser() {
    $.ajax('./signin', {
        method: 'get',
        complete: function (data) {
            var user = JSON.parse(data.responseText);
            if (user != null) {
                userLogin = user.login;
                userId  = user.id;
                $('#login').empty().append('Пользователь: ' + user.name)
            }
        }
    });
}