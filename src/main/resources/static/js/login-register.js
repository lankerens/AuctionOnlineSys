function myInfoPage() {
    var storge = window.sessionStorage;
    var identity = storge.getItem("identity");
    var href ;
    console.log(identity);
    console.log(typeof identity);
    var data = {
        "account": storge.getItem("account"),
        "identity": storge.getItem("identity")
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

                if(identity === '0' || identity === '1' || identity === '2'){

                }else if(identity === '3'){

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




