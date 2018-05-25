/*
 * 用户信息View，新建和更新用户信息的弹窗panel
 *
 */
Ext.define("core.app.view.UserViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.userviewform',
    id: 'userviewformid',
    requires: ['core.widget.MultiSelector'],
    author: '100%',
    autoScroll: true,
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                    xtype: 'form',
                    title: '<span height=40>用户设置</span>',
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
                            name: 'username',
                            allowBlank: false,
                            minLength: 6,
                            vtype: 'alphanum',
                            fieldLabel: '用户名<font color="red">*</font>'

                        },
                        {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'fullname',
                            allowBlank: false,
                            fieldLabel: '姓名<font color="red">*</font>'
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            vtype: 'email',
                            name: 'email',
                            allowBlank: false,
                            fieldLabel: '邮箱<font color="red">*</font>'
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'qq',
                            fieldLabel: 'qq'
                        }, {
                            xtype: 'textfield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'mobilePhone',
                            allowBlank: false,
                            regex:/^1[3|4|5|7|8][0-9]{9}$/,
                            regexText:'必须符合手机格式',
                            fieldLabel: '手机<font color="red">*</font>'
                        }, {
                            xtype: 'datefield',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'hireDate',
                            format:'Y-m-d',
                            fieldLabel: '入职时间'
                        }, {
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
                                margin: '0 0 0 30',
                                boxLabel : '女',
                                name:'gender',
                                inputValue : 'FEMAIL'
                            }]
                        }, {
                            xtype: 'combobox',
                            anchor: '90%',
                            itemId: 'userstatus',
                            margin: '5 0 10 5',
                            name: 'status',
                            fieldLabel: '用户状态<font color="red">*</font>',
                            allowBlank: false,
                            displayField: 'name',
                            valueField: 'value',
                            store: Ext.create('Ext.data.Store', {
                                fields: ['value', 'name'],
                                data: [{
                                    "value": "ACTIVE",
                                    "name": "可用"
                                }, {
                                    "value": "INACTIVE",
                                    "name": "不可用"
                                }]
                            })
                        },
                        {
                            xtype: 'combobox',
                            anchor: '90%',
                            itemId: 'userschool',
                            margin: '5 0 10 5',
                            name: 'school.id',
                            fieldLabel: '所属校区<font color="red">*</font>',
                            allowBlank: false,
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
                                    },
                                    autoLoad: true
                                }
                            }),

                            listeners: {        //这是ComboBox的监听器

                                'change': function (field, newValue) {  //change事件
                                    if (newValue) {
                                        var userdepartment = Ext.getCmp("userviewformid").down("#userdepartment");
                                        userdepartment.setValue(null);

                                        //在校区发生改变时将校区ID传到后台，加载该校区下的讲师，
                                        userdepartment.getStore().getProxy().url = "/departmentsBySchool?schoolId="+newValue;
                                        userdepartment.getStore().load();

                                    }
                                }
                            }
                        },
                        {
                            xtype: 'combobox',
                            anchor: '90%',
                            itemId: 'userdepartment',
                            margin: '5 0 10 5',
                            name: 'department.id',
                            fieldLabel: '部门',
                            displayField: 'name',
                            valueField: 'id',
                            emptyText: "--请选择--",
                            store:  Ext.create('Ext.data.Store', {
                                fields: ['id', 'name'],
                                proxy: {
                                    type: 'rest',
                                    reader: {
                                        type: "json",
                                        root: "data",
                                        successProperty: 'success'
                                    }
                                }
                            })
                        },
                        {
                            xtype: 'fieldcontainer',
                            anchor: '90%',
                            margin: '5 0 10 5',
                            fieldLabel: '是否是管理员',
                            defaultType: 'radiofield',
                            layout:'hbox',
                            items:[{
                                boxLabel : '是',
                                name:'admin',
                                inputValue : 'true'
                            },{
                                margin: '0 0 0 30',
                                boxLabel : '否',
                                name:'admin',
                                inputValue : 'false',
                                checked: true
                            }]
                        },
                        {
                            xtype: 'fieldcontainer',
                            anchor: '90%',
                            margin: '5 0 10 5',
                            fieldLabel: '管理校区',
                            defaultType: 'radiofield',
                            layout:'hbox',
                            items:[{
                                boxLabel : '是',
                                name:'leader',
                                inputValue : 'true'
                            },{
                                boxLabel : '否',
                                margin: '0 0 0 30',
                                name:'leader',
                                inputValue : 'false',
                                checked: true
                            }]
                        },
                        {
                            xtype: 'multiselector',
                            anchor: '90%',
                            margin: '5 0 0 5',
                            name: 'roleIds',
                            itemId: 'userroles',
                            fieldLabel: '角色',
                            displayField : 'roleName',
                            valueField : 'id',
                            store: Ext.create('Ext.data.Store', {
                                fields: ['id', 'roleName'],
                                proxy: {
                                    type: 'rest',
                                    url: "/allroles",
                                    reader: {
                                        type: "json",
                                        root: "data",
                                        successProperty: 'success'
                                    }
                                }
                            })
                        },


                        {
                            xtype: 'fieldcontainer',
                            height: 30,
                            anchor: '95%',
                            margin: '5 0 10 5',
                            style: 'text-align:center',
                            items: [{
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'submituserviewformid',
                                ref: 'submituserviewform',
                                text: '确认'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'closeuserviewformid',
                                ref: 'closeuserviewform',
                                text: '取消'
                            }]
                        }]
                }]
        }), me.callParent(arguments);
    }

});
