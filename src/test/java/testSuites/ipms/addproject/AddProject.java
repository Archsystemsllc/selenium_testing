package testSuites.ipms.addproject;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.addproject.AddProjectPage;


public class AddProject extends TestBase{
	LoginPage loginPage;
	AddProject addProject;
	AddProjectPage addProjectPage;
	
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			addProjectPage= new AddProjectPage(driver);
			
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
	}
	@Test(priority=2,dataProvider="getData", description="1.8 Upload Lessons Learned, View Lessons Learned, View Action Items of Add Project in Dashboard")
	public void addProject(String uploadLessonsLearnedTitle, String viewLessonsLearnedTitle, String uploadActionItemsTitle, String viewActionItemsTitle) throws InterruptedException{
			log.debug("Click on "+uploadLessonsLearnedTitle);
			Thread.sleep(2000);
			Assert.assertTrue(addProjectPage.isCheckAndClickUploadLessonsLearned(uploadLessonsLearnedTitle));
			//log.debug("Click on View Lessons Learned");
			//Thread.sleep(2000);
			//Assert.assertTrue(addProjectPage.isCheckAndClickViewLessonsLearned(viewLessonsLearnedTitle));
			log.debug("Click on Upload Action Items");
			Thread.sleep(2000);
			Assert.assertTrue(addProjectPage.isCheckAndClickUploadActionItems(uploadActionItemsTitle));
			log.debug("Click on the View Action Items");
			Thread.sleep(2000);
			Assert.assertTrue(addProjectPage.isCheckAndClickViewActionItems(viewActionItemsTitle));
	}
}
