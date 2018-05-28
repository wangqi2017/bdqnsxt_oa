/*
 *
 *
 */
Ext.define("core.app.model.ClazzModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "clname",
        type : "string",
        sortable : true
    }, {
        name : "orientation",
        type : "string",
        sortable : true
    }, {
        name : "belongSchool.id",
        type : "string",
        sortable : true
    }, {
        name : "belongSchool.scname",
        type : "string",
        sortable : true
    }, {
        name : "startDate",
        type : "date",
        sortable : true
    }, {
        name : "endDate",
        type : "date",
        sortable : true
    }, {
        name : "status",
        type : "string",
        sortable : true
    },{
        name : "lecturer.id",
        type : "string",
        sortable : true
    },{
        name : "lecturer.fullname",
        type : "string",
        sortable : true
    },{
        name : "classLeader.id",
        type : "string",
        sortable : true
    },{
        name : "classLeader.fullname",
        type : "string",
        sortable : true
    },{
        name : "tutors",
        type : "array",
        sortable : true
    },{
        name : "tutors.ids",
        type : "array",
        sortable : true
    }],

    proxy: {
        type: 'rest',
        url: "/clazzss",
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