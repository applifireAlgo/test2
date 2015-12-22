Ext.define('Test1.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Test1.view.reportui.querycriteria.QueryCriteriaView',
			'Test1.view.reportui.datachart.DataChartViewTab',
			'Test1.view.reportui.datachart.DataChartViewPanel',
			'Test1.view.reportui.ReportViewController' ,
			'Test1.view.fw.MainDataPointPanel',
			'Test1.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
