Ext.define('Test1.view.databrowsercalendar.DBCalendar', {
	extend : 'Test1.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Test1.view.databrowsercalendar.DBCalendarController',
	             'Test1.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
