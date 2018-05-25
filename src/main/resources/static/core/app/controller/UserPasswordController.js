
Ext.define("core.app.controller.UserPasswordController", {
    extend: "Ext.app.Controller",
    clazzRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'userpasswordviewform button[ref=submituserpasswordviewform]' : {
                click : _self.searchUserPasswordForm
            }
        });
    },

    searchUserPasswordForm: function (btn) {
        debugger
        var newValue = btn.up('form').down('#newpassword').value;
        var confirmValue = btn.up('form').down('#newPasswordconfirm').value;
        if(newValue !== confirmValue){
            Ext.Msg.alert("错误!", "两次密码不一致！");
            return;
        }

        var passFormCmp = btn.up('form');
        var passForm = passFormCmp.getForm();
        if (passForm.isValid()) {
            var passinfo = passForm.getValues();
            var passmodel = Ext.create("core.app.model.UserPasswordModel", passinfo);
            passmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message);
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


    models :["core.app.model.UserPasswordModel"],
    stores:["core.app.store.UserPasswordStore"],
    views :["core.app.view.UserPasswordViewForm"]

})