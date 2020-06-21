function myInfoPage() {
    var storge = window.sessionStorage;
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
                if(j.AccountInfo.identity === 0 || j.AccountInfo.identity === 1 || j.AccountInfo.identity === 2){
                    storge.setItem("AccountInfo", JSON.stringify(j.AccountInfo));
                    href = "./PersonHomePage.html";
                }else if(j.AccountInfo.identity === 3){

                }else{
                    href = "./404.html";
                }
                window.location.href = href;
            }else if(j.msg === "f"){
                console.log("出错了");
            }

        }
    }
    xmlhttp.open("POST","http://localhost:8080/getAccountInfo",true);
    xmlhttp.setRequestHeader("Content-type","application/json");
    xmlhttp.send(jsonData);

}




