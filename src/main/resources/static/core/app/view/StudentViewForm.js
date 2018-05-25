/*
 * 学员信息View，新建和更新学员信息的弹窗panel
 *
 */
Ext.define("core.app.view.StudentViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.studentviewform',
    id: 'studentviewformid',
    author: '100%',
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                xtype: 'form',
                title: '<span height=40>学员设置</span>',
                autoScroll: true,
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
                        name: 'stuName',
                        allowBlank: false,
                        fieldLabel: '学员名称<font color="red">*</font>'

                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'mobilePhone',
                        allowBlank: false,
                        fieldLabel: '手机号<font color="red">*</font>',
                        regex:/^1[3|4|5|7|8][0-9]{9}$/,
                        regexText:'必须符合手机格式',

                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'idCard',
                        fieldLabel: '身份证号',
                        regex:/(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/,
                        regexText:'必须符合身份证格式'
                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'studentstatus',
                        margin: '5 0 10 5',
                        name: 'status',
                        fieldLabel: '状态<font color="red">*</font>',
                        allowBlank: false,
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "咨询",
                                "name": "咨询"
                            }, {
                                "value": "试听",
                                "name": "试听"
                            }, {
                                "value": "报名",
                                "name": "报名"
                            }, {
                                "value": "就读",
                                "name": "就读"
                            }, {
                                "value": "结业",
                                "name": "结业"
                            }, {
                                "value": "就业",
                                "name": "就业"
                            }, {
                                "value": "离校",
                                "name": "离校"
                            }, {
                                "value": "失联",
                                "name": "失联"
                            }]
                        })
                    },
                    {
                        xtype: 'fieldcontainer',
                        anchor: '90%',
                        margin: '5 0 10 5',
                        fieldLabel: '性别<font color="red">*</font>',
                        defaultType: 'radiofield',
                        layout:'hbox',
                        items:[{
                            boxLabel : '男',
                            name:'gender',
                            inputValue : 'MAIL',
                            checked: true
                        },{
                            boxLabel : '女',
                            name:'gender',
                            inputValue : 'FEMAIL'
                        }]
                    },
                    {
                        xtype: 'datefield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'schoolTime',
                        format: 'Y-m-d',
                        fieldLabel: '入校时间'
                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'studentclazz',
                        margin: '5 0 10 5',
                        name: 'currentClazz.id',
                        fieldLabel: '所在班级<font color="red">*</font>',
                        displayField: 'clname',
                        valueField: 'id',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['id', 'clname'],
                            proxy: {
                                type: 'rest',
                                url: "/allclazzs",
                                reader: {
                                    type: "json",
                                    root: "data",
                                    successProperty: 'success'
                                },
                                autoLoad: true
                            }
                        })
                    },
                    {
                        xtype: 'datefield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'gradutionTime',
                        format: 'Y-m-d',
                        fieldLabel: '毕业时间'
                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'gradutionFrom',
                        fieldLabel: '毕业院校'

                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'studentrecord',
                        margin: '5 0 10 5',
                        name: 'gradutionRecord',
                        fieldLabel: '学历<font color="red">*</font>',
                        displayField: 'name',
                        valueField: 'value',
                        allowBlank: false,
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "大专",
                                "name": "大专"
                            }, {
                                "value": "本科",
                                "name": "本科"
                            }, {
                                "value": "研究生",
                                "name": "研究生"
                            }, {
                                "value": "博士生",
                                "name": "博士生"
                            }]
                        })
                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'studentforeign',
                        margin: '5 0 10 5',
                        name: 'foreignLevel',
                        fieldLabel: '外语水平<font color="red">*</font>',
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        allowBlank: false,
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "未达标",
                                "name": "未达标"
                            }, {
                                "value": "四级",
                                "name": "四级"
                            }, {
                                "value": "六级",
                                "name": "六级"
                            }, {
                                "value": "八级",
                                "name": "八级"
                            }, {
                                "value": "十级",
                                "name": "十级"
                            }]
                        })
                    }
                    ,
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'studentcomputer',
                        margin: '5 0 10 5',
                        name: 'computerSkill',
                        fieldLabel: '计算机水平<font color="red">*</font>',
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        allowBlank: false,
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "未达标",
                                "name": "未达标"
                            }, {
                                "value": "一级",
                                "name": "一级"
                            }, {
                                "value": "二级",
                                "name": "二级"
                            }, {
                                "value": "三级",
                                "name": "三级"
                            }, {
                                "value": "四级",
                                "name": "四级"
                            }]
                        })
                    }
                    ,
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'qq',
                        fieldLabel: 'qq'

                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'email',
                        fieldLabel: 'email',
                        vtype: 'email'
                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'contactor',
                        fieldLabel: '紧急联系人'
                    },
                    {
                        xtype: 'textfield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'contactorPhone',
                        fieldLabel: '紧急联系人电话'
                    },
                    {
                        xtype: 'textarea',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'remarks',
                        fieldLabel: '标识'

                    },
                    {
                        xtype: 'fieldcontainer',
                        height:
                            30,
                        anchor:
                            '95%',
                        margin:
                            '5 0 10 5',
                        style:
                            'text-align:center',
                        items:
                            [{
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'submitstudentviewformid',
                                ref: 'submitstudentviewform',
                                text: '确认'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'closestudentviewformid',
                                ref: 'closestudentviewform',
                                text: '取消'
                            }]
                    }
                ]
            }]
        }),
            me.callParent(arguments);
    }

})
;
