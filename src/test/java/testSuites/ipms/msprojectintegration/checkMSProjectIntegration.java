package testSuites.ipms.msprojectintegration;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.msprojectintegration.MSProjectIntegrationPage;

public class checkMSProjectIntegration extends TestBase {
	LoginPage loginPage;
	MSProjectIntegrationPage msProjectIntegrationPage;
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);
		msProjectIntegrationPage = new MSProjectIntegrationPage(driver);
		log.debug("Checking the Sharepoint submenu in dashboard");
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
	@Test(priority=2,dataProvider="getData", description="1.2 Checks the Sharepoint Submenu in dashboard")
	public void checkMSProjectIntegration(String msProjectIntegrationTitle) throws InterruptedException {
		log.debug("The MS Project Integration Excel is "+msProjectIntegrationTitle);
		String msProjectIntegrationElementValue = msProjectIntegrationPage.getmsProjectIntegrationSubmenu();
		log.debug("The MS Project Integration value is "+msProjectIntegrationElementValue);
		Assert.assertEquals(msProjectIntegrationTitle, msProjectIntegrationElementValue);
	}

}
