package pageObjects.ipms.financialmanagement;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pageObjects.BasePage;

public class FinancialManagementPage extends BasePage{
	public FinancialManagementPage(WebDriver driver){
		this.driver=driver;
	}
	//Elements
	public By evmUpload = By.xpath("//*[@id='sidenav']/li[2]/ul/li[4]/ul/li[1]/a");
	public By finacialReport = By.xpath("//*[@id='sidenav']/li[2]/ul/li[4]/ul/li[2]/a");
	public By evmMetrics = By.xpath("//*[@id='sidenav']/li[2]/ul/li[4]/ul/li[3]/a");
	
	// Methods
	public boolean isCheckAndClickEVMUpload(String evmUploadTitle){
		WebElement evmUploadElement= driver.findElement(evmUpload);
		//System.out.println("EVM Upload : "+evmUploadElement.getText().trim());
		if(evmUploadTitle.equals(evmUploadElement.getText().trim())){
			evmUploadElement.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickFinacialReport(String financialReportTitle){
		WebElement finacialReportElement= driver.findElement(finacialReport);
		//System.out.println("Financial Report Title : "+finacialReportElement.getText().trim());
		if(financialReportTitle.equals(finacialReportElement.getText().trim())){
			finacialReportElement.click();
			return true;
		}
		return false;
		
	}
	public boolean isCheckAndClickEVMMetrics(String evmMetricsTitle){
		WebElement evmMetricsElement= driver.findElement(evmMetrics);
		//System.out.println("EVM Metrics : "+evmMetricsElement.getText().trim());
		if(evmMetricsTitle.equals(evmMetricsElement.getText().trim())){
			evmMetricsElement.click();
			return true;
		}
		return false;
		
	}
}
