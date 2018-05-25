/*
 * 用户信息Controller
 *
 */
Ext.define("core.app.controller.TeacherController", {
    extend: "Ext.app.Controller",
    teacherstore: null,
    addrolespanel: null,
    addroleswindow: null,
    teacherRecord: null,
    rolestore: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'teacherview button[ref=searchteacherview]' : {
                click : _self.searchTeacher
            },
            'teacherview button[ref=clearsearchteacherview]' : {
                click : _self.clearSearchTeacher
            }
        });
    },

    searchTeacher : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        teacherstore = btn.up("#teacherviewid").down("#teachergird").getStore();
        teacherstore.on("beforeload", function() {
            Ext.apply(teacherstore.proxy.extraParams, {
                username : seachinfo.username,
                schoolId:seachinfo.schoolId
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        teacherstore.currentPage = 1;
        teacherstore.load({
        });
    },

    clearSearchTeacher:function (btn,e) {
        btn.up('form').form.reset();
    },




    models :["core.app.model.TeacherModel"],
    stores:["core.app.store.TeacherStore"],
    views :["core.app.view.TeacherView"]

})