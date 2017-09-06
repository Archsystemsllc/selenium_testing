package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public WebDriver driver;
	public String url = "http://ec2-34-208-202-43.us-west-2.compute.amazonaws.com/util/login";
	
	// Elements / Instance Variables
	public By msg = By.xpath("//*[@id='header']/nav/div/table/tbody/tr[1]/td[2]/div");
	
	
	// User Actions / Instance Methods
	public void waitForElementToBeVisible(By element) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10); // seconds
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public void open() {
		
		driver.get(this.url);
	}
	
}
