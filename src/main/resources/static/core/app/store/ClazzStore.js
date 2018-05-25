Ext.define("core.app.store.ClazzStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.ClazzModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
