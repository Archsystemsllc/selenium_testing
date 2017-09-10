package testSuites.ipms.taskmanagement;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.taskmanagement.TaskManagementPage;

public class TaskManagement extends TestBase{
	LoginPage loginPage;
	TaskManagement taskManagement;
	TaskManagementPage taskManagementPage;
	
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			taskManagementPage= new TaskManagementPage(driver);
			
	}
	@Test(priority=1,dataProvider="getData", description="1.1 Admin Login Test Case for IPMS")
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
	@Test(priority=2,dataProvider="getData", description="1.4 Add Task, Upload Tasks and View tasks in Dashboard")
	public void taskManagement(String addTask, String uploadTasks, String viewTasks){
			Assert.assertTrue(taskManagementPage.isCheckAndClickAddTaskManagment(addTask));
			Assert.assertTrue(taskManagementPage.isCheckAndClickUploadTasksManagment(uploadTasks));
			Assert.assertTrue(taskManagementPage.isCheckAndClickViewTasksManagment(viewTasks));
	}
}
