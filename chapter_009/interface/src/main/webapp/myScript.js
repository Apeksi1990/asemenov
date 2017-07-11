function getRole() {
    $.ajax('./signin', {
        method: 'get',
        complete: function (data) {
            var user = JSON.parse(data.responseText);
            roleConnect = user.role.name;
            loginConnect = user.login;
        }
    });
}
getRole();
function loadUsers() {
    $.ajax('./get', {
        method : 'get',
        complete: function(data) {
            var result = '';
            var users = JSON.parse(data.responseText);
            console.log(users);
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
    $( "#table-body" ).on( "click", "tr", function() {
        var tname = $(this).find("td").eq(0).html();
        var tlogin = $(this).find("td").eq(1).html();
        var temail = $(this).find("td").eq(2).html();
        var trole = $(this).find("td").eq(3).html();
        console.log(tname + ' ' + tlogin + ' ' + temail + ' ' + trole);
        $('.modal-body').empty();
        $('.modal-body').append('Name: <input type="text" class="form-control" id="edit-name" disabled></br>');
        $('.modal-body').append('Login: <input type="text" class="form-control" id="edit-login" disabled></br>');
        $('.modal-body').append('Email: <input type="text" class="form-control" id="edit-email" disabled></br>');
        $('.modal-body').append('Role: <input type="text" class="form-control" id="edit-role" disabled></br>');
        $('.modal-body').append('<input type="hidden" id="oldLogin"></br>');
        if (roleConnect == 'administrator' || loginConnect == tlogin) {
            $('.modal-body input').attr('disabled', false);
        }
        $('#edit-name').val(tname);
        $('#edit-login').val(tlogin);
        $('#edit-email').val(temail);
        $('#edit-role').val(trole);
        $('#oldLogin').val(tlogin);
        $('#myModal').modal('show');
    });
});
function editUser() {
    $.ajax('./edit', {
        method : 'post',
        data : {login : userLogin},
        success : location.href = "/edit.html"
    });
    return false;
}