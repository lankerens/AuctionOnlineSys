var s = window.sessionStorage;
var res0 = s.getItem("GoodInfo");
var GoodInfo ;
try {
    GoodInfo = $.parseJSON(res0);
}catch (e) {
    GoodInfo = null;
}

//  放大镜
$(function () {
    $("#big-pic-imgtag").zoomio();

    if(GoodInfo != null){
        // 设置左侧
        $("#big-pic-imgtag").attr("src", GoodInfo.pic);
        GoodInfo.pack_mail === 1 ? $("#myPackMailSpan").removeClass("layui-bg-gray").addClass("layui-bg-green") : 1+1 ;
        GoodInfo.oimei === 1 ? $("#myOiMeiSpan").removeClass("layui-bg-gray").addClass("layui-bg-green") : 1+1 ;
        GoodInfo.ensure === 1 ? $("#myEnsureSpan").removeClass("layui-bg-gray").addClass("layui-bg-green") : 1+1 ;

        $("#myGoodTitle").empty().text(GoodInfo.good_name);
        $("#startTime").empty().text(GoodInfo.start_time);
        $("#endTime").empty().text(GoodInfo.end_time);
        $("#myTypeGoodInfo").empty().text(GoodInfo.goodType);
        $("#startPrice").empty().text(GoodInfo.start_price);
        $("#nowPrice").empty().text(GoodInfo.now_price + "元");
        $("#myGoodDes").empty().text(GoodInfo.goods_dec);
        $("#GoodInfoStatus").empty().text(GoodInfo.status === "1" ? "正在拍卖" : "已结束");
        $("#myPricePlus").attr("placeholder", "竞拍最低限"+GoodInfo.price_plus+"元");

    }

});


layui.use(['util', 'laydate', 'layer'], function() {
    var util = layui.util
        , laydate = layui.laydate
        , $ = layui.$
        , layer = layui.layer;

    //倒计时
    var thisTimer, setCountdown = function (y, M, d, H, m, s) {
        var endTime = new Date(y, M || 0, d || 1, H || 0, m || 0, s || 0) //结束日期
            , serverTime = new Date(); //假设为当前服务器时间，这里采用的是本地时间，实际使用一般是取服务端的

        clearTimeout(thisTimer);
        util.countdown(endTime, serverTime, function (date, serverTime, timer) {
            var str = "距离结束: " + date[0] + '天' + date[1] + '时' + date[2] + '分' + date[3] + '秒';
            lay('#theCountDownInGoodInfo').html(str);
            thisTimer = timer;
        });
    };
    if(GoodInfo != null){
        var myd = new Date(GoodInfo.end_time);
        setCountdown(myd.getFullYear(),  myd.getMonth(), myd.getDate(), myd.getHours(), myd.getMinutes(), myd.getSeconds());
    } else{
        setCountdown(2099, 1, 1);
    }


});



