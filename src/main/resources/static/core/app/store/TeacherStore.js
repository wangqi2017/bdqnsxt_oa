Ext.define("core.app.store.TeacherStore", {
    extend: 'Ext.data.Store',
    model: 'core.app.model.TeacherModel',

    pageSize: configStore.numPerPage,

    autoLoad: true

})
