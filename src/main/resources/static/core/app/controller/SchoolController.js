/*
 * 校区信息Controller
 *
 */
Ext.define("core.app.controller.SchoolController", {
    extend: "Ext.app.Controller",
    schoolstore: null,
    addrolespanel: null,
    addroleswindow: null,
    schoolRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'schoolview button[ref=searchschoolview]' : {
                click : _self.searchSchool
            },
            'schoolview button[ref=clearsearchschoolview]' : {
                click : _self.clearSearchSchool
            },
            'schoolview button[ref=createschool]': {
                click: _self.showCreateSchoolForm
            },
            'schoolviewform button[ref=submitschoolviewform]': {
                click: _self.submitSchoolForm
            },
            'schoolviewform button[ref=closeschoolviewform]': {
                click: _self.closeSchoolForm
            },
            'schoolview grid[itemId=schoolgird]': {
                'itemdblclick': _self.showUpdateSchoolForm
            },
            'schoolview button[ref=deleteschool]' : {
                click : _self.deleteSchool
            }
        });
    },

    searchSchool : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        schoolstore = btn.up("#schoolviewid").down("#schoolgird").getStore();
        schoolstore.on("beforeload", function() {
            Ext.apply(schoolstore.proxy.extraParams, {
                scname : seachinfo.scname,
                organization: seachinfo.organization,
                province:seachinfo.province
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        schoolstore.currentPage = 1;
        schoolstore.load({
        });
    },

    clearSearchSchool:function (btn,e) {
        btn.up('form').form.reset();
    },

    showCreateSchoolForm: function (btn, e) {
        schoolstore = btn.up("#schoolviewid").down("#schoolgird").getStore();
        var schoolpanel = Ext.create("core.app.view.SchoolViewForm");
        schoolpanel.down('#submitschoolviewformid').setText('新建校区');
        // 为combox 设置默认值 可用
        schoolpanel.down('#organization').setValue('北大青鸟尚学堂');
        schoolpanel.down('#province').setValue('山东');
        AlertWin.alert('新建校区', null, schoolpanel, 600, 300);
    },

    submitSchoolForm: function (btn) {
        var schoolFormCmp = btn.up('form');
        var schoolform = schoolFormCmp.getForm();
        if (schoolform.isValid()) {
            AlertWin.hide();
            var schoolinfo = schoolform.getValues();
            var schoolmodel = Ext.create("core.app.model.SchoolModel", schoolinfo);
            schoolmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        schoolstore.load();
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

    closeSchoolForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateSchoolForm: function (grid, record, item, index, e, eopts) {
        schoolstore = grid.getStore();
        schoolRecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个校区!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var schoolpanel = Ext.create("core.app.view.SchoolViewForm");
            schoolpanel.down('#submitschoolviewformid').setText('修改校区');
            var schoolform = schoolpanel.down('form');
            schoolform.loadRecord(record);
            AlertWin.alert('修改校区', null, schoolpanel, 600, 300);
        }
    },

    deleteSchool : function(btn, e) {
        var schoolgrid = btn.up("#schoolviewid").down('#schoolgird');
        schoolstore = schoolgrid.getStore();
        var record = schoolgrid.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的校区!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个校区吗？", function(btn) {
                if (btn == 'yes') {
                    record.destroy({
                        scope : this,
                        callback : function(response, opts) {
                            /*
                            var resp = Ext.decode(opts.response.responseText);
                            if (resp.success == "true"||resp.success == true) {
                                Ext.Msg.alert("信息!", resp.message)
                                schoolstore.load();
                            } else {
                                Ext.Msg.alert("错误!", resp.message)
                            }*/
                            Ext.Msg.alert("信息!", opts.request.scope.reader.jsonData["message"]);
                            clazzstore.load();
                        }
                    });
                }
            });
        }
    },


    models :["core.app.model.SchoolModel"],
    stores:["core.app.store.SchoolStore"],
    views :["core.app.view.SchoolView"]

})