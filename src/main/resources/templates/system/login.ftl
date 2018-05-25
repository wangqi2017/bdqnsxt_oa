<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>北大青鸟尚学堂OA系统</title>
    <link rel="icon" href="/images/ztlogo.ico" type="image/x-icon" />
    <link rel="Shortcut icon" href="images/ztlogo.ico" type="image/x-icon" />
    <link rel="stylesheet" type="text/css" href="css/login.css")">
</head>
<body>
<div
        style="margin: auto; width: 1440px; height: auto; overflow: hidden">
    <div class="top">
        <div class="left_one"></div>
        <div class="center">
            <img src="/images/login/tit.jpg" width="720"
                 height="257" alt="北大青鸟尚学堂OA系统" />
        </div>
        <div class="right_one"></div>
    </div>
    <div class="bottom">
        <div class="left_two"></div>
        <div class="loginbox">
            <table cellspacing="0" cellpadding="0" style="margin-top: 47px" width="420" >
                <form id="loginForm" action="login" method="post">
                    <tbody>
                    <tr>
                        <td class="tdleft"  ><div id="s_userName" style="">账&nbsp;&nbsp;号:</div>
                        </td>
                        <td class="tdright"  ><input class="inputbox"
                                                     name="username" id="username" type="text" maxlength="32" />
                        </td>
                        <td width = "160px" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </td>
                    </tr>
                    <tr>
                        <td class="tdleft"  ><div id="s_password" style="">密&nbsp;&nbsp;码:</div>
                        </td>
                        <td class="tdright"  ><input class="inputbox"
                                                     name="password" id="password" type="password" maxlength="32" />
                        </td>
                        <td width = "160px" > &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

                        </td>
                    </tr>
                    <tr>
                        <td  > &nbsp;&nbsp;
                        </td>
                        <td colspan="2"  style="text-align: left">&nbsp;&nbsp;&nbsp;&nbsp;<img
                                src="/images/login/btn.jpg" alt="登录"
                                name="submitBut" align="middle" id="submitcom"
                                onClick="submit()"
                                onmouseover="this.src='/images/login/btn_hover.jpg'"
                                onmouseout="this.src='/images/login/btn.jpg'"
                                type="image" />
                            <!--
                            <a href="#" style="padding: 10 0 0 0px" ><font color="red">忘记密码</font></a>
                                    -->
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3" style="text-align: center">
                            <font id="errMsg"  color="#FF0000">
                                <#if resp.success == false>
                                    <p class="error">${resp.message}</p>
                                </#if>
                            </font>
                        </td>
                    </tr>
                </form>
                </tbody>
                }
            </table>
            <tr style="display: none">
                <td style="display: none" width="73"></td>
                <td style="display: none" colspan="2"></td>
            </tr>

        </div>
        <div class="right_two"></div>
    </div>
</div>
<script language="javascript">

    function submit(){
        var errMsg = document.getElementById("errMsg");
        var username = document.getElementById("username").value;
        var password = document.getElementById("password").value;
        if(username.trim().length==0){
            errMsg.innerHTML = "<p class="error">用户名不能为空！</p>"
            return false;
        }
        if(password.trim().length==0){
            errMsg.innerHTML = "<p class="error">密码不能为空！</p>"
            return false;
        }
        document.forms[0].submit();
    }

    document.onkeydown=function(event){
        e = event ? event :(window.event ? window.event : null);
        if(e.keyCode==13){
            var pass=  document.forms[0].password.value;
            if(pass.length>0){
                //执行的方法
                submit();
            }
        }
    }

</script>
</body>
</html>
