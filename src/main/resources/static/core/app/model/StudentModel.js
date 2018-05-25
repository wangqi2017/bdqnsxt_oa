/*
 *
 *
 */
Ext.define("core.app.model.StudentModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "stuName",
        type : "string",
        sortable : true
    }, {
        name : "idCard",
        type : "string",
        sortable : true
    }, {
        name : "mobilePhone",
        type : "string",
        sortable : true
    }, {
        name : "gender",
        type : "string",
        sortable : true
    }, {
        name : "schoolTime",
        type : "date",
        sortable : true
    }, {
        name : "gradutionTime",
        type : "date",
        sortable : true
    }, {
        name : "gradutionFrom",
        type : "string",
        sortable : true
    },{
        name : "gradutionRecord",
        type : "string",
        sortable : true
    },{
        name : "foreignLevel",
        type : "string",
        sortable : true
    },{
        name : "qq",
        type : "string",
        sortable : true
    },{
        name : "email",
        type : "string",
        sortable : true
    },{
        name : "contactor",
        type : "string",
        sortable : true
    },{
        name : "contactorPhone",
        type : "string",
        sortable : true
    },{
        name : "remarks",
        type : "string",
        sortable : true
    },{
        name : "computerSkill",
        type : "string",
        sortable : true
    },{
        name : "currentClazz.id",
        type : "string",
        sortable : true
    },{
        name : "currentClazz.clname",
        type : "string",
        sortable : true
    },{
        name : "currentClazz.belongSchool.scname",
        type : "string",
        sortable : true
    },{
        name : "status",
        type : "string",
        sortable : true
    },{
        name : "studentConsult.lastLockTime",
        type : "date"
    },{
        name : "studentConsult.consulter.fullname",
        type : "string",
        sortable : true
    },{
        name : "lockId",
        type : "string",
        sortable : true
    }],

    proxy: {
        type: 'rest',
        url: "/students",
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