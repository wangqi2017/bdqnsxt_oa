Ext.define('core.app.model.DepartmentModel', {
    extend : 'Ext.data.Model',
    fields : [{
        name : 'id',
        type : 'string'
    }, {
        name : 'name',
        type : 'string'
    }, {
        name : 'description',
        type : 'string'
    }, {
        name : 'userCount',
        type : 'string',
        persist : false
    }, {
        name : 'roleCount',
        type : 'string',
        persist : false
    }, {
        name : 'createByUsername',
        type : 'string',
        persist : false
    }, {
        name : 'updateByUsername',
        type : 'string',
        persist : false
    }, {
        name : 'createOn',
        type : 'string',
        persist : false
    }, {
        name : 'updateOn',
        type : 'string',
        persist : false
    }],
    proxy : {
        type : 'rest',
        url : '/departments',
        reader : {
            type : "json",
            root : "departments",
            successProperty : 'success'
        },
        writer : {
            type : "json"
        }
    }
});