/*
 *
 *
 */
Ext.define("core.app.model.StudentCodeModel", {
    extend: 'Ext.data.Model',
    fields : [ {
        name : "addTotal",
        type : "int",
        sortable : true
    }, {
        name : "subTotal",
        type : "int",
        sortable : true
    }, {
        name : "changeTotal",
        type : "int",
        sortable : true
    }, {
        name : "repoType",
        type : "string",
        sortable : true
    }, {
        name : "commitTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d"
    }]

})