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
    $('#table-body').empty();
    cars.forEach(function(car) {
        getImg(car.id).then(function (result) {
            addRow(result, car)
        });
    });
}

function addRow(img, car) {
    $('#table-body').append($('<tr>')
        .append($('<td>')
            .append($('<input>', {class: 'carId',type: 'hidden', value: car.id}))
            .append($('<input>', {class: 'userId',type: 'hidden', value: car.user}))
        )
        .append($('<td>', { class: 'divImg'}).append($('<img>', { src: '/files/' + car.id + '/' + img, class: 'img'})))
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
    getImg(car.id).then(function (result) {
        $('#mImg').attr('src', '/files/' + car.id + '/' + result)
    });
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
    return $.ajax('./models', {
        method: 'get',
        dataType: 'text',
        data: {
            type: 'img',
            id: id
        }
    });
}

/*------ФИЛЬТРЫ-------*/

$(function () {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'mark'
        },
        complete: function (data) {
            var marks = JSON.parse(data.responseText);
            addMark(marks)
        }
    });
});

function addMark(marks) {
    marks.forEach(function (mark) {
        $('#mark_id').append($('<option>', {
            value: mark.id,
            text: mark.name
        }))
    });
}

function getModel(mark) {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'model',
            mark: mark
        },
        complete: function (data) {
            var models = JSON.parse(data.responseText);
            addModel(models)
        }
    });
}

function addModel(models) {
    $('#model_id').empty().append(($('<option>', {
        value: '',
        text: 'Выберите модель'
    })));
    models.forEach(function (model) {
        $('#model_id').append($('<option>', {
            value: model.id,
            text: model.name
        }))
    })
}

$(document).ready(function () {
    $('#mark_id').on('change', function () {
        var valueSelected = this.value;
        if (valueSelected == '') {
            $('#model_id').empty().append(($('<option>', {
                value: '',
                text: 'Выберите модель'
            })));
        } else {
            getModel(valueSelected)
        }
    });
});

$(function () {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'body'
        },
        complete: function (data) {
            var bodies = JSON.parse(data.responseText);
            addBody(bodies)
        }
    });
});

function addBody(bodies) {
    bodies.forEach(function (body) {
        $('#body_id').append($('<option>', {
            value: body.id,
            text: body.name
        }))
    })
}

$(function () {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'engine'
        },
        complete: function (data) {
            var engines = JSON.parse(data.responseText);
            addEngine(engines)
        }
    });
});

function addEngine(engines) {
    engines.forEach(function (engine) {
        $('#engine_id').append($('<option>', {
            value: engine.id,
            text: engine.name
        }))
    })
}

$(function () {
    $.ajax('./models', {
        method: 'get',
        data: {
            type: 'transmission'
        },
        complete: function (data) {
            var transmissions = JSON.parse(data.responseText);
            addTransmission(transmissions)
        }
    });
});

function addTransmission(transmissions) {
    transmissions.forEach(function (transmission) {
        $('#transmission_id').append($('<option>', {
            value: transmission.id,
            text: transmission.name
        }))
    })
}

$(document).ready(function () {
    $('.filters').on('change', function () {
        var data = {};
        $('.filters').each( function () {
            if (this.value != '') {
                data[this.name] = this.value;
            }}
        );
        $.ajax('./cars', {
            method : 'get',
            data: data,
            complete: function(data) {
                var cars = JSON.parse(data.responseText);
                createTable(cars);
            }
        });
    });
});

