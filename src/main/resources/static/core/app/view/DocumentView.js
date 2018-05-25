Ext.define('core.app.view.DocumentView', {
    extend : 'Ext.panel.Panel',
    alias : 'widget.documentview',
    itemId: 'maindocumentviewid',
    margins : '0 0 0 0',
    closable : true,
    border : 0,
    title : '<center height=40>模板管理</center>',
    bodyStyle : 'padding:0px',
    layout : {
        type : 'border'
    },
    items : [{
        xtype : 'documentcateview',
        region : 'west',
        split : true,
        title : '模板分类',
        height : '100%',
        width : '25%'
    }, {
        xtype : 'grid',
        region : 'center',
        stripeRows : true,
        autoScroll : true,
        columnLines : true,
        title : '模板列表',
        width : '100%',
        itemId:'documentgridid',
        selModel : {
            selType : 'checkboxmodel',
            mode : 'SIMPLE'
        },
        viewConfig : {
            loadMask : {
                msg : '数据加载中......'
            }
        },
        store: "core.app.store.DocumentStore",
        columns : [{
            xtype : 'gridcolumn',
            text : '名称',
            dataIndex : 'name',
            flex : 1,
            sortable : true
        },{
            xtype : 'gridcolumn',
            text : '描述',
            dataIndex : 'description',
            flex : 1,
            sortable : true
        },{
            xtype : 'gridcolumn',
            text : '所属分类',
            dataIndex : 'documentCategories',
            flex : 1,
            sortable : true,
            renderer: function (value, metaData, record){
                var documentCategories = record.data.documentCategories;
                var str = '';
                if(documentCategories!=null&&documentCategories.length>0){
                    Ext.Array.each(documentCategories, function(name, index, countriesItSelf) {
                        str += documentCategories[index].name + ",";
                    });
                }
                return str;
            }
        }, {
            xtype : 'gridcolumn',
            text : '上传者',
            dataIndex : 'createByUsername',
            flex : 1,
            sortable : true
        }, {
            xtype : 'datecolumn',
            text : '上传时间',
            dataIndex : 'createOn',
            format: 'Y年m月d日',
            flex : 1,
            sortable : true
        }, {
            xtype : 'gridcolumn',
            dataIndex : '',
            flex : 1,
            text : '下载文件',
            renderer : function(value, opt, record) {
                var rederervalue = Ext.String.format("<a href='/document_download/{0}' target='_blank'>下载</a>", record.data.id);
                return rederervalue;
            }
        }, {
            xtype : 'gridcolumn',
            dataIndex : '',
            flex : 1,
            text : '预览文件',
            renderer : function(value, opt, record) {
                var rederervalue = Ext.String.format("<a href='/document_view/{0}' target='_blank'>预览</a>", record.data.id);
                return rederervalue;
            }
        }],
        dockedItems: [{
            xtype: 'pagingtoolbar',
            dock: 'bottom',
            store: "core.app.store.DocumentStore",
            displayInfo: true,
            emptyMsg: "没有数据"
            // displayMsg : "显示从{0}条数据到{1}条数据，共{2}条数据"
        }],
        listeners: {
            render: function (view, eOpts) {
                Ext.Ajax.request({
                    url: '/resource/buttons/documentgridid',
                    success: function (response, opts) {
                        var resp = Ext.decode(response.responseText);
                        if (resp.success == "true" || resp.success == true) {
                            var btnArr = [];
                            var data = resp.data;
                            Ext.Array.each(data, function (name, index, self) {
                                var btn = Ext.create("Ext.button.Button", {
                                    text: data[index].text,
                                    ref: data[index].ref
                                });
                                btnArr.push(btn);
                            })
                            var tbar = Ext.create('Ext.toolbar.Toolbar', {
                                dock: 'top',
                                items: btnArr
                            })
                            view.addDocked(tbar);
                        }
                    },
                    failure: function (response, opts) {
                        Ext.Msg.alert("错误!", "尝试获取按钮失败")
                    }
                });
            }
        }
    }]
});
