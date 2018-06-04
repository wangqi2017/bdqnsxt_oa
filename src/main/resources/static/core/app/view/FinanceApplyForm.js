Ext.define("core.app.view.FinanceApplyForm", {
    extend : 'Ext.window.Window',
    alias : 'widget.financeapplyForm',
    constrain : true,
    modal : true,
    height : 250,
    width : 400,
    title : '财务申请',
    layout : {
        type : 'fit'
    },

    commiturl : '/finances',
    initComponent : function() {
        var me = this;
        me.callParent(arguments);
    },
    items : [{
        xtype : 'form',
        itemId: 'financeapplyform',
        bodyPadding : 10,
        title : '',
        autoScroll: true,
        items : [
            {
            xtype: 'textfield',
            anchor: '90%',
            margin: '5 0 0 5',
            name: 'id',
            hidden: true
        }

        ,

        {
            xtype: 'combobox',
            anchor: '90%',
            itemId: 'school',
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
            })
        },{
            xtype: 'combobox',
            anchor: '90%',
            itemId: 'financeType',
            margin: '5 0 10 5',
            name: 'financeType',
            fieldLabel: '费用类型<font color="red">*</font>',
            allowBlank: false,
            displayField: 'name',
            valueField: 'value',
            emptyText: "--请选择--",
            store: Ext.create('Ext.data.Store', {
                fields: ['value', 'name'],
                data: [{
                    "value": "奖金",
                    "name": "奖金"
                }, {
                    "value": "备用金",
                    "name": "备用金"
                }, {
                    "value": "公司垫付",
                    "name": "公司垫付"
                }, {
                    "value": "机房建设费",
                    "name": "机房建设费"
                }, {
                    "value": "教学费",
                    "name": "教学费"
                }, {
                    "value": "就业费",
                    "name": "就业费"
                }, {
                    "value": "市场费",
                    "name": "市场费"
                }, {
                    "value": "行政日常费",
                    "name": "行政日常费"
                }, {
                    "value": "固定资产费",
                    "name": "固定资产费"
                }, {
                    "value": "耗材费",
                    "name": "耗材费"
                }, {
                    "value": "房屋租赁费",
                    "name": "房屋租赁费"
                }, {
                    "value": "物业管理费",
                    "name": "物业管理费"
                }, {
                    "value": "班级管理费",
                    "name": "班级管理费"
                }, {
                    "value": "学员管理费",
                    "name": "学员管理费"
                }, {
                    "value": "其它",
                    "name": "其它"
                }]
            })
        }, {
            xtype : 'textfield',
            anchor : '100%',
            name : 'amount',
            fieldLabel : '金额<font color="red">*</font>',
            allowBlank: false,
            margin: '5 0 10 5',
            listeners: {
                blur: function(object){
                    var newValue = object.value;
                    var oldValue = object.value;
                    newValue = Ext.util.Format.usMoney(newValue.replace(/[^0-9\.]/g, ''));
                    if(newValue == '$NaN.00') object.setValue(oldValue); else object.setValue(newValue);
                },
                change: function (object, newValue, oldValue) {
                    if (object.wasDirty != undefined)
                        return;
                    newValue = Ext.util.Format.usMoney(newValue.replace(/[^0-9\.]/g, ''));
                    if (newValue == '$NaN.00') object.setValue(oldValue); else object.setValue(newValue);
                }
            }
        },{
            xtype : 'textarea',
            anchor : '100%',
            name : 'details',
            fieldLabel : '详情',
            margin: '5 0 10 5',
        },{
            xtype : 'filefield',
            anchor : '100%',
            margin: '5 0 10 5',
            buttonText : '浏览...',
            name : 'files',
            validator : function(val) {
                var fileName = /(\.png$)|(\.jpg$)|(\.jpeg$)/;
                if (!fileName.test(val)) {
                    return "文件格式不正确，请选择png/jpg/jpeg中的一种格式";
                }
                return true;
            },
            fieldLabel : '发票<font color="red">*</font>',
            allowBlank: false
        }
        , {
            xtype : 'fieldcontainer',
            margin : '0 0 10 20',
            height : 40,
            style : 'text-align:right',
            fieldLabel : '',
            items : [{
                xtype : 'button',
                itemId : 'addfile',
                ref : 'addfile',
                margin : '0 5 0 0',
                text : '添加附件'
            }, {
                xtype : 'button',
                margin : '0 0 0 5',
                text : '删除附件',
                itemId : 'delfile',
                ref : 'delfile'
            }]
        }, {
            xtype : 'fieldcontainer',
            margin : '0 0 10 5',
            height : 40,
            style : 'text-align:center',
            fieldLabel : '',
            items : [{
                xtype : 'button',
                itemId : 'financeapplybtn',
                ref : 'financeapplybtn',
                margin : '0 5 0 0',
                text : '确认'
            }, {
                xtype : 'button',
                margin : '0 0 0 5',
                ref : 'financeformclosebtn',
                text : '取消'
            }]
        }]

    }]

})