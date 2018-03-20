package com.liberate.automation.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.liberate.automation.core.ReportGenerator;
import com.liberate.automation.core.TestActions;
import com.liberate.automation.core.TestData;
import com.liberate.automation.pom.ADMaintainEmployee;
import com.liberate.automation.pom.ADManageUser;

public class UserManagementTC {
	static TestActions action = CommonLogin.action;

	static String employeeUserName = "";
	static String newUserID = "";

	@BeforeClass
	public static void loadData() {
		employeeUserName = TestData.employeeUserName;
		newUserID = TestData.newUserID;
	}

	@Test(priority = 1)
	public static void amendUser() {
		String TestCase = "UserManagementTC_amendUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(TestCase);
		adm.amendUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 2)
	public static void copyUser() {
		String TestCase = "UserManagementTC_copyUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName(employeeUserName);
		action.getScreenShot(TestCase);
		adm.copyUser("99999");
		action.getScreenShot(TestCase);
		adm.verifyCopyUser();
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 3)
	public static void createUser() {
		String TestCase = "UserManagementTC_createUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ADManageUser adm = new ADManageUser(action);
		ADMaintainEmployee ade = new ADMaintainEmployee(action);

		ade.navigate();
		ade.searchWithStaffNumber(newUserID);
		ade.createNewEmployee();

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserName("");
		action.getScreenShot(TestCase);
		adm.createUser(ade.EmployeeID, ade.VMSUserName);
		action.getScreenShot(TestCase);
		adm.verifyUserDetails();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

	@Test(priority = 4)
	public static void deleteUser() {
		String TestCase = "UserManagementTC_deleteUser";
		action.log("*****STARTING '" + TestCase + "' EXECUTION*****");

		ADManageUser adm = new ADManageUser(action);

		adm.navigate();
		action.getScreenShot(TestCase);
		adm.searchByUserIS(newUserID);
		action.getScreenShot(TestCase);
		adm.deleteUser();
		action.getScreenShot(TestCase);
		adm.verifyDelete();
		action.getScreenShot(TestCase);

		ReportGenerator.generateReport(TestCase);
		action.log("*****ENDING '" + TestCase + "' EXECUTION***** \n");
	}

}
