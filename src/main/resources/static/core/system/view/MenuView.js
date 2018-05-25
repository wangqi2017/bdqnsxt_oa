Ext.define("core.system.view.MenuView",{
    extend: "Ext.tree.Panel",
    alias:"widget.menuview",
    border: false,
    //是否显示根节点
    rootVisible: false,
    //数据集
    store: 'core.system.store.MenuStore',
    //菜单样式
    bodyStyle: {
        background: '#99bce8',
        height: 800
    }
})