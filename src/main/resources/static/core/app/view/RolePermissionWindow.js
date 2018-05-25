Ext.define("core.app.view.RolePermissionWindow", {
    extend : 'Ext.window.Window',
    alias : 'widget.rolepermissionwin',
    itemId:'rolepermissionwinid',
    margins : '0 0 0 0',
    border : 0,
    modal : true,
    constrainHeader : true,
//    closeAction : 'hide',
    hideMode : 'offsets',
    title : '用户权限列表',
    height : 500,
    width : 350,
    resizable : false,
    layout : {
        type : 'fit'
    },
    hiddenToolbar : false,
    initComponent : function() {
        var me = this;
        var menuStore = Ext.create("Ext.data.TreeStore", {
            defaultRootId : '',
            fields : ['id', 'text']
        });

        // 勾选父节点
        var checkedParentNode = function(node, checked, eOpts) {
            if (node.parentNode) {
                node.parentNode.set('checked', true);
                checkedParentNode(node.parentNode, true, eOpts);
            }
        }

        // 勾选或勾空子节点
        var checkedChildNode = function(node, checked, eOpts) {
            if (node.hasChildNodes()) {
                for ( var i = 0, len = node.childNodes.length; i < len; i++) {
                    node.childNodes[i].set('checked', checked);
                    checkedChildNode(node.childNodes[i], checked, eOpts);
                }
            }
        }
        // 树节点勾选事件
        var permissionCheckChange = function(node, checked, eOpts) {
            // 勾选节点 递归勾选父节点
            if (checked) {
                checkedParentNode(node, checked, eOpts);
            }
            // 勾选节点，子节点全部勾选, 勾空节点，子节点全部勾空,
            checkedChildNode(node, checked, eOpts);
        }
        // role tree
        var menuTree = null;

        var menuitems = [];
        menuTree = Ext.create('Ext.tree.Panel', {
                title : '岗位权限',
                flex : 1,
                height : '100%',
                rootVisible : false,
                itemId : 'menutree',
                store : menuStore,
                viewConfig : {
                    loadMask : {
                        msg : '数据加载中......'
                    }
                },
                listeners : {
                    checkChange : permissionCheckChange
                }
            });
        menuitems.push(menuTree);

        Ext.applyIf(me, {
            items : [{
                xtype : 'panel',
                layout : 'fit',
                items :[{
                    xtype : 'panel',
                    border:0,
                    layout : 'hbox',
                    items :menuitems
                }]
            }],
            buttons : [{
                xtype : 'button',
                text : '保存修改',
                itemId : 'modifiedbtn',
                ref : 'btnmodifypermission'
            }, {
                xtype : 'button',
                text : '取消',
                listeners : {
                    click : function(btn) {
                        me.close();
                    }
                }
            }]
        });
        me.callParent(arguments);
    }
});
