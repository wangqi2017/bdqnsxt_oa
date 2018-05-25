/**
 * 复制用户权限 view
 */
Ext.define("core.app.view.RoleCopyPermissionWindow", {
    extend: 'Ext.window.Window',
    alias: 'widget.rolecopypermissionwin',
    margins: '0 0 0 0',
    border: 0,
    modal: true,
//    closeAction : 'hide',
    hideMode: 'offsets',
    constrainHeader: true,
    height: 500,
    width: 350,
    resizable: false,
    layout: {
        type: 'fit'
    },
    initComponent: function () {
        var me = this;
        var targetTree = null;

        targetTree = Ext.create('Ext.tree.Panel', {
            // title : '复制权限',
            height: '100%',
            rootVisible: false,
            displayField: "name",
            viewConfig: {
                loadMask: {
                    msg: '数据加载中......'
                }
            },
            itemId:'pertreeid',
            store: Ext.create("Ext.data.TreeStore", {
                defaultRootId: '',
                fields: ['id', 'roleId', 'name'],
                proxy: {
                    type: 'rest',
                    url: '/departments',
                    reader: {
                        type: "json",
                        root: "departments",
                        successProperty: 'success'
                    },
                    writer: {
                        type: "json"
                    }
                },
                listeners: {
                    load: function (store, records, successful, eOpts) {
                        //修改部门为非leaf
                        var schs = records.childNodes;
                        Ext.Array.each(schs,function (name, index, countriesItSelf) {
                            var deps = schs[index].childNodes;
                            Ext.Array.each(deps,function (name, index, countriesItSelf) {
                                deps[index].data.leaf = false;
                            })
                        })

                        /*
                        var firstNodeId = records.childNodes[0].data.id;

                        var nodes = null;
                        if (firstNodeId) {
                            nodes = records.childNodes[0].childNodes;
                        } else {
                            nodes = records.childNodes;
                        }
                        for (var i = 0, len = nodes.length; i < len; i++) {
                            nodes[i].set('loaded', false);
                            nodes[i].set('expanded', false);
                            if (nodes[i].data.roleid) {
                                nodes[i].set('leaf', true);
                                nodes[i].set('loaded', true);
                                nodes[i].set('checked', false);
                            }
                        }
                        */
                    }

                }
            })
        });


        Ext.applyIf(me, {
            items: targetTree,
            buttons: [{
                xtype: 'button',
                text: '确定',
                itemId: 'modifiedbtn',
                ref: 'btncopypermission'
            }, {
                xtype: 'button',
                text: '取消',
                listeners: {
                    click: function (btn) {
                        me.close();
                    }
                }
            }]
        });
        me.callParent(arguments);
    }
});
