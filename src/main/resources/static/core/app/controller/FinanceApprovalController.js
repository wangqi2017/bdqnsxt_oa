
Ext.define("core.app.controller.FinanceApprovalController", {
    extend: "Ext.app.Controller",
    financestore: null,
    financerecord:null,
    uses:['core.utils.Common'],
    _self: null,
    filecount: 1,
    otheritemscount: 4,
    init: function () {
        _self = this;
        this.control({
            'financeapprovalview button[ref=financeapply]' : {
                click : _self.showFinanceApply
            },
            'financeapplyForm button[ref=financeformclosebtn]' : {
                click : _self.closeFinanceApply
            },
            'financeapplyForm button[ref=addfile]' : {
                click : _self.addFile
            },
            'financeapplyForm button[ref=delfile]' : {
                click : _self.delFile
            },
            'financeapplyForm button[ref=financeapplybtn]' : {
                click : _self.submitApplyForm
            },
            'financeapprovalview button[ref=searchfinanceview]' : {
                click : _self.searchFinance
            },
            'financeapprovalview button[ref=clearsearchfinanceview]' : {
                click : _self.clearSearch
            },
            'financeapprovalview grid[itemId=financegird]': {
                'itemdblclick': _self.showUpdateFinanceForm
            },
            'financeapprovalview button[ref=financeapproval]':{
                'click': _self.showApprovalFinanceForm
            },
            'financeapprovalform button[ref=financeapprovalclosebtn]':{
                'click': _self.closeApprovalFinanceForm
            },
            'financeapprovalform button[ref=financeapprovalbtn]':{
                'click': _self.submitApprovalFinanceForm
            }

        });
    },

    searchFinance : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        _self.financestore = btn.up("#financeapprovalviewitemid").down("#financegird").getStore();
        _self.financestore.on("beforeload", function() {
            Ext.apply(_self.financestore.proxy.extraParams, {
                schoolId : seachinfo.schoolId,
                processStatus: seachinfo.processStatus,
                financeApprovalerId : seachinfo.financeApprovalerId,
                proposerName: seachinfo.proposerName
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        _self.financestore.currentPage = 1;
        _self.financestore.load({});
    },

    clearSearch:function (btn,e) {
        btn.up('form').form.reset();
    },

    showFinanceApply : function(btn, e) {
        _self.financestore = btn.up("#financeapprovalviewitemid").down("#financegird").getStore();
        var financepanel = Ext.create("core.app.view.FinanceApplyForm");
        _self.filecount = 1;
        financepanel.show();
    },

    closeFinanceApply: function (btn,e) {
        _self.filecount = 1;
        btn.up('window').close();
    },

    addFile : function(btn, e) {
        var fileField = new Ext.form.File({
            name:"files",
            anchor : '100%',
            margin: '5 0 10 5',
            buttonText : '浏览...',
            fieldLabel : '发票<font color="red">*</font>',
            allowBlank: false,
            validator : function(val) {
                var fileName = /(\.png$)|(\.jpg$)|(\.jpeg$)/;
                if (!fileName.test(val)) {
                    return "文件格式不正确，请选择png/jpg/jpeg中的一种格式";
                }
                return true;
            }
        });
        var form = btn.up('form');
        var index = 4 + _self.filecount;
        form.insert(index,fileField);
        _self.filecount++;
    },

    delFile : function(btn, e) {
        var form = btn.up('form');
        if(_self.filecount > 1){
            var file = form.items.items[4+_self.filecount-1];
            if(file.getName()=="files")
            {
                file.destroy();
                _self.filecount--;
            }
        }
    },

    submitApplyForm : function (btn) {
        var me = btn.up('window');
        var formCmp = btn.up('form');
        var form = formCmp.getForm();
        var values = form.getValues();
        var method = "POST";
        var url = "/finances";
        if(values.id != null && values.id>0){
            method = "PUT";
            url = "/finances/" + values.id;
        }
        form.submit({
            url : url,
            params : {
                schoolId : values['school.id'],
                amount:values.amount,
                financeType:values.financeType,
                details:values.details
            },

            method : method,
            success : function(form, action) {
                // 上传成功
                if (action.result.success == true) {
                    _self.filecount = 1;
                    _self.financestore.load();
                    Ext.MessageBox.alert('成功', action.result.message);
                } else {
                    Ext.MessageBox.alert('失败', action.result.message);
                }
                btn.up('window').close();
            },
            failure : function(form, action) {
                Ext.MessageBox.alert('失败', action.result.message);
            }

        });
    },

    showUpdateFinanceForm: function (grid, record, item, index, e, eopts) {
        _self.financestore = grid.getStore();
        _self.financerecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一条财务信息!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        }else if(record.data.processStatus != '草稿'){
            Ext.MessageBox.show({
                title: "提示",
                msg: "只能修改草稿状态下的财务记录!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var panel = Ext.create("core.app.view.FinanceApplyForm");
            var form = panel.down('form');
            form.loadRecord(record);
            //设置下拉框的值
            var schoolTemp = Ext.create("core.app.model.SchoolModel", {
                id : _self.financerecord.data['school.id'],
                scname : _self.financerecord.data['school.scname']
            });
            panel.down('#school').setValue(schoolTemp);
            panel.show();
        }
    },

    showApprovalFinanceForm:function (btn) {

        var grid = btn.up("#financeapprovalviewitemid").down('#financegird');
        var record = grid.getSelectionModel().getSelection()[0];
        _self.financestore = grid.getStore();
        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要审批的项!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        }else{
            var panel = Ext.create("core.app.view.FinanceApprovalForm");
            panel.down('#formid').setValue(record.data.id);
            panel.down('#schoolName').setValue(record.data['school.scname']);
            panel.down('#financeType').setValue(record.data.financeType);
            panel.down('#amount').setValue(record.data.amount);
            panel.down('#details').setValue(record.data.details);
            if(record.data.fileLocations !=null){
                var value = record.data.fileLocations;
                var str = '';
                if(value != null && value.length>0){
                    var locations = value.split('_-_');
                    Ext.Array.each(locations,function (name, index, countriesItSelf) {
                        str += '<a href="'+ locations[index] +'" target="_blank"><img src="' + locations[index] + '" width="50" height="30" borerd="0" /></a>'
                        str += "&nbsp;&nbsp;";
                    })
                }
                panel.down('#files').setValue(str);
            }
            AlertWin.alert('财务审批', null, panel, 600, 600);
        }
    },

    closeApprovalFinanceForm:function (btn) {
        AlertWin.hide();
    },

    submitApprovalFinanceForm:function (btn) {

        var me = btn.up('#financeApprovalFormid');
        var formCmp = btn.up('form');
        var form = formCmp.getForm();
        var values = form.getValues();
        var url = me.commiturl;
        form.submit({
            url : url,
            params : {
                id : values.id,
                approvalOpin:values.approvalOpin,
                isPass:values.isPass
            },
            method : 'POST',
            success : function(form, action) {
                if (action.result.success == true) {
                    _self.financestore.load();
                    Ext.MessageBox.alert('成功', action.result.message);
                    AlertWin.hide();
                } else {
                    Ext.MessageBox.alert('失败', action.result.message);
                }

            },
            failure : function(form, action) {
                Ext.MessageBox.alert('失败', action.result.message);
            }
        });
    },

    views: ['core.app.view.FinanceApplyForm','core.app.view.FinanceApprovalView'],
    models: ['core.app.model.FinanceModel'],
    stores: ['core.app.store.FinanceStore']

})