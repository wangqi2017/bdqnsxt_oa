Ext.define("core.app.store.SchoolStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.SchoolModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
