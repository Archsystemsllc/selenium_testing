package testSuites.ipms.sharepoint;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

import pageObjects.ipms.sharepoint.CheckSharePointSubmenuPage;
import testSuites.ipms.TestLogin;

public class CheckSharepointSubmenuTitle extends TestBase {
	CheckSharePointSubmenuPage sharePointSubmenuPage;
	TestLogin loginAdmin;
	@BeforeMethod
	public void testSetUp() {
		sharePointSubmenuPage = new CheckSharePointSubmenuPage(driver);
		log.debug("Checking the Sharepoint submenu in dashboard");
	}
	
	@Test(dataProvider="getData", description="1.2 Checks the Sharepoint Submenu in dashboard")
	public void checkSharePointSubmenuTitle(String submenuTitleName) throws InterruptedException {
		log.debug("The sharepoint Excel is "+submenuTitleName);
		String sharePointSubmenuTitle = sharePointSubmenuPage.getSharePointSubmenu();
		log.debug("The sharepoint value is "+sharePointSubmenuTitle);
		Assert.assertEquals(submenuTitleName, sharePointSubmenuTitle);
	}

}
