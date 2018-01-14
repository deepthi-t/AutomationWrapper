package com.liberate.automation.pom;

import org.openqa.selenium.By;

import com.liberate.automation.common.LiberateCommon;
import com.liberate.automation.core.TestActions;

public class Login {
	TestActions action = null;

	// Page Elements : Failure Queries
	By UserName = By.xpath("//*[@id='login:userName']");
	By PassWord = By.xpath("//*[@id='login:userPassword']");
	By LoginButton = By.xpath("//*[@id='login:loginButtonImg']");
	
	By LiberateFrame = By.xpath("//iframe[@id='liberate']");
	
	public Login(TestActions action) {
		this.action = action;
	}

	public boolean login(String username, String password) {
		boolean passed = false;

		if (action.countOf(LiberateCommon.LevelOne.Home) > 0)
			return true;

		passed = action.sendDataTo(UserName, username);
		passed = action.sendDataTo(PassWord, password);
		passed = action.clickOn(LoginButton);
		passed = action.waitFor(LoginButton, 5, false);
		
		if(action.countOf(LiberateFrame)>0)
		{
			action.switchToFrame(LiberateFrame);
		}
		
		passed = action.waitFor(LiberateCommon.LevelOne.Home, 4, true);
		
		return passed;
	}
}
