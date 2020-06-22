function myInfoPage() {
    var storge = window.sessionStorage;

    var b = storge.getItem("AccountInfo");
    console.log(b);
    console.log(typeof b);
    if(b != null){
        console.log("不为空呀");
        // 利用之前存的....
        goOtherPage($.parseJSON(b));
    }

    var res0 = storge.getItem("account");
    var account;
    try {
        account = $.parseJSON(res0);
    }catch (e) {
        account = null;
    }
    var href ;
    var data = {
        "account": account.account,
        "identity": account.identity
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
            console.log(xmlhttp.responseText);
            var res = xmlhttp.responseText;
            var j = $.parseJSON(res);
            if(j.msg === "ok"){
                storge.setItem("AccountInfo", JSON.stringify(j.AccountInfo));
                goOtherPage(j.AccountInfo);
            }else if(j.msg === "f"){
                console.log("出错了");
            }

        }
    }
    xmlhttp.open("POST","http://localhost:8080/getAccountInfo",true);
    xmlhttp.setRequestHeader("Content-type","application/json");
    xmlhttp.send(jsonData);

}


function goOtherPage(AccountInfo) {
    if(AccountInfo.identity === 0 || AccountInfo.identity === 1 || AccountInfo.identity === 2 || AccountInfo.identity === 4){
        href = "./PersonHomePage.html";
    }else if(AccountInfo.identity === 3){
        href = "./lankeren.html";
    }else{
        href = "./404.html";
    }
    window.location.href = href;
}



