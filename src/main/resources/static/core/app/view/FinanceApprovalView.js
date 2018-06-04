
Ext.define("core.app.view.FinanceApprovalView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.financeapprovalview',
    id: 'financeapprovalviewid',
    itemId: 'financeapprovalviewitemid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>财务信息</center>',
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
                height: 60,
                layout: 'vbox',
                items: [{
                    xtype: 'panel',
                    layout: 'hbox',
                    width : '100%',
                    height: 30,
                    border: 0,
                    items: [{
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
                    },{
                        xtype: 'combobox',
                        anchor: '90%',
                        margin: '5 0 10 5',
                        name: 'processStatus',
                        fieldLabel: '审批状态',
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "草稿",
                                "name": "草稿"
                            }, {
                                "value": "财务审批通过",
                                "name": "财务审批通过"
                            }, {
                                "value": "中心审批通过",
                                "name": "中心审批通过"
                            }, {
                                "value": "归档",
                                "name": "归档"
                            }]
                        })
                    },{
                        xtype: 'combobox',
                        anchor: '90%',
                        margin: '5 0 10 5',
                        name: 'financeApprovalerId',
                        fieldLabel: '财务审批人',
                        displayField: 'fullname',
                        valueField: 'id',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['id', 'fullname'],
                            proxy: {
                                type: 'rest',
                                url: "/getApprovalers",
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
                        xtype: 'textfield',
                        margin: '5 0 10 5',
                        name: 'proposerName',
                        fieldLabel: '申请人'
                    }, {
                        xtype : 'button',
                        margin : '5 0 0 50',
                        itemId : 'searchfinanceviewid',
                        ref : 'searchfinanceview',
                        text : '查询'
                    },{
                        xtype : 'button',
                        margin : '5 0 0 30',
                        itemId : 'clearsearchfinanceviewid',
                        ref : 'clearsearchfinanceview',
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
            itemId: 'financegird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.FinanceStore",
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                itemId: 'financegriddockitemId',
                items: [{
                    xtype: 'button',
                    text: '申请',
                    ref: 'financeapply'
                }, '-']
            }],
            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '审批状态',
                    dataIndex: 'processStatus',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所属校区',
                    dataIndex: 'school.scname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '申请人',
                    dataIndex: 'proposer.fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '金额',
                    dataIndex: 'amount',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '类型',
                    dataIndex: 'financeType',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '详情',
                    dataIndex: 'details',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '申请时间',
                    dataIndex: 'applyTime',
                    flex: 1,
                    sortable: true,
                    format:'Y-m-d H:i:s'
                },
                {
                    xtype: 'gridcolumn',
                    text: '文件',
                    dataIndex: 'fileLocations',
                    flex: 2,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var str = '';
                        if(value != null && value.length>0){
                            var locations = value.split('_-_');
                            Ext.Array.each(locations,function (name, index, countriesItSelf) {
                                str += '<a href="'+ locations[index] +'" target="_blank"><img src="' + locations[index] + '" width="50" height="30" borerd="0" /></a>'
                                str += "&nbsp;&nbsp;";
                            })
                        }
                        return str;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '财务审批人',
                    dataIndex: 'financeApprovaler.fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '财务审批时间',
                    dataIndex: 'financeApprovalTime',
                    format: 'Y年m月d日 H时i分s秒',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '财务意见',
                    dataIndex: 'financeApprovalOpin',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '中心审批人',
                    dataIndex: 'centerApprovaler.fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '中心审批时间',
                    dataIndex: 'centerAprrovalTime',
                    format: 'Y年m月d日 H时i分s秒',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '中心意见',
                    dataIndex: 'centerApprovalOpin',
                    flex: 1,
                    sortable: true
                }],

            listeners: {
                render: function (view, eOpts) {
                    Ext.Ajax.request({
                        url: '/resource/button/financeapproval',
                        success: function (response, opts) {
                            var dockItems = view.getDockedComponent('financegriddockitemId');
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
        store : "core.app.store.FinanceStore",
        displayInfo: true,
        emptyMsg: "没有数据",
        displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
    }]

});
