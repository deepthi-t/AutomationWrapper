package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.ADMaintainEmployee;
import com.liberate.automation.pom.ADManageUser;

public class UserManagementTC {
	static TestActions action = CommonLogin.action;

	@Test
	public static void amendUser() {
		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot("amendUser");
		adm.searchByUserName("ASDASEXC.DSFSDFSDF");
		action.getScreenShot("amendUser");
		adm.amendUser();
		action.getScreenShot("amendUser");
		adm.verifyUserDetails();
		action.getScreenShot("amendUser");
	}

	@Test
	public static void deleteUser() {
		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot("deleteUser");
		adm.searchByUserName("COM3_CRUSHER");
		action.getScreenShot("deleteUser");
		adm.deleteUser();
		action.getScreenShot("deleteUser");
		adm.verifyDelete();
		action.getScreenShot("deleteUser");
	}

	@Test
	public static void copyUser() {
		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot("copyUser");
		adm.searchByUserName("ASDASEXC.DSFSDFSDF");
		action.getScreenShot("copyUser");
		adm.copyUser("99999");
		action.getScreenShot("copyUser");
		adm.verifyCopyUser();
		action.getScreenShot("copyUser");
		adm.verifyUserDetails();
		action.getScreenShot("copyUser");
	}

	@Test
	public static void createUser() {
		ADManageUser adm = new ADManageUser(action);
		ADMaintainEmployee ade = new ADMaintainEmployee(action);

		ade.navigate();
		ade.searchWithStaffNumber("999908");
		ade.createNewEmployee();

		adm.navigate();
		action.getScreenShot("createUser");
		adm.searchByUserName("");
		action.getScreenShot("createUser");
		adm.createUser(ade.EmployeeID, ade.VMSUserName);
		action.getScreenShot("createUser");
		adm.verifyUserDetails();
		action.getScreenShot("createUser");
	}
}
