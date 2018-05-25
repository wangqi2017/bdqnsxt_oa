Ext.define("core.app.store.DepartmentStore", {
    extend : 'Ext.data.TreeStore',
    model : 'core.app.model.DepartmentModel',
    defaultRootId:'',//便于实现rest风格的请求
    autoLoad: false
});