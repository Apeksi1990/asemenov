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
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        getModel(valueSelected)
    });
});