Ext.define("core.app.model.StudentConsultModel", {
    extend : "core.app.model.AbstractModel",
    fields : [ {
        name : "consulter.id",
        type : "string",
        sortable : true
    }, {
        name : "consulter.fullname",
        type : "string",
        sortable : true
    }, {
        name : "student.id",
        type : "string",
        sortable : true
    }, {
        name : "student.stuName",
        type : "string",
        sortable : true
    }, {
        name : "student.status",
        type : "string",
        sortable : true
    }, {
        name : "lastLockTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d H:i:s"
    }, {
        name : "quizTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d H:i:s"
    }, {
        name : "firstVisit",
        type : "string",
        sortable : true
    }, {
        name : "secondVisit",
        type : "string",
        sortable : true
    }, {
        name : "thirdVisit",
        type : "string",
        sortable : true
    }, {
        name : "purpose",
        type : "string",
        sortable : true
    }, {
        name : "remarks",
        type : "string",
        sortable : true
    }],

    proxy: {
        type: 'rest',
        url: "/consults",
        reader: {
            type: "json",
            root: "data",
            successProperty: 'success',
            totalProperty: 'total',

        },
        writer: {
            type: "json"
        }
    }

})