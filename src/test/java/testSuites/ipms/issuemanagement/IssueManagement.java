package testSuites.ipms.issuemanagement;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.financialmanagement.FinancialManagementPage;
import pageObjects.ipms.issuemanagement.IssueManagementPage;

public class IssueManagement extends TestBase{
	LoginPage loginPage;
	IssueManagementPage issueManagementPage;
	IssueManagement issueManagement;
	
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			issueManagementPage = new IssueManagementPage(driver);
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
	@Test(priority=2,dataProvider="getData", description="1.6 Add Issue, Upload Issues, Search Issues and View Issues of Issue Management in Dashboard")
	public void issueManagement(String addIssueTitle, String uploadIssuesTitle, String searchIssuesTitle, String viewIssueTitle){
			log.debug("Clicking on the Add Issue");
			Assert.assertTrue(issueManagementPage.isCheckAndClickAddIssue(addIssueTitle));
			log.debug("Clicking on the Upload Issues");
			Assert.assertTrue(issueManagementPage.isCheckAndClickUploadIssues(uploadIssuesTitle));
			//log.debug("Clicking on the Search Issues(JIRA)");
			//Assert.assertTrue(issueManagementPage.isCheckAndClickSearchIssues(searchIssuesTitle));
			log.debug("Clicking on the View Issues");
			Assert.assertTrue(issueManagementPage.isCheckAndClickViewIssues(viewIssueTitle));
	}
}
