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
            .append($('<td>', { text: item.desc }).attr('checked', (items.done == false ? 'false': 'true')))
            .append($('<td>', { text: item.created }))
            .append($('<td>')
                .append($('<label>', {class: 'checkbox-inline'})
                    .append($('<input>', { id: 'checkbox', type: 'checkbox', checked: (item.done == false ? false : true)}))
                    .append(item.done == false ? 'Открыто': 'Выполнено'))
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
