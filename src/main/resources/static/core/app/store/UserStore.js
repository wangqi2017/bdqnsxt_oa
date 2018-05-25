Ext.define("core.app.store.UserStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.UserModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
