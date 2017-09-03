package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import utilities.ExcelReader;

public class TestBase {
		
	public static WebDriver driver;
	public static Properties config;
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("TestBase");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "/src/test/resources/excel/test_data.xlsx");
	
	@BeforeSuite
	public void setUp() throws IOException {
		if (driver==null) {				
			fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/properties/Config.properties");
			config = new Properties();
			config.load(fis);			
			
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/src/test/resources/executables/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
			
			driver.get(config.getProperty("test_site_url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			log.debug("Navigated to site url: " + config.getProperty("test_site_url"));
		}
	}
	
	@AfterSuite
	public void tearDown() {
		takeScreenshots();
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
	public static void takeScreenshots(){

		try {
			SimpleDateFormat formatter = new SimpleDateFormat("dd_M_yyyy_hh_mm_ss");
			Date date = new Date();
			String currentDate = formatter.format(date);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+ "/" + "Screenshots" + "/" + "Results" +"/"+ currentDate+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
