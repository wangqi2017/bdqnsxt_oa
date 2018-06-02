
Ext.define("core.app.controller.FinanceApprovalController", {
    extend: "Ext.app.Controller",

    _self: null,
    init: function () {
        _self = this;
        this.control({
            'financeapprovalview button[ref=financeapply]' : {
                click : _self.financeApply
            }
        });
    },

    financeApply : function(btn, e) {
        Ext.Ajax.request({
            url: '/finance/startService',
            method: 'get',
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