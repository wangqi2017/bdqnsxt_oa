/*
 * 用户信息
 * author
 *
 */
Ext.define("core.app.view.UserView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.userview',
    id: 'userviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>用户信息</center>',
    closable: true,
    bodyStyle: 'padding:0px',
    menuAlign: "center",
    layout: 'border',
    items: [
        // 查询栏items
        {
            xtype: 'panel',
            region: 'north',
            title: '查询',
            collapsible: true,
            items: [{
                xtype: 'form',
                height: 100,
                layout: 'vbox',
                items: [{
                    xtype: 'panel',
                    layout: 'hbox',
                    width : '100%',
                    height: 30,
                    border: 0,
                    items: [
                        {
                            xtype: 'textfield',
                            margin: '5 0 0 10',
                            name: 'username',
                            fieldLabel: '用户名'
                        }, {
                            xtype: 'textfield',
                            margin: '5 0 0 10',
                            name: 'mobilePhone',
                            fieldLabel: '手机号'
                        }, {
                            xtype: 'combobox',
                            anchor: '90%',
                            margin: '5 0 10 5',
                            name: 'roleId',
                            fieldLabel: '系统角色',
                            displayField: 'roleName',
                            valueField: 'id',
                            emptyText: "--请选择--",
                            store: Ext.create('Ext.data.Store', {
                                fields: ['id', 'roleName'],
                                proxy: {
                                    type: 'rest',
                                    url: "/allSystemRoles",
                                    reader: {
                                        type: "json",
                                        root: "data",
                                        successProperty: 'success'
                                    },
                                    autoLoad: true
                                }
                            })
                        }
                    ]
                }, {
                    xtype: 'panel',
                    layout: 'hbox',
                    width : '100%',
                    height: 30,
                    border: 0,
                    items: [{
                        xtype: 'datefield',
                        margin: '5 0 0 10',
                        name: 'hireDateStart',
                        format: 'Y-m-d',
                        fieldLabel: '入职时间大于'
                    },{
                        xtype : 'datefield',
                        margin : '5 0 0 10',
                        name : 'hireDateEnd',
                        format:'Y-m-d',
                        fieldLabel : '入职时间小于'
                    }, {
                        xtype: 'combobox',
                        anchor: '90%',
                        margin: '5 0 10 5',
                        name: 'schoolId',
                        fieldLabel: '所属校区',
                        displayField: 'scname',
                        valueField: 'id',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['id', 'scname'],
                            proxy: {
                                type: 'rest',
                                url: "/allschools",
                                reader: {
                                    type: "json",
                                    root: "data",
                                    successProperty: 'success'
                                },
                                autoLoad: true
                            }
                        })
                    }]
                },{
                    xtype: 'panel',
                    layout: 'hbox',
                    width : '100%',
                    height: 30,
                    border: 0,
                    items: [{
                        xtype : 'button',
                        margin : '5 0 0 50',
                        itemId : 'searchuserviewid',
                        ref : 'searchuserview',
                        text : '查询'
                    },{
                        xtype : 'button',
                        margin : '5 0 0 30',
                        itemId : 'clearsearchuserviewid',
                        ref : 'clearsearchuserview',
                        text : '清空'
                    }, {
                        xtype: 'tbfill'
                    }]
                }
                ]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'usergird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.UserStore",
            tbar: [{
                xtype: 'button',
                text: '新增用户',
                ref: 'createuser'
            }, '-', {
                xtype: 'button',
                text: '删除用户',
                ref: 'deleteuser'
            }],

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '用户名',
                    dataIndex: 'username',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '姓名',
                    dataIndex: 'fullname',
                    flex: 1,
                    sortable: true
                },
                /*
                {
                    xtype: 'gridcolumn',
                    text: '管理员',
                    dataIndex: 'admin',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var isAdmin = record.data.admin;
                        if(isAdmin){
                            return '是';
                        }else{
                            return '否';
                        }
                    }
                },
                */
                {
                    xtype: 'gridcolumn',
                    text: '校区',
                    dataIndex: 'school.scname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '部门',
                    dataIndex: 'department.name',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '角色',
                    dataIndex: 'roles',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var roles = record.data.roles;
                        var roleNames = "";
                        if(roles.length>0){
                            Ext.Array.each(roles,function (name, index, countriesItSelf){
                                roleNames += roles[index].roleName + ","
                            })
                            roleNames = roleNames.substr(0,roleNames.length-1);
                        }
                        return roleNames;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: 'qq',
                    dataIndex: 'qq',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '邮箱',
                    dataIndex: 'email',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '性别',
                    dataIndex: 'gender',
                    flex: 1,
                    sortable: true,
                    renderer: function (value) {
                        if (value == 'MAIL') {
                            return '男'
                        } else if (value == 'FEMAIL') {
                            return '女'
                        } else {
                            return '异常'
                        }
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '手机',
                    dataIndex: 'mobilePhone',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '入职时间',
                    dataIndex: 'hireDate',
                    format: 'Y年m月d日',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '创建者',
                    dataIndex: 'createByUsername',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '创建时间',
                    dataIndex: 'createOn',
                    format: 'Y-m-d H:i:s',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '修改时间',
                    dataIndex: 'updateOn',
                    format: 'Y-m-d H:i:s',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '用户状态',
                    dataIndex: 'status',
                    flex: 1,
                    sortable: true,
                    renderer: function (value) {
                        if (value == 'ACTIVE') {
                            return '可用'
                        } else if (value == 'INACTIVE') {
                            return '不可用'
                        } else {
                            return '异常'
                        }
                    }
                }]

        }],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store : "core.app.store.UserStore",
        displayInfo: true,
        emptyMsg: "没有数据"
        // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
    }]

});
