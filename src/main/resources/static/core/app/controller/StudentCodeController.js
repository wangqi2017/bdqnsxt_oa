/*
 * 班级信息Controller
 *
 */
Ext.define("core.app.controller.StudentCodeController", {
    extend: "Ext.app.Controller",
    _self: null,
    codestore:null,
    init: function () {
        _self = this;
        this.control({
            'codeview button[ref=searchcodeview]': {
                click: _self.searchCode
            },
            'codeview button[ref=clearsearchcodeview]' : {
                click : _self.clearSearchCode
            }
        })
    },

    searchCode:function (btn) {
        debugger
        var searchform = btn.up('form');
        var searchinfo = searchform.getValues();
        _self.codestore = btn.up("#codeviewitemid").down("#codechart").getStore();
        _self.codestore.on("beforeload", function() {
            Ext.apply(_self.codestore.proxy.extraParams, {
                stuId : searchinfo["stuId"],
                startCommitTime: searchinfo["startCommitTime"],
                endCommitTime:searchinfo.endCommitTime,
                repoType:searchinfo.repoType
            });
        });
        _self.codestore.load();
    },

    clearSearchCode:function (btn,e) {
        btn.up('form').form.reset();
    },

    models: ["core.app.model.StudentCodeModel"],

    stores: ["core.app.store.StudentCodeStore"],
    views : ["core.app.view.CodeView"]
})