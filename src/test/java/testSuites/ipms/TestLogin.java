package testSuites.ipms;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.TestBase;
import pageObjects.ipms.LoginPage;

public class TestLogin extends TestBase {
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);
		loginPage.open();
		log.debug("Navigated to Sign In Page");
	}
	
	@Test(dataProvider="getData", description="1.1 Admin Login Test Case for IPMS")
	public void loginIPMS(String fullName, String password,String userType) throws InterruptedException {

		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clickSubmit();
		log.debug("Clicked submit button");
		Thread.sleep(5000);
		System.out.println("User Type : "+loginPage.getAdminName());
		Assert.assertEquals(userType,loginPage.getAdminName());
		
	}
}
