
Ext.define("core.app.view.StudentConsultViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.studentconsultviewform',
    id: 'studentconsultviewformid',
    requires:'core.widget.DateTimeField',
    author: '100%',
    autoScroll: true,
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                    xtype: 'form',
                    title: '<span height=40>学员追踪</span>',
                    autoScroll: true,
                    items: [{
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'id',
                        hidden: true
                    },{
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'consulter.id',
                        hidden: true
                    },{
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'student.id',
                        hidden: true
                    },
                        {
                            xtype:'displayfield',
                            margin : '5 0 0 5',
                            anchor : '95%',
                            fieldLabel : "咨询师<font color='red'>*</font>",
                            name: 'consulter.fullname',
                        },
                        {
                            xtype:'displayfield',
                            margin : '5 0 0 5',
                            anchor : '95%',
                            fieldLabel : "学员<font color='red'>*</font>",
                            name: 'student.stuName'
                        },

                         {
                             xtype: 'combobox',
                             anchor: '90%',
                             itemId: 'purpose',
                             margin: '5 0 10 5',
                             name: 'purpose',
                             fieldLabel: '意向等级<font color="red">*</font>',
                             allowBlank: false,
                             displayField: 'name',
                             valueField: 'value',
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
                            xtype: 'datetimefield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'quizTime',
                            format:'Y-m-d H:i:s',
                            fieldLabel: '面试时间'
                        }
                        ,{
                            xtype: 'textarea',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'firstVisit',
                            fieldLabel: '第一次回访'

                        },{
                            xtype: 'textarea',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'secondVisit',
                            fieldLabel: '第二次回访'

                        },{
                            xtype: 'textarea',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'thirdVisit',
                            fieldLabel: '第三次回访'

                        }, {
                            xtype: 'textarea',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'remarks',
                            fieldLabel: '备注'

                        }, {
                            xtype: 'fieldcontainer',
                            height: 30,
                            anchor: '95%',
                            margin: '5 0 10 5',
                            style: 'text-align:center',
                            items: [{
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'submitstudentconsultviewformid',
                                ref: 'submitstudentconsultviewform',
                                text: '确认'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'closestudentconsultviewformid',
                                ref: 'closestudentconsultviewform',
                                text: '取消'
                            }]
                        }]
                }]
        }), me.callParent(arguments);
    }

});
