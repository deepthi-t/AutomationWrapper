package com.liberate.automation.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
import com.liberate.automation.common.CommonPanel;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.AllocateRouteServiceOrder;
import com.liberate.automation.pom.BrowseServiceOrder;
import com.liberate.automation.pom.MSOAddRemoveServiceCharge;
import com.liberate.automation.pom.MSOAddSpecialInstructions;
import com.liberate.automation.pom.MSOAssign;
import com.liberate.automation.pom.MSOCancelServiceOrder;
import com.liberate.automation.pom.MSOEnquiry;
import com.liberate.automation.pom.MSOManualWaitlistRelease;
import com.liberate.automation.pom.MSORedirect;
import com.liberate.automation.pom.MSOReject;
import com.liberate.automation.pom.MSORelease;
import com.liberate.automation.pom.MSOSignoff;
import com.liberate.automation.pom.MSOSplit;
import com.liberate.automation.pom.MSOSuspend;
import com.liberate.automation.pom.MSOWaitlist;

public class ManageServiceOrder {
	static TestActions action = CommonLogin.action;

	@Test
	public static void soEnquiry() {
		String TestCase = "ManageServiceOrder_soEnquiry";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOEnquiry msr = new MSOEnquiry(action);
		String serviceOrderNumber = "A00071A";

		msr.navigate();
		action.getScreenShot(TestCase);
		msr.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot(TestCase);
		msr.verifyServiceOrderDetails(serviceOrderNumber);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void addSpecialInstructions() {
		String TestCase = "ManageServiceOrder_addSpecialInstructions";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOAddSpecialInstructions mso = new MSOAddSpecialInstructions(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		String serviceOrderNumber = "A00071A";

		action.getScreenShot(TestCase);
		mso.navigate();
		action.getScreenShot(TestCase);
		mso.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot(TestCase);
		mso.verifyServiceOrderDetails();
		action.getScreenShot(TestCase);
		mso.addSpecialInstruction();
		action.getScreenShot(TestCase);
		mso.clickOnOKpopup();
		action.getScreenShot(TestCase);

		mse.navigate();
		action.getScreenShot(TestCase);
		mse.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot(TestCase);
		mse.verifyServiceOrderDetails(serviceOrderNumber);
		action.getScreenShot(TestCase);
		mse.verifySepcialInstructions(mso.SpecialInstruction);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void addServiceCharge() {
		String TestCase = "ManageServiceOrder_addServiceCharge";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "WH00477";

		msr.navigate();
		action.getScreenShot(TestCase);
		msr.searchServiceOrder("RSNET", serviceOrderNumber);
		action.getScreenShot(TestCase);
		msr.verifyServiceOrderDetails();
		action.getScreenShot(TestCase);
		msr.addServiceCharge();
		action.getScreenShot(TestCase);
		msr.verifyServiceCharge(msr.ServiceCharge, true);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void removeServiceCharge() {
		String TestCase = "ManageServiceOrder_removeServiceCharge";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "WH00477";

		msr.navigate();
		action.getScreenShot(TestCase);
		msr.searchServiceOrder("RSNET", serviceOrderNumber);
		action.getScreenShot(TestCase);
		msr.verifyServiceOrderDetails();
		action.getScreenShot(TestCase);
		msr.deleteServiceCharge();
		action.getScreenShot(TestCase);
		msr.verifyServiceCharge(msr.ServiceCharge, false);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void cancelServiceOrder() {
		String TestCase = "ManageServiceOrder_cancelServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOCancelServiceOrder msc = new MSOCancelServiceOrder(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		msc.navigate();
		action.getScreenShot(TestCase);
		msc.searchServiceOrder("", "");
		action.getScreenShot(TestCase);
		msc.verifyServiceOrdeDetails(msc.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		msc.cancelServiceOrder();
		action.getScreenShot(TestCase);
		msc.clickOnOKButton();
		action.getScreenShot(TestCase);

		mse.navigate();
		action.getScreenShot(TestCase);
		mse.searchServiceOrder(msc.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mse.verifyDepartmentCirculation();
		action.getScreenShot(TestCase);
		mse.getCurrentServiceOrderStatus();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void generalSignOffServiceOrder() {
		String TestCase = "ManageServiceOrder_generalSignOffServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("BGINS", "WI00720");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.generalSignOff();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void accountSignOffServiceOrder() {
		String TestCase = "ManageServiceOrder_accountSignOffServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("AQSOF", "ZF00009");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.accountSignOff();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void rejectServiceOrder() {
		String TestCase = "ManageServiceOrder_rejectServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOReject mss = new MSOReject(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("BGSOF", "ZG00127");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.reject();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void releaseServiceOrder() {
		String TestCase = "ManageServiceOrder_releaseServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSORelease mss = new MSORelease(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("AQSOF", "A00173B");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.releaseServiceOrder();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void waitlistServiceOrder() {
		String TestCase = "ManageServiceOrder_waitlistServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOWaitlist mss = new MSOWaitlist(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("AQSOF", "YC00265");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.waitlistServiceOrder();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void manualWaitlistReleaseServiceOrder() {
		String TestCase = "ManageServiceOrder_manualWaitlistReleaseServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOManualWaitlistRelease mss = new MSOManualWaitlistRelease(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("RSNET", "ZC00213");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.manualWaitlistRelease();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void suspendSeviceOrder() {
		String TestCase = "ManageServiceOrder_suspendSeviceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOSuspend mss = new MSOSuspend(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("AQSOF", "YE00194");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.suspendServiceOrder();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void splitServiceOrder() {
		String TestCase = "ManageServiceOrder_splitServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOSplit mss = new MSOSplit(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("CRCL", "WI00204");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.splitServiceOrder();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void assignServiceOrder() {
		String TestCase = "ManageServiceOrder_assignServiceOrder";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOAssign mss = new MSOAssign(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("RSNET", "ZA00103");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.assignServiceOrder();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void browseSO() {
		String TestCase = "ManageServiceOrder_browseSO";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		BrowseServiceOrder mss = new BrowseServiceOrder(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("RSNET", "ZA00103");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void redirectSO() {
		String TestCase = "ManageServiceOrder_redirectSO";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSORedirect mss = new MSORedirect(action);

		mss.navigate();
		action.getScreenShot(TestCase);
		mss.searchServiceOrder("BGCNG", "WI00650");
		action.getScreenShot(TestCase);
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot(TestCase);
		mss.redirectServiceOrder();
		action.getScreenShot(TestCase);
		mss.validateMessage();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void allocateCopperRoute() {
		String TestCase = "ManageServiceOrder_allocateCopperRoute";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot(TestCase);
		arso.searchServiceOrder("BGNET", "A00528F");
		action.getScreenShot(TestCase);
		arso.allocateAuto(CommonData.PlantItemType.CopperDP, "DP100");
		action.getScreenShot(TestCase);
		arso.verifyAutoAllocateRoute();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test
	public static void allocateFiberRoute() {
		String TestCase = "ManageServiceOrder_allocateFiberRoute";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot(TestCase);
		arso.searchServiceOrder("BGNET", "A00528F");
		action.getScreenShot(TestCase);
		arso.allocateAuto(CommonData.PlantItemType.FiberDP, "FDP2");
		action.getScreenShot(TestCase);
		arso.verifyAutoAllocateRoute();
		action.getScreenShot(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	public static void signOffCompletely(String ServiceOrder) {
		String TestCase = "ManageServiceOrder_signOffCompletely";

		List<String> Department = new ArrayList<String>();
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		MSOEnquiry enquiry = new MSOEnquiry(action);
		MSOSignoff signoff = new MSOSignoff(action);

		enquiry.navigate();
		enquiry.searchServiceOrder(ServiceOrder);
		enquiry.verifyDepartmentCirculation();
		Department = enquiry.getCurrentDepartments();

		signoff.navigate();
		for (int i = 0; i < Department.size(); i++) {
			CommonPanel.ServiceOrder.Search(action, Department.get(i), ServiceOrder);
			signoff.accountSignOff();
		}
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}
}
