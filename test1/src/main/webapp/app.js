/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Test1',

    extend: 'Test1.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Test1.view.mainleftmenutree.MainPanel':'Test1.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Test1.view.login.LoginPage':'Test1.view.mobileview.login.LoginPage',//'Test1.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Test1.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
