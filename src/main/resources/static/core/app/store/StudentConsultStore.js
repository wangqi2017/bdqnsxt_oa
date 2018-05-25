Ext.define("core.app.store.StudentConsultStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.StudentConsultModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
