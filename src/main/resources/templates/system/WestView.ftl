Ext.define("core.system.view.WestView", {
    extend : 'Ext.panel.Panel',
    alias : 'widget.westview',
    id : 'comwestviewid',
    collapsible : true,
    split : true,
    defaults : {
        bodyStyle : 'padding:2px'
    },
    border : 0,
    margins : '2 2 0 0',
    width : 225,
    title : "业务导航",
    layout : 'accordion',
    layoutConfig : {
        titleCollapse : false,
        animate : true,
        activeOnTop : true
    },
    items : ${items},
    initComponent : function() {
        this.callParent(arguments);
    }
});