/*
 *
 *
 */
Ext.define("core.app.model.UserModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "username",
        type : "string",
        sortable : true
    }, {
        name : "fullname",
        type : "string",
        sortable : true
    }, {
        name : "email",
        type : "string",
        sortable : true
    }, {
        name : "mobilePhone",
        type : "string",
        sortable : true
    }, {
        name : "qq",
        type : "string",
        sortable : true
    }, {
        name : "gender",
        type : "string",
        sortable : true
    },  {
        name : "status",
        type : "string",
        sortable : true
    }, {
        name : "hireDate",
        type : "date",
        sortable : true
    }, {
        name : "roles",
        type : "array",
        sortable : true
    }, {
        name : "roleIds",
        type : "array",
        sortable : true
    }, {
        name : "school.id",
        type : "string",
        sortable : true
    }, {
        name : "school.scname",
        type : "string",
        sortable : true
    }, {
        name : "department.id",
        type : "string",
        sortable : true
    }, {
        name : "department.name",
        type : "string",
        sortable : true
    }, {
        name : "admin",
        type : "boolean",
        sortable : true
    }, {
        name : "leader",
        type : "boolean",
        sortable : true
    }
    ],

    proxy: {
        type: 'rest',
        url: "/users",
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