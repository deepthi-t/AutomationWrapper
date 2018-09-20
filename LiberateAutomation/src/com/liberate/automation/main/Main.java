package com.liberate.automation.main;

import com.liberate.automation.testcases.AlterLineProductTC;
import com.liberate.automation.testcases.BulkSOProcessingTC;
import com.liberate.automation.testcases.CeaseMultipleServicesTC;
import com.liberate.automation.testcases.CloneServiceTC;
import com.liberate.automation.testcases.CommonLogin;
import com.liberate.automation.testcases.ComverseTC;
import com.liberate.automation.testcases.CustomerCareTC;
import com.liberate.automation.testcases.LimeLiteProvisioningTC;
import com.liberate.automation.testcases.ManageServiceOrderTC;
import com.liberate.automation.testcases.POSPaymentTC;
import com.liberate.automation.testcases.PaymentEnquiriesTC;
import com.liberate.automation.testcases.QueryManagementTC;
import com.liberate.automation.testcases.SanityTestCases;
import com.liberate.automation.testcases.ServiceProvisioningTC;
import com.liberate.automation.testcases.TransferProductTC;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		CommonLogin.login();
		//SanityTestCases.sanityReports_Test();
		//ServiceProvisioningTC.newCustomerPCLPostpaid();
		//ServiceProvisioningTC.newCustomerPCLCreditLimit();
		//ComverseTC.addNewAccountOffer();
		//CeaseMultipleServicesTC.testmultiplecease();
		//BulkSOProcessingTC.bulkGeneralSignOff();
		//CloneServiceTC.cloneService();
		//CustomerCareTC.createSubAccount();
		//PaymentEnquiriesTC.searchAccountNumber();
		//TransferProductTC.transferProduct();
		//POSPaymentTC.posPayment();
		//CeaseMultipleServicesTC.testmultiplecease();
		AlterLineProductTC.alterProducts();
		ManageServiceOrderTC.accountSignOffServiceOrder();
		
	}

	public void test() {

	}
}