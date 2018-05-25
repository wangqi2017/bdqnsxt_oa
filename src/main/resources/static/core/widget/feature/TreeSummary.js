/**
 * 针对treepanel的，Summary插件
 */
Ext.define('core.widget.feature.TreeSummary', {
    extend : 'Ext.grid.feature.AbstractSummary',
    alias : 'feature.treesummary',
    /**
     * 默认只计算叶子节点的字段值
     */
    leafOnly : true,
    getFragmentTpl : function() {
        this.summaryData = this.generateSummaryData();
        return this.getSummaryFragments();
    },

    getTableFragments : function() {
        if (this.showSummaryRow) {
            return {
                closeRows : this.closeRows
            };
        }
    },

    closeRows : function() {
        return '</tpl>{[this.printSummaryRow()]}';
    },

    getPrintData : function(index) {
        var me = this, columns = me.view.headerCt.getColumnsForTpl(), i = 0, length = columns.length, data = [], active = me.summaryData, column;

        for (; i < length; ++i) {
            column = columns[i];
            column.gridSummaryValue = this.getColumnValue(column, active);
            data.push(column);
        }
        return data;
    },

    generateSummaryData : function() {
        var me = this;
        return me.createSummaryRecord(me.view);
    },
    createSummaryRecord : function(view) {
        var me = this;
        var columns = me.grid.headerCt.gridDataColumns, colCount = columns.length, i, column, store = me.grid.getStore(), summaryRecord = {};
        summaryRecord[columns[0].id] = '<center style="font-weight:bold">合计</center>';
        for (i = 1; i < colCount; ++i) {
            column = columns[i];
            summaryRecord[column.id] = me.getSummary(store, column.summaryType, column.dataIndex, me.leafOnly);
        }
        return summaryRecord;
    },
    getSummary : function(store, type, field, leafOnly) {
        var me = this;
        if (type) {
            var rootNode = store.getRootNode();
            switch (type) {
                case 'count' :
                    return 0;
                case 'min' :
                    return 0;
                case 'max' :
                    return 0;
                case 'sum' :
                    return me.getSum(rootNode, field, leafOnly);
                case 'average' :
                    return 0;
                default :
                    return '';
            }
        }
    },
    getSum : function(currentNode, field, leafOnly) {
        var me = this;
        var result = 0;
        var rawvalue = currentNode.get(field);
        var intvalue = 0;
        if (rawvalue * 1 > 0) {
            intvalue = rawvalue * 1;
        }
        if (leafOnly == false || currentNode.isLeaf()) {
            result += intvalue;
        }
        if (currentNode.hasChildNodes()) {
            var children = currentNode.childNodes;
            for ( var i = 0, len = children.length; i < len; i++) {
                result += me.getSum(children[i], field, leafOnly);
            }
        }
        return result;
    }
});