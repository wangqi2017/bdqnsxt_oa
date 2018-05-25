Ext.define("core.app.model.DocumentCategoryModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "name",
        type : "string",
        sortable : true
    },{
        name : "parent.id",
        type : "string",
        sortable : true
    }],
    proxy : {
        type : 'rest',
        url : '/docCats',
        reader : {
            type : "json",
            root : "docCats",
            successProperty : 'success'
        },
        writer : {
            type : "json"
        }
    }

})