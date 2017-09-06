package pageObjects.ipms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pageObjects.BasePage;

public class LoginPage extends BasePage {
	
	// Elements
	public By uName = By.xpath("//*[@id='user']");
	public By pWord = By.xpath("//*[@id='pw']");
	public By login = By.xpath("//*[@id='theme-default']/div[4]/div[2]/form/div/a/input");
	public By admin = By.xpath("//*[@id='header']/div[2]/span[1]/strong");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		//this.url = super.url + "/sign_in";
	}
	
	// User Actions
	public void enterUsername(String username) {
		driver.findElement(uName).clear();
		driver.findElement(uName).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(pWord).clear();
		driver.findElement(pWord).sendKeys(password);
	}
	
	public void clickSubmit() {
		driver.findElement(login).click();
	}
	public String getAdminName(){
		return driver.findElement(admin).getText();
	}
}
