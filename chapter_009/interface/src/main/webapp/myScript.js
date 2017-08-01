/*
Добавление кнопки добавление новых польхователей.
 */
function addUserButton() {
    if (roleConnect == 'administrator') {
        $('.container:first').append('<button type="button" class="btn btn-success" onclick="modalAddUser()">Add new user</button>')
    }
}
/*
Получение роли и логина подключенного пользователя.
 */
function getRole() {
    $.ajax('./signin', {
        method: 'get',
        complete: function (data) {
            var user = JSON.parse(data.responseText);
            roleConnect = user.role.name;
            loginConnect = user.login;
            addUserButton()
        }
    });
}
/*
Получение всех ролей в базе.
 */
function getRoles() {
    $.ajax('./edit', {
        method: 'get',
        data: {
            option: 'roles'
        },
        complete: function (data) {
            allRoles = JSON.parse(data.responseText);
        }
    });
}
/*
Обновление списка пользователей.
 */
function loadUsers() {
    $.ajax('./get', {
        method : 'get',
        complete: function(data) {
            var result = '';
            var users = JSON.parse(data.responseText);
            for (var i = 0; i != users.length; ++i) {
                result += "<tr>"+
                    "<td>" + users[i].name + "</td>"+
                    "<td>" + users[i].login + "</td>"+
                    "<td>" + users[i].email + "</td>"+
                    "<td>" + users[i].role.name + "</td>"+
                    "<td>" + users[i].country + "</td>"+
                    "<td>" + users[i].city + "</td>"+
                    "</tr>";
            }
            $('#table-body').empty().append(result);
        }
    });
}
getRole();
getRoles();
loadUsers();
/*
Открытие модального окна редактирование пользователя.
 */
$(document).ready(function() {
    $('#table-body').on('click', 'tr', function() {
        var tname = $(this).find("td").eq(0).html();
        var tlogin = $(this).find("td").eq(1).html();
        var temail = $(this).find("td").eq(2).html();
        var trole = $(this).find("td").eq(3).html();
        var tcountry = $(this).find("td").eq(4).html();
        var tcity = $(this).find("td").eq(5).html();
        $('#delBut').remove();
        $('#editBut').remove();
        $('#addBut').remove();
        $('.modal-title').empty().append('Edit user');
        $('.modal-body').empty().append('Name: <input type="text" class="form-control" id="edit-name" disabled></br>')
                                .append('Login: <input type="text" class="form-control" id="edit-login" disabled></br>')
                                .append('Email: <input type="text" class="form-control" id="edit-email" disabled></br>')
                                .append('<input type="hidden" id="oldLogin">');
        addRolePanel(roleConnect, trole);
        countryCity(roleConnect, tcountry, tcity);
        if (roleConnect == 'administrator' || loginConnect == tlogin) {
            $('.modal-body input').attr('disabled', false);
            $('.modal-footer').prepend('<button type="button" class="btn btn-default" data-dismiss="modal" id="editBut" onclick="editUser()">Edit</button>')
        }
        addDelBut(roleConnect);
        $('#edit-name').val(tname);
        $('#edit-login').val(tlogin);
        $('#edit-email').val(temail);
        $('#oldLogin').val(tlogin);
        $('#myModal').modal('show');
    });
});
/*
Добавление в модальное окно полей страны и города.
 */
function countryCity(role, country, city) {
    if (role == 'administrator') {
        addCountriesPanel(country, city);
    } else {
        $('.modal-body').append('Country: <input type="text" class="form-control" id="edit-country" disabled></br>')
                        .append('City: <input type="text" class="form-control" id="edit-city" disabled></br>');
        $('#edit-country').val(country);
        $('#edit-city').val(city);
    }
}
/*
Добавдение поля страны.
 */
function addCountriesPanel(country, city) {
    $.ajax('./edit', {
        method: 'get',
        data: {
            option: 'countries'
        },
        complete: function (data) {
            var allCountries = JSON.parse(data.responseText);
            $('.modal-body').append('Country: <select name="countries_id" class="form-control" id="edit-country"></select></br>');
            $.each(allCountries, function(i,v) {
                $('#edit-country').append($('<option>', {
                    value: v,
                    text: v
                }));
            });
            $('#edit-country').find('option:contains(' + country + ')').attr('selected', 'selected');
            addCitiesPanel(country, city);
        }
    });
}
/*
Добавление поля города.
 */
