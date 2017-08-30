loadItems();
function loadItems() {
    $.ajax('./items', {
        method : 'get',
        complete: function(data) {
            var items = JSON.parse(data.responseText);
            createTable(items);
        }
    });
}

function createTable(items) {
    var tableBody = $('#table-body');
    tableBody.empty();
    items.forEach(function(item) {
        tableBody.append($('<tr>')
            .append($('<td>', { text: item.id}))
            .append($('<td>', { text: item.desc }).attr('checked', (items.done == false ? 'false': 'true')))
            .append($('<td>', { text: item.created }))
            .append($('<td>')
                .append($('<label>', {class: 'checkbox-inline'})
                    .append($('<input>', {type: 'checkbox', checked: (item.done == false ? false : true)}))
                    .append($('<p>').text(item.done == false ? 'Открыто': 'Выполнено'))
                )
            ));
    });
}

function addNewTask() {
    var newtask = $('#newTask');
    var textTask = newtask.val();
    newtask.val('');
    sendTask(textTask)
}

function sendTask(text) {
    $.ajax('./items', {
        method : 'post',
        data : {
            text : text
        },
        complete: function () {
            loadItems()
        }
    });
}

$(document).ready(function() {
    $('#showAll').change(function () {
        if ($(this).is(':checked')) {
            showRows()
        } else {
            hideRows()
        }
    });
});

function hideRows() {
    $('#table-body').find('tr:contains("Выполнено")').hide();
}

function showRows() {
    $('#table-body').find('tr').show();
}

$(document).ready(function() {
    $('#table-body').on('change', 'input[type="checkbox"]', function () {
        if ($(this).is(':checked')) {
            $(this).parent().find('p').text('Выполнено');
            console.log($(this).parent().parent().children(':first-child'))
        } else {
            $(this).parent().find('p').text('Открыто')
        }
    })
});

function editState(id, state) {
    $.ajax('./items', {
        method : 'post',
        data : {
            id : id,
            state : state
        },
        complete: function () {
            loadItems()
        }
    });
}
