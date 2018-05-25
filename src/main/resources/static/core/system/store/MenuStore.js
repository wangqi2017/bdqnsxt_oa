Ext.define("core.system.store.MenuStore", {
    extend:'Ext.data.TreeStore',
    proxy: {
        type: 'ajax',
        url: '/westviewstore.json',
        reader: {
            type: 'json'
        }
    },
    autoLoad: true
});
