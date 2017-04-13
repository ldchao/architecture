/**
 * Created by marioquer on 2017/4/13.
 */

function trans(flag) {
    if (flag == 1) {
        $('#logup').modal('close');
        $('#login').modal('open');
    } else {
        $('#login').modal('close');
        $('#logup').modal('open');
    }
}

function login() {
    var phone = $("#phone").val();
    var password = $("#password").val();

    $.ajax({
        method: "post",
        url: "/user/login",
        async: false,
        dataType: "json",
        data: {
            "phone": phone,
            "password": password
        },
        success: function (result) {
            if (result.state == "success") {
                Materialize.toast('登录成功!', 1200);
                switch (result.role) {
                    case 0:
                        window.location.href = "/user/hotel";
                        break;
                    case 1:
                        window.location.href = "/landlord/hotel-info";
                        break;
                    default:
                        window.location.href = "/boss/apply";
                }
            } else {
                Materialize.toast('登录失败!', 1200);
            }
        },
        error: function () {
            Materialize.toast('请求出错!', 1200);
        }
    });
}

function logup() {
    var phone = $("#new_phone").val();
    var password = $("#new_password").val();
    var role = $("#new_role").val();
    var name = $("#new_name").val();

    $.ajax({
        method: "post",
        url: "/user/logup",
        async: false,
        data: {
            "phone": phone,
            "name": name,
            "password": password,
            "role": role
        },
        success: function (result) {
            if (result == "success") {
                Materialize.toast('注册成功!', 1800);
                setInterval((function () {
                    window.location.href = "/";
                }()),1800);

            } else if (result == "exist") {
                Materialize.toast('用户已存在!', 1200);
            } else {
                Materialize.toast('注册失败!', 1200);
            }
        },
        error: function () {
            Materialize.toast('请求出错!', 1200);
        }
    });
}

function logout(id) {
    alert(id);
}
