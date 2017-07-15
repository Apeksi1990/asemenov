function addUserButton() {
    if (roleConnect == 'administrator') {
        $('.container:first').append('<button type="button" class="btn btn-success" onclick="modalAddUser()">Add new user</button>')
    }
}
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
getRole();
function getRoles() {
    return $.ajax('./edit', {
        method: 'get',
        complete: function (data) {
            allRoles = JSON.parse(data.responseText);
        }
    });
}
getRoles();
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
                    "</tr>";
            }
            $('#table-body').empty().append(result);
        }
    });
}
loadUsers();
$(document).ready(function() {
    $('#table-body').on('click', 'tr', function() {
        var tname = $(this).find("td").eq(0).html();
        var tlogin = $(this).find("td").eq(1).html();
        var temail = $(this).find("td").eq(2).html();
        var trole = $(this).find("td").eq(3).html();
        $('#delBut').remove();
        $('#editBut').remove();
        $('#addBut').remove();
        $('.modal-title').empty().append('Edit user');
        $('.modal-body').empty().append('Name: <input type="text" class="form-control" id="edit-name" disabled></br>')
                                .append('Login: <input type="text" class="form-control" id="edit-login" disabled></br>')
                                .append('Email: <input type="text" class="form-control" id="edit-email" disabled></br>')
                                .append('<input type="hidden" id="oldLogin"></br>');
        addRolePanel(roleConnect, trole);
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
function addRolePanel(role, value) {
    if (role == 'administrator') {
        $('.modal-body').append('<select name="role_id" class="form-control" id="edit-role"></select>');
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
function addDelBut(role) {
    if (role == 'administrator') {
        $('.modal-footer').prepend('<button type="button" class="btn btn-default" data-dismiss="modal" id="delBut" onclick="deleteUser()">Delete</button>');
    }
}
function editUser() {
    $.ajax('./edit', {
        method : 'post',
        data : {login : $('#edit-login').val(), name : $('#edit-name').val(), email : $('#edit-email').val(), role_id : $('#edit-role').val(), oldLogin : $('#oldLogin').val()},
        complete: function () {
            loadUsers()
        }
    });
}
function deleteUser() {
    $.ajax('./delete', {
        method : 'post',
        data : {login : $('#edit-login').val()},
        complete: function () {
            loadUsers()
        }
    });
}
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
    $('.modal-footer').prepend('<button type="button" class="btn btn-default" data-dismiss="modal" id="addBut" onclick="addNewUser()">Add User</button>');
    $('.modal-body input').attr('disabled', false);
    $('#myModal').modal('show');
}
function addNewUser() {
    $.ajax('./add', {
        method : 'post',
        data : {login : $('#add-login').val(), name : $('#add-name').val(), email : $('#add-email').val(), role_id : $('#edit-role').val(), password : $('#add-password').val()},
        complete: function () {
            loadUsers()
        }
    });
}