Ext.define("core.app.view.DocumentUploadForm", {
    extend : 'Ext.window.Window',
    alias : 'widget.documentuploadform',
    constrain : true,
    modal : true,
    height : 250,
    width : 400,
    title : '模板上传',
    requires: ['core.widget.TreeComboBox'],
    layout : {
        type : 'fit'
    },
    commiturl : '/documents',
    loadstore : null,
    initComponent : function() {
        var me = this;
        me.callParent(arguments);
    },
    items : [{
        xtype : 'form',
        bodyPadding : 10,
        title : '',
        items : [{
            xtype : 'filefield',
            anchor : '100%',
            buttonText : '浏览...',
            name : 'doc',
            validator : function(val) {
                var fileName = /(\.doc$)|(\.docx$)|(\.xls$)|(\.xlsx$)|(\.ppt$)/;
                if (!fileName.test(val)) {
                    return "文件格式不正确，请选择doc/docx/xls/xlsx/ppt中的一种格式";
                }
                return true;
            },
            fieldLabel : '文件'
        }, {
            xtype : 'textarea',
            anchor : '100%',
            name : 'description',
            fieldLabel : '文档描述'
        }, {
            xtype : 'treecombobox',
            name : 'catIds',
            itemId : 'doccats',
            anchor : '100%',
            model : 'core.app.model.DocumentCategoryModel',
            displayField : 'name',
            valueField : 'id',
            allowEmpty : false,
            fieldLabel : '模板分类<font color="red">*</font>'
        }, {
            xtype : 'fieldcontainer',
            margin : '0 0 10 5',
            height : 40,
            style : 'text-align:center',
            fieldLabel : '',
            items : [{
                xtype : 'button',
                itemId : 'uploadcategorybtn',
                ref : 'uploadcategorybtn',
                margin : '0 5 0 0',
                text : '确认'
            }, {
                xtype : 'button',
                margin : '0 0 0 5',
                text : '取消',
                listeners : {
                    'click' : function(btn) {
                        btn.up('window').close();
                    }
                }
            }]
        }]

    }]

})