/**
 * 部门管理View
 */
Ext.define("core.app.view.DepartmentView", {
    extend : 'Ext.panel.Panel',
    alias : 'widget.departmentview',
    id : 'departmentviewid',
    //requires:['core.widget.feature.TreeSummary'],
    margins : '0 0 0 0',
    border : 0,
    title : '<center height=40>部门管理</center>',
    closable : true,
    bodyStyle : 'padding:0px',
    menuAlign : "center",
    layout : 'fit',
    tbar : [{
        text : '新建',
        ref : 'createdepartment'
    },'-', {
        text : '删除',
        ref : 'deletedepartment'
    }],
    items : [{
        xtype : "treepanel",
        id : 'departmenttreepanel',
        rootVisible : false,
        columnLines : true,
        layout : 'fit',
        stripeRows : true,
        columnLines : true, // 展示竖线
        height : 490,
        width : '100%',
        autoScroll : true,
        store : "core.app.store.DepartmentStore",
        /*
        features: [{
          ftype: 'treesummary',
          leafOnly:false
        }],
        */
        columns : [{
            xtype : 'treecolumn',
            text : '名称',
            flex : 4,
            dataIndex : 'name'
        }, {
        	xtype : 'gridcolumn',
            text : '用户数量',
            dataIndex : 'userCount',
            flex : 2
       }, {
        	xtype : 'gridcolumn',
            text : '岗位数量',
            dataIndex : 'roleCount',
            flex : 2
        },{
            xtype: 'gridcolumn',
            text : '描述',
            dataIndex : 'description',
            flex : 6
        }, {
            xtype : 'gridcolumn',
            text : '创建者',
            dataIndex : 'createByUsername',
            flex : 4
        }, {
            xtype : 'gridcolumn',
            text : '修改者',
            dataIndex : 'updateByUsername',
            flex : 4
        }, {
            xtype : 'datecolumn',
            text : '创建时间',
            dataIndex : 'createOn',
            flex : 4,
            format:'Y-m-d H:i:s'
        }, {
            xtype : 'datecolumn',
            text : '修改时间',
            dataIndex : 'updateOn',
            flex : 4,
            format:'Y-m-d H:i:s'
        }]
    }]
});