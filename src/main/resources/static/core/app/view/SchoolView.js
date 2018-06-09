/*
 * 校区信息
 * author
 *
 */
Ext.define("core.app.view.SchoolView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.schoolview',
    id: 'schoolviewid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>校区信息</center>',
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
                                name: 'scname',
                                fieldLabel: '校区名称'
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'organization',
                                margin: '5 0 10 60',
                                name: 'organization',
                                fieldLabel: '所属机构',
                                allowBlank: false,
                                displayField: 'name',
                                valueField: 'value',
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
                                itemId: 'province',
                                margin: '5 0 0 10',
                                name: 'province',
                                fieldLabel: '所属省份',
                                allowBlank: false,
                                displayField: 'name',
                                valueField: 'value',
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "山东",
                                        "name": "山东"
                                    }, {
                                        "value": "河北",
                                        "name": "河北"
                                    }]
                                })
                            }
                            , {
                                xtype: 'tbfill'
                            },
                            {
                                xtype: 'button',
                                margin: '5 0 0 10',
                                itemId: 'searchschoolviewid',
                                ref: 'searchschoolview',
                                text: '查询'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 30',
                                itemId: 'clearsearchschoolviewid',
                                ref: 'clearsearchschoolview',
                                text: '清空'
                            }]
                    }]
            }]
        },

        // 添加，删除按钮以及数据展示层面的items
        {
            xtype: 'grid',
            region: 'center',
            itemId: 'schoolgird',
            stripeRows: true,
            autoScroll: true,
            columnLines: true, // 展示竖线
            height: 490,
            width: '100%',
            autoScroll: true,
            store: "core.app.store.SchoolStore",
            tbar: [{
                xtype: 'button',
                text: '新增校区',
                ref: 'createschool'
            }, '-', {
                xtype: 'button',
                text: '删除校区',
                ref: 'deleteschool'
            }],

            columns: [
                {
                    xtype: 'gridcolumn',
                    text: '校区名称',
                    dataIndex: 'scname',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所属机构',
                    dataIndex: 'organization',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '所属省份',
                    dataIndex: 'province',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '教师人数',
                    dataIndex: 'teachers',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var teachers = record.data.teachers;
                        return teachers.length;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '当前开班数',
                    dataIndex: 'currentClazzes',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var currentClazzes = record.data.currentClazzes;
                        return currentClazzes.length;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '总开班数',
                    dataIndex: 'totalClazzes',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var totalClazzes = record.data.totalClazzes;
                        return totalClazzes.length;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '当前学员数',
                    dataIndex: 'currentClazzes',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var stuNums = 0;
                        var currentClazzes = record.data.currentClazzes;
                        Ext.Array.each(currentClazzes,function (name, index, countriesItSelf) {
                            var clazz = currentClazzes[index];
                            stuNums += clazz.students.length;
                        })
                        return stuNums;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '总学员数',
                    dataIndex: 'totalClazzes',
                    flex: 1,
                    sortable: true,
                    renderer: function (value, metaData, record){
                        var stuNums = 0;
                        var totalClazzes = record.data.totalClazzes;
                        Ext.Array.each(totalClazzes,function (name, index, countriesItSelf) {
                            var clazz = totalClazzes[index];
                            stuNums += clazz.students.length;
                        })
                        return stuNums;
                    }
                },
                {
                    xtype: 'gridcolumn',
                    text: '校区地址',
                    dataIndex: 'address',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '负责人',
                    dataIndex: 'leader',
                    flex: 1,
                    sortable: true
                },
                {
                    xtype: 'gridcolumn',
                    text: '负责人电话',
                    dataIndex: 'leaderPhone',
                    flex: 1,
                    sortable: true
                }]

        }],
    dockedItems: [{
        xtype: 'pagingtoolbar',
        dock: 'bottom',
        store: "core.app.store.SchoolStore",
        displayInfo: true,
        emptyMsg: "没有数据"
        // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
    }]

});
