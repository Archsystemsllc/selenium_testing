package testSuites.ipms.artifactsmanager;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.artifactsmanager.ArtifactsManagerPage;
import pageObjects.ipms.msprojectintegration.MSProjectIntegrationPage;

public class CheckArtifactsManager extends TestBase {
	LoginPage loginPage;
	ArtifactsManagerPage artifactsManagerPage;
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);
		artifactsManagerPage = new ArtifactsManagerPage(driver);
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
	@Test(priority=2,dataProvider="getData", description="1.10 Checks  Artifacts Manager in dashboard")
	public void checkArtifactsManager(String  artifactsManagerTitle) throws InterruptedException {
		log.debug("The MS Project Integration Excel is "+artifactsManagerTitle);
		String artifactsManagerTitleElementValue = artifactsManagerPage.getArtifactsManagerPageSubmenu();
		log.debug("The MS Project Integration value is "+artifactsManagerTitleElementValue);
		Assert.assertEquals(artifactsManagerTitle, artifactsManagerTitleElementValue);
	}

}
