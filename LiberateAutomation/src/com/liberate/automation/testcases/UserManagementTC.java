package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.ADMaintainEmployee;
import com.liberate.automation.pom.ADManageUser;

public class UserManagementTC {
	static TestActions action = CommonLogin.action;

	@Test
	public static void amendUser() {
		String TestCase = "UserManagementTC_amendUser";

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("ASDASEXC.DSFSDFSDF");
		action.getScreenShot(TestCase);
		adm.amendUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void deleteUser() {
		String TestCase = "UserManagementTC_deleteUser";

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("COM3_CRUSHER");
		action.getScreenShot(TestCase);
		adm.deleteUser();
		action.getScreenShot(TestCase);
		adm.verifyDelete();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void copyUser() {
		String TestCase = "UserManagementTC_copyUser";

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("ASDASEXC.DSFSDFSDF");
		action.getScreenShot(TestCase);
		adm.copyUser("99999");
		action.getScreenShot(TestCase);
		adm.verifyCopyUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);
	}

	@Test
	public static void createUser() {
		String TestCase = "UserManagementTC_createUser";

		ADManageUser adm = new ADManageUser(action);
		ADMaintainEmployee ade = new ADMaintainEmployee(action);

		ade.navigate();
		ade.searchWithStaffNumber("999908");
		ade.createNewEmployee();

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("");
		action.getScreenShot(TestCase);
		adm.createUser(ade.EmployeeID, ade.VMSUserName);
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);
	}
}
