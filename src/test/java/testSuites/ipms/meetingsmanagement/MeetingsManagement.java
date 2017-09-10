package testSuites.ipms.meetingsmanagement;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pageObjects.ipms.LoginPage;
import pageObjects.ipms.meetingsmanagement.MeetingsManagementPage;

public class MeetingsManagement extends TestBase{
	LoginPage loginPage;
	MeetingsManagementPage meetingsManagementPage;
	MeetingsManagement meetingsManagement;
	@BeforeMethod
	public void testSetUp() {
			loginPage = new LoginPage(driver);
			log.debug("Navigated to Sign In Page");
			meetingsManagementPage = new MeetingsManagementPage(driver);
			log.debug("Clicking on the Meetings Management submenu in dashboard");
	}
	@Test(dataProvider="getData", description="1.1 Admin Login Test Case for IPMS")
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
	@Test(dataProvider="getData", description="1.3 Create A Meeting, Update Meeting and View Meeting")
	public void meetingsManagement(String title, String organizer, String date,String time,String type,
			String duration, String location, String confCall, String facilitator, String verticalGroup,
			String editTitleHeading, String updateTitle, String updatedMeetingSuccessMessage) throws InterruptedException{
		/* To Create a Meeting	*/
		title+=Math.random();
		meetingsManagementPage.clickMeetingsMangment();
		
		meetingsManagementPage.clickAddMeeting();
		
		Thread.sleep(2000);
		meetingsManagementPage.addMeeting(title,organizer,date,time,type,duration,location,confCall,facilitator,verticalGroup);
		meetingsManagementPage.clickCreateViewMeeting();
			//View Meeting	
		meetingsManagementPage.clickViewMeetings();
		meetingsManagementPage.isShowViewMeetingInfo(title);
			//Update Meeting	
		Thread.sleep(2000);
		meetingsManagementPage.clickEditViewMeeting(title);
		Thread.sleep(2000);
		Assert.assertTrue(meetingsManagementPage.isEditMeetingTitle(editTitleHeading));
		meetingsManagementPage.updateTitleNameInMeeting(updateTitle);
		meetingsManagementPage.clickOnUpdateButtonMeeting();
		Assert.assertTrue(meetingsManagementPage.isGetSuccessMessage(updatedMeetingSuccessMessage));
	}
}
