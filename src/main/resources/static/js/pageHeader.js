function lankeren1() {
    // var sto = window.localStorage;
    var sto = window.sessionStorage;
    var res0 = sto.getItem("account");
    var account;
    try {
        account =  $.parseJSON(res0);
    }catch (e) {
        account = null;
    }
    var lis ;
    if(account == null){
        lis = "   <li><a href=\"login.html\"><span class=\"glyphicon glyphicon-log-in\"></span> 登录</a></li>\n" +
            "                    <li><a href=\"register.html\"><span class=\"glyphicon glyphicon-user\"></span> 注册</a></li>\n" +
            "                    <li><a href=\"SaleGoods.html\"><span class=\"glyphicon glyphicon-gift\"></span> 发布商品</a></li>\n" +
            "                    <li><a href=\"contactLankeren.html\"><span class=\"glyphicon glyphicon-pencil\"></span> 联系管理</a></li>\n" +
            "                    <li><a href=\"contactLankeren.html\"><span class=\"glyphicon glyphicon-subtitles\"></span> 本站公告</a></li>"
    }else{
        lis = " <li><a href=\"#\" onclick='myInfoPage()'><span class=\"glyphicon glyphicon-user\"></span> "+ account.name +"</a></li>\n" +
            "            <li><a href=\"SaleGoods.html\"><span class=\"glyphicon glyphicon-gift\"></span> 发布商品</a></li>\n" +
            "            <li><a href=\"contactLankeren.html\"><span class=\"glyphicon glyphicon-pencil\"></span> 联系管理</a></li>\n" +
            "            <li><a href=\"contactLankeren.html\"><span class=\"glyphicon glyphicon-subtitles\"></span> 本站公告</a></li>";
    }
    // $(".lankeren1").innerHTML = lis;
    document.write(lis);
}