Ext.onReady(function () {
    Ext.QuickTips.init();
    Ext.History.init();//开启history
    Ext.Loader.setConfig({
        enabled: true
    });
    configStore = {'numPerPage':15};
    Ext.Loader.setPath('Ext.ux', '/ext/examples/ux');
    Ext.application({
        name: 'core',
        appFolder: 'core',
        launch: function () {
            Ext.create("Ext.container.Viewport", {
                layout: "fit",
                border: 0,
                items: [{
                    xtype: "mainview"
                }]

            });
        },
        controllers: ["core.system.controller.MainController"]
    });


});
