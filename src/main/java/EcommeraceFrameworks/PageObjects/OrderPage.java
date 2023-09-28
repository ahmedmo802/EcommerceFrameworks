package EcommeraceFrameworks.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	//am227450@gmail.com-0126733141.Asd
		WebDriver driver;
		
		public OrderPage(WebDriver driver) 
		{ 
			super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		} 


		 @FindBy(css = ".form-group input")
		 WebElement countryName;
		 
		 @FindBy(css = "a[class*='btnn action__submit']")
		 WebElement placeOrder;
		 By countryNamebox= By.cssSelector(".form-group input");
		 
		 public void entrCountryName(String Mycountry) {
			 WaitForElementToAppear(countryNamebox);
			 countryName.sendKeys(Mycountry); 
		 }
		
		 public void selectCountry(String Mycountry) {
			 List<WebElement> countries= driver.findElements(By.cssSelector("section[class*='ta-results'] button"));
			    for(WebElement country :countries) {
			    	
			    	if(country.getText().equalsIgnoreCase(Mycountry)) {
			    		country.click();
			    		break;
			    	}
			    }
		 }

	public ConfirmationPage clickOnPlaceOrder() {
		placeOrder.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}


}
