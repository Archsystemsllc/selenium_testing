package pageObjects.ipms.msprojectintegration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;

public class MSProjectIntegrationPage extends BasePage {
	// Elements
	public By msProjectIntegration = By.xpath("//*[@id='sidenav']/li[2]/ul/li[7]/a");
	
	
	public MSProjectIntegrationPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getmsProjectIntegrationSubmenu(){
		return driver.findElement(msProjectIntegration).getText().trim();
	}
	
	

}
