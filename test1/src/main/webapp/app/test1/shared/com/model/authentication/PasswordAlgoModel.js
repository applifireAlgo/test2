Ext.define('Test1.test1.shared.com.model.authentication.PasswordAlgoModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "algoId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "algorithm",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "algoName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "algoDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "algoIcon",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "algoHelp",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});