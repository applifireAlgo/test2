Ext.define('Test1.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Test1.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Test1.view.mobileview.reportui.datachart.DataChartViewTab',
			'Test1.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Test1.view.mobileview.reportui.ReportViewController' ,
			'Test1.view.mobileview.fw.DataPointPanel',
			'Test1.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
