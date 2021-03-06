/*
 * 班级信息Controller
 *
 */
Ext.define("core.app.controller.ClazzController", {
    extend: "Ext.app.Controller",
    clazzstore: null,
    addrolespanel: null,
    addroleswindow: null,
    clazzRecord: null,
    _self: null,
    init: function () {
        _self = this;
        this.control({
            'clazzview button[ref=searchclazzview]' : {
                click : _self.searchClazz
            },
            'clazzview button[ref=clearsearchclazzview]' : {
                click : _self.clearSearchClazz
            },
            'clazzview button[ref=createclazz]': {
                click: _self.showCreateClazzForm
            },
            'clazzviewform button[ref=submitclazzviewform]': {
                click: _self.submitClazzForm
            },
            'clazzviewform button[ref=closeclazzviewform]': {
                click: _self.closeClazzForm
            },
            'clazzview grid[itemId=clazzgird]': {
                'itemdblclick': _self.showUpdateClazzForm
            },
            'clazzview button[ref=deleteclazz]' : {
                click : _self.deleteClazz
            },
            'clazzviewform #clazzorientation' :{
                'change' : function (combo,newValue,oldValue,eOpts) {
                    if(newValue == 'ACCP'){
                        combo.up('form').down('#clazzlevelitemid').show();
                    }else{
                        combo.up('form').down('#clazzlevelitemid').hide();
                    }
                    this.setClazzName(combo,newValue,oldValue,eOpts);
                }
            },
            'clazzviewform #startdateitemid':{
                'change' : _self.setClazzName
            },
            'clazzviewform #clazzlevelitemid':{
                'change' : _self.setClazzName
            }
        });
    },

    setClazzName: function (compent,newValue,oldValue,eOpts) {
        var clname;
        var orientValue = compent.up('form').down('#clazzorientation').getValue();
        var levelRadio = compent.up('form').down('#clazzlevelitemid').getChecked()[0];
        var startDate = compent.up('form').down('#startdateitemid').getValue();
        var start = Ext.util.Format.date(startDate,'Y-m-d');
        if(orientValue !=null && start!=null){
            if(levelRadio == null){
                clname = orientValue + "_" + start;
                compent.up('form').down('#clnameitemid').setValue(clname);
            }else{
                clname = orientValue + "_" + levelRadio.boxLabel + "_" + start;
                compent.up('form').down('#clnameitemid').setValue(clname);
            }
        }

    },

    searchClazz : function(btn, e) {
        var seachform = btn.up('form');

        var seachinfo = seachform.getValues();
        clazzstore = btn.up("#clazzviewid").down("#clazzgird").getStore();
        clazzstore.on("beforeload", function() {
            Ext.apply(clazzstore.proxy.extraParams, {
                clname : seachinfo.clname,
                organization: seachinfo.organization,
                status: seachinfo.status,
                schoolId: seachinfo.schoolId
            });
        });
        //给store的currentPage 赋值，每次查询start为1
        clazzstore.currentPage = 1;
        clazzstore.load({
        });
    },

    clearSearchClazz:function (btn,e) {
        btn.up('form').form.reset();
    },

    showCreateClazzForm: function (btn, e) {
        clazzstore = btn.up("#clazzviewid").down("#clazzgird").getStore();
        var clazzpanel = Ext.create("core.app.view.ClazzViewForm");
        clazzpanel.down('#submitclazzviewformid').setText('新建班级');
        AlertWin.alert('新建班级', null, clazzpanel, 600, 400);
    },

    submitClazzForm: function (btn) {
        var clazzFormCmp = btn.up('form');
        var clazzform = clazzFormCmp.getForm();
        if (clazzform.isValid()) {
            AlertWin.hide();
            var clazzinfo = clazzform.getValues();
            var clazzmodel = Ext.create("core.app.model.ClazzModel", clazzinfo);
            clazzmodel.save({
                success: function (response, opts) {
                    var resp = Ext.decode(opts.response.responseText);
                    if (resp.success == "true" || resp.success == true) {
                        Ext.Msg.alert("信息!", resp.message)
                        clazzstore.load();
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

    closeClazzForm: function (btn) {
        AlertWin.hide();
    },

    showUpdateClazzForm: function (grid, record, item, index, e, eopts) {
        clazzstore = grid.getStore();
        clazzRecord = record;
        if (!record) {
            Ext.MessageBox.show({
                title: "提示",
                msg: "请先选择一个班级!",
                icon: Ext.MessageBox.INFO,
                buttons: Ext.Msg.OK
            })
            return;
        } else {
            var clazzpanel = Ext.create("core.app.view.ClazzViewForm");
            clazzpanel.down('#submitclazzviewformid').setText('修改班级');
            var clazzform = clazzpanel.down('form');

            //delete clazzRecord.data['belongSchool.id'];
            //delete clazzRecord.data['lecturer.id'];
            clazzform.loadRecord(clazzRecord);
            var schoolTemp = Ext.create("core.app.model.SchoolModel", {
                id : clazzRecord.data['belongSchool.id'],
                scname : clazzRecord.data['belongSchool.scname']
            });
            var lecturerTemp = Ext.create("core.app.model.UserModel", {
                id : clazzRecord.data['lecturer.id'],
                fullname : clazzRecord.data['lecturer.fullname']
            });
            var classLeaderTemp = Ext.create("core.app.model.UserModel", {
                id : clazzRecord.data['classLeader.id'],
                fullname : clazzRecord.data['classLeader.fullname']
            });
            var tutors = clazzRecord.data["tutors"];
            var tutorTemp = [];
            Ext.Array.each(tutors,function(name, index, itSelf){
                var tutorModel = Ext.create("core.app.model.UserModel", {
                    id : tutors[index].id,
                    fullname : tutors[index].fullname
                });
                tutorTemp.push(tutorModel);
            });
            clazzpanel.down('#clazzschool').setValue(schoolTemp);
            clazzpanel.down('#lecturer').setValue(lecturerTemp);
            clazzpanel.down('#classLeader').setValue(classLeaderTemp);
            //设置itemselector的值
            clazzpanel.down('#classLeader').setValue(tutorTemp);
            clazzpanel.down('#tutors').setValue(tutorTemp);
            AlertWin.alert('修改班级', null, clazzpanel, 600, 400);
        }
    },

    deleteClazz : function(btn, e) {
        var clazzgrid = btn.up("#clazzviewid").down('#clazzgird');
        clazzstore = clazzgrid.getStore();
        var record = clazzgrid.getSelectionModel().getSelection()[0];

        if (!record) {
            Ext.MessageBox.show({
                title : "提示",
                msg : "请先选择要删除的班级!",
                icon : Ext.MessageBox.INFO,
                buttons : Ext.Msg.OK
            })
            return;
        } else {
            Ext.MessageBox.confirm("标题", "你要删除这个班级吗？", function(btn) {
                if (btn == 'yes') {
                    record.data['tutors.ids'] = [];
                    record.destroy({
                        scope : this,
                        callback : function(response, opts) {
                            /*var resp = Ext.decode(opts.response.responseText);
                            if (resp.success == "true"||resp.success == true) {
                                opts.request.scope.reader.jsonData["message"];*/
                                Ext.Msg.alert("信息!", opts.request.scope.reader.jsonData["message"]);
                                clazzstore.load();
                            /*} else {
                                Ext.Msg.alert("错误!", resp.message)
                            }*/
                        }
                    });
                }
            });
        }
    },


    models :["core.app.model.ClazzModel"],
    stores:["core.app.store.ClazzStore"],
    views :["core.app.view.ClazzView"]

})