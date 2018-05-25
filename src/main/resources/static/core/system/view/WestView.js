Ext.define('core.system.view.WestViewss',{
    extend: 'Ext.panel.Panel',
    alias: 'widget.westviewss',
    width: 200,
    title : "业务导航",
    collapsible: true,
    rootVisible: true,
    margins: '5 0 5 5',
    items:[{
        xtype:'menuview'
    }]
})