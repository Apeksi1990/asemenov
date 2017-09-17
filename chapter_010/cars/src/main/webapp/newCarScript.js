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
    $('#mark_id').empty();
    marks.forEach(function (mark) {
        $('#mark_id').append($('<option>', {
            value: mark.id,
            text: mark.name
        }))
    });
    var mark = $('#mark_id').val();
    getModel(mark)
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
    $('#model_id').empty();
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
        getModel(valueSelected)
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
    $('#body_id').empty();
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
    $('#engine_id').empty();
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
    $('#transmission_id').empty();
    transmissions.forEach(function (transmission) {
        $('#transmission_id').append($('<option>', {
            value: transmission.id,
            text: transmission.name
        }))
    })
}

function addNewCar() {
    var mark = $('#mark_id').val();
    var model = $('#model_id').val();
    var body = $('#body_id').val();
    var engine = $('#engine_id').val();
    var capacity = $('#capacity').val();
    var transmission = $('#transmission_id').val();
    var distance = $('#distance').val();
    var year = $('#year').val();
    var price = $('#price').val();
    newCar(mark, model, body, engine, capacity, transmission, distance, year, price)
}

function newCar(mark, model, body, engine, capacity, transmission, distance, year, price) {
    $.ajax('./cars', {
        method: 'post',
        data: {
            mark: mark,
            model: model,
            body: body,
            engine: engine,
            capacity: capacity,
            transmission: transmission,
            distance: distance,
            year: year,
            price: price
        },
        complete: function (data) {
            $('#carId').val(data.responseText);
            $('#carImg').submit();
        }
    });
}

