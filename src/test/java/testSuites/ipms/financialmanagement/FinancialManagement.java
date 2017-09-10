package testSuites.ipms.financialmanagement;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.financialmanagement.FinancialManagementPage;

public class FinancialManagement extends TestBase{
	LoginPage loginPage;
	FinancialManagementPage financialManagementPage;
	FinancialManagement finacialManagement;
	
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			financialManagementPage = new FinancialManagementPage(driver);
	}
	@Test(priority=1,dataProvider="getData", description="1.1 Admin Login Test Case for IPMS")
	public void loginIPMS(String fullName, String password,String userType) throws InterruptedException {
		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clickSubmit();
		log.debug("Clicked submit button");
		System.out.println("User Type : "+loginPage.getAdminName());
		Assert.assertEquals(userType,loginPage.getAdminName());
		Thread.sleep(2000);
	}
	@Test(priority=2,dataProvider="getData", description="1.5 EVM Upload, Financial Report and EVM Metrics of Financial Management in Dashboard")
	public void finacialManagement(String evmUploadTitle, String finacialReportTitle, String evmMetricsTitle ){
			Assert.assertTrue(financialManagementPage.isCheckAndClickEVMUpload(evmUploadTitle));
			Assert.assertTrue(financialManagementPage.isCheckAndClickFinacialReport(finacialReportTitle));
			Assert.assertTrue(financialManagementPage.isCheckAndClickEVMMetrics(evmMetricsTitle));
	}
}
