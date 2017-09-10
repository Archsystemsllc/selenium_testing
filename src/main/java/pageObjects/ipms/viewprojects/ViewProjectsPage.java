package pageObjects.ipms.viewprojects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;

public class ViewProjectsPage extends BasePage {
	// Elements
	public By  viewProjectsElement = By.xpath("//*[@id='sidenav']/li[2]/ul/li[1]/a");
	
	
	public ViewProjectsPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getViewProjectsPageSubmenu(){
		return driver.findElement(viewProjectsElement).getText().trim();
	}
	
	

}
