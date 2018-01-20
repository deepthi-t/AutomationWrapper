package com.liberate.automation.testcases;

import org.testng.annotations.Test;

import com.liberate.automation.core.TestActions;
import com.liberate.automation.pom.ADManageUser;

public class UserManagementTC {
	static TestActions action = CommonLogin.action;

	@Test
	public void amendUser() {
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
	public void deleteUser() {
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
	public void copyUser() {
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
}
