Ext.define("core.system.view.CenterView", {
    extend : 'Ext.tab.Panel',
    alias : 'widget.centerview',
    id : 'centerviewid',
    margins : '0 0 0 0',
    border : 0,
    bodyStyle : 'padding:0px',
    menuAlign : "center",
    activeTab : 0,
    items : [{
        xtype: 'panel',
        margins: '0 0 0 0',
        border: 0,
        title: '<center height=40>首页</center>',
        layout: 'border',
        width: '100%',
        height: '100%',
        items: [{
            region: "center",
            xtype: 'panel',
            layout: {
                type: 'hbox',
                align: 'top'
            },
            width: '100%',
            height: '70%'
        }]
    }]
});