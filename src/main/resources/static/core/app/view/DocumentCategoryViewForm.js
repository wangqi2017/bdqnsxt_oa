Ext.define('core.app.view.DocumentCategoryViewForm', {
    extend: 'Ext.panel.Panel',

    alias: 'widget.documentcategoryviewform',
    margins: '0 0 0 0',
    border: 0,
    author: '100%',
    autoScroll: true,
    activeTab: 0,
    layout: {
        type: 'fit'
    },

            items : [{
                xtype : 'form',
                border : 0,
                height : '100%',
                items : [{
                    xtype:'textfield',
                    itemId : 'documentcatid',
                    name: 'id',
                    hidden: true
                },{
                    xtype:'textfield',
                    itemId : 'documentcatparentid',
                    name: 'parent.id',
                    hidden: true
                },{
                    xtype:'displayfield',
                    itemId : 'documentcatparentname',
                    name: 'parent.name',
                    margin : '5 0 0 5',
                    anchor : '95%',
                    fieldLabel : "所属分类<font color='red'>*</font>"
                },{
                    xtype:'textfield',
                    itemId : 'documentcatname',
                    name: 'name',
                    margin : '5 0 0 5',
                    anchor : '95%',
                    fieldLabel : "分类名称<font color='red'>*</font>",
                    allowBlank: false
                },{
                    xtype : 'fieldcontainer',
                    height : 30,
                    anchor : '95%',
                    margin : '5 0 10 5',
                    style : 'text-align:center',
                    items : [{
                        xtype : 'button',
                        margin : '5 0 0 5',
                        width : 80,
                        itemId : 'submitdocumentcatviewformid',
                        ref : 'submitdocumentcatviewform',
                        text : '确认'
                    }, {
                        xtype : 'button',
                        margin : '5 0 0 15',
                        width : 80,
                        ref : 'closedocumentcatform',
                        text : '取消'
                    }]
                }]
            }]

})