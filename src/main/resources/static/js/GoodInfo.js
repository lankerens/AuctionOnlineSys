//  放大镜
$(function () {
    $("#big-pic-imgtag").zoomio();
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
    setCountdown(2099, 1, 1);


});