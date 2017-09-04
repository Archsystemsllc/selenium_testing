package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.ExcelReader;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBase");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/test_data.xlsx");
	
	@BeforeSuite
	@Parameters({"applicationUrl"})
	public void setUp(String applicationUrl) throws IOException {
		if (driver==null) {				
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
			config = new Properties();
			config.load(fis);			
			
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/executables/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			
			driver.get(applicationUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.debug("Navigated to site url: " + applicationUrl);
		}
	}
	
	@AfterSuite
	public void tearDown() {
		driver.close();
		driver.quit();
		log.debug("Close the driver");
	}
		
	@DataProvider
	public Object[][] getData(Method m) {
		
		String sheetName = m.getName(); 
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum < cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;	
	}
	@AfterMethod
    public void afterTest(Method method) {
    	try {
    		SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ "/" + "Screenshots" + "/" + "Results" +"/"+getTestDescription(method).replaceAll(" ", "_")+"_"+currentDate+".png"));
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	} catch (NoSuchWindowException ex) {
    		ex.printStackTrace();
    	}
    }
	protected String getTestDescription(Method m) {
		Annotation[] annotations = m.getDeclaredAnnotations();
		for (Annotation annotation : annotations) {
		    if(annotation instanceof Test){
		        Test test = (Test) annotation;
		        if (!test.description().isEmpty()) {
		           return test.description();
		        }
		    }
		}
		return m.getName();
	}
	
}
