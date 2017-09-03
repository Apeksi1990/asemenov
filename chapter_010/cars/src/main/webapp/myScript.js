loadCars();
function loadCars() {
    $.ajax('./cars', {
        method : 'get',
        complete: function(data) {
            console.log(data);
            var cars = JSON.parse(data.responseText);
            createTable(cars);
        }
    });
}

function createTable(cars) {
    console.log(cars);
    var tableBody = $('#table-body');
    tableBody.empty();
    cars.forEach(function(car) {
        tableBody.append($('<tr>')
                .append($('<td>', { id: 'divImg'}).append($('<img>', { src: 'foto.jpg', id: 'img'})))
                .append($('<td>'))
                .append($('<td>').append($('<h4>', {text: car.price})))
                .append($('<td>').append($('<h4>', {text: car.year})))
                .append($('<td>').append($('<h4>', {text: car.distance})))
            );
    });
}