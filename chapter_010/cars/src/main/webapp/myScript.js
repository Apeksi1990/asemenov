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
        var img = getImg(car.id);
        consolel.log(img);
        tableBody.append($('<tr>')
                .append($('<td>')
                                .append($('<input>', {class: 'carId',type: 'hidden', value: car.id}))
                                .append($('<input>', {class: 'userId',type: 'hidden', value: car.user}))
                )
                .append($('<td>', { class: 'divImg'}).append($('<img>', { src: '/files/foto.jpg', class: 'img'})))
                .append($('<td>').append($('<p>', {text: car.mark}))
                                 .append($('<p>', {text: car.body}))
                                 .append($('<p>', {text: car.transmission}))
                                 .append($('<p>', {text: car.engine}))
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
                .append($('<td>').append($('<h4>', {text: (car.status == true ? '' : 'Машина продана')}))
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
    $('.modal-title').empty().append(car.mark + ' ' + car.model);
    $('#mBody').empty().val(car.body);
    $('#mEngine').empty().val(car.engine);
    $('#mTransmission').empty().val(car.transmission);
    $('#mCapacity').empty().val(car.capacity);
    $('#mYear').empty().val(car.year);
    $('#mDistance').empty().val(car.distance);
    $('#mPrice').empty().val(car.price);
    $('#carStatus').empty();
    if (typeof userId != 'undefined') {
        if ((userId == car.user) && (car.status == true)) {
            $('#carStatus').append($('<button>', {type: 'button', text: 'Машина была продана', value: car.id}))
        }
    }
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
                $('#login').empty()
                    .append('Пользователь: ' + user.name)
                    .append($('</br>'))
                    .append($('<a>', {href: 'newcar.html', text: 'Добавить новое объявление'}))
            }
        }
    });
}

function statusOff(id) {
    $.ajax('./models', {
        method: 'post',
        data: {
            id: id
        },
        complete: function () {
            location.href = "index.html"
        }
    });
}

$(document).ready(function() {
    $('#carStatus').on('click', 'button', function() {
        statusOff($(this).val())
    });
});

function getImg(id) {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'img',
            id: id
        },
        complete: function (data) {
            var img = data.responseText;
            console.log(img);
            return img;
        }
    });
}