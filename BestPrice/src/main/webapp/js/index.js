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
    var username = $("#username").val();
    var password = $("#password").val();

    $.ajax({
        method: "post",
        url: "/user/login",
        async: false,
        data: {
            "username": username,
            "password": password
        },
        success: function (result) {
            if (result == "success") {
                Materialize.toast('登录成功!', 1200);
                window.location.href = "#";

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
    var username = $("#new_username").val();
    var password = $("#new_password").val();
    var email = $("#new_email").val();
    var address = $("#new_address").val();

    $.ajax({
        method: "post",
        url: "/user/logup",
        async: false,
        data: {
            "username": username,
            "password": password,
            "email": email,
            "address": address
        },
        success: function (result) {
            if (result == "success") {
                Materialize.toast('注册成功!', 1800);
                setInterval((function () {
                    window.location.href = "/index";
                }()), 1800);
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

function logout() {
    $.ajax({
        method: "post",
        url: "/user/logout",
        async: false,
        success: function (result) {
            if (result == "success") {
                Materialize.toast('登出成功!', 1800);
                setInterval((function () {
                    window.location.href = "/index";
                }()), 1800);
            } else {
                Materialize.toast('登出失败!', 1200);
            }
        },
        error: function () {
            Materialize.toast('请求出错!', 1200);
        }
    });

}
