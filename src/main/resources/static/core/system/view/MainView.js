Ext.define("core.system.view.MainView", {
    extend : 'Ext.panel.Panel',
    border : 0,
    layout : 'border',
    alias : 'widget.mainview',
    itemId: 'mainviewid',
    width : 1000,
    height : 800,
    initComponent : function() {
        var me = this;

        Ext.apply(me, {
            items : [{
                region : 'north',
                xtype : 'topview'
            },{
                region: 'west',
                xtype : 'westview'
            },{
                region: 'center',
                xtype : 'centerview'
            }]
        });

        me.callParent(arguments);
    }
});
