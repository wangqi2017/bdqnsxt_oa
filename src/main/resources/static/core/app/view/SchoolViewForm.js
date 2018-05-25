/*
 * 校区信息View，新建和更新用户信息的弹窗panel
 *
 */
Ext.define("core.app.view.SchoolViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.schoolviewform',
    id: 'schoolviewformid',
    author: '100%',
    autoScroll: true,
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                    xtype: 'form',
                    title: '<span height=40>校区设置</span>',
                    items: [{
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'id',
                        hidden: true
                    },

                        {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'scname',
                            allowBlank: false,
                            minLength: 3,
                            fieldLabel: '校区名称<font color="red">*</font>'

                        },
                         {
                             xtype: 'combobox',
                             anchor: '90%',
                             itemId: 'organization',
                             margin: '5 0 10 5',
                             name: 'organization',
                             fieldLabel: '所属机构<font color="red">*</font>',
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
                            xtype: 'combobox',
                            anchor: '90%',
                            itemId: 'province',
                            margin: '5 0 10 5',
                            name: 'province',
                            fieldLabel: '所属省份<font color="red">*</font>',
                            allowBlank: false,
                            displayField: 'name',
                            valueField: 'value',
                            store: Ext.create('Ext.data.Store', {
                                fields: ['value', 'name'],
                                data: [{
                                    "value": "山东",
                                    "name": "山东"
                                },{
                                    "value": "河北",
                                    "name": "河北"
                                }]
                            })
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'address',
                            allowBlank: false,
                            fieldLabel: '地址<font color="red">*</font>'
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'leader',
                            fieldLabel: '负责人'
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'leaderPhone',
                            regex:/^1[3|4|5|7|8][0-9]{9}$/,
                            fieldLabel: '负责人电话'
                        }, {
                            xtype: 'fieldcontainer',
                            height: 30,
                            anchor: '95%',
                            margin: '5 0 10 5',
                            style: 'text-align:center',
                            items: [{
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'submitschoolviewformid',
                                ref: 'submitschoolviewform',
                                text: '确认'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'closeschoolviewformid',
                                ref: 'closeschoolviewform',
                                text: '取消'
                            }]
                        }]
                }]
        }), me.callParent(arguments);
    }

});
