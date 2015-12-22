Ext.define('Test1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Test1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Test1.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
