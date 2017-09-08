package pageObjects.ipms.meetingsmanagement;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import pageObjects.BasePage;

public class MeetingsManagementPage extends BasePage{

	public MeetingsManagementPage(WebDriver driver){
		this.driver=driver;
	}
	
	// Elements
	public By meetingsManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[7]/a");
	public By addMeeting = By.xpath(".//*[@id='sidenav']/li[2]/ul/li[7]/ul/li[1]/a");
	public By sheduleNewMeeting = By.xpath("//*[@id='container']/div[4]/div/div/div/div/h6");
	public By title = By.xpath("//*[@id='title']");
	public By organizer = By.xpath("//*[@id='organizerId']");
	public By date = By.xpath("//*[@id='date']");
	public By time = By.xpath("//*[@id='time']");
	public By type = By.xpath("//*[@id='type']");
	public By duration = By.xpath("//*[@id='duration']");
	public By location = By.xpath("//*[@id='locationInfo']");
	public By confCall = By.xpath("//*[@id='otherInfo']");
	public By facilitator = By.xpath("//*[@id='attendeesList']");
	public By verticalGroup = By.xpath("//*[@id='programId']");
	// CREATE
	public By createButton = By.xpath("//*[@id='meeting']/div/ul/li[11]/div/div/button[1]/span");
	// Message 
	public By updateSuccessMessge = By.xpath("//*[@id='content']/div/div/div/div[1]/div[1]");
	// EDIT MEETING 
	public By editMeeting = By.xpath("//*[@id='container']/div[4]/div/div/div/div[1]/h6");
	// UPDATE
	public By updateButton = By.xpath("//*[@id='meeting']/ul[2]/li/div/button[1]/span");
	// view Meetings
	public By viewMeetingsButton = By.xpath("//*[@id='sidenav']/li[2]/ul/li[8]/ul/li[2]/a");
	public By viewTitle = By.xpath("//*[@id='content']/div/div/div/div[1]/h6");
	public By checkCreatedMeetingTitleRow = By.xpath("//*[@id='content']/div/div/div/div[2]/table/tbody/tr");
	
	// Methods
	
	
	public void clickMeetingsMangment(){
		driver.findElement(meetingsManagment).click();
	}
	public void clickAddMeeting(){
		//driver.findElement(addMeeting).click();
		driver.navigate().to(baseURL+"/app/new-programmeeting");
	}
	// Add Meeting Actions
	public void addMeeting(String titleName, String organizerValue, String dateValue,String timeValue,String typeValue,
			String durationValue, String locationValue, String confCallValue, String facilitatorValue, String verticalGroupValue){
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys(titleName);
		new Select(driver.findElement(organizer)).selectByVisibleText(organizerValue);
		driver.findElement(date).sendKeys(dateValue);
		driver.findElement(time).sendKeys(timeValue);
		new Select(driver.findElement(type)).selectByVisibleText(typeValue);
		driver.findElement(duration).sendKeys(durationValue);
		driver.findElement(location).sendKeys(locationValue);
		driver.findElement(confCall).sendKeys(confCallValue);
		new Select(driver.findElement(facilitator)).selectByVisibleText(facilitatorValue);
		new Select(driver.findElement(verticalGroup)).selectByVisibleText(verticalGroupValue);
	}
	public void clickCreateViewMeeting(){
		driver.findElement(createButton).click();
	}
	public void clickViewMeetings(){
		//driver.findElement(viewMeetingsButton).click();
		driver.navigate().to(baseURL+"/app/meetings");
	}
	// View Meetings Actions
	public String getViewMeeting(){
		return driver.findElement(viewTitle).getText().trim();
	}
	public boolean isShowViewMeetingInfo(String titleColumn){
		List<WebElement> row=driver.findElements(checkCreatedMeetingTitleRow);
		List<WebElement> td=row.get(row.size()-1).findElements(By.tagName("td"));
		String titleRowName =td.get(1).findElement(By.tagName("a")).getText().trim();
		if(titleRowName.equals(titleColumn)){
			return true;
		}
		return false;
	}
	public void clickEditViewMeeting(String titleColumnName){
		List<WebElement> row=driver.findElements(checkCreatedMeetingTitleRow);
		List<WebElement> td=row.get(row.size()-1).findElements(By.tagName("td"));
		td.get(td.size()-1).findElement(By.xpath("span[1]/a")).click();
	}
	public boolean isEditMeetingTitle(String editTitleName){
		System.out.println("Edit Meeting title is "+driver.findElement(editMeeting).getText().trim());
		if(editTitleName.equals(driver.findElement(editMeeting).getText().trim())){
			return true;
		}
		return false;
	}
	public void clickOnUpdateButtonMeeting(){
		driver.findElement(updateButton).click();
	}
	public boolean isGetSuccessMessage(String successMessageName){
		if(successMessageName.equals(driver.findElement(updateSuccessMessge).getText().trim())){
			return true;
		}
		return false;
	}
	public void updateTitleNameInMeeting(String newTitleName){
		driver.findElement(title).clear();
		driver.findElement(title).sendKeys(newTitleName);
	}

}
