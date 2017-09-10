package testSuites.ipms.riskmanagement;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.riskmanagement.RiskManagementPage;

public class RiskManagement extends TestBase{
	LoginPage loginPage;
	RiskManagement riskManagement;
	RiskManagementPage riskManagementPage;
	
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			riskManagementPage= new RiskManagementPage(driver);
			
	}
	@Test(dataProvider="getData", description="1.1 Admin Login Test Case for IPMS")
	public void loginIPMS(String fullName, String password,String userType) throws InterruptedException {
		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clicksubmit();
		log.debug("Clicked submit button");
		System.out.println("User Type : "+loginPage.getAdminName());
		Assert.assertEquals(userType,loginPage.getAdminName());
		Thread.sleep(2000);
	}
	@Test(dataProvider="getData", description="1.7 Add Risk, Upload Risks and View Risks of Risk Management in Dashboard")
	public void riskManagement(String addRisk, String uploadRisks, String viewRisks){
			Assert.assertTrue(riskManagementPage.isCheckAndClickAddRiskManagment(addRisk));
			String uploadrisks;
			Assert.assertTrue(riskManagementPage.isCheckAndClickUploadRisksManagment(uploadRisks));
			Assert.assertTrue(riskManagementPage.isCheckAndClickViewRisksManagment(viewRisks));
	}
}
