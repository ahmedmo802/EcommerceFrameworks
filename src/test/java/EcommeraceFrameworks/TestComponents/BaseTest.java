package EcommeraceFrameworks.TestComponents;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import EcommeraceFrameworks.PageObjects.LandingePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LandingePage landingePage;
	Properties prop= new Properties();
	
	public WebDriver intialzeDriver() throws IOException {
		FileInputStream fls= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\EcommeraceFrameworks\\resources\\GlobalDate1.Properties");
		prop.load(fls);
		String browserName=	System.getProperty("browser")!=null ? System.getProperty("browser") :prop.getProperty("browser");
		//prop.getProperty("browser");
	//	String browserName = prop.getProperty("browser");
		if(browserName.contains("chrome")) {
		ChromeOptions opetions = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		if (browserName.contains("headless")) {
			opetions.addArguments("headless");
			}
		 driver = new ChromeDriver(opetions);
	     driver.manage().window().setSize(new Dimension(1440,900));   //(new Dimension(1440,900));// Full Screen

		}
		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			 driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge")){
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException {
		
		String jsonContent = FileUtils.readFileToString(new File(filepath),
				StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){
			
		});
		return data;
		
	}

      public String screenShot(String testCaseName, WebDriver driver) throws IOException {
	  TakesScreenshot takeScreenShot =(TakesScreenshot)driver;
      File source =	takeScreenShot.getScreenshotAs(OutputType.FILE);
      File file = new File(System.getProperty("user.dir")+"\\Reports\\"+ testCaseName +".png");	
      FileUtils.copyFile(source, file);
      return System.getProperty("user.dir")+"\\Reports\\"+ testCaseName +".png";
}

    

	/*@BeforeMethod(alwaysRun=true)
	public LandingePage launchApp() throws IOException {
		driver = intialzeDriver();
		 landingePage = new LandingePage(driver); 
		landingePage.goTo();
		return landingePage;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp() {
		driver.close();
	}*/
      @BeforeMethod(alwaysRun=true)
    	  public LandingePage launchApp() throws IOException {
    	  driver = intialzeDriver();
    		  landingePage = new LandingePage(driver);
    		  landingePage.goTo();
    		  return landingePage;
    	  }
      
      @AfterMethod(alwaysRun=true)
      public void closeApp() {
    	  driver.close();
      }
   
    	  
      
}



