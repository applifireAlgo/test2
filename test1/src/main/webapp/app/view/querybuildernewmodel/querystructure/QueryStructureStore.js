Ext.define('Test1.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Test1.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Test1.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
