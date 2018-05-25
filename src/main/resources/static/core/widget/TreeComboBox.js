Ext.define('core.widget.TreeComboBox', {
    extend : 'Ext.form.field.ComboBox',
    alias : 'widget.treecombobox',
    id : 'treecomboboxid',
    textProperty : 'text',
    model : '',
    displayField : '',
    allowEmpty : true,
    customLable : null,
    multiSelect:true,
    selected:[],
    initComponent : function() {
        var me = this;
        Ext.apply(this, {
            editable : false,
            queryMode : 'local',
            select : Ext.emptyFn
        });

        this.displayField = this.displayField || 'text', this.treeid = Ext.String.format('tree-combobox-{0}', Ext.id());
        this.tpl = Ext.String.format('<div id="{0}"></div>', this.treeid);

        var store = Ext.create('Ext.data.TreeStore', {
            defaultRootId : '',
            model : me.model
        });
        this.tree = Ext.create('Ext.tree.Panel', {
            rootVisible : false,
            autoScroll : true,
            checked: true,
//            expanded : true,
            height : 200,
             //displayField : 'name',
             store : store,
            displayField : me.displayField,
            /*
            selModel: {
                selType: 'checkboxmodel',
                mode: 'MULTI'
            },
            */
            viewConfig : {
            	 preserveScrollOnRefresh : true,
                loadMask : {
                    msg : '数据加载中......'
                   }
            }
        });

        this.tree.on('checkchange',function (node,checked) {
            if(checked){
                if(!Ext.Array.contains(me.selected,node)){
                    Ext.Array.push(me.selected,node);
                }
            }else{
                Ext.Array.remove(me.selected,node);
            }
            me.setValue(me.selected);
        });


        me.on('expand', function() {
            if (!this.tree.rendered) {
                this.tree.render(this.treeid);
            }
        });

        this.callParent(arguments);
    }
});