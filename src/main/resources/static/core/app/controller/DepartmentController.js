/**
 * 部门管理controller
 */
Ext.define('core.app.controller.DepartmentController', {
    extend : 'Ext.app.Controller',
    uses:['core.utils.Common'],
    departmentStore : null,// 全局store
    _self : '',
    rolestore : null,
    departmentId : null,
    departmentName : null,
    selectedRecord : null,
    add: false,
    init : function() {
        _self = this;
        this.control({

            // 弹出创建部门的窗口
            'departmentview button[ref=createdepartment]' : {
                click : this.showCreateDepartmentViewForm
            },

            // 删除部门
            'departmentview button[ref=deletedepartment]' : {
                click : this.deleteDepartment
            },

            // 弹出更新部门信息的窗口
            'departmentview > treepanel' : {
                'itemdblclick' : this.showUpdateDepartmentViewForm,
                'itemclick' : function(tree, record, item, index, e, eOpts) {
                    //tree.toggleOnDblClick = false;
                },
                'select' : _self.storeSchoolRecord
            },

            // form提交
            'departmentviewform button[ref=submitdepartmentviewform]' : {
                click : this.submitDepartmentViewForm
            },

            // form取消
            'departmentviewform button[ref=closedepartmentviewform]' : {
                click : this.closeDepartmentViewForm
            },

            'departmentviewform button[ref=createsystemrole]':{
                click: this.showCreateSystemRoleViewForm
            },

            'systemroleform button[ref=submitsystemroleviewform]':{
                click: this.submitSystemRoleViewForm
            },

            // form取消
            'systemroleform button[ref=closesystemroleform]' : {
                click : this.closeSystemRoleViewForm
            },

            'departmentviewform button[ref=deletesystemrole]':{
                click: this.deleteSystemRole
            },

            'departmentviewform  #rolegrid': {
                'itemdblclick' : this.showUpdateSystemRoleViewForm,
            },

            'departmentviewform button[ref=btnpermission]' : {
                click : this.showModifiedRolePermissionWindow
            },

            'rolepermissionwin button[ref=btnmodifypermission]' : {
                click : this.submitPermissionWindow
            },

            'departmentviewform button[ref=btncopypermission]' : {
                click : this.showRoleCopyPermissionWindow
            },

            'rolecopypermissionwin button[ref=btncopypermission]' : {
                click : this.submitCopyPermissionWindow
            }
        });
    },

    storeSchoolRecord : function(tree, record, index, eOpts) {
        _self.selectedRecord = record;
    },

    // 创建部门
    showCreateDepartmentViewForm : function(btn) {
        if(!_self.selectedRecord){
            Ext.Msg.alert("失败!", "请先选择一个校区！");
            return;
        }
        if(_self.selectedRecord.data.leaf == true){
            Ext.Msg.alert("失败!", "请选择校区，而不是部门！");
            return;
        }
        _self.add = true;
        departmentStore = btn.up('departmentview').down('#departmenttreepanel').getStore();
        //var createDepartmentFormPanel = Ext.create("core.app.view.DepartmentViewForm");
        var createDepartmentFormPanel = Ext.widget("departmentviewform");
        AlertWin.alert('添加部门', null, createDepartmentFormPanel, 400, 300);
    },

    // 更新部门
    showUpdateDepartmentViewForm : function(view, record, item, index, e, eopts) {
        departmentStore = view.ownerCt.getStore();
        var updateDepartmentFormPanel = Ext.widget("departmentviewform");
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要修改的内容!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            // 如果选择的是校区就不弹窗，不允许修改
            if (record.parentNode.data.depth == 0) {
                return false;
            }
            updateDepartmentFormPanel.down('form').loadRecord(record);

            //记录部门id，供role使用
            departmentId = record.data.id;
            departmentName = record.data.name;

            _self.add = false;
            _self.selectedRecord = record;
            var tabpanel = updateDepartmentFormPanel.down('tabpanel');
            var rolegrid = updateDepartmentFormPanel.down('#rolegrid');
            rolegrid.hidden = false;
            tabpanel.add(rolegrid);
            rolestore = rolegrid.getStore();
            rolestore.proxy.url = "/roles?departmentId="+record.data.id;
            rolestore.load();
            AlertWin.alert('修改部门', null, updateDepartmentFormPanel, 400, 300);
        }
    },

    // 删除部门
    deleteDepartment : function(btn) {
        var orgtp = btn.up("departmentview").down('#departmenttreepanel');
        var record = orgtp.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的部门!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        }

        // 如果是校区节点，则无法删除
        if (record.parentNode.data.depth == 0) {
            Ext.Msg.alert("失败!", "无法删除校区！");
            return;
        }

        // 下属员工数量不为0，无法删除
        if (record.data.userCount != 0) {
            Ext.Msg.alert("失败!", "请先删除该部门的下属员工！");
            return;
        }

        // 下属岗位数量不为0，无法删除
        if (record.data.roleCount != 0) {
            Ext.Msg.alert("失败!", "请先删除该部门的下属岗位！");
            return;
        }

        Ext.MessageBox.confirm("提示", "你要删除这个部门吗？", function(btn) {
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

    // 提交部门表单
    submitDepartmentViewForm : function(btn) {
        var form = btn.up('form').getForm();
        if (form.isValid()) {
            var formBean = form.getValues();
            var model = Ext.create('core.app.model.DepartmentModel', formBean);
            if(_self.add){
                model.set("parentId",_self.selectedRecord.data.id);
            }else{
                model.set("parentId",_self.selectedRecord.parentNode.data.id);
            }
            model.save({
                success : function(response, operation) {
                    //Ext.Msg.alert("成功!", common.feedBackMsg(operation));
                    Ext.Msg.alert("成功!");
                    departmentStore.load();
                    AlertWin.hide();
                },
                failure : function(response, operation) {
                    AlertWin.hide();
                    //Ext.Msg.alert("失败!", common.feedBackMsg(operation));
                    Ext.Msg.alert("失败!");
                }
            });
        }
    },


    
    // 关闭窗口
    closeDepartmentViewForm : function() {
        AlertWin.hide();
    },

    //新建角色窗口
    showCreateSystemRoleViewForm: function () {
        var rolepanel = Ext.create("core.app.view.SystemRoleViewForm");
        rolepanel.down('#submitsystemroleviewformid').setText('新建岗位');
        if (departmentId!= null) {
            rolepanel.down('#departmentId').setValue(departmentId);
        }
        if (departmentName!= null) {
            rolepanel.down('#departmentName').setValue(departmentName);
        }
        var rolewindow = Ext.create('Ext.window.Window', {
            title : '新增岗位',
            layout : 'fit',
            modal : true,
            resizable : false,
            constrainHeader : true,
            items : rolepanel
        });
        rolewindow.show();
    },

    showUpdateSystemRoleViewForm:function (view, record, item, index, e, eopts) {
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择一个岗位!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            var updateSystemRoleFormPanel = Ext.widget("systemroleform");
            updateSystemRoleFormPanel.down('form').loadRecord(record);
            if (departmentId != null) {
                updateSystemRoleFormPanel.down('#departmentId').setValue(departmentId);
            }
            if (departmentName != null) {
                updateSystemRoleFormPanel.down('#departmentName').setValue(departmentName);
            }
            updateSystemRoleFormPanel.down('#submitsystemroleviewformid').setText('修改岗位')
            var rolewindow = Ext.create('Ext.window.Window', {
                title : '修改岗位',
                layout : 'fit',
                modal : true,
                resizable : false,
                constrainHeader : true,
                items : updateSystemRoleFormPanel
            });
            rolewindow.show();
        }

    },

    //提交角色
    submitSystemRoleViewForm: function (btn) {
        var form = btn.up('form').getForm();
        if (form.isValid()) {
            var formBean = form.getValues();
            var model = Ext.create('core.app.model.SystemRoleModel', formBean);
            model.save({
                success: function (response, operation) {
                    rolestore.load();
                    departmentStore.load();
                    btn.up('window').close();
                    Ext.Msg.alert("成功", operation.request.scope.reader.jsonData["message"]);
                },
                failure: function (response, operation) {
                    Ext.Msg.alert("失败", operation.request.scope.reader.jsonData["message"])

                }
            });
        }
    },

    closeSystemRoleViewForm : function(btn) {
        btn.up('window').close();
    },

    deleteSystemRole:function (btn) {
        var orgtp = btn.up("departmentviewform").down("#rolegrid");
        var record = orgtp.getSelectionModel().getSelection()[0];
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的岗位!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        };
        if (record.data.userCount != 0) {
            Ext.Msg.alert("失败!", "请先删除该岗位的下属人员！");
            return;
        };
        Ext.MessageBox.confirm("提示", "你要删除这个岗位吗？", function(btn) {
            if (btn == 'yes') {
                common.destroyNode(record, {
                    success : function(records, operation) {
                        orgtp.getSelectionModel().deselectAll();
                        orgtp.getStore().load();
                        departmentStore.load();
                        Ext.Msg.alert("成功!", common.feedBackMsg(operation));
                    },
                    failure : function(records, operation) {
                        Ext.Msg.alert("失败!", common.feedBackMsg(operation));
                    }
                });
            }
        });


        },

    showModifiedRolePermissionWindow:function (btn) {
        var grid = btn.up('grid');
        var record = grid.getSelectionModel().getSelection()[0];
        if (!record) {
            Ext.MessageBox.alert('提示', '请先选择岗位');
            return false;
        }
        var me = this;
        me.roleRecord = record;
        rolePermissionWindow = Ext.create('core.app.view.RolePermissionWindow', {
            itemId : 'rolepermissionwin',
            width : 700
        });
        Ext.Ajax.request({
            url: "/roles/permission/" + record.data.id,
            method: 'GET',
            success: function (response, operation) {
                var result = Ext.decode(response.responseText);
                if (result.success == 'false' || result.success == false) {
                    Ext.Msg.alert("失败", "没有查询到权限列表");
                    return false;
                }
                var menuStore = rolePermissionWindow.down('#menutree').getStore();
                menuStore.setRootNode(result.data.menus);
                rolePermissionWindow.show();
            }, failure: function (response, operation) {
                Ext.Msg.alert("失败", "权限列表查询失败");
            }
        })
    },

    submitPermissionWindow:function (btn) {
        var me = this;
        var permissionWindow = btn.up('window');
        var menutree = permissionWindow.down('#menutree');
        var checkedMenu = menutree.getChecked();
        var roleMenuIds = [];
        for ( var i = 0, len = checkedMenu.length; i < len; i++) {
            if (checkedMenu[i].data.depth == 0) {
                continue;
            }
            roleMenuIds.push(checkedMenu[i].data.id);
        }
        Ext.Ajax.request({
            url : "/roles/permission/" + me.roleRecord.data.id,
            method : 'POST',
            params : {
                "roleMenuIds" : roleMenuIds
            },
            success : function(response, operation) {
                var result = Ext.decode(response.responseText);
                if (result.success == 'false'||result.success == false) {
                    Ext.Msg.alert("失败", result.message);
                    return false;
                }
                Ext.Msg.alert("成功", result.message);
            },
            failure : function(response, operation) {
                Ext.Msg.alert("失败", "权限列表保存失败")
            }
        });

        permissionWindow.close();
    },

    showRoleCopyPermissionWindow: function (btn) {
        var grid = btn.up('grid');
        var record = grid.getSelectionModel().getSelection()[0];
        if (!record) {
            Ext.MessageBox.alert('提示', '请先选择岗位');
            return false;
        }
        var me = this;
        me.roleRecord = record;
        roleCopyPermissionWindow = Ext.create('core.app.view.RoleCopyPermissionWindow', {
            title : '复制权限',
            itemId : 'rolecopypermissionwin'
        });
        roleCopyPermissionWindow.show();
    },

    submitCopyPermissionWindow : function (btn) {
        var copyPermissionWindow = btn.up('rolecopypermissionwin');
        var orgtp = btn.up("rolecopypermissionwin").down("#pertreeid");
        var record = orgtp.getSelectionModel().getSelection()[0];
        var copiedRoleId = record.data.id;
        var me = this;
        Ext.Ajax.request({

            url : "/roles/copypermission/" + me.roleRecord.data.id,
            method : 'POST',
            params : {
                "copiedRoleId" : copiedRoleId
            },
            success : function(response, operation) {
                var result = Ext.decode(response.responseText);
                if (result.success == 'false'||result.success == false) {
                    Ext.Msg.alert("失败", result.message);
                    return false;
                }
                Ext.Msg.alert("成功", result.message);
            },
            failure : function(response, operation) {
                Ext.Msg.alert("失败", "岗位权限复制失败")
            }
        });
        copyPermissionWindow.close();

    },



    views :  ['core.app.view.DepartmentViewForm','core.app.view.DepartmentView','core.app.view.SystemRoleViewForm'],
    stores : ['core.app.store.DepartmentStore','core.app.store.SystemRoleStore'],
    models : ['core.app.model.DepartmentModel', 'core.app.model.UserModel','core.app.model.SystemRoleModel']
});