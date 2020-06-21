//  个人信息板块切换
function changeActiveDaohang(g, myclass) {

    var a1 = $(".myactive-daohang");
    a1.removeClass("myactive-daohang");
    $(g).addClass("myactive-daohang");

    console.log(myclass);
    $(".right-info-div").addClass("myActiveInRightInfo");
    $(".right-info-psw").addClass("myActiveInRightInfo");
    $(".right-info-shopcart").addClass("myActiveInRightInfo");
    $(".right-info-myauction").addClass("myActiveInRightInfo");;
    $(".right-info-myGoods").addClass("myActiveInRightInfo");
    $(".right-info-myOrderInfo").addClass("myActiveInRightInfo");;
    $(".right-info-myVIP").addClass("myActiveInRightInfo");;
    $(".right-info-mysaler").addClass("myActiveInRightInfo");;


    var div0 = $("."+myclass);
    div0.removeClass("myActiveInRightInfo");

}


// 点击修改后的文字显示
function myinfoUpdateBtn(){
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
function myinfoUpdateSubmitBtn(){
    var stroge = window.sessionStorage;
    var res0 = stroge.getItem("AccountInfo");
    var AccountInfo;
    try {
        AccountInfo = $.parseJSON(res0);
    }catch (e) {
        AccountInfo = null;
    }
    var name;
    if(($("#myinfo-div-account").text().trim() === $("#username").val())){
        name = null;
    }else{
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
        "love":$("#mylove").val(),
        "account":$("#myaccount").val(),
        "identity":$("#myidentity").val()
    };
    var jsonData = JSON.stringify(data);
    console.log(jsonData);
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    xmlhttp.onreadystatechange=function()
    {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            // console.log(xmlhttp.responseText);
            var res = xmlhttp.responseText;
            var j = $.parseJSON(res);
            if(j.msg === "ok"){
                stroge.setItem("AccountInfo", jsonData);
                flushMyInfo();
            }else if(j.msg === "f"){
                console.log("出现了不可意料的错误");
            }

        }
    }
    xmlhttp.open("POST","http://localhost:8080/updateAccountInfo",true);
    xmlhttp.setRequestHeader("Content-type","application/json");
    xmlhttp.send(jsonData);
};



function flushMyInfo(){
    var stroge = window.sessionStorage;
    var res0 = stroge.getItem("AccountInfo");
    var AccountInfo;
    try {
        AccountInfo = $.parseJSON(res0);
    }catch (e) {
        AccountInfo = null;
    }
    //  如果是正常进入的，替换默认值
    if(AccountInfo != null){
        var username = $("#myinfo-div-name");
        var useraccount = $("#myinfo-div-account");
        var useridentity = $("#myinfo-div-identity");
        var usersex = $("#myinfo-div-sex");
        var useradress = $("#myinfo-div-address");
        var usersgin = $("#myinfo-div-sgin");
        var userphone = $("#myinfo-div-phone");
        var useremail = $("#myinfo-div-email");
        var userlove = $("#myinfo-div-love");

        Infojudge(AccountInfo.name, username);
        Infojudge(AccountInfo.account, useraccount);
        Infojudge(AccountInfo.identity, useridentity);
        Infojudge(AccountInfo.sex, usersex);
        Infojudge(AccountInfo.location, useradress);
        Infojudge(AccountInfo.personalSign, usersgin);
        Infojudge(AccountInfo.phone, userphone);
        Infojudge(AccountInfo.email, useremail);
        Infojudge(AccountInfo.love, userlove);
    }


    function Infojudge(obj0, obj1) {
        if(obj0 != null){
            obj1.empty();
            obj1.text(obj0);
        }
    }
}


//  基本信息展示
// 进入页面就启用.
window.onload = function () {
    flushMyInfo();

};




















