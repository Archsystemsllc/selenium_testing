package pageObjects.ipms.sharepoint;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;

public class CheckSharePointSubmenuPage extends BasePage {
	// Elements
	public By sharePointSubmenu = By.xpath("//*[@id='sidenav']/li[4]/a");
	
	
	public CheckSharePointSubmenuPage(WebDriver driver){
		this.driver=driver;
	}

	public String getSharePointSubmenu(){
		return driver.findElement(sharePointSubmenu).getText().trim();
	}
	
	

}
