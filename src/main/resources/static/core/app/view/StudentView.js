/*
 * 学员信息
 * author
 *
 */
Ext.define("core.app.view.StudentView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.studentview',
    id: 'studentviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>学员信息</center>',
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
                height: 70,
                items: [
                    {
                        xtype: 'panel',
                        layout: 'hbox',
                        width: '100%',
                        height: 30,
                        border: 0,
                        items: [
                            {
                                xtype: 'textfield',
                                margin: '5 0 0 10',
                                name: 'stuName',
                                fieldLabel: '学员名称'
                            }, {
                                xtype: 'textfield',
                                margin: '5 0 0 10',
                                name: 'mobilePhone',
                                fieldLabel: '手机号'
                            }, {
                                xtype: 'tbfill'
                            }]
                    },
                    {
                        xtype: 'panel',
                        layout: 'hbox',
                        width: '100%',
                        height: 30,
                        border: 0,
                        items: [

                            {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'status',
                                margin: '5 0 0 10',
                                name: 'status',
                                fieldLabel: '学员状态',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "咨询",
                                        "name": "咨询"
                                    }, {
                                        "value": "试听",
                                        "name": "试听"
                                    }, {
                                        "value": "报名",
                                        "name": "报名"
                                    }, {
                                        "value": "就读",
                                        "name": "就读"
                                    }, {
                                        "value": "结业",
                                        "name": "结业"
                                    }, {
                                        "value": "就业",
                                        "name": "就业"
                                    }, {
                                        "value": "离校",
                                        "name": "离校"
                                    }, {
                                        "value": "失联",
                                        "name": "失联"
                                    }]
                                })
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'lockId',
                                margin: '5 0 0 10',
                                name: 'lockId',
                                fieldLabel: '锁定人',
                                displayField: 'fullname',
                                valueField: 'id',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['id', 'fullname'],
                                    proxy: {
                                        type: 'rest',
                                        url: '/getConsulters',
                                        reader: {
                                            type: "json",
                                            root: "data",
                                            successProperty: 'success'
                                        }
                                    },
                                    listeners: {
                                        load : function(store, records, options ){
                                            var model = Ext.create("core.app.model.UserModel",{
                                                id : '0',
                                                fullname: '未锁定'
                                            });
                                            store.insert(0,model);
                                        }
                                    }
                                })
                            },
                            {
                                xtype: 'button',
                                margin: '5 0 0 10',
                                itemId: 'searchstudentviewid',
                                ref: 'searchstudentview',
                                text: '查询'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 30',
                                itemId: 'clearsearchstudentviewid',
                                ref: 'clearsearchstudentview',
                                text: '清空'
                            }]
                    }]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'studentgird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.StudentStore",
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                itemId: 'studentgriddockitemId',
                items: [{
                    xtype: 'button',
                    text: '新增学员',
                    ref: 'createstudent'
                }, '-', {
                    xtype: 'button',
                    text: '删除学员',
                    ref: 'deletestudent'
                }, '-']
            }],

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '学员名称',
                    dataIndex: 'stuName',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '手机号',
                    dataIndex: 'mobilePhone',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所属校区',
                    dataIndex: 'currentClazz.belongSchool.scname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所在班级',
                    dataIndex: 'currentClazz.clname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '状态',
                    dataIndex: 'status',
                    flex: 1,
                    sortable: true
                },{
                    xtype : 'gridcolumn',
                    text : '锁定人',
                    dataIndex : 'studentConsult.consulter.fullname',
                    flex : 1,
                    sortable : true
                },{
                    xtype : 'datecolumn',
                    text : '最终锁定时间',
                    dataIndex : 'studentConsult.lastLockTime',
                    flex : 1,
                    format: 'Y年m月d日 H时i分s'
                },
                {
                    xtype: 'gridcolumn',
                    text: '标识',
                    dataIndex: 'remarks',
                    flex: 1,
                    sortable: true
                }],
            listeners: {
                render: function (view, eOpts) {
                    Ext.Ajax.request({
                        url: '/resource/button/lockstudent',
                        success: function (response, opts) {
                            var dockItems = view.getDockedComponent('studentgriddockitemId');
                            var resp = Ext.decode(response.responseText);
                            if (resp.success == "true" || resp.success == true) {
                                var data = resp.data;
                                Ext.Array.each(data, function (name, index, self) {
                                    var btn = Ext.create("Ext.button.Button", {
                                        text: data[index].text,
                                        ref: data[index].ref
                                    });
                                    dockItems.add(btn);
                                })
                            }
                        },
                        failure: function (response, opts) {
                            Ext.Msg.alert("错误!", "尝试获取按钮失败")
                        }
                    });
                }
            }

        }],
        dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            store: "core.app.store.StudentStore",
            displayInfo: true,
            emptyMsg: "没有数据"
            // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
        }]


});
