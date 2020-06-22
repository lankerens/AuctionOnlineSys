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
}


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
