/*
 * 学员信息Controller
 *
 */
Ext.define("core.app.controller.StudentController", {
    extend: "Ext.app.Controller",
    studentstore: null,
    addrolespanel: null,
    addroleswindow: null,
    studentRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'studentview button[ref=searchstudentview]' : {
                click : _self.searchStudent
            },
            'studentview button[ref=clearsearchstudentview]' : {
                click : _self.clearSearchStudent
            },
            'studentview button[ref=createstudent]': {
                click: _self.showCreateStudentForm
            },
            'studentviewform button[ref=submitstudentviewform]': {
                click: _self.submitStudentForm
            },
            'studentviewform button[ref=closestudentviewform]': {
                click: _self.closeStudentForm
            },
            'studentview grid[itemId=studentgird]': {
                'itemdblclick': _self.showUpdateStudentForm
            },
            'studentview button[ref=deletestudent]' : {
                click : _self.deleteStudent
            },
            'studentview button[ref=lockstudent]' : {
                click : _self.lockStudent
            }
        });
    },

    searchStudent : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        studentstore = btn.up("#studentviewid").down("#studentgird").getStore();
        studentstore.on("beforeload", function() {
            Ext.apply(studentstore.proxy.extraParams, {
                stuName : seachinfo.stuName,
                mobilePhone: seachinfo.mobilePhone,
                status: seachinfo.status,
                lockId: seachinfo.lockId
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        studentstore.currentPage = 1;
        studentstore.load({
        });
    },

    clearSearchStudent:function (btn,e) {
        btn.up('form').form.reset();
    },

    showCreateStudentForm: function (btn, e) {
        studentstore = btn.up("#studentviewid").down("#studentgird").getStore();
        var studentpanel = Ext.create("core.app.view.StudentViewForm");
        studentpanel.down('#submitstudentviewformid').setText('新建学员');
        AlertWin.alert('新建学员', null, studentpanel, 600, 400);
    },

    submitStudentForm: function (btn) {
        var studentFormCmp = btn.up('form');
        var studentform = studentFormCmp.getForm();
        if (studentform.isValid()) {
            AlertWin.hide();
            var studentinfo = studentform.getValues();
            var studentmodel = Ext.create("core.app.model.StudentModel", studentinfo);
            studentmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        studentstore.load();
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

    closeStudentForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateStudentForm: function (grid, record, item, index, e, eopts) {
        studentstore = grid.getStore();
        studentRecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个学员!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var studentpanel = Ext.create("core.app.view.StudentViewForm");
            studentpanel.down('#submitstudentviewformid').setText('修改学员');
            var studentform = studentpanel.down('form');
            //delete record.data['currentClazz.id'];
            studentform.loadRecord(record);
            //设置下拉框的值
            var clazzTemp = Ext.create("core.app.model.ClazzModel", {
                id : record.data['currentClazz.id'],
                clname : record.data['currentClazz.clname']
            });
            studentpanel.down('#studentclazz').setValue(clazzTemp);
            AlertWin.alert('修改学员', null, studentpanel, 600, 400);
        }
    },

    deleteStudent : function(btn, e) {
        var studentgrid = btn.up("#studentviewid").down('#studentgird');
        studentstore = studentgrid.getStore();
        var record = studentgrid.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的学员!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个学员吗？", function(btn) {
                if (btn == 'yes') {
                    record.destroy({
                        scope : this,
                        callback : function(response, opts) {
                            var resp = Ext.decode(opts.response.responseText);
                            if (resp.success == "true"||resp.success == true) {
                                Ext.Msg.alert("信息!", resp.message)
                                studentstore.load();
                            } else {
                                Ext.Msg.alert("错误!", resp.message)
                            }
                        }
                    });
                }
            });
        }
    },

    lockStudent: function (btn) {
        var studentgrid = btn.up("#studentviewid").down('#studentgird');
        studentstore = studentgrid.getStore();
        var record = studentgrid.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要锁定的学员!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "您要锁定这个学员吗？", function(btn) {
                if (btn == 'yes') {
                    Ext.Ajax.request({
                        url: '/consult/' + record.data.id,
                        method: 'post',
                        success: function (response, opts) {
                            var resp = Ext.decode(response.responseText);
                            if (resp.success == "true"||resp.success == true) {
                                Ext.Msg.alert("成功!", resp.message);
                            } else {
                                Ext.Msg.alert("失败!", resp.message)
                            }
                        },
                        failure: function (response, opts) {
                            debugger
                            Ext.Msg.alert("错误!", "发射错误");
                        }
                    });
                }
            })
        }
    },


    models :["core.app.model.StudentModel"],
    stores:["core.app.store.StudentStore"],
    views :["core.app.view.StudentView"]

})