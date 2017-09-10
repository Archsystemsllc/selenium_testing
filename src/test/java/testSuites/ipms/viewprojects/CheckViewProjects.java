package testSuites.ipms.viewprojects;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.artifactsmanager.ArtifactsManagerPage;
import pageObjects.ipms.msprojectintegration.MSProjectIntegrationPage;
import pageObjects.ipms.viewprojects.ViewProjectsPage;

public class CheckViewProjects extends TestBase {
	LoginPage loginPage;
	ViewProjectsPage viewProjectsPage;
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);
		viewProjectsPage = new ViewProjectsPage(driver);
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
	@Test(priority=2,dataProvider="getData", description="1.11 Checking View Projects in dashboard")
	public void checkViewProjects(String  viewProjectsTitle) throws InterruptedException {
		log.debug("The View Projects Excel is "+viewProjectsTitle);
		String viewProjectsSubmenuValue = viewProjectsPage.getViewProjectsPageSubmenu();
		log.debug("The View Projects value is "+viewProjectsSubmenuValue);
		Assert.assertEquals(viewProjectsTitle, viewProjectsSubmenuValue);
	}

}
