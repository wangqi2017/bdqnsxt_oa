Ext.define("core.system.view.TopView", {
    extend : "Ext.panel.Panel",
    alias : 'widget.topview',
    id : "topviewid",
    height : 50,

    bodyStyle : {
        background : '#075281'
    },
    layout : {
        type : 'border'
    },
    requires: ['core.widget.GridComboBox'],
    initComponent : function() {
        var me = this;
        Ext.apply(this, {

            items : [{
                xtype : 'image',
                region : 'west',
                height : 50,
                width : 300,
                src : '/images/logo.png'
            },/* {
                xtype : 'fieldcontainer',
                region : 'center',
                width : 50,
                height: 50
            }, */{
                xtype : 'fieldcontainer',
                itemId: 'topfieldcontainer',
                region : 'east',
                width : 750,
                height : 50,
                style : 'text-align:center',
                layout : {
                    type : 'column'
                },
                items : [{
                    xtype : 'displayfield',
                    margin : '5 0 0 5',
                    style : 'color:white;font-weight:bold',
                    value : "",
                    width : 400
                },{
                    xtype : 'displayfield',
                    itemId : 'disrecorditemid',
                    anchor : '90%',
                    margin : '5 0 0 5',
                    style : 'color:white;font-weight:bold',
                    value : "<span  style='color:white;font-weight:bold'>" + username + "</span>",
                    width : 90,
                    labelWidth : 30,
                    fieldLabel : '欢迎'
                }, {
                    xtype : 'button',
                    itemId: 'userpassworditemid',
                    id: 'userpassword',
                    text : '修改密码',
                    width : 90,
                    margin : '5 0 0 10'
                    /*,
                    listeners: {
                        'mouseover': function () {
                            debugger
                            stompClient.send("/studentConsultRemiding",{},JSON.stringify({"id":userId}));
                        }
                    }*/
                }, {
                    xtype : 'button',
                    text : '退出',
                    width : 50,
                    margin : '5 0 0 10',
                    handler : function(btn, e) {
                        window.location.href = '/logout';
                    }
                }]
            }]
        });
        this.callParent(arguments);
        // Ext.Ajax.request({
        //     url : "/projects/user",
        //     method : "GET",
        //     success : function(response, opts) {
        //         var resp = Ext.decode(response.responseText);
        //         if (resp.success == "true" || resp.success == true) {
        //             var menu1 = common.generateMenus(resp.data);
        //             var projectbtn = me.down('#projectbutton');
        //             projectbtn.menu = menu1;
        //         }
        //     },
        //     failure : function(resp, opts) {
        //     }
        // });
    }
    ,
    listeners : {
        render : function(view,eOpts) {
            Ext.Array.each(loginRoles,function (name,index,selfSel) {
                var ele = loginRoles[index];
                if(ele == '咨询师'||ele == '咨询主管'|| ele == '在线咨询师'|| ele=='咨询助理'){
                    var studentConsult= [];


                    var socket = new SockJS('/messageRemindingEndpoint');
                    var stompClient = Stomp.over(socket);
                    stompClient.connect({},function(){
                        stompClient.subscribe('/queue/getConsult',function(response){

                            var body = JSON.parse(response.body);
                            var data = body.data;
                            if(data.length > 0){
                                    studentConsult = [];
                                    Ext.Array.each(data,function (name, index, countriesItSelf) {
                                        if(data[index].consulter.id == userId){
                                            studentConsult.push(data[index]);
                                        }
                                    })
                                    Ext.Msg.alert("提醒!", "您今天有："+ (studentConsult.length) + "个面试学员学员");
                                    var store = Ext.create('Ext.data.Store',{
                                        fields:['student.stuName','quizTime','firstVisit','secondVisit','thirdVisit'],
                                        data : studentConsult
                                    })

                                    var item = Ext.create("core.widget.GridComboBox",{
                                        itemId: 'consultgridcombobox',
                                        margin : '5 0 0 10',
                                        width: 80,
                                        value: '面试学员',
                                        store: store,
                                        mode: 'local'
                                    });
                                    var topfieldcontainer = view.down('#topfieldcontainer');
                                    topfieldcontainer.insert(2,item);
                            }
                        })

                    });
                    return false;
                }
            })
            //stompClient.send("/studentConsultRemiding",{},JSON.stringify({"id":userId}));
        }
    }
});
