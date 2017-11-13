package com.liberate.automation.testcases;
import static org.testng.Assert.assertEquals;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.Login;
import com.liberate.automation.pom.VoidPayment;


public class VoidPayment_tc {

	
	TestActions action = null ;
	

    public VoidPayment_tc(TestActions action) {
		// TODO Auto-generated constructor stub
    	this.action = action;
    }


	public void navigateToURL()
    {
                    action.gotoURL("http://172.21.73.80:8081/liberate-LONI01-S10/");
    }

    
    public void newVoidPaymentSearch()
    {
    	VoidPayment vp = new VoidPayment(action);
    	 Login login = new Login(action);

         assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
         action.getScreenShot("VoidPayment");
         assertEquals(vp.navigate(),true);
         action.getScreenShot("VoidPayment");
         assertEquals(vp.PaymentNumber("9320140"),true);
         action.getScreenShot("VoidPayment");
         assertEquals(vp.Search(),true);
         action.getScreenShot("VoidPayment");
         assertEquals(vp.EnterVoidReason("3"),true);
         assertEquals(vp.Accept(),true);
         action.getScreenShot("VoidPayment");
    }
    
    
    public void newVoidPaymentReset(){
    	VoidPayment vp = new VoidPayment(action);
   	 Login login = new Login(action);

        assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
        action.getScreenShot("VoidPayment");
        assertEquals(vp.navigate(),true);
        action.getScreenShot("VoidPayment");
        assertEquals(vp.PaymentNumber("9879899"),true);
        action.getScreenShot("VoidPayment");
        assertEquals(vp.Reset(),true);
        action.getScreenShot("VoidPayment");
    	
    }
    
    public void newVoidPaymentCancel(){
    
    VoidPayment vp = new VoidPayment(action);
	 Login login = new Login(action);

    assertEquals(login.login("libadmin", "Ic3cr34m!"),true);
    action.getScreenShot("VoidPayment");
    assertEquals(vp.navigate(),true);
    action.getScreenShot("VoidPayment");
    assertEquals(vp.PaymentNumber("9879899"),true);
    action.getScreenShot("VoidPayment");
    assertEquals(vp.Search(),true);
    action.getScreenShot("VoidPayment");
    assertEquals(vp.Cancel(),true);
    action.getScreenShot("VoidPayment");
    }
    
}

          
           
          