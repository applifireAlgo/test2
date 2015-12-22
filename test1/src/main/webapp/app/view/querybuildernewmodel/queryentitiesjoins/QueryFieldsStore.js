Ext.define('Test1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Test1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Test1.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
