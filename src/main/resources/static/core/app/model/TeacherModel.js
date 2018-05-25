/*
 *
 *
 */
Ext.define("core.app.model.TeacherModel", {
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
        name : "school",
        type : "array",
        sortable : true
    }
    ],

    proxy: {
        type: 'rest',
        url: "/teachers",
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