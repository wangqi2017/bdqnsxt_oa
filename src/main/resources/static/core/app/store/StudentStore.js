Ext.define("core.app.store.StudentStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.StudentModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