function addCitiesPanel(country, city) {
    $('.modal-body').append('City: <select name="city_id" class="form-control" id="edit-city"></select></br>');
    addCitiesToPanel(country, city);
}
/*
Обновление поля города.
 */
function addCitiesToPanel(country, city) {
    if (country == undefined) {
        country = $('#edit-country').val()
    }
    $.ajax('./edit', {
        method: 'get',
        data: {
            option: 'city',
            country: country
        },
        complete: function (data) {
            var allCity = JSON.parse(data.responseText);
            $('#edit-city').empty();
            $.each(allCity, function(i,v) {
                $('#edit-city').append($('<option>', {
                    value: v.id,
                    text: v.name
                }));
            });
            $('#edit-city').find('option:contains(' + city + ')').attr('selected', 'selected');
        }
    });
}
/*
Изменение городов в зависимости от страны.
 */
$(document).ready(function () {
    $('.modal-body').on('change', '#edit-country', function () {
        var optionSelected = $(this).find("option:selected");
        var textSelected = optionSelected.text();
        addCitiesToPanel(textSelected)
    })
});
/*
Добавление в модальное окно поля ролей.
 */
function addRolePanel(role, value) {
    if (role == 'administrator') {
        $('.modal-body').append('Role: <select name="role_id" class="form-control" id="edit-role"></select></br>');
        $.each(allRoles, function(i,v) {
            $('#edit-role').append($('<option>', {
                value: v.id,
                text: v.name
            }));
        });
        $('#edit-role').find('option:contains(' + value + ')').attr('selected', 'selected');
    } else {
        $('.modal-body').append('Role: <input type="text" class="form-control" id="edit-role" disabled></br>');
        $('#edit-role').val(value);
    }
}
/*
Добавление кнопки удаления пользователя.
 */
function addDelBut(role) {
    if (role == 'administrator') {
        $('.modal-footer').prepend('<button type="button" class="btn btn-default" data-dismiss="modal" id="delBut" onclick="deleteUser()">Delete</button>');
    }
}
/*
Запрос на изменение пользователя.
 */
function editUser() {
    $.ajax('./edit', {
        method : 'post',
        data : {
            login : $('#edit-login').val(),
            name : $('#edit-name').val(),
            email : $('#edit-email').val(),
            role_id : $('#edit-role').val(),
            city_id : $('#edit-city').val(),
            oldLogin : $('#oldLogin').val()},
        complete: function () {
            loadUsers()
        }
    });
}
/*
Запрос на удаление пользователя.
 */
function deleteUser() {
    $.ajax('./delete', {
        method : 'post',
        data : {login : $('#edit-login').val()},
        complete: function () {
            loadUsers()
        }
    });
}
/*
Открытие модального окна на добавление пользователя.
 */
function modalAddUser() {
    $('#delBut').remove();
    $('#editBut').remove();
    $('#addBut').remove();
    $('.modal-title').empty().append('Add user');
    $('.modal-body').empty().append('Name: <input type="text" class="form-control" id="add-name" disabled></br>')
        .append('Login: <input type="text" class="form-control" id="add-login" disabled></br>')
        .append('Email: <input type="text" class="form-control" id="add-email" disabled></br>')
        .append('Password: <input type="text" class="form-control" id="add-password" disabled></br>');
    addRolePanel(roleConnect);
    countryCity(roleConnect);
    $('.modal-footer').prepend('<button type="button" class="btn btn-default" data-dismiss="modal" id="addBut" onclick="addNewUser()">Add User</button>');
    $('.modal-body input').attr('disabled', false);
    $('#myModal').modal('show');
}
/*
Запрос на добавление нового пользователя.
 */
function addNewUser() {
    $.ajax('./add', {
        method : 'post',
        data : {
            login : $('#add-login').val(),
            name : $('#add-name').val(),
            email : $('#add-email').val(),
            role_id : $('#edit-role').val(),
            password : $('#add-password').val(),
            city_id : $('#edit-city').val()},
        complete: function () {
            loadUsers()
        }
    });
}