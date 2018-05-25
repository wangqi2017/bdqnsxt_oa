/*
 *
 *
 */
Ext.define("core.app.model.SystemRoleModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "roleName",
        type : "string",
        sortable : true
    },{
        name : "description",
        type : "string",
        sortable : true
    },{
        name : "userCount",
        type : "string",
        sortable : true
    },{
        name : "departmentId",
        type : "string",
        sortable : true
    }],

    proxy: {
        type: 'rest',
        reader: {
            type: "json",
            root: "data",
            successProperty: 'success',
            totalProperty: 'total'
        },
        writer: {
            type: "json"
        }
    }
})