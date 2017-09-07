package testSuites.ipms.dashboards;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.dashboard.horizontal.HorizontalPage;

public class HorizontalGroups extends TestBase{

	HorizontalPage horizontalPage;
	HorizontalGroups horizontalGroups;
	
	@BeforeMethod
	public void testSetUp() {
		horizontalPage = new HorizontalPage(driver);
		log.debug("Clicking on the Horizontal Groups submenu in dashboard");
	}
	
	@Test(dataProvider="getData", description="1.3 Clicking on the Horizontal Groups submenu in dashboard")
	public void dashboardHorizontalGroups(String submenuTitle, String innerSubmenuTitle,
			String groupNameBusinessPath, String groupNameLearningAndDiffusionGroupPath,
			String groupNamePolicyAndProgramsPath, String groupNameResearchPath) throws InterruptedException {
		// Check the Horizontal Groups title in dashboard
		Assert.assertEquals(submenuTitle.trim(), horizontalPage.getHorizontalGroupsSubmenuTitle());
		// Click on the Horizontal Submenu
		horizontalPage.clickOnHorizontalSubmenu();
		Assert.assertTrue(horizontalPage.isHorizontalGroupsSubmenuPageTitle(submenuTitle.trim()));
		// Check Submenu Title
		Assert.assertTrue(horizontalPage.isHorizontalGroupsSubmenuPageSubTitle(innerSubmenuTitle.trim()));
		// Checking the Business image available or not
		Assert.assertTrue(horizontalPage.isGroupNameBusiness(groupNameBusinessPath.trim()));
		//Checking Group Name Learning And Diffusion Group Path
		Assert.assertTrue(horizontalPage.isGroupNameLearningAndDiffusionGroup(groupNameLearningAndDiffusionGroupPath.trim()));
		//Checking the Group Name Policy And Programs Path
		Assert.assertTrue(horizontalPage.isGroupNamePolicyAndPrograms(groupNamePolicyAndProgramsPath.trim()));
		//Checking the Group Name Research Path
		Assert.assertTrue(horizontalPage.isGroupNameResearch(groupNameResearchPath.trim()));
	}
}
