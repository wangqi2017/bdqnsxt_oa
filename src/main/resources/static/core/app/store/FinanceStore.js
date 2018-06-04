Ext.define("core.app.store.FinanceStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.FinanceModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
