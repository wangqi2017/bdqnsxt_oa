/*
 * 班级信息
 * author
 *
 */
Ext.define("core.app.view.CodeView", {
    extend: 'Ext.panel.Panel',
    alias: 'widget.codeview',
    itemId: 'codeviewitemid',
    margins: '0 0 0 0',
    border: 0,
    title: '<center height=40>代码统计</center>',
    closable: true,
    bodyStyle: 'padding:0px',
    menuAlign: "center",
    layout: 'border',
    items: [
        // 查询栏items
        {
            xtype: 'panel',
            region: 'north',
            title: '查询',
            itemId: 'codeviewsearchitemid',
            collapsible: true,
            items: [{
                xtype: 'form',
                height: 70,
                items: [
                    {
                        xtype: 'panel',
                        layout: 'hbox',
                        width: '100%',
                        height: 30,
                        border: 0,
                        items: [
                            {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'clazzcodeitemid',
                                margin: '5 0 0 10',
                                fieldLabel: '所在班级',
                                displayField: 'clname',
                                valueField: 'id',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['id', 'clname'],
                                    proxy: {
                                        type: 'rest',
                                        url: "/allclazzs",
                                        reader: {
                                            type: "json",
                                            root: "data",
                                            successProperty: 'success'
                                        }
                                    }
                                }),
                                listeners: {        //这是ComboBox的监听器

                                    'change': function (field, newValue) {  //change事件
                                        if (newValue) {
                                            var studentCode = field.up("#codeviewsearchitemid").down("#studentcodeitemid");
                                            studentCode.setValue(null);
                                            studentCode.getStore().getProxy().url = "/getByClazz?clazzId=" + newValue;
                                            studentCode.getStore().load();
                                        }
                                    }
                                }
                            }, {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'studentcodeitemid',
                                margin: '5 0 0 60',
                                name: 'stuId',
                                fieldLabel: '学员',
                                displayField: 'stuName',
                                valueField: 'id',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['id', 'stuName'],
                                    proxy: {
                                        type: 'rest',
                                        reader: {
                                            type: "json",
                                            root: "data",
                                            successProperty: 'success'
                                        }
                                    }
                                })
                            },{
                                xtype: 'datefield',
                                anchor: '90%',
                                itemId: 'startcommittimeitemid',
                                margin: '5 0 0 60',
                                name: 'startCommitTime',
                                fieldLabel: '起始时间',
                                format: 'Y-m-d'
                            }]
                    },
                    {
                        xtype: 'panel',
                        layout: 'hbox',
                        width: '100%',
                        height: 30,
                        border: 0,
                        items: [

                            {
                                xtype: 'datefield',
                                anchor: '90%',
                                itemId: 'endCommitTime',
                                margin: '5 0 0 10',
                                name: 'endCommitTime',
                                fieldLabel: '结束时间',
                                format: 'Y-m-d'
                            }
                            , {
                                xtype: 'combobox',
                                anchor: '90%',
                                itemId: 'status',
                                margin: '5 0 10 60',
                                name: 'repoType',
                                fieldLabel: '仓库类型',
                                displayField: 'name',
                                valueField: 'value',
                                emptyText: "--请选择--",
                                store: Ext.create('Ext.data.Store', {
                                    fields: ['value', 'name'],
                                    data: [{
                                        "value": "PRACTICE",
                                        "name": "练习库"
                                    }, {
                                        "value": "PROJECT",
                                        "name": "项目库"
                                    }]
                                })
                            },
                            {
                                xtype: 'button',
                                margin: '5 0 0 10',
                                itemId: 'searchcodeviewid',
                                ref: 'searchcodeview',
                                text: '查询'
                            }, {
                                xtype: 'button',
                                margin: '5 0 0 30',
                                itemId: 'clearsearchcodeviewid',
                                ref: 'clearsearchcodeview',
                                text: '清空'
                            }]
                    }]
            }]
        },


        {
            xtype: 'panel',
            layout: 'fit',
            title: '趋势图',
            region: 'center',
            forceFit: true,
            items: {
                xtype: 'chart',  //设置图表类型
                itemId: 'codechart',
                animate: true,  //开始加载时是否动画
                shadow: true,  //加上阴影 自动创建一个Ext.Shadow,或一个字符串表示Ext.Shadow.mode影子的显示
                legend: { position: 'top', boxStroke: 'border:0px;', labelFont: '11px Helvetica' },
                store:"core.app.store.StudentCodeStore",//数据对象
                //axes :轴
                axes: [
                    {
                        title: '提交时间',
                        type: 'Time',  //数字类型轴
                        position: 'bottom', //停靠位置
                        fields: 'commitTime', //Y轴坐标数据，会取最大值
                        label: {    //轴上数据文本显示  比如label: { rotate: { degrees: 315} } 旋转315°
                            rotate: { degrees: -15}
                        },
                        dateFormat: "Y-m-d"
                        //fromDate: new Date('2018-06-01'),
                        //toDate: new Date('2020-12-31')
                        //title: 'Y坐标',
                        //minimum: 0,  //起始点数 默认0
                        //grid: true  //显示背景表格对照
                    },
                    {
                        type: 'Numeric',
                        position: 'left',
                        title: '代码修改量',
                        fields: 'changeTotal',
                        minimum: 0
                    }
                ],
                series: [            //竖条 内容
                    {
                        title: '修改量',
                        type: 'line',
                        axis: ['left', 'bottom'], //指定Y轴  是左边这条
                        xField: 'commitTime',
                        yField: 'changeTotal'
                    },
                    {
                        title: '增加量',
                        type: 'line',
                        axis: ['left', 'bottom'], //指定Y轴  是左边这条
                        xField: 'commitTime',
                        yField: 'addTotal'
                    },
                    {
                        title: '删除量',
                        type: 'line',
                        axis: ['left', 'bottom'], //指定Y轴  是左边这条
                        xField: 'commitTime',
                        yField: 'subTotal'
                    }
                ]

            }

        }]

});
