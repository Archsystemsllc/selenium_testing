package pageObjects.ipms.issuemanagement;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.model.Log;

import pageObjects.BasePage;

public class IssueManagementPage extends BasePage{
	public IssueManagementPage(WebDriver driver){
		this.driver=driver;
	}
	//Elements
	public By addIssue = By.xpath("//*[@id='sidenav']/li[2]/ul/li[6]/ul/li[1]/a");
	public By uploadIssues = By.xpath("//*[@id='sidenav']/li[2]/ul/li[6]/ul/li[2]/a");
	public By searchIssues = By.xpath("//*[@id='sidenav']/li[2]/ul/li[6]/ul/li[3]/a");
	public By viewIssue = By.xpath("//*[@id='sidenav']/li[2]/ul/li[6]/ul/li[4]/a");
	
	// Methods
	public boolean isCheckAndClickAddIssue(String addIssueTitle){
		WebElement addIssueElement= driver.findElement(addIssue);
		System.out.println("Add Issues : "+addIssueElement.getText().trim());
		if(addIssueTitle.equals(addIssueElement.getText().trim())){
			addIssueElement.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickUploadIssues(String uploadIssuesTitle){
		WebElement uploadIssuesElement= driver.findElement(uploadIssues);
		System.out.println("Upload Issues : "+uploadIssuesElement.getText().trim());
		if(uploadIssuesTitle.equals(uploadIssuesElement.getText().trim())){
			uploadIssuesElement.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickSearchIssues(String searchIssuesTitle){
		WebElement searchIssuesElement= driver.findElement(searchIssues);
		System.out.println("Search Issues : "+searchIssuesElement.getText().trim());
		if(searchIssuesTitle.equals(searchIssuesElement.getText().trim())){
			searchIssuesElement.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickViewIssues(String viewIssueTitle){
		WebElement viewIssueElement= driver.findElement(viewIssue);
		System.out.println("View Issues : "+viewIssueElement.getText().trim());
		if(viewIssueTitle.equals(viewIssueElement.getText().trim())){
			viewIssueElement.click();
			return true;
		}
		return false;
		
	}
}
