package pageObjects.ipms.dashboard.horizontal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class HorizontalPage extends BasePage {
	public HorizontalPage(WebDriver driver) {
		this.driver = driver;
	}
	// Elements
	public By horizontalGroups = By.xpath("//*[@id='sidenav']/li[1]/ul/li[1]/a");
	public By horizontalGroupsSubmenuPageTitle = By.xpath("//*[@id='container']/div[2]/h3");
	public By horizontalGroupsSubmenuPageSubTitle = By.xpath("//*[@id='programDId']/div/div[1]/h6");
	// Group Names Elements
	public By groupNameBusiness = By.xpath("//*[@id='programDId']/div/div[2]/table/tbody/tr/td[1]/a/img");
	public By groupNameLearningAndDiffusionGroup = By.xpath("//*[@id='programDId']/div/div[2]/table/tbody/tr/td[2]/a/img");
	public By groupNamePolicyAndPrograms = By.xpath("//*[@id='programDId']/div/div[2]/table/tbody/tr/td[3]/a/img");
	public By groupNameResearch =  By.xpath("//*[@id='programDId']/div/div[2]/table/tbody/tr/td[4]/a/img");
	// Methods
	public void clickOnHorizontalSubmenu() {
		driver.findElement(horizontalGroups).click();
	}
	public String getHorizontalGroupsSubmenuTitle(){
		return driver.findElement(horizontalGroups).getText().trim();
	}
	public boolean isHorizontalGroupsSubmenuPageTitle(String titleName){
		String innerPageTitleName = driver.findElement(horizontalGroupsSubmenuPageTitle).getText().trim();
		if(titleName.equals(innerPageTitleName)){
			return true;
		}
		return false;
	}
	public boolean isHorizontalGroupsSubmenuPageSubTitle(String subTitleName){
		String innerPageSubTitleName = driver.findElement(horizontalGroupsSubmenuPageSubTitle).getText().trim();
		if(subTitleName.equals(innerPageSubTitleName)){
			return true;
		}
		return false;
	}
	public boolean isGroupNameBusiness(String imagePath){
		WebElement business = driver.findElement(groupNameBusiness);
		String businessImageSrc= business.getAttribute("src").trim();
		if((baseURL+imagePath).equals(businessImageSrc)){
			return true;
		}
		return false;
	}
	public boolean isGroupNameLearningAndDiffusionGroup(String imagePath){
		WebElement business = driver.findElement(groupNameLearningAndDiffusionGroup);
		String groupNameLearningAndDiffusionGroupSrc= business.getAttribute("src").trim();
		if((baseURL+imagePath).equals(groupNameLearningAndDiffusionGroupSrc)){
			return true;
		}
		return false;
	}
	public boolean isGroupNamePolicyAndPrograms(String imagePath){
		WebElement business = driver.findElement(groupNamePolicyAndPrograms);
		String groupNamePolicyAndProgramsSrc= business.getAttribute("src").trim();
		if((baseURL+imagePath).equals(groupNamePolicyAndProgramsSrc)){
			return true;
		}
		return false;
	}
	public boolean isGroupNameResearch(String imagePath){
		WebElement business = driver.findElement(groupNameResearch);
		String groupNameResearchSrc= business.getAttribute("src").trim();
		if((baseURL+imagePath).equals(groupNameResearchSrc)){
			return true;
		}
		return false;
	}
}
