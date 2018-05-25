/*
 * 班级信息Controller
 *
 */
Ext.define("core.app.controller.ClazzController", {
    extend: "Ext.app.Controller",
    clazzstore: null,
    addrolespanel: null,
    addroleswindow: null,
    clazzRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'clazzview button[ref=searchclazzview]' : {
                click : _self.searchClazz
            },
            'clazzview button[ref=clearsearchclazzview]' : {
                click : _self.clearSearchClazz
            },
            'clazzview button[ref=createclazz]': {
                click: _self.showCreateClazzForm
            },
            'clazzviewform button[ref=submitclazzviewform]': {
                click: _self.submitClazzForm
            },
            'clazzviewform button[ref=closeclazzviewform]': {
                click: _self.closeClazzForm
            },
            'clazzview grid[itemId=clazzgird]': {
                'itemdblclick': _self.showUpdateClazzForm
            },
            'clazzview button[ref=deleteclazz]' : {
                click : _self.deleteClazz
            }
        });
    },

    searchClazz : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        clazzstore = btn.up("#clazzviewid").down("#clazzgird").getStore();
        clazzstore.on("beforeload", function() {
            Ext.apply(clazzstore.proxy.extraParams, {
                clname : seachinfo.clname,
                organization: seachinfo.organization,
                status: seachinfo.status,
                schoolId: seachinfo.schoolId
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        clazzstore.currentPage = 1;
        clazzstore.load({
        });
    },

    clearSearchClazz:function (btn,e) {
        btn.up('form').form.reset();
    },

    showCreateClazzForm: function (btn, e) {
        clazzstore = btn.up("#clazzviewid").down("#clazzgird").getStore();
        var clazzpanel = Ext.create("core.app.view.ClazzViewForm");
        clazzpanel.down('#submitclazzviewformid').setText('新建班级');
        AlertWin.alert('新建班级', null, clazzpanel, 600, 400);
    },

    submitClazzForm: function (btn) {
        var clazzFormCmp = btn.up('form');
        var clazzform = clazzFormCmp.getForm();
        if (clazzform.isValid()) {
            AlertWin.hide();
            var clazzinfo = clazzform.getValues();
            var clazzmodel = Ext.create("core.app.model.ClazzModel", clazzinfo);
            clazzmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        clazzstore.load();
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

    closeClazzForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateClazzForm: function (grid, record, item, index, e, eopts) {
        clazzstore = grid.getStore();
        clazzRecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个班级!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var clazzpanel = Ext.create("core.app.view.ClazzViewForm");
            clazzpanel.down('#submitclazzviewformid').setText('修改班级');
            var clazzform = clazzpanel.down('form');

            //delete clazzRecord.data['belongSchool.id'];
            //delete clazzRecord.data['lecturer.id'];
            clazzform.loadRecord(clazzRecord);
            var schoolTemp = Ext.create("core.app.model.SchoolModel", {
                id : clazzRecord.data['belongSchool.id'],
                scname : clazzRecord.data['belongSchool.scname']
            });
            var lecturerTemp = Ext.create("core.app.model.UserModel", {
                id : clazzRecord.data['lecturer.id'],
                fullname : clazzRecord.data['lecturer.fullname']
            });
            var classLeaderTemp = Ext.create("core.app.model.UserModel", {
                id : clazzRecord.data['classLeader.id'],
                fullname : clazzRecord.data['classLeader.fullname']
            });
            clazzpanel.down('#clazzschool').setValue(schoolTemp);
            clazzpanel.down('#lecturer').setValue(lecturerTemp);
            clazzpanel.down('#classLeader').setValue(classLeaderTemp);
            //设置itemselector的值
            var tutorsValue = record.data.tutors;
            clazzpanel.down('#tutors').setValue(['3','4']);
            AlertWin.alert('修改班级', null, clazzpanel, 600, 400);
        }
    },

    deleteClazz : function(btn, e) {
        var clazzgrid = btn.up("#clazzviewid").down('#clazzgird');
        clazzstore = clazzgrid.getStore();
        var record = clazzgrid.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的班级!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个班级吗？", function(btn) {
                if (btn == 'yes') {
                    record.destroy({
                        scope : this,
                        callback : function(response, opts) {
                            /*var resp = Ext.decode(opts.response.responseText);
                            if (resp.success == "true"||resp.success == true) {
                                opts.request.scope.reader.jsonData["message"];*/
                                Ext.Msg.alert("信息!", opts.request.scope.reader.jsonData["message"]);
                                clazzstore.load();
                            /*} else {
                                Ext.Msg.alert("错误!", resp.message)
                            }*/
                        }
                    });
                }
            });
        }
    },


    models :["core.app.model.ClazzModel"],
    stores:["core.app.store.ClazzStore"],
    views :["core.app.view.ClazzView"]

})