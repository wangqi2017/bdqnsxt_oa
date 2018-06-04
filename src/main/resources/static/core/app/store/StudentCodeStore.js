Ext.define("core.app.store.StudentCodeStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.StudentCodeModel',
    autoLoad: true,
    proxy: {
        type: 'ajax',
        url: '/codes',
        reader: {
            type: 'json',
            root: 'data'
        }
    }
})
