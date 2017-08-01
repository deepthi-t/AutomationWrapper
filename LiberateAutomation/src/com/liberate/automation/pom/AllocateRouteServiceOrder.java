package com.liberate.automation.pom;

import org.openqa.selenium.By;

public class AllocateRouteServiceOrder {
	//Main header
By Orders = By.xpath("//*[@class = 'headermenu_row']/div[1]/div[3]/a"); 
//sub heading
By  Route_Maintenance = By.xpath("//*[text ( ) = 'Route Maintenance']");
//left navigation menu
By AllocateRouteServiceOrder = By.xpath("//*[@class = 'leftmenu']/div[1]/div[2]/a");
//search panel
By Change_department = By.xpath("//*[@value = 'Change']");// change button
By Departmentselect = By.xpath("//*[text ( ) = 'Department:']/following::select]"); //  Department select button 

//Service order list panel
By ServiceOrderList = By.xpath("//*[text ( ) = 'Service Order List']");
By Exchangeinputfield = By.xpath("//*[text ( ) = 'Service Order List']/following::input[4]");//enter BOT value to it
By FirstServiceOrderNumber = By.xpath("//*[text ( ) = 'Service Order List']/following::td[2]");//click on service order number-first one

//Route Allocation page

By AllocateAuto = By.xpath("//*[text ( ) = 'Allocate Auto']");

//Allocate Route - Auto

By ExchangeArea = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[1]");
By PlantItemType = By.xpath("//*[text ( ) = 'Exchange Area :']/following::select[2]");
By PlantItemNo = By.xpath("//*[text ( ) = 'Plant Item No:']/following::input[1]");
By AcceptButton = By.xpath("//*[@value = 'Accept']");




}
