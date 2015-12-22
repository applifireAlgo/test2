Ext.define('Test1.view.mobileview.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Test1.view.mobileview.reportui.datachart.DataChartTController',
			'Test1.view.mobileview.reportui.datachart.datagrid.DataGridView','Test1.view.mobileview.reportui.datachart.chart.ChartTabView','Test1.view.mobileview.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	initComponent : function() {
		/*this.items */

		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});