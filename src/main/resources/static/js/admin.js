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


//时间转换函数
function showTime(tempDate) {
    var d = new Date(tempDate);
    var year = d.getFullYear();
    var month = d.getMonth();
    month++;
    var day = d.getDate();
    var hours = d.getHours();

    var minutes = d.getMinutes();
    var seconds = d.getSeconds();
    month = month<10 ? "0"+month:month;
    day = day<10 ? "0"+day:day;
    hours = hours<10 ? "0"+hours:hours;
    minutes = minutes<10 ? "0"+minutes:minutes;
    seconds = seconds<10 ? "0"+seconds:seconds;


    var time = year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    return time;
}

// 用户身份转换
function showUserIdentity(identityNum) {
    var arr = ["普通用户", "会员", "卖家", "管理员", "会员卖家"];
    return arr[identityNum];
}

// 商品分类
function showGoodType(i) {
    // 这里都可以变成向服务器请求查询实时的
    var arr = ["陶瓷", "手表", "名画", "古剑", "旗袍"];
    return arr[i];
}

function showGoodsStatus(i) {
    var arr = ["已下架", "拍卖中", "未开始", "已成交", "不存在"];
    return arr[i];
}

function showAuctionStatus(i) {
    var arr = ["未开始", "拍卖中", "已成交"];
    return arr[i];
}

function showOrderStatus(i) {
    var arr = ["待支付", "已支付", "超时支付已失效", "待发货", "运送中"];
    return arr[i];
}


function showSalerApply(i) {
    var arr = ["待审核", "已通过", "已拒绝"];
    return arr[i];
}




layui.use('table', function() {
    var table = layui.table;

    // 用户管理
    table.on('tool(test)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'forbidden') { //禁用
            //
            console.log(tr[1].textContent);
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除该用户吗？。？', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令

            });
        } else if (layEvent === "pswReset") {
            console.log("reset");
        }
    });

    // 商品信息管理
    table.on('tool(adGoodsInfo)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'detail') { //查看商品信息
            //
            console.log(tr[1].textContent);
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除该商品吗？。？', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令

            });
        }
    });

    // 竞拍记录
    table.on('tool(adAuctionRecord)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'del') { //删除
            layer.confirm('真的删除该竞拍记录吗？。？', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令

            });
        }
    });

    // 订单管理
    table.on('tool(order)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'detail') { //查看
            //
            console.log(tr[1].textContent);
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除该订单吗？。？', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令

            });
        }
    });

    // 商家申请
    table.on('tool(adsalerApply)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
        var tr = obj.tr; //获得当前行 tr 的 DOM 对象（如果有的话）

        if (layEvent === 'agree') { // 同意
            //
            console.log(tr[1].textContent);
        } else if (layEvent === 'del') { //删除
            layer.confirm('真的删除该用户的申请记录吗？。？', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                layer.close(index);
                //向服务端发送删除指令

            });
        } else if (layEvent === "refuse") {
            console.log("refuse");
        }
    });

});

