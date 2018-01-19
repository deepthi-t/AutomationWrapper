package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.common.CommonData;
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
	public void soEnquiry() {
		MSOEnquiry msr = new MSOEnquiry(action);
		String serviceOrderNumber = "A00071A";

		msr.navigate();
		action.getScreenShot("soEnquiry");
		msr.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot("soEnquiry");
		msr.verifyServiceOrderDetails(serviceOrderNumber);
		action.getScreenShot("soEnquiry");
	}

	@Test
	public void addSpecialInstructions() {
		MSOAddSpecialInstructions mso = new MSOAddSpecialInstructions(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		String serviceOrderNumber = "A00071A";

		action.getScreenShot("addSpecialInstructions");
		mso.navigate();
		action.getScreenShot("addSpecialInstructions");
		mso.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mso.verifyServiceOrderDetails();
		action.getScreenShot("addSpecialInstructions");
		mso.addSpecialInstruction();
		action.getScreenShot("addSpecialInstructions");
		mso.clickOnOKpopup();
		action.getScreenShot("addSpecialInstructions");

		mse.navigate();
		action.getScreenShot("addSpecialInstructions");
		mse.searchServiceOrder(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mse.verifyServiceOrderDetails(serviceOrderNumber);
		action.getScreenShot("addSpecialInstructions");
		mse.verifySepcialInstructions(mso.SpecialInstruction);
		action.getScreenShot("addSpecialInstructions");
	}

	@Test
	public void addServiceCharge() {
		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "WH00477";

		msr.navigate();
		action.getScreenShot("addServiceCharge");
		msr.searchServiceOrder("RSNET", serviceOrderNumber);
		action.getScreenShot("addServiceCharge");
		msr.verifyServiceOrderDetails();
		action.getScreenShot("addServiceCharge");
		msr.addServiceCharge();
		action.getScreenShot("addServiceCharge");
		msr.verifyServiceCharge(msr.ServiceCharge, true);
		action.getScreenShot("addServiceCharge");
	}

	@Test
	public void removeServiceCharge() {
		MSOAddRemoveServiceCharge msr = new MSOAddRemoveServiceCharge(action);
		String serviceOrderNumber = "WH00477";

		msr.navigate();
		action.getScreenShot("removeServiceCharge");
		msr.searchServiceOrder("RSNET", serviceOrderNumber);
		action.getScreenShot("removeServiceCharge");
		msr.verifyServiceOrderDetails();
		action.getScreenShot("removeServiceCharge");
		msr.deleteServiceCharge();
		action.getScreenShot("removeServiceCharge");
		msr.verifyServiceCharge(msr.ServiceCharge, false);
		action.getScreenShot("removeServiceCharge");
	}

	@Test
	public void cancelServiceOrder() {
		MSOCancelServiceOrder msc = new MSOCancelServiceOrder(action);
		MSOEnquiry mse = new MSOEnquiry(action);

		msc.navigate();
		action.getScreenShot("cancelServiceOrder");
		msc.searchServiceOrder("", "");
		action.getScreenShot("cancelServiceOrder");
		msc.verifyServiceOrdeDetails(msc.ServiceOrderNumber);
		action.getScreenShot("cancelServiceOrder");
		msc.cancelServiceOrder();
		action.getScreenShot("cancelServiceOrder");
		msc.clickOnOKButton();
		action.getScreenShot("cancelServiceOrder");

		mse.navigate();
		action.getScreenShot("cancelServiceOrder");
		mse.searchServiceOrder(msc.ServiceOrderNumber);
		action.getScreenShot("cancelServiceOrder");
		mse.verifyDepartmentCirculation();
		action.getScreenShot("cancelServiceOrder");
		mse.getCurrentServiceOrderStatus();
		action.getScreenShot("cancelServiceOrder");
	}

	@Test
	public void generalSignOffServiceOrder() {
		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot("generalSignOffServiceOrder");
		mss.searchServiceOrder("BGINS", "WI00720");
		action.getScreenShot("generalSignOffServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("generalSignOffServiceOrder");
		mss.generalSignOff();
		action.getScreenShot("generalSignOffServiceOrder");
	}

	@Test
	public void accountSignOffServiceOrder() {
		MSOSignoff mss = new MSOSignoff(action);

		mss.navigate();
		action.getScreenShot("accountSignOffServiceOrder");
		mss.searchServiceOrder("AQSOF", "ZF00009");
		action.getScreenShot("accountSignOffServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("accountSignOffServiceOrder");
		mss.accountSignOff();
		action.getScreenShot("accountSignOffServiceOrder");
	}

	@Test
	public void rejectServiceOrder() {
		MSOReject mss = new MSOReject(action);

		mss.navigate();
		action.getScreenShot("rejectServiceOrder");
		mss.searchServiceOrder("BGSOF", "ZG00127");
		action.getScreenShot("rejectServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("rejectServiceOrder");
		mss.reject();
		action.getScreenShot("rejectServiceOrder");
	}

	@Test
	public void releaseServiceOrder() {
		MSORelease mss = new MSORelease(action);

		mss.navigate();
		action.getScreenShot("releaseServiceOrder");
		mss.searchServiceOrder("AQSOF", "A00173B");
		action.getScreenShot("releaseServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("releaseServiceOrder");
		mss.releaseServiceOrder();
		action.getScreenShot("releaseServiceOrder");
	}

	@Test
	public void waitlistServiceOrder() {
		MSOWaitlist mss = new MSOWaitlist(action);

		mss.navigate();
		action.getScreenShot("waitlistServiceOrder");
		mss.searchServiceOrder("AQSOF", "YC00265");
		action.getScreenShot("waitlistServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("waitlistServiceOrder");
		mss.waitlistServiceOrder();
		action.getScreenShot("waitlistServiceOrder");
	}

	@Test
	public void manualWaitlistReleaseServiceOrder() {
		MSOManualWaitlistRelease mss = new MSOManualWaitlistRelease(action);

		mss.navigate();
		action.getScreenShot("manualWaitlistReleaseServiceOrder");
		mss.searchServiceOrder("RSNET", "ZC00213");
		action.getScreenShot("manualWaitlistReleaseServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("manualWaitlistReleaseServiceOrder");
		mss.manualWaitlistRelease();
		action.getScreenShot("manualWaitlistReleaseServiceOrder");
	}

	@Test
	public void suspendSeviceOrder() {
		MSOSuspend mss = new MSOSuspend(action);

		mss.navigate();
		action.getScreenShot("suspendSeviceOrder");
		mss.searchServiceOrder("AQSOF", "YE00194");
		action.getScreenShot("suspendSeviceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("suspendSeviceOrder");
		mss.suspendServiceOrder();
		action.getScreenShot("suspendSeviceOrder");
	}

	@Test
	public void splitServiceOrder() {
		MSOSplit mss = new MSOSplit(action);

		mss.navigate();
		action.getScreenShot("splitServiceOrder");
		mss.searchServiceOrder("CRCL", "WI00204");
		action.getScreenShot("splitServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("splitServiceOrder");
		mss.splitServiceOrder();
		action.getScreenShot("splitServiceOrder");
	}

	@Test
	public void assignServiceOrder() {
		MSOAssign mss = new MSOAssign(action);

		mss.navigate();
		action.getScreenShot("assignServiceOrder");
		mss.searchServiceOrder("RSNET", "ZA00103");
		action.getScreenShot("assignServiceOrder");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("assignServiceOrder");
		mss.assignServiceOrder();
		action.getScreenShot("assignServiceOrder");
	}

	@Test
	public void browseSO() {
		BrowseServiceOrder mss = new BrowseServiceOrder(action);

		mss.navigate();
		action.getScreenShot("browseSO");
		mss.searchServiceOrder("RSNET", "ZA00103");
		action.getScreenShot("browseSO");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("browseSO");
	}

	@Test
	public void redirectSO() {
		MSORedirect mss = new MSORedirect(action);

		mss.navigate();
		action.getScreenShot("redirectSO");
		mss.searchServiceOrder("BGCNG", "WI00650");
		action.getScreenShot("redirectSO");
		mss.verifyServiceOrdeDetails(mss.ServiceOrderNumber);
		action.getScreenShot("redirectSO");
		mss.redirectServiceOrder();
		action.getScreenShot("redirectSO");
		mss.validateMessage();
		action.getScreenShot("redirectSO");
	}

	@Test
	public void allocateCopperRoute() {
		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot("allocateCopperRoute");
		arso.searchServiceOrder("BGNET", "A00528F");
		action.getScreenShot("allocateCopperRoute");
		arso.allocateAuto(CommonData.PlantItemType.CopperDP, "DP100");
		action.getScreenShot("allocateCopperRoute");
		arso.verifyAutoAllocateRoute();
		action.getScreenShot("allocateCopperRoute");
	}
	
	@Test
	public void allocateFiberRoute() {
		AllocateRouteServiceOrder arso = new AllocateRouteServiceOrder(action);

		arso.navigate();
		action.getScreenShot("allocateFiberRoute");
		arso.searchServiceOrder("BGNET", "A00528F");
		action.getScreenShot("allocateFiberRoute");
		arso.allocateAuto(CommonData.PlantItemType.FiberDP, "FDP2");
		action.getScreenShot("allocateFiberRoute");
		arso.verifyAutoAllocateRoute();
		action.getScreenShot("allocateFiberRoute");
	}
}
