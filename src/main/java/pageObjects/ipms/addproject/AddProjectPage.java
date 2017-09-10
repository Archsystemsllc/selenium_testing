package pageObjects.ipms.addproject;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class AddProjectPage extends BasePage{
	public AddProjectPage(WebDriver driver){
		this.driver=driver;
	}
	//Elements
	public By uploadLessonsLearned = By.xpath("//*[@id='sidenav']/li[3]/a");
	public By viewLessonsLearned = By.xpath("//*[@id='sidenav']/ul/li[1]/a");
	public By uploadActionItems = By.xpath("//*[@id='sidenav']/ul/li[2]/a");
	public By viewActionItems = By.xpath("//*[@id='sidenav']/ul/li[3]/a");
	
	// Methods
	public boolean isCheckAndClickUploadLessonsLearned(String uploadLessonsLearnedTitle){
		WebElement uploadLessonsLearnedElement= driver.findElement(uploadLessonsLearned);
		System.out.println("Upload Lessons Learned :"+uploadLessonsLearnedElement.getText().trim());
		if(uploadLessonsLearnedTitle.equals(uploadLessonsLearnedElement.getText().trim())){
			uploadLessonsLearnedElement.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickViewLessonsLearned(String viewLessonsLearnedTitle){
		WebElement viewLessonsLearnedElement= driver.findElement(viewLessonsLearned);
		System.out.println("View Lessons Learned : "+viewLessonsLearnedElement.getText().trim());
		if(viewLessonsLearnedTitle.equals(viewLessonsLearnedElement.getText().trim())){
			viewLessonsLearnedElement.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickUploadActionItems(String uploadActionItemsTitle){
		WebElement uploadActionItemsElement= driver.findElement(uploadActionItems);
		System.out.println("Upload Action Items :"+uploadActionItemsElement.getText().trim());
		if(uploadActionItemsTitle.equals(uploadActionItemsElement.getText().trim())){
			uploadActionItemsElement.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickViewActionItems(String viewActionItemsTitle){
		WebElement viewActionItemsElement= driver.findElement(viewActionItems);
		System.out.println("View Action Items :"+viewActionItemsElement.getText().trim());
		if(viewActionItemsTitle.equals(viewActionItemsElement.getText().trim())){
			viewActionItemsElement.click();
			return true;
		}
		return false;
	}

}
