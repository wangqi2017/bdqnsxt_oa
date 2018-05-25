/*
 *
 *
 */
Ext.define("core.app.model.UserPasswordModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "newPassword",
        type : "string",
        sortable : true
    }, {
        name : "oldPassword",
        type : "string",
        sortable : true
    }
    ],

    proxy: {
        type: 'rest',
        url: "/userPass",
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