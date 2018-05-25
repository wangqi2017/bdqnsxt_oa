/**
 * 新建和更新部门(department)的弹窗panel
 */
Ext.define("core.app.view.DepartmentViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.departmentviewform',
    id: 'departmentviewformid',
    width: 500,
    autoScroll: true,
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                xtype: 'tabpanel',
                activeTab: 0,
                border: 0,
                listeners: {
                    beforetabchange: function (tabs, newTab, oldTab) {
                        /*
                        var orgnazitionId = oldTab.items.items[0].value;
                        if (orgnazitionId) {
                            Ext.apply(rolestore.proxy.extraParams, {
                                departmentId: orgnazitionId
                            });
                        }
                        */
                    }
                },
                items: [{
                    xtype: 'form',
                    title: '<span height=40>部门设置</span>',
                    border: 0,
                    height: '100%',
                    items: [{
                        xtype: 'textfield',
                        id: 'departmentid',
                        name: 'id',
                        hidden: true
                    }, {
                        xtype: 'textfield',
                        anchor: '95%',
                        margin: '5 0 0 5',
                        name: 'name',
                        id: 'departmentname',
                        allowBlank: false,
                        fieldLabel: "部门名称<font color='red'>*</font>"
                    }, {
                        xtype: 'textarea',
                        anchor: '95%',
                        margin: '5 0 0 5',
                        name: 'description',
                        id: 'departmentdescription',
                        fieldLabel: "部门描述"
                    }, {
                        xtype: 'fieldcontainer',
                        height: 30,
                        anchor: '95%',
                        margin: '5 0 10 5',
                        style: 'text-align:center',
                        items: [{
                            xtype: 'button',
                            margin: '5 0 0 5',
                            width: 80,
                            ref: 'submitdepartmentviewform',
                            text: '确认'
                        }, {
                            xtype: 'button',
                            margin: '5 0 0 15',
                            width: 80,
                            ref: 'closedepartmentviewform',
                            text: '取消'
                        }]
                    }]
                }
                , {
                    xtype: 'grid',
                    hidden: true,
                    region: 'center',
                    itemId: 'rolegrid',
                    title: '<span height=40>岗位设置</span>',
                    stripeRows: true,
                    autoScroll: true,
                    columnLines: true, // 展示竖线
                    layout: 'fit',
                    store: "core.app.store.SystemRoleStore",
                    tbar: [{
                        xtype: 'button',
                        text: '新增岗位',
                        ref: 'createsystemrole'
                    }, '-', {
                        xtype: 'button',
                        text: '删除岗位',
                        ref: 'deletesystemrole'
                    }, '-', {
                        xtype: 'button',
                        text: '修改权限',
                        ref: 'btnpermission'
                    }, '-', {
                        xtype: 'button',
                        text: '复制权限',
                        ref: 'btncopypermission'
                    }],
                    columns: [{
                        xtype: 'gridcolumn',
                        width: 150,
                        text: '岗位名称',
                        dataIndex: 'roleName',
                        sortable: true
                    }, {
                        xtype: 'gridcolumn',
                        text: '岗位描述',
                        dataIndex: 'description',
                        flex: 1,
                        sortable: true
                    }, {
                        xtype: 'gridcolumn',
                        text: '用户数量',
                        dataIndex: 'userCount',
                        flex: 1,
                        sortable: true
                    }, {
                        xtype: 'gridcolumn',
                        text: '创建人',
                        dataIndex: 'createByUsername',
                        flex: 1,
                        sortable: true
                    }, {
                        xtype: 'gridcolumn',
                        text: '修改人',
                        dataIndex: 'updateByUsername',
                        flex: 1,
                        sortable: true
                    }, {
                        xtype : 'datecolumn',
                        text : '创建时间',
                        dataIndex : 'createOn',
                        flex : 1,
                        format:'Y-m-d H:i:s'
                    }, {
                        xtype : 'datecolumn',
                        text : '修改时间',
                        dataIndex : 'updateOn',
                        flex : 1,
                        format:'Y-m-d H:i:s'
                    }]
                }]
            }]
        });
        me.callParent(arguments);
    }
})