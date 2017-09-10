package pageObjects.ipms.riskmanagement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class RiskManagementPage extends BasePage{
	public RiskManagementPage(WebDriver driver){
		this.driver=driver;
	}
	//Elements
	public By addRiskManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[5]/ul/li[1]/a");
	public By uploadRisksManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[5]/ul/li[2]/a");
	public By viewRisksManagment = By.xpath("//*[@id='sidenav']/li[2]/ul/li[5]/ul/li[3]/a");
	
	// Methods
	public boolean isCheckAndClickAddRiskManagment(String addRiskTitle){
		WebElement addRisks= driver.findElement(addRiskManagment);
		System.out.println("Add Risk "+addRisks.getText().trim());
		if(addRiskTitle.equals(addRisks.getText().trim())){
			addRisks.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickUploadRisksManagment(String uploadRisksTitle){
		WebElement uploadRisks= driver.findElement(uploadRisksManagment);
		System.out.println("Add Risk "+uploadRisks.getText().trim());
		if(uploadRisksTitle.equals(uploadRisks.getText().trim())){
			uploadRisks.click();
			return true;
		}
		return false;
	}
	public boolean isCheckAndClickViewRisksManagment(String viewRisksTitle){
		WebElement uploadRisks= driver.findElement(viewRisksManagment);
		System.out.println("Add Risk "+uploadRisks.getText().trim());
		if(viewRisksTitle.equals(uploadRisks.getText().trim())){
			uploadRisks.click();
			return true;
		}
		return false;
	}

}
