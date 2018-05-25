Ext.define("core.app.model.DocumentModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "name",
        type : "string",
        sortable : true
    },{
        name : "description",
        type : "string",
        sortable : true
    },{
        name : "location",
        type : "string",
        sortable : true
    },{
        name : "documentCategories",
        type : "array",
        sortable : true
    },{
        name : "createByUsername",
        type : "string",
        sortable : true
    },{
        name : "createOn",
        type : "date",
        sortable : true
    }],
    proxy : {
        type : 'rest',
        reader : {
            type : "json",
            root : "data",
            successProperty : 'success',
            totalProperty: 'total'
        },
        writer : {
            type : "json"
        }
    }

})