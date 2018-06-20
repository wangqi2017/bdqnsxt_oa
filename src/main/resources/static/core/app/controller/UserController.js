/*
 * 用户信息Controller
 *
 */
Ext.define("core.app.controller.UserController", {
    extend: "Ext.app.Controller",
    userstore: null,
    addrolespanel: null,
    addroleswindow: null,
    userRecord: null,
    rolestore: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'userview button[ref=searchuserview]' : {
                click : _self.searchUser
            },
            'userview button[ref=clearsearchuserview]' : {
                click : _self.clearSearchUser
            },
            'userview button[ref=createuser]': {
                click: _self.showCreateUserForm
            },
            'userviewform button[ref=submituserviewform]': {
                click: _self.submitUserForm
            },
            'userviewform button[ref=closeuserviewform]': {
                click: _self.closeUserForm
            },
            'userview grid[itemId=usergird]': {
                'itemdblclick': _self.showUpdateUserForm
            },
            'userview button[ref=deleteuser]' : {
                click : _self.deleteUser
            }
        });
    },

    searchUser : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        userstore = btn.up("#userviewid").down("#usergird").getStore();
        userstore.on("beforeload", function() {
            Ext.apply(userstore.proxy.extraParams, {
                username : seachinfo.username,
                mobilePhone: seachinfo.mobilePhone,
                hireDateStart : seachinfo.hireDateStart,
                hireDateEnd: seachinfo.hireDateEnd,
                roleId: seachinfo.roleId,
                schoolId:seachinfo.schoolId
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        userstore.currentPage = 1;
        userstore.load({
        });
    },

    clearSearchUser:function (btn,e) {
        btn.up('form').form.reset();
    },

    showCreateUserForm: function (btn, e) {
        userstore = btn.up("#userviewid").down("#usergird").getStore();
        var userpanel = Ext.create("core.app.view.UserViewForm");
        userpanel.down('#submituserviewformid').setText('新建用户');
        // 为combox 设置默认值 可用
        userpanel.down('#userstatus').setValue('ACTIVE');
        AlertWin.alert('新建用户', null, userpanel, 600, 450);
    },

    submitUserForm: function (btn) {
        var userFormCmp = btn.up('form');
        var userform = userFormCmp.getForm();
        if (userform.isValid()) {
            AlertWin.hide();
            var userinfo = userform.getValues();
            var usermodel = Ext.create("core.app.model.UserModel", userinfo);
            usermodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        userstore.load();
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

    closeUserForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateUserForm: function (grid, record, item, index, e, eopts) {
        userstore = grid.getStore();
        userRecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个用户!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var userpanel = Ext.create("core.app.view.UserViewForm");
            userpanel.down('#submituserviewformid').setText('修改用户');
            var userform = userpanel.down('form');
            userform.loadRecord(record);

            //设置下拉框的值
            var schoolTemp = Ext.create("core.app.model.SchoolModel", {
                id : userRecord.data['school.id'],
                scname : userRecord.data['school.scname']
            });
            var departmentTemp = Ext.create("core.app.model.DepartmentModel", {
                id : userRecord.data['department.id'],
                name : userRecord.data['department.name']
            });
            var roles = userRecord.data["roles"];
            var roleTemp = [];
            Ext.Array.each(roles,function(name, index, itSelf){
                var roleModel = Ext.create("core.app.model.SystemRoleModel", {
                    id : roles[index].id,
                    roleName : roles[index].roleName
                });
                roleTemp.push(roleModel);
            });
            userpanel.down('#userschool').setValue(schoolTemp);
            userpanel.down('#userdepartment').setValue(departmentTemp);
            userpanel.down('#userroles').setValue(roleTemp);
            AlertWin.alert('修改用户', null, userpanel, 600, 450);
        }
    },

    deleteUser : function(btn, e) {
        var usergrid = btn.up("#userviewid").down('#usergird');
        userstore = usergrid.getStore();
        var record = usergrid.getSelectionModel().getSelection()[0];
        debugger
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的用户!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个用户吗？", function(btn) {
                if (btn == 'yes') {
                    record.data.roleIds = [];
                    record.destroy({
                        scope : this,
                        callback : function(response, opts) {
                                Ext.Msg.alert("信息!", opts.request.scope.reader.jsonData["message"]);
                                userstore.load();
                        }
                    });
                }
            });
        }
    },


    models :["core.app.model.UserModel"],
    stores:["core.app.store.UserStore"],
    views :["core.app.view.UserView"]

})