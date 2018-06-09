Ext.define("core.app.view.StudentConsultView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.studentconsultview',
    id: 'studentconsultviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>学员咨询信息</center>',
    closable: true,
    bodyStyle: 'padding:0px',
    menuAlign: "center",
    layout: 'border',
    requires:'core.widget.DateTimeField',
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
                                name: 'student.stuName',
                                fieldLabel: '学员姓名'
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'studentstatus',
                                margin: '5 0 10 60',
                                name: 'student.status',
                                fieldLabel: '学员状态',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: '--请选择--',
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "咨询",
                                        "name": "咨询"
                                    },{
                                        "value": "试听",
                                        "name": "试听"
                                    }]
                                })
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'consulter',
                                margin: '5 0 10 60',
                                name: 'consulter.id',
                                fieldLabel: '咨询师',
                                displayField: 'fullname',
                                valueField: 'id',
                                emptyText: '--请选择--',
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['id', 'fullname'],
                                    proxy: {
                                        type: 'rest',
                                        url: "/getConsulters",
                                        reader: {
                                            type: "json",
                                            root: "data",
                                            successProperty: 'success'
                                        },
                                        autoLoad: true
                                    }
                                })
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
                                xtype: 'datetimefield',
                                anchor: '90%',
                                itemId: 'quizTime',
                                margin: '5 0 0 10',
                                name: 'quizTime',
                                fieldLabel: '面试时间',
                                format: 'Y-m-d H:i:s'
                            }
                            , {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'purpose',
                                margin: '5 0 10 60',
                                name: 'purpose',
                                fieldLabel: '意向等级',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: '--请选择--',
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "0",
                                        "name": "低"
                                    },{
                                        "value": "1",
                                        "name": "中"
                                    },{
                                        "value": "2",
                                        "name": "高"
                                    }]
                                })
                            },
                            {
                                xtype: 'button',
                                margin: '5 0 0 150',
                                itemId: 'searchstudentconsultviewid',
                                ref: 'searchstudentconsultview',
                                text: '查询'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 30',
                                itemId: 'clearsearchstudentconsultviewid',
                                ref: 'clearsearchstudentconsultview',
                                text: '清空'
                            }]
                    }]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'studentconsultgird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.StudentConsultStore",
            viewConfig:{
                getRowClass:function(record, rowIndex){
                    if(record.get('purpose') == '2'){
                        return "high-purpose";
                    }else if(record.get("purpose") == "1"){
                        return "middle-purpose";
                    }else{
                        return "low-purpose";
                    }
                }
            },
            tbar: [{
                xtype: 'button',
                text: '学员跟踪',
                ref: 'tracestudentconsult'
            }, '-', {
                xtype: 'button',
                text: '解锁',
                ref: 'deletestudentconsult'
            }],

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '学员姓名',
                    dataIndex: 'student.stuName',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '咨询人',
                    dataIndex: 'consulter.fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '学员状态',
                    dataIndex: 'student.status',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '最终锁定时间',
                    dataIndex: 'lastLockTime',
                    flex: 1,
                    sortable: true,
                    format:'Y-m-d H:i:s'
                },
                {
                    xtype: 'datecolumn',
                    text: '面试时间',
                    dataIndex: 'quizTime',
                    flex: 1,
                    sortable: true,
                    format:'Y-m-d H:i:s'
                },
                {
                    xtype: 'gridcolumn',
                    text: '意向等级',
                    dataIndex: 'purpose',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        if(value == '2'){
                            return '<span style="color:red;">' + "高" + '</span>';
                        }else if(value == '1'){
                            return '<span style="color:green;">' + "中" + '</span>';
                        }else{
                            return '<span style="color:#795548;">' + "低" + '</span>';
                        }
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '第一次回访',
                    dataIndex: 'firstVisit',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '第二次回访',
                    dataIndex: 'secondVisit',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '第三次回访',
                    dataIndex: 'thirdVisit',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '备注',
                    dataIndex: 'remarks',
                    flex: 1,
                    sortable: true
                }]

        }],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: "core.app.store.StudentConsultStore",
        displayInfo: true,
        emptyMsg: "没有数据"
    }]

});
