package EcommeraceFrameworks.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EcommeraceFrameworks.PageObjects.OrderlistPage;


public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) 
	{ 
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	}
	
	
	 @FindBy(css = "[routerlink='/dashboard/myorders']")
	 WebElement OrderBtn;

	public void WaitForElementToAppear(By findBy) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	       
			
	}
	
	public void WaitForWebElementToAppear(WebElement ele) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOf(ele));
	       
			
	}
	
	public void WaitForElementToBeClickable(WebElement ele) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.elementToBeClickable(ele));
	       
			
	}
	
	
	public void waitForElementToDissappear(By findBy) {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	public OrderlistPage gotToOrderListPage() {
		OrderBtn.click();
		OrderlistPage oderlistPage = new OrderlistPage(driver);
		return oderlistPage;
	}
}
