Ext.define('Test1.test1.web.com.view.location.CurrencyMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CurrencyMainController",
     "restURL": "/Currency",
     "defaults": {
          "split": true
     },
     "requires": ["Test1.test1.shared.com.model.location.CurrencyModel", "Test1.test1.web.com.controller.location.CurrencyMainController", "Test1.test1.shared.com.model.location.CountryModel", "Test1.test1.shared.com.viewmodel.location.CurrencyViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Currency",
               "name": "CurrencyTreeContainer",
               "itemId": "CurrencyTreeContainer",
               "restURL": "/Currency",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CurrencyTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "currencyId",
                         "itemId": "currencyId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Code",
                         "fieldId": "F4934A98-0AA0-44E2-9E8C-F7701498A3CD",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": ""
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code",
                         "fieldId": "6AB2D69A-0BB6-4EE5-8A77-87944788AEB2",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Test1.test1.shared.com.model.location.CountryModel"
                         }
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "CurrencyViewModel",
                    "xtype": "form",
                    "displayName": "Currency",
                    "title": "Currency",
                    "name": "Currency",
                    "itemId": "Currency",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "currencyId",
                         "itemId": "currencyId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency Code<font color='red'> *<\/font>",
                         "fieldId": "F4934A98-0AA0-44E2-9E8C-F7701498A3CD",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "currencyId",
                         "bind": "{currencyId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6AB2D69A-0BB6-4EE5-8A77-87944788AEB2",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Test1.test1.shared.com.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "currencyCode",
                         "itemId": "currencyCode",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Currency",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Currency",
                         "fieldId": "A2727BBB-C132-4036-A525-962948EAAFD4",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "currencyCode",
                         "bind": "{currencyCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "unicodeDecimal",
                         "itemId": "unicodeDecimal",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Unicode Descimal",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Unicode Descimal",
                         "fieldId": "3816A4C0-79CE-4A72-A9E6-F4EB0481FDF5",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "unicodeDecimal",
                         "bind": "{unicodeDecimal}",
                         "columnWidth": 0.5
                    }, {
                         "name": "unicodeHex",
                         "itemId": "unicodeHex",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "unicode Hex",
                         "margin": "5 5 5 5",
                         "fieldLabel": "unicode Hex",
                         "fieldId": "7601E01A-1C0A-4A2C-ABF9-F55534D46FDF",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "unicodeHex",
                         "bind": "{unicodeHex}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "50E76777-FD9B-47AB-B7BC-6C08E211AFCD",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 173,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 173,
                              "customId": 59
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 173,
                              "customId": 60,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 173,
                              "customId": 61,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Currency",
                    "title": "Details Grid",
                    "name": "CurrencyGrid",
                    "itemId": "CurrencyGrid",
                    "restURL": "/Currency",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Currency Code",
                         "dataIndex": "currencyId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country Code",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Currency",
                         "dataIndex": "currencyCode",
                         "flex": 1
                    }, {
                         "header": "Unicode Descimal",
                         "dataIndex": "unicodeDecimal",
                         "flex": 1
                    }, {
                         "header": "unicode Hex",
                         "dataIndex": "unicodeHex",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "CurrencyViewModel",
               "xtype": "form",
               "displayName": "Currency",
               "title": "Currency",
               "name": "Currency",
               "itemId": "Currency",
               "bodyPadding": 10,
               "items": [{
                    "name": "currencyId",
                    "itemId": "currencyId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency Code<font color='red'> *<\/font>",
                    "fieldId": "F4934A98-0AA0-44E2-9E8C-F7701498A3CD",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "currencyId",
                    "bind": "{currencyId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6AB2D69A-0BB6-4EE5-8A77-87944788AEB2",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Test1.test1.shared.com.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5
               }, {
                    "name": "currencyCode",
                    "itemId": "currencyCode",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Currency",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Currency",
                    "fieldId": "A2727BBB-C132-4036-A525-962948EAAFD4",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "currencyCode",
                    "bind": "{currencyCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "unicodeDecimal",
                    "itemId": "unicodeDecimal",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Unicode Descimal",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Unicode Descimal",
                    "fieldId": "3816A4C0-79CE-4A72-A9E6-F4EB0481FDF5",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "unicodeDecimal",
                    "bind": "{unicodeDecimal}",
                    "columnWidth": 0.5
               }, {
                    "name": "unicodeHex",
                    "itemId": "unicodeHex",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "unicode Hex",
                    "margin": "5 5 5 5",
                    "fieldLabel": "unicode Hex",
                    "fieldId": "7601E01A-1C0A-4A2C-ABF9-F55534D46FDF",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "unicodeHex",
                    "bind": "{unicodeHex}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "50E76777-FD9B-47AB-B7BC-6C08E211AFCD",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 173,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 173,
                         "customId": 59
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 173,
                         "customId": 60,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 173,
                         "customId": 61,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});