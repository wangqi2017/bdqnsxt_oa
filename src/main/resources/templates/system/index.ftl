<!DOCTYPE html>
<html lang="en">


<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="js/sockjs.min.js"></script>
    <script src="js/stomp.min.js"></script>
    <script src="js/jquery.js"></script>
    <!--
    <script src="js/echarts.common.min.js"></script>
    -->
    <script type="text/javascript">
        var username = "${ login_user.username}";
        var userId = "${ login_user.id}";
        var loginRoles = [];
        <#if login_user.roles??>
            <#list login_user.roles as role>
                loginRoles.push("${role.roleName}");
            </#list>
        </#if>
        /*
        $(function(){
            if(loginRoles.length>0){
                $.each(loginRoles,function (index,ele) {
                    if(ele == '咨询师'||ele == '咨询主管'|| ele == '在线咨询师'|| ele=='咨询助理'){
                        var socket = new SockJS('/messageRemindingEndpoint');
                        var stompClient = Stomp.over(socket);
                        stompClient.connect({},function(){
                            stompClient.subscribe('/queue/getConsult',function(response){
                                console.log(response);
                            })

                        });
                        return false;
                    }
                })
            }

        })
        */
    </script>

    <link rel="stylesheet" href="ext/resources/css/ext-all.css">
    <link rel="stylesheet" href="ext/examples/ux/css/ItemSelector.css">
    <link rel="stylesheet" href="css/main.css">
    <script src="ext/ext-all-debug.js"></script>
    <script src="core/app.js"></script>
</head>
<body>

</body>

</html>