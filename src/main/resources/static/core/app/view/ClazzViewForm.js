/*
 * 班级信息View，新建和更新班级信息的弹窗panel
 *
 */
Ext.define("core.app.view.ClazzViewForm", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.clazzviewform',
    id: 'clazzviewformid',
    requires: ['Ext.ux.form.ItemSelector'],
    author: '100%',
    layout: 'fit',
    initComponent: function () {
        var me = this;
        Ext.applyIf(me, {
            items: [{
                xtype: 'form',
                title: '<span height=40>班级设置</span>',
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
                        name: 'clname',
                        allowBlank: false,
                        minLength: 6,
                        fieldLabel: '班级名<font color="red">*</font>'

                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'clazzorientation',
                        margin: '5 0 10 5',
                        name: 'orientation',
                        fieldLabel: '方向<font color="red">*</font>',
                        allowBlank: false,
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        store: Ext.create('Ext.data.Store', {
                            fields: ['value', 'name'],
                            data: [{
                                "value": "JAVA工程师",
                                "name": "JAVA工程师"
                            }, {
                                "value": "UI设计",
                                "name": "UI设计"
                            }, {
                                "value": "大数据工程师",
                                "name": "大数据工程师"
                            }]
                        })
                    },
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'clazzschool',
                        margin: '5 0 10 5',
                        name: 'belongSchool.id',
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
                                    var classLeader = Ext.getCmp("clazzviewformid").down("#classLeader");
                                    classLeader.setValue(null);

                                    classLeader.getStore().getProxy().url = "/getUsersBySchoolAndRole?schoolId="+newValue+"&roleNames=班主任";
                                    classLeader.getStore().load();


                                    var lecturer = Ext.getCmp("clazzviewformid").down("#lecturer");
                                    lecturer.setValue(null);

                                    //在校区发生改变时将校区ID传到后台，加载该校区下的讲师，
                                    lecturer.getStore().getProxy().url = "/getUsersBySchoolAndRole?schoolId="+newValue+"&roleNames=教员";
                                    lecturer.getStore().load();

                                    var tutors = Ext.getCmp("clazzviewformid").down("#tutors");
                                    tutors.reset();

                                    //在校区发生改变时将校区ID传到后台，加载该校区下的助教，
                                    var tutorStore = tutors.getStore();
                                    tutorStore.getProxy().url = "/getUsersBySchoolAndRole?schoolId="+newValue+"&roleNames=辅导员";
                                    tutorStore.load();


                                        /*
                                        {
                                        params: {'schoolId': nv},    //参数
                                        callback: function (records, operation, success) { //加载完成调用的函数
                                            //添加一个所有选项
                                            //lecturer.getStore().insert(0, {id: 0, name: '所有'});
                                            //lecturer.setValue(0); //设置默认第一个
                                        }
                                    });*/
                                }
                            }
                        }
                    },
                    {
                        xtype: 'datefield',
                        anchor: '90%',
                        margin: '5 0 0 5',
                        name: 'startDate',
                        format: 'Y-m-d',
                        allowBlank: false,
                        fieldLabel: '开始时间<font color="red">*</font>'
                    }
                    ,
                    {
                        xtype: 'datefield',
                        anchor:  '90%',
                        margin: '5 0 0 5',
                        name: 'endDate',
                        format: 'Y-m-d',
                        allowBlank: false,
                        fieldLabel: '结束时间<font color="red">*</font>'
                    }
                    ,
                    {
                        xtype: 'combobox',
                        anchor:  '90%',
                        itemId: 'clazzstatus',
                        margin: '5 0 10 5',
                        name: 'status',
                        fieldLabel: '班级状态<font color="red">*</font>',
                        allowBlank:  false,
                        displayField: 'name',
                        valueField: 'value',
                        emptyText: "--请选择--",
                        store:  Ext.create('Ext.data.Store', {
                                fields: ['value', 'name'],
                                data: [{
                                    "value": "未开班",
                                    "name": "未开班"
                                }, {
                                    "value": "试听",
                                    "name": "试听"
                                }, {
                                    "value": "开班",
                                    "name": "开班"
                                }, {
                                    "value": "结束",
                                    "name": "结束"
                                }]
                            })
                    }
                    ,
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'lecturer',
                        margin: '5 0 10 5',
                        name: 'lecturer.id',
                        fieldLabel: '讲师',
                        displayField: 'fullname',
                        valueField: 'id',
                        emptyText: "--请选择--",
                        store:  Ext.create('Ext.data.Store', {
                                fields: ['id', 'fullname'],
                                proxy: {
                                    type: 'rest',
                                    reader: {
                                        type: "json",
                                        root: "data",
                                        successProperty: 'success'
                                    }
                                }
                            })
                    }
                    ,
                    {
                        xtype: 'combobox',
                        anchor: '90%',
                        itemId: 'classLeader',
                        margin: '5 0 10 5',
                        name: 'classLeader.id',
                        fieldLabel: '班主任',
                        displayField: 'fullname',
                        valueField: 'id',
                        emptyText: "--请选择--",
                        store:  Ext.create('Ext.data.Store', {
                            fields: ['id', 'fullname'],
                            proxy: {
                                type: 'rest',
                                reader: {
                                    type: "json",
                                    root: "data",
                                    successProperty: 'success'
                                }
                            }
                        })
                    }
                    ,
                    {
                        xtype: 'itemselector',
                        name: 'tutors.ids',
                        itemId: 'tutors',
                        id:'tutors',
                        anchor: '90%',
                        fieldLabel: '助教',
                        displayField: 'fullname',
                        valueField: 'id',
                        msgTarget: 'side',
                        imagePath: '../../../../ext/examples/ux/css/images',
                        fromTitle: '可选的助教',
                        toTitle: '选中的助教',
                        store:  Ext.create('Ext.data.Store', {
                            fields: ['id', 'fullname'],
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
                                itemId: 'submitclazzviewformid',
                                ref: 'submitclazzviewform',
                                text: '确认'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 5',
                                itemId: 'closeclazzviewformid',
                                ref: 'closeclazzviewform',
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
