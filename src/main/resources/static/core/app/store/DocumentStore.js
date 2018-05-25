Ext.define("core.app.store.DocumentStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.DocumentModel',
    autoLoad: false,
    pageSize: configStore.numPerPage


})
