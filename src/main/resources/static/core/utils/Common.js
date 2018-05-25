Ext.define('core.utils.Common', {
    alternateClassName : 'common',
    singleton : true,

    tabs : new Array(0, 0, 0, 0, 0),
    addFunItem : function(funInfo, self, custom) {
        if (!funInfo) {
            return false;
        }
        var mainView = funInfo.mainView;
        var funPanel = mainView.down(funInfo.funViewXtype);
        if (custom && custom.refreshOnOpen) {
            funPanel = null
        }
        if (funPanel) {
            mainView.setActiveTab(funPanel);
            return true;
        }
        if (funInfo.funController) {
            if (!Ext.ClassManager.isCreated(funInfo.funController)) {
                self.application.getController(funInfo.funController);
            }
        }
        if (custom) {
            funPanel = Ext.create(funInfo.funViewName, custom);
        } else {
            funPanel = Ext.create(funInfo.funViewName);
        }
        //用来给 view添加menuId 当history变化时，会起作用
        funPanel.menuId = funInfo.menuId;
        // 先看看数组是否满了，不满添加新的tab
        var flag = false; // tab没满是false
        for ( var j = 0; j < 5; j++) {
            if (!this.tabs[j]) {
                this.tabs[j] = funPanel;
                mainView.add(funPanel);
                flag = true;
                break;
            }
        }
        // 如果tabs满了，删掉最前面的一个，后面跟上，新的tab添加到数组末尾
        if (!flag) {
            mainView.remove(this.tabs[0]);
            for ( var i = 0; i < 4; i++) {
                this.tabs[i] = this.tabs[i + 1]
            }
            this.tabs[4] = funPanel;
            mainView.add(funPanel);
        }
        mainView.setActiveTab(funPanel);
    },


    feedBackMsg : function(operation) {
        return operation.request.scope.reader.jsonData["message"];
    },

    /**
     * 使用方法：destroyNode(model,{success;failure});
     *
     * @param {}
     *            me
     * @param {}
     *            options
     * @return {}
     */
    destroyNode : function(me, options) {
        options = Ext.apply({}, options);

        var scope = options.scope || me, stores = me.stores, i = 0, storeCount, store, args, operation, callback;

        Ext.apply(options, {
            records : [me],
            action : 'destroy'
        });

        operation = new Ext.data.Operation(options);
        callback = function(operation) {
            args = [me, operation];
            if (operation.wasSuccessful()) {
                for (storeCount = stores.length; i < storeCount; i++) {
                    store = stores[i];
                    store.fireEvent('write', store, operation);
                    store.fireEvent('datachanged', store);
                    // Not firing refresh here, since it's a single record
                }
                me.clearListeners();
                Ext.callback(options.success, scope, args);
            } else {
                Ext.callback(options.failure, scope, args);
            }
            Ext.callback(options.callback, scope, args);
        };

        me.getProxy().destroy(operation, callback, me);
        return me;
    }
})