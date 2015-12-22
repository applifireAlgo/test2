Ext.define('Test1.view.art.masterform.QueryPanel', {
	extend :'Ext.form.Panel',
	xtype: 'queryPanel',
	itemId: 'queryPanel',
	requires: ['Test1.view.art.masterform.QueryPanelController','Test1.view.art.masterform.QueryPanelViewModel'],
	controller: 'queryPanelController',
	viewModel:'queryPanelViewModel',
	serviceURL:null,
	buttons : [{
		text : 'Filter',
		listeners:{
			click:'submitQuery'
		}	
		
	}]	
});