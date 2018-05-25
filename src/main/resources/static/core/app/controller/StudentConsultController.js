Ext.define("core.app.controller.StudentConsultController", {
    extend: "Ext.app.Controller",
    studentconsultstore: null,
    studentConsultRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'studentconsultview button[ref=searchstudentconsultview]':{
                click: _self.searchStudentConsult
            },
            'studentconsultview button[ref=clearsearchstudentconsultview]':{
                click: _self.clearSearchStudentConsult
            },
            'studentconsultview button[ref=tracestudentconsult]':{
                click: _self.traceStudentConsult
            },
            'studentconsultviewform button[ref=submitstudentconsultviewform]':{
                click: _self.submitStudentConsultForm
            },
            'studentconsultviewform button[ref=closestudentconsultviewform]':{
                click: _self.closeStudentConsultForm
            },
            'studentconsultview button[ref=deletestudentconsult]':{
                click:this.deleteStudentConsult
            },
        });
    },

    searchStudentConsult:function (btn) {
            var searchform = btn.up('form');
            var searchinfo = searchform.getValues();
            _self.studentconsultstore = btn.up("#studentconsultviewid").down("#studentconsultgird").getStore();
            _self.studentconsultstore.on("beforeload", function() {
                Ext.apply(_self.studentconsultstore.proxy.extraParams, {
                    stuName : searchinfo["student.stuName"],
                    stuStatus: searchinfo["student.status"],
                    quizTime:searchinfo.quizTime,
                    purpose:searchinfo.purpose,
                    consulterId:searchinfo["consulter.id"]
                });
            });
            //给store的currentPage 赋值，每次查询start为1
            _self.studentconsultstore.currentPage = 1;
            _self.studentconsultstore.load({});
    },

    clearSearchStudentConsult:function (btn,e) {
        btn.up('form').form.reset();
    },

    traceStudentConsult:function (btn,e) {
        var studentconsultgrid = btn.up("#studentconsultviewid").down('#studentconsultgird');
        var record = studentconsultgrid.getSelectionModel().getSelection()[0];
        _self.studentconsultstore = studentconsultgrid.getStore();
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要跟踪的学员!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            var studentconsultpanel = Ext.create("core.app.view.StudentConsultViewForm");
            var studentconsultform = studentconsultpanel.down('form');
            studentconsultform.loadRecord(record);
            AlertWin.alert('学员跟踪', null, studentconsultpanel, 600, 300);
        }
    },

    submitStudentConsultForm: function (btn) {
        var studentConsultFormCmp = btn.up('form');
        var form = studentConsultFormCmp.getForm();
        var record = form.getRecord();
        if (form.isValid()) {
            AlertWin.hide();
            var studentconsultinfo = form.getValues();
            //var d =studentconsultinfo.quizTime;
            //alert(typeof d);
            debugger
            var studentconsultmodel = Ext.create("core.app.model.StudentConsultModel", studentconsultinfo);
            studentconsultmodel.data['consulter.fullname'] = record.data['consulter.fullname'];
            studentconsultmodel.data['student.stuName'] = record.data['student.stuName'];
            studentconsultmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        _self.studentconsultstore.load();
                    } else {
                        Ext.Msg.alert("错误!", resp.message)
                    }
                },
                failure: function (response, opts) {
                    Ext.Msg.alert("错误!", response.responseText)
                }
            });
        }

    },

    closeStudentConsultForm: function (btn) {
        AlertWin.hide();
    },

    deleteStudentConsult:function (btn) {
        var orgtp = btn.up("#studentconsultviewid").down('#studentconsultgird');
        var record = orgtp.getSelectionModel().getSelection()[0];
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要解锁吗!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        }
        Ext.MessageBox.confirm("提示", "你要解除锁定吗？", function(btn) {
            if (btn == 'yes') {
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

    models :["core.app.model.StudentConsultModel"],
    stores:["core.app.store.StudentConsultStore"],
    views :["core.app.view.StudentConsultView"]

})