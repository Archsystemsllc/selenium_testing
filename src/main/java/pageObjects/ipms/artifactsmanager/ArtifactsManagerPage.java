package pageObjects.ipms.artifactsmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;

public class ArtifactsManagerPage extends BasePage {
	// Elements
	public By  artifactsManagerElement = By.xpath("//*[@id='sidenav']/li[5]/a");
	
	
	public ArtifactsManagerPage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getArtifactsManagerPageSubmenu(){
		return driver.findElement(artifactsManagerElement).getText().trim();
	}
	
	

}
