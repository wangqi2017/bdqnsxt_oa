Ext.define('core.widget.MultiSelector',{
    extend : 'Ext.form.field.ComboBox',
    alias : 'widget.multiselector',
    id : 'multiselectorid',
    editable : false,
    multiSelect : true,
    listConfig : {
        itemTpl : Ext.create('Ext.XTemplate','<input type=checkbox>{[values.roleName||values.fullname]}'),
        onItemSelect : function(record) {
            var node = this.getNode(record);
            if (node) {
                Ext.fly(node).addCls(this.selectedItemCls);
                var checkboxs = node.getElementsByTagName("input");
                if (checkboxs != null)
                    var checkbox = checkboxs[0];
                checkbox.checked = true;
            }
        },
        listeners : {
            itemclick : function(view, record, item, index, e, eOpts) {
                var isSelected = view.isSelected(item);
                var checkboxs = item.getElementsByTagName("input");
                if (checkboxs != null) {
                    var checkbox = checkboxs[0];
                    if (!isSelected) {
                        checkbox.checked = true;
                    } else {
                        checkbox.checked = false;
                    }
                }
            }
        }
    },
    queryMode : 'remote'
}); 