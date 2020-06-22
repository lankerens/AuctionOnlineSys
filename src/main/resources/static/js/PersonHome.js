//  个人信息板块切换
function changeActiveDaohang(g, myclass) {

    var a1 = $(".myactive-daohang");
    a1.removeClass("myactive-daohang");
    $(g).addClass("myactive-daohang");

    console.log(myclass);
    $(".right-info-div").addClass("myActiveInRightInfo");
    $(".right-info-psw").addClass("myActiveInRightInfo");
    $(".right-info-shopcart").addClass("myActiveInRightInfo");
    $(".right-info-myauction").addClass("myActiveInRightInfo");
    $(".right-info-myGoods").addClass("myActiveInRightInfo");
    $(".right-info-myOrderInfo").addClass("myActiveInRightInfo");
    $(".right-info-myVIP").addClass("myActiveInRightInfo");
    $(".right-info-mysaler").addClass("myActiveInRightInfo");


    var div0 = $("." + myclass);
    div0.removeClass("myActiveInRightInfo");

}


// 点击修改后的文字回显
function myinfoUpdateBtn() {
    $("#username").val($("#myinfo-div-name").text().trim());
    $("#myaccount").val($("#myinfo-div-account").text().trim());
    $("#myidentity").val($("#myinfo-div-identity").text().trim());
    $("#mysgin").val($("#myinfo-div-sgin").text().trim());
    $("#mylove").val($("#myinfo-div-love").text().trim());
    $("#mysex").val($("#myinfo-div-sex").text().trim());
    $("#myphone").val($("#myinfo-div-phone").text().trim());
    $("#myemail").val($("#myinfo-div-email").text().trim());
    $("#mylocation").val($("#myinfo-div-address").text().trim());

}


//  基本信息修改
function myinfoUpdateSubmitBtn() {
    var stroge = window.sessionStorage;
    var res0 = stroge.getItem("AccountInfo");
    var AccountInfo;
    try {
        AccountInfo = $.parseJSON(res0);
    } catch (e) {
        AccountInfo = null;
    }
    var name;
    if (($("#myinfo-div-account").text().trim() === $("#username").val())) {
        name = null;
    } else {
        name = $("#username").val();
    }
    var data = {
        "aid": AccountInfo.aid,
        "name": name,
        "sex": $("#mysex").val(),
        "location": $("#mylocation").val(),
        "phone": $("#myphone").val(),
        "email": $("#myemail").val(),
        "personalSign": $("#mysgin").val(),
        "love": $("#mylove").val(),
        "account": $("#myaccount").val(),
        "identity": $("#myidentity").val()
    };
    var jsonData = JSON.stringify(data);
    console.log(jsonData);
    var xmlhttp;
    if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp = new XMLHttpRequest();
    } else {// code for IE6, IE5
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange = function () {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
            // console.log(xmlhttp.responseText);
            var res = xmlhttp.responseText;
            var j = $.parseJSON(res);
            if (j.msg === "ok") {
                stroge.setItem("AccountInfo", jsonData);
                flushMyInfo();
            } else if (j.msg === "f") {
                console.log("出现了不可意料的错误");
            }

        }
    }
    xmlhttp.open("POST", "http://localhost:8080/updateAccountInfo", true);
    xmlhttp.setRequestHeader("Content-type", "application/json");
    xmlhttp.send(jsonData);
};


