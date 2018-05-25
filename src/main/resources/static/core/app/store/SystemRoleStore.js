Ext.define("core.app.store.SystemRoleStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.SystemRoleModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
