/*
 *
 *
 */
Ext.define("core.app.model.SchoolModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "scname",
        type : "string",
        sortable : true
    }, {
        name : "organization",
        type : "string",
        sortable : true
    }, {
        name : "province",
        type : "string",
        sortable : true
    }, {
        name : "address",
        type : "string",
        sortable : true
    }, {
        name : "leader",
        type : "string",
        sortable : true
    }, {
        name : "leaderPhone",
        type : "string",
        sortable : true
    }, {
        name : "teachers",
        type : "array",
        sortable : true
    }, {
        name : "currentClazzes",
        type : "array",
        sortable : true
    }, {
        name : "totalClazzes",
        type : "array",
        sortable : true
    }],

    proxy: {
        type: 'rest',
        url: "/schools",
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