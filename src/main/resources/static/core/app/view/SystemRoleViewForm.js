/*
 * 岗位管理View中，用来创建岗位和更新岗位的panel
 * 
 */
Ext.define("core.app.view.SystemRoleViewForm", {
    extend : 'Ext.panel.Panel',
    id : 'systemroleviewform',
    alias : 'widget.systemroleform',
    resizable : false,
    anchor : '100%',
    border : 0,
    autoScroll : true,
    height : 200,
    width : 400,
    items : [{
        xtype : 'form',
        border : 0,
        items : [{
            xtype:'textfield',
            hidden: true,
            name : 'departmentId',
            itemId : 'departmentId'
        },{
            xtype:'displayfield',
            itemId : 'departmentName',
            margin : '5 0 0 5',
            anchor : '95%',
            fieldLabel : "所属部门<font color='red'>*</font>"
        },{
            xtype : 'textfield',
            anchor : '95%',
            margin : '5 0 0 5',
            name : 'id',
            hidden : true,
            readOnly : true,
            fieldLabel : 'id'
        }, {
            xtype : 'textfield',
            anchor : '95%',
            margin : '5 0 0 5',
            name : 'roleName',
            allowBlank : false,
            fieldLabel : '岗位名称<font color="red">*</font>'

        }, {
            xtype : 'textarea',
            anchor : '95%',
            margin : '5 0 0 5',
            name : 'description',
            fieldLabel : '岗位描述'
        }, {
            xtype : 'fieldcontainer',
            height : 30,
            anchor : '95%',
            margin : '5 0 10 5',
            style : 'text-align:center',
            items : [{
                xtype : 'button',
                margin : '5 0 0 5',
                width : 80,
                itemId : 'submitsystemroleviewformid',
                ref : 'submitsystemroleviewform',
                text : '确认'
            }, {
                xtype : 'button',
                margin : '5 0 0 15',
                width : 80,
                ref : 'closesystemroleform',
                text : '取消'
            }]
        }]
    }]

})