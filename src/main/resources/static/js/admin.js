//  个人信息板块切换
function adminDaohang(g, myclass) {

    var a1 = $(".myactive-daohang");
    a1.removeClass("myactive-daohang");
    $(g).addClass("myactive-daohang");

    // console.log(myclass);
    //  与普通用户共用的三个class
    // 基本信息、修改密码、会员特权
    $(".right-info-div").addClass("myActiveInRightInfo");
    $(".right-info-psw").addClass("myActiveInRightInfo");
    $(".right-info-myVIP").addClass("myActiveInRightInfo");

    // 自定义class名部分
    $(".right-info-adminUser").addClass("myActiveInRightInfo");
    $(".right-info-adminGoods").addClass("myActiveInRightInfo");
    $(".right-info-adminAuctions").addClass("myActiveInRightInfo");
    $(".right-info-adminOrder").addClass("myActiveInRightInfo");
    $(".right-info-adminSaler").addClass("myActiveInRightInfo");

    var div0 = $("." + myclass);
    div0.removeClass("myActiveInRightInfo");

    adcurrentPage = 1;
}

var adcurrentPage = 1;

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


function adminAjax(url, name) {

    $.ajax({
        type: "get",
        dataType: "json",
        url: url,
        async: false,
        success: function (data) {
            console.log(data);
            if (data.msg === "ok") {
                var storage = window.sessionStorage;
                storage.setItem(name, JSON.stringify(data.data));

            }

        },
        error: function (e) {
            console.log("获取列表失败" + e);
        }
    })
}

function getUserList() {
    if (account == null) {
        myTips("请先登录");
        return;
    } else {
        if (account.identity != 3) {
            myTips("你好像不是管理员呢~~");
            return ;
        }
    }
    var url = "http://localhost:8080/getUserList/";
    var na = "UserList";
    adminAjax(url, na);
    var res0 = window.sessionStorage.getItem("UserList");
    var UserList ;
    try {
        UserList = $.parseJSON(res0).list;
    }catch (e) {
        UserList = null;
    }
    if(UserList != null){


    }
}


function disableUserAccount(a) {
    console.log(a.parentNode.parentNode.parentNode.childNodes[1].innerText);
}


