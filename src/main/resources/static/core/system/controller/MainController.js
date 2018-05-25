Ext.define("core.system.controller.MainController", {
    extend: 'Ext.app.Controller',
    uses : ['core.utils.Common', 'core.utils.Files'],
    contractgridstore: null,
    gridstore: null,
    mainController: null,
    _self: null,
    init: function () {
        mainController = this;
        this.control({
            "westview treepanel" : {
                'itemclick' : this.onMenuClick
            },
            'mainview' : {
                afterrender : this.onMainViewAfterRender
            },
            'topview #userpassworditemid' :{
                'click' : this.onUserPasswordClick
            }
        })
    },

    onMenuClick:function(tree, record, item, index, e, eOpts) {
        if (record.data.funViewXtype) {
            // 改变history
            var tabs = [];
            tabs[0] = record.data.id;
            var newToken = tabs.join(":");
            var oldToken = Ext.History.getToken();
            if (oldToken === null || oldToken.search(newToken) === -1) {
                Ext.History.add(newToken);
            }
        }
    },

    onUserPasswordClick:function(btn){
        var tabs = [];
        tabs[0] = btn.id;
        var newToken = tabs.join(":");
        var oldToken = Ext.History.getToken();
        if (oldToken === null || oldToken.search(newToken) === -1) {
            Ext.History.add(newToken);
        }
    },

    // history 事件监听
    onMainViewAfterRender : function(component, eOpts) {
        var westview = component.down('westview');
        var centerview = component.down("centerview");
        var trees = westview.items.items;
        var treestores = [];
        for ( var i = 0, len = trees.length; i < len; i++) {
            //trees[i]: 人力资源
            //trees[i]:trees[i].items.items:用户+岗位
            var twoArray = trees[i].items.items;
            for(var j=0,len2=twoArray.length;j<len2;j++){
                //三级菜单in store
                var store = twoArray[j].getStore();
                treestores.push(store);
                //三级菜单
                // var threeArray = twoArray[j].items.items;
                // for(var k=0,len3=threeArray.length;k<len3;k++){
                //     var store = threeArray[k].getStore();
                //     treestores.push(store);
                // }

            }


        }
        var maincontroller = window.mainController;
        // 先看一下 url有没有，token
        var oldToken = Ext.History.getToken();
        if (oldToken) {
            var menurecord = null;
            for ( var j = 0, len2 = treestores.length; j < len2; j++) {
                menurecord = treestores[j].getNodeById(oldToken);
                if (menurecord) {
                    // 向上展开菜单的父节点
                    var depth = menurecord.getDepth() - 1;
                    var depthOneNode = menurecord;
                    for ( var x = 0; x < depth; x++) {
                        depthOneNode = depthOneNode.parentNode;
                        depthOneNode.expand();
                    }
                    depthOneNode.expand();
                    depthOneNode = null;
                    break;
                } else {
                    continue;
                }
            }
            if (menurecord) {
                trees[j].expand(true);
                common.addFunItem({
                    'mainView' : centerview,
                    'menuId' : menurecord.data.id,
                    'funViewXtype' : menurecord.data.funViewXtype,
                    'funController' : menurecord.data.funController,
                    'funViewName' : menurecord.data.funViewName
                }, maincontroller);
            }
        }

        // history 的change事件的监听，如果url有改变，那么就根据menuId跳转到指定页面
        Ext.History.on('change', function(token) {

            if (!token) {
                return false;
            }

            //修改密码
            if(token == 'userpassword'){
                common.addFunItem({
                    'mainView' : centerview,
                    'menuId' : 'userpassword',
                    'funViewXtype' : 'userpasswordviewform',
                    'funController' : 'core.app.controller.UserPasswordController',
                    'funViewName' : 'core.app.view.UserPasswordViewForm'
                }, maincontroller);
                return;
            }

            var record = null;
            for ( var k = 0, len3 = treestores.length; k < len3; k++) {
                record = treestores[k].getNodeById(token);
                if (record) {
                    break;
                } else {
                    continue;
                }
            }

            if (record) {
                common.addFunItem({
                    'mainView' : centerview,
                    'menuId' : record.data.id,
                    'funViewXtype' : record.data.funViewXtype,
                    'funController' : record.data.funController,
                    'funViewName' : record.data.funViewName
                }, maincontroller);
            }


        });
    },


    views: ["core.system.view.MainView", "core.system.view.TopView", "core.system.view.CenterView", "core.system.view.WestView",
        "core.widget.AlertWin"],
    controllers: ["core.app.controller.UserPasswordController"]
});
