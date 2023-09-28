package EcommeraceFrameworks.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;

public class OrderlistPage extends AbstractComponent{
	//am227450@gmail.com-0126733141.Asd
		WebDriver driver;
		
		public OrderlistPage(WebDriver driver) 
		{ 
			super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		} 


		 @FindBy(css = "tr td:nth-child(3)")
		 List<WebElement> orderList;
		 
		 
		 
		 
		 public List<WebElement> orderList() {
			 return orderList;
		 }
		 
		 public boolean checkProductName(String productName) {
			 boolean match= orderList().stream().anyMatch(cardProduct-> cardProduct.getText().equalsIgnoreCase(productName));
			 return match;
		 }
}
