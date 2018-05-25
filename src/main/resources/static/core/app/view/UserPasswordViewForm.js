Ext.define("core.app.view.UserPasswordViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.userpasswordviewform',
    id: 'userpasswordviewformid',
    itemId: 'userpasswordviewformitemid',
    author: '100%',
    autoScroll: true,
    closable: true,
    layout: 'fit',
    title : '<center height=40>修改密码</center>',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                xtype: 'form',
                title: '<span height=40>密码修改</span>',
                items: [
                    {
                        xtype: 'textfield',
                        inputType: 'password',
                        anchor: '60%',
                        margin: '20 0 0 100',
                        name: 'oldPassword',
                        allowBlank: false,
                        minLength: 6,
                        vtype: 'alphanum',
                        fieldLabel: '原密码<font color="red">*</font>'

                    },
                    {
                        xtype: 'textfield',
                        inputType: 'password',
                        itemId: 'newpassword',
                        anchor: '60%',
                        margin: '20 0 0 100',
                        name: 'newPassword',
                        allowBlank: false,
                        minLength: 6,
                        vtype: 'alphanum',
                        fieldLabel: '新密码<font color="red">*</font>'

                    },
                    {
                        xtype: 'textfield',
                        inputType: 'password',
                        itemId: 'newPasswordconfirm',
                        anchor: '60%',
                        margin: '20 0 0 100',
                        name: 'newPasswordConfirm',
                        allowBlank: false,
                        minLength: 6,
                        vtype: 'alphanum',
                        fieldLabel: '密码确认<font color="red">*</font>'
                    },

                    {
                        xtype: 'fieldcontainer',
                        height: 30,
                        anchor: '95%',
                        style: 'text-align:center',
                        items: [{
                            xtype: 'button',
                            margin: '5 0 0 -50',
                            itemId: 'submituserpasswordviewformid',
                            ref: 'submituserpasswordviewform',
                            text: '确认'
                        }, {
                            xtype: 'button',
                            margin: '5 0 0 60',
                            itemId: 'closeuserpasswordviewformid',
                            ref: 'closeuserpasswordviewform',
                            text: '取消'
                        }]
                    }]
            }]
        }), me.callParent(arguments);
    }

});