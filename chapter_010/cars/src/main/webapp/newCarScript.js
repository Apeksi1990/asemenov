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
    })
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
        }
    });
}