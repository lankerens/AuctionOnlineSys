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
    // $(".right-info-myauction");

    var div0 = $("."+myclass);
    div0.removeClass("myActiveInRightInfo");

}

