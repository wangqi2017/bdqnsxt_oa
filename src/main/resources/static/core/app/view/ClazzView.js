/*
 * 班级信息
 * author
 *
 */
Ext.define("core.app.view.ClazzView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.clazzview',
    id: 'clazzviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>班级信息</center>',
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
                                name: 'clname',
                                fieldLabel: '班级名称'
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'organization',
                                margin: '5 0 10 5',
                                name: 'organization',
                                fieldLabel: '所属机构',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "北大青鸟尚学堂",
                                        "name": "北大青鸟尚学堂"
                                    }]
                                })
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
                                itemId: 'clazzschool',
                                margin: '5 0 0 10',
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
                                        }
                                    }
                                    /*,
                                    listeners: {
                                        'datachanged': function(store, eOpts ){
                                            store.insert(0, new school({'id':'0','scname':'所有'}));
                                        }
                                    }*/
                                })
                            }
                            , {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'status',
                                margin: '5 0 10 5',
                                name: 'status',
                                fieldLabel: '班级状态',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "未开班",
                                        "name": "未开班"
                                    }, {
                                        "value": "试听",
                                        "name": "试听"
                                    },{
                                        "value": "开班",
                                        "name": "开班"
                                    },{
                                        "value": "结束",
                                        "name": "结束"
                                    }]
                                })
                            },
                            {
                                xtype: 'button',
                                margin: '5 0 0 10',
                                itemId: 'searchclazzviewid',
                                ref: 'searchclazzview',
                                text: '查询'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 30',
                                itemId: 'clearsearchclazzviewid',
                                ref: 'clearsearchclazzview',
                                text: '清空'
                            }]
                    }]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'clazzgird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.ClazzStore",
            tbar: [{
                xtype: 'button',
                text: '新增班级',
                ref: 'createclazz'
            }, '-', {
                xtype: 'button',
                text: '删除班级',
                ref: 'deleteclazz'
            }],

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '班级名称',
                    dataIndex: 'clname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '方向',
                    dataIndex: 'orientation',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '开始时间',
                    dataIndex: 'startDate',
                    format: 'Y年m月d日',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'datecolumn',
                    text: '结束时间',
                    dataIndex: 'endDate',
                    format: 'Y年m月d日',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '当前状态',
                    dataIndex: 'status',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所属校区',
                    dataIndex: 'belongSchool.scname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '班主任',
                    dataIndex: 'classLeader.fullname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '教员',
                    dataIndex: 'lecturer.fullname',
                    flex: 1,
                    sortable: true
                },{
                    xtype: 'gridcolumn',
                    text: '辅导员',
                    dataIndex: 'tutors',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var tutors = record.data.tutors;
                        var tutorNames = "";
                        if(tutors!=''&&tutors!=null){
                            console.log(JSON.stringify(tutors));
                            Ext.Array.each(tutors, function(name, index, countriesItSelf) {
                                tutorNames += tutors[index].fullname + ",";
                            });
                        }
                        return tutorNames.substr(0,tutorNames.length-1);
                    }
                }]

        }],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: "core.app.store.ClazzStore",
        displayInfo: true,
        emptyMsg: "没有数据"
        // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
    }]

});
