Ext.define('core.app.model.AbstractModel', {
    extend : 'Ext.data.Model',
    fields : [{
        name : 'id',
        type : 'auto'
    }, {
        name : 'createByUsername',
        type : 'auto',
    	persist : false
    }, {
        name : 'updateByUsername',
        type : 'auto',
    	persist : false
    }, {
        name : 'createOn',
        type : 'auto',
    	persist : false
    }, {
        name : 'updateOn',
        type : 'auto',
    	persist : false
    },{
        name : 'createByUserId',
        type : 'auto',
        persist : false
    },{
        name : 'updateByUserId',
        type : 'auto',
        persist : false
    }]
});