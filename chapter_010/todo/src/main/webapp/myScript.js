/*function loadItems() {
    $.ajax('./items', {
        method : 'get',
        complete: function(data) {
            var items = JSON.parse(data.responseText);
            $('#table-body').empty();
            for (var i = 0; i != items.length; ++i) {
                $('#table-body')
                    .append($('<tr>')
                        .append($('<td>').text(items[i].desc))
                        .append($('<td>').text(items[i].created))
                        .append($('<td>').append($('<input>').attr('type', 'checkbox').attr('checked', (items[i].done == false ? '' : 'true')))
                                         .append($('<label>').text((items[i].done == false ? 'Открыто': 'Выполнено')))
                        )
                    )
            }
        }
    });
}*/
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
        tableBody.append($('<tr>'))
            .append($('<td>', { text: item.desc }).attr('checked', (items.done == false ? 'false': 'true')))
            .append($('<td>', { text: item.created }))
            .append($('<td>')
                .append($('<input>', { type: 'checkbox'}))
                .append($('<label>', { text: (items.done == false ? 'Открыто': 'Выполнено') }))
            );
    });
}