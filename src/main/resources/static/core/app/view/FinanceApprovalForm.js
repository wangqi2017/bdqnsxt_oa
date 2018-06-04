Ext.define("core.app.view.FinanceApprovalForm", {
    extend : 'Ext.panel.Panel',
    alias : 'widget.financeapprovalform',
    itemId: 'financeApprovalFormid',
    title : '财务审批',
    layout : {
        type : 'fit'
    },
    width: 500,
    height : 400,
    commiturl: '/financesApproval',
    initComponent : function() {
        var me = this;
        me.callParent(arguments);
    },
    items : [{
        xtype : 'form',
        itemId: 'financeapprovalformid',
        bodyPadding : 10,
        title : '',
        autoScroll: true,
        items : [{
            xtype: 'textfield',
            anchor: '90%',
            margin: '5 0 0 5',
            itemId: 'formid',
            name: 'id',
            hidden: true
        },{
            xtype:'displayfield',
            itemId : 'schoolName',
            margin : '5 0 0 5',
            anchor : '95%',
            fieldLabel : "所属校区"
        },{
            xtype:'displayfield',
            itemId : 'financeType',
            margin : '5 0 0 5',
            anchor : '95%',
            fieldLabel : "费用类型"
        }, {
            xtype:'displayfield',
            itemId : 'amount',
            margin : '5 0 0 5',
            anchor : '95%',
            fieldLabel : "金额"
        },{
            xtype : 'displayfield',
            anchor : '95%',
            itemId : 'details',
            fieldLabel : '详情',
            margin: '5 0 10 5',
        },{
            xtype : 'displayfield',
            anchor : '95%',
            itemId : 'files',
            fieldLabel : '文件',
            margin: '5 0 10 5',
        }, {
            xtype: 'textarea',
            anchor: '90%',
            margin: '5 0 0 5',
            name: 'approvalOpin',
            fieldLabel: '意见'
        }, {
            xtype: 'fieldcontainer',
            anchor: '90%',
            margin: '5 0 10 5',
            fieldLabel: '是否通过<font color="red">*</font>',
            defaultType: 'radiofield',
            layout:'hbox',
            items:[{
                boxLabel : '通过',
                name:'isPass',
                inputValue : '通过',
                checked: true
            },{
                margin: '0 0 0 30',
                boxLabel : '否',
                name:'isPass',
                inputValue : '不通过'
            }]
        },{
            xtype : 'fieldcontainer',
            margin : '0 0 10 5',
            height : 40,
            style : 'text-align:center',
            fieldLabel : '',
            items : [{
                xtype : 'button',
                itemId : 'financeapprovalbtn',
                ref : 'financeapprovalbtn',
                margin : '0 5 0 0',
                text : '确认'
            }, {
                xtype : 'button',
                margin : '0 0 0 5',
                ref : 'financeapprovalclosebtn',
                text : '取消'
            }]
        }]

    }]

})