function flushMyInfo() {
    var stroge = window.sessionStorage;
    var res0 = stroge.getItem("AccountInfo");
    var AccountInfo;
    try {
        AccountInfo = $.parseJSON(res0);
    } catch (e) {
        AccountInfo = null;
    }
    //  如果是正常进入的，替换默认值
    if (AccountInfo != null) {
        // var username = $("#myinfo-div-name");
        var username = $(".myinfo-div-name");
        var useraccount = $("#myinfo-div-account");
        var useridentity = $("#myinfo-div-identity");
        var usersex = $("#myinfo-div-sex");
        var useradress = $("#myinfo-div-address");
        // var usersgin = $("#myinfo-div-sgin");
        var usersgin = $(".myinfo-div-sgin");
        var userphone = $("#myinfo-div-phone");
        var useremail = $("#myinfo-div-email");
        var userlove = $("#myinfo-div-love");
        var con = AccountInfo.identity;
        if(con === 0){con = "普通用户";}else if(con === 1){con = "普通会员";}else if(con === 2){con = "卖家";}else if(con === 3){con = "管理员";}else if(con === 4){ con = "卖家会员";}
        Infojudge(AccountInfo.name, username);
        Infojudge(AccountInfo.account, useraccount);
        Infojudge(con, useridentity);
        Infojudge(AccountInfo.sex, usersex);
        Infojudge(AccountInfo.location, useradress);
        Infojudge(AccountInfo.personalSign, usersgin);
        Infojudge(AccountInfo.phone, userphone);
        Infojudge(AccountInfo.email, useremail);
        Infojudge(AccountInfo.love, userlove);
    }


    function Infojudge(obj0, obj1) {
        if (obj0 != null) {
            obj1.empty();
            obj1.text(obj0);
        }
    }
}


//  基本信息展示
// 进入页面就启用.
window.onload = function () {
    flushMyInfo();
    myVIPPart();
};


//  修改密码

// $("#myinfo-updatePsw").click( function () {
function myinfoUpdatePsw(){
    var p = $("#mypassword0").val();
    var p1 = $("#mypassword1").val();
    var p2 = $("#mypassword2").val();
    console.log(p);
    console.log(p1);
    console.log(p2);
    console.log(typeof p);
    console.log(typeof p1);
    console.log(typeof p2);
    if (p1 != p2 || p == "" || p1 == "" || p2 == "") {
        myTips("修改失败");
    } else if (p1 === p2) {
        var res0 = window.sessionStorage.getItem("AccountInfo");
        var AccountInfo;
        try {
            AccountInfo = $.parseJSON(res0);
        } catch (e) {
            AccountInfo = null;
        }
        var data = {
            "oldPassword": p,
            "password": p1,
            "id": AccountInfo.aid
        };
        var jsonData = JSON.stringify(data);
        console.log(jsonData);
        var xmlhttp;
        if (window.XMLHttpRequest) {// code for IE7+, Firefox, Chrome, Opera, Safari
            xmlhttp = new XMLHttpRequest();
        } else {// code for IE6, IE5
            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange = function () {
            if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                var res = xmlhttp.responseText;
                var j = $.parseJSON(res);
                if (j.msg === "ok") {
                    myTips("修改成功");
                } else if (j.msg === "f") {
                    console.log("出现了不可预知的错误");
                }

            }
        }
        xmlhttp.open("POST", "http://localhost:8080/updateAccountPsw", true);
        xmlhttp.setRequestHeader("Content-type", "application/json");
        xmlhttp.send(jsonData);
    }


};


function myTips(msg) {
    //提示层
    layer.msg(msg);
};


// jq载入
$(document).ready(function(){

    // 头像旋转
    $(".myHeadImgCircle").hover(function () {
        // console.log("进来了吗");
        $(".myHeadImgCircle").addClass("layui-anim-rotate layui-anim-loop");
    }, function () {
        $(".myHeadImgCircle").removeClass("layui-anim-rotate layui-anim-loop");
    });


});


//  vip 部分
function myVIPPart() {

    var res0 = window.sessionStorage.getItem("account");
    var account;
    try {
        account = $.parseJSON(res0);
    }catch (e) {
        account = null;
    }
    if (account.identity == 1 || account.identity == 4){
        $("#myVIPIcon").removeClass("btn-default").addClass("btn-danger");
        $("#myVIPWord").empty().text("续费特权");
    }

}


