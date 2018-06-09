/*
 * 教师信息
 * author
 *
 */
Ext.define("core.app.view.TeacherView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.teacherview',
    id: 'teacherviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>教师信息</center>',
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
                height: 40,
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
                            fieldLabel: '教师名称'
                        }, {
                            xtype: 'combobox',
                            anchor: '90%',
                            margin: '5 0 10 60',
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
                        }, {
                            xtype : 'button',
                            margin : '5 0 0 50',
                            itemId : 'searchteacherviewid',
                            ref : 'searchteacherview',
                            text : '查询'
                        },{
                            xtype : 'button',
                            margin : '5 0 0 30',
                            itemId : 'clearsearchteacherviewid',
                            ref : 'clearsearchteacherview',
                            text : '清空'
                        }, {
                            xtype: 'tbfill'
                        }
                    ]
                }
                ]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'teachergird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.TeacherStore",

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '讲师姓名',
                    dataIndex: 'fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所在校区',
                    dataIndex: 'school',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var school = record.data.school;
                        return school.scname;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '类别',
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
                }
                ]

        }],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store : "core.app.store.TeacherStore",
        displayInfo: true,
        emptyMsg: "没有数据"
        // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
    }]

});
