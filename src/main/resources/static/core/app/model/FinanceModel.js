Ext.define("core.app.model.FinanceModel", {
    extend : "core.app.model.AbstractModel",
    fields : [{
        name : "approvalStatus",
        type : "string",
        sortable : true
    },{
        name : "processStatus",
        type : "string",
        sortable : true
    },{
        name : "school.id",
        type : "string",
        sortable : true
    },{
        name : "school.scname",
        type : "string",
        sortable : true
    },{
        name : "proposer.fullname",
        type : "string",
        sortable : true
    },{
        name : "amount",
        type : "string",
        sortable : true
    },{
        name : "financeType",
        type : "string",
        sortable : true
    },{
        name : "details",
        type : "string",
        sortable : true
    },{
        name : "applyTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d H:i:s"
    },{
        name : "fileLocations",
        type : "string",
        sortable : true
    },{
        name : "financeApprovaler.fullname",
        type : "string",
        sortable : true
    },{
        name : "financeApprovalTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d H:i:s"
    },{
        name : "financeApprovalOpin",
        type : "string",
        sortable : true
    },{
        name : "centerApprovaler.fullname",
        type : "string",
        sortable : true
    },{
        name : "centerAprrovalTime",
        type : "date",
        sortable : true,
        dateFormat : "Y-m-d H:i:s"
    },{
        name : "centerApprovalOpin",
        type : "string",
        sortable : true
    },{
        name: "isPass",
        type: "string"
    }],
    proxy : {
        type : 'rest',
        url: '/finances',
        reader : {
            type : "json",
            root : "data",
            successProperty : 'success',
            totalProperty: 'total'
        },
        writer : {
            type : "json"
        }
    }

})