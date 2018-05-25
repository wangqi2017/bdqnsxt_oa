Ext.define("core.app.view.DocumentCategoryView", {
    extend : 'Ext.panel.Panel',
    alias : 'widget.documentcateview',
    id : 'documentcateviewid',
    itemId: 'documentcateviewitemid',
    margins : '0 0 0 0',
    margins : '0 0 0 0',
    border : 0,
    title : '<center height=40>模板分类</center>',
    bodyStyle : 'padding:0px',
    menuAlign : "center",
    layout : 'fit',
    /*
    tbar : [{
        text : '新增',
        ref : 'createdocumentcate'
    }, '-',{
        text : '删除',
        ref : 'deletedocumentcate'
    }],
    */
    items : [{
        xtype : "treepanel",
        id : 'documentcatetree',
        itemId: 'documentcatetreeitemid',
        rootVisible : false,
        columnLines : true,
        layout : 'fit',
        stripeRows : true,
        columnLines : true, // 展示竖线
        height : 490,
        width : '100%',
        autoScroll : true,
        store : "core.app.store.DocumentCategoryStore",
        columns : [{
            xtype : 'treecolumn',
            text : '分组',
            dataIndex : 'name',
            flex : 1,
            sortable : true
        }],
        listeners:{
            render: function( view, eOpts ){
                Ext.Ajax.request({
                    url: '/resource/buttons/documentcatetreeitemid',
                    success: function(response,opts){
                        var resp = Ext.decode(response.responseText);
                        if (resp.success == "true" || resp.success == true) {
                            var btnArr = [];
                            var data = resp.data;
                            Ext.Array.each(data,function (name,index,self) {
                                var btn = Ext.create("Ext.button.Button",{
                                    text: data[index].text,
                                    ref:  data[index].ref
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
                /*
                console.log("prepare for button");
                var tbar = Ext.create('Ext.toolbar.Toolbar', {
                    width: 500,
                    dock: 'top',
                    items: [
                        {
                            // xtype: 'button', // 默认的工具栏类型
                            text: '按钮'
                        },
                        {
                            xtype: 'splitbutton',
                            text: '分割按钮'
                        }
                    ]
                })
                view.addDocked(tbar);
                */

        }
    }]

});