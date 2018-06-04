/*
 * 班级信息Controller
 *
 */
Ext.define("core.app.controller.DocumentController", {
    extend: "Ext.app.Controller",
    uses:['core.utils.Common'],
    _self: '',
    selectedRecord: null,
    documentcatstore: null,
    parentId: null,
    parentName: null,
    optId:null,
    documentviewgrid: null,
    init: function () {
        _self = this;
        this.control({

            'documentview':{
                afterrender : this.onDocumentViewAfterRender
            },

            'documentcateview button[ref=createdocumentcate]': {
                click: this.showCreateDocumentCategoryViewForm
            },

            'documentcateview treepanel': {
                load: this.loadDocumentCategoryRecord,
                select: this.storeCategoryRecordAndLoadDocument
            },

            'documentcategoryviewform button[ref=submitdocumentcatviewform]':{
                click: this.submitDocumentCategoryWindow
            },

            'documentcategoryviewform button[ref=closedocumentcatform]':{
                click: this.closeDocumentCategoryForm
            },

            'documentcateview #documentcatetree':{
                itemdblclick: this.showUpdateDocumentCategoryViewForm
            },

            'documentcateview button[ref=deletedocumentcate]':{
                click:this.deleteDocumentCategory
            },

            'documentview button[ref=createdocumentitem]':{
                click:this.showCreateDocumentViewForm
            },

            'documentuploadform button[ref=uploadcategorybtn]':{
                click:this.submitUploadCategoryForm
            },

            'documentview button[ref=deletedocumentitem]':{
                click:this.deleteDocumentView
            },
        });
    }
    ,

    onDocumentViewAfterRender:function (component,eOpts) {
        _self.documentviewgrid = component.down('grid');
    },

    loadDocumentCategoryRecord:function( row, records, successful, eOpts ){

        var tree = Ext.getCmp("documentcateviewid").down('treepanel');
        if(_self.optId!=null) {
             var node = row.getNodeById(_self.optId);
             tree.expandPath(node.getPath());
        }
    },

    storeCategoryRecordAndLoadDocument:function (row, record, index, eOpts) {
        _self.storeDocumentCategoryRecord(row, record, index, eOpts);
        _self.loadDocumentRecord(row, record, index, eOpts);
    },

    loadDocumentRecord:function (row, record, index, eOpts) {
        var catId =  record.data.id;
        if(_self.documentviewgrid!=null){
            var store = _self.documentviewgrid.getStore();
            store.proxy.url = "/documents/" + catId;
            store.load();
        }
    },



    storeDocumentCategoryRecord: function (row, record, index, eOpts) {
        _self.selectedRecord = record;
        _self.parentId = record.data.id;
        _self.parentName = record.data.name;
    }
    ,

    showCreateDocumentCategoryViewForm: function (btn) {
        if (!_self.selectedRecord) {
            Ext.Msg.alert("失败!", "请先选择一个分类！");
            return;
        }
        _self.documentcatstore = btn.up('documentcateview').down('treepanel').getStore();
        var createDocumentCatFormPanel = Ext.widget("documentcategoryviewform");
        if (_self.parentId != null) {
           createDocumentCatFormPanel.down('form').down("#documentcatparentid").setValue(_self.parentId);
        }
        if (_self.parentName != null) {
            createDocumentCatFormPanel.down('form').down("#documentcatparentname").setValue(_self.parentName);
        }
        AlertWin.alert('添加模板分类', null, createDocumentCatFormPanel, 400, 150);
    },

    submitDocumentCategoryWindow:function (btn) {
      var form = btn.up('form').getForm();
      if(form.isValid()){
          var formBean = form.getValues();
          _self.optId = formBean['parent.id'];
          var model = Ext.create("core.app.model.DocumentCategoryModel",formBean);
          model.save({
              success: function (response, opts) {
                  var resp = Ext.decode(opts.response.responseText);
                  if (resp.success == "true" || resp.success == true) {
                      Ext.Msg.alert("信息!", resp.message);
                      btn.up('window').close();
                      _self.documentcatstore.load();
                  } else {
                      Ext.Msg.alert("错误!", resp.message)
                  }
              },
              failure: function (response, opts) {
                  Ext.Msg.alert("错误!", opts.request.scope.reader.jsonData["message"])
              }
          });
      }

    },

    closeDocumentCategoryForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateDocumentCategoryViewForm:function (view,record,item, index, e, eopts) {
        _self.documentcatstore = view.ownerCt.getStore();
        if(!record){
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个模板分类!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        }else{
            var parentId = record.parentNode.data.id;
            var parentName = record.parentNode.data.name;
            var updateDocumentCatFormPanel = Ext.widget("documentcategoryviewform");
            var updateForm = updateDocumentCatFormPanel.down('form');
            updateForm.loadRecord(record);
            if(parentId!=null){
                updateDocumentCatFormPanel.down('form').down("#documentcatparentid").setValue(parentId);
            }
            if(parentName!=null){
                updateDocumentCatFormPanel.down('form').down("#documentcatparentname").setValue(parentName);
            }
            AlertWin.alert('修改模板分类', null, updateDocumentCatFormPanel, 400, 150);
        }

    },

    deleteDocumentCategory:function (btn) {
        var orgtp = btn.up("documentcateview").down('#documentcatetreeitemid');
        var record = orgtp.getSelectionModel().getSelection()[0];
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的分类!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        }
        if (record.parentNode.data.depth == 0) {
            Ext.Msg.alert("失败!", "无法删除根分类！");
            return;
        }
        if (record.childNodes.length>0) {
            Ext.Msg.alert("失败!", "请先删除子分类！");
            return;
        }
        Ext.MessageBox.confirm("提示", "你要删除这个模板分类吗？", function(btn) {
            if (btn == 'yes') {
                _self.optId = record.parentNode.data.id;
                common.destroyNode(record, {
                    success : function(records, operation) {
                        orgtp.getSelectionModel().deselectAll();
                        orgtp.getStore().load();
                        Ext.Msg.alert("成功!", common.feedBackMsg(operation));
                    },
                    failure : function(records, operation) {
                        Ext.Msg.alert("失败!", common.feedBackMsg(operation));
                    }
                });
            }
        });
    },

    showCreateDocumentViewForm:function(btn){
        var documentuploadform = Ext.widget("documentuploadform");
        documentuploadform.show();
    },


    submitUploadCategoryForm: function (btn) {
                var me = btn.up('window');
                var sform = btn.up('form');
                var treecombobox = me.down('treecombobox');
                var values = sform.getForm().getValues();
                btn.up('form').getForm().submit({
                    url : me.commiturl,
                    params : {
                        description : values.description,
                        catIds:values.catIds
                    },
                    method : "POST",
                    success : function(form, action) {
                        // 上传成功

                        if (action.result.success == "true") {
                            // 重新load 清单树
                            if (me.loadstore) {
                                me.loadstore.load();
                            }
                            //清空上次选择的内容
                            var selectedArr = treecombobox.selected
                            Ext.Array.splice(selectedArr,0,selectedArr.length);
                            Ext.MessageBox.alert('成功', action.result.message);
                        } else {
                            Ext.MessageBox.alert('失败', action.result.message);
                        }
                        btn.up('window').close();
                    },
                    failure : function(form, action) {
                        Ext.MessageBox.alert('失败', '发送请求失败!')
                    }

                });
    },

    deleteDocumentView:function(btn, e) {
       var documentGrid = btn.up('documentview').down('grid');
       var docStore = documentGrid.getStore();
       var url = docStore.proxy.url;
       var record = documentGrid.getSelectionModel().getSelection()[0];
       docStore.proxy.url = "/documents/";
       if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的模板!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个模板吗？", function(btn) {
                if (btn == 'yes') {
                    common.destroyNode(record, {
                        success : function(records, operation) {
                            docStore.proxy.url = url;
                            docStore.load();
                            Ext.Msg.alert("成功!", common.feedBackMsg(operation));
                        },
                        failure : function(records, operation) {
                            Ext.Msg.alert("失败!", common.feedBackMsg(operation));
                        }
                    });
                }
            });
        }
    },

    models: ["core.app.model.DocumentCategoryModel","core.app.model.DocumentModel"],
    stores:
        ["core.app.store.DocumentCategoryStore","core.app.store.DocumentStore"],
    views:
        ["core.app.view.DocumentUploadForm","core.app.view.DocumentCategoryView",
            "core.app.view.DocumentView", "core.app.view.DocumentCategoryViewForm"]

})