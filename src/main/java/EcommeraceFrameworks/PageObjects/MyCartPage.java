package EcommeraceFrameworks.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;



public class MyCartPage extends AbstractComponent{
	//am227450@gmail.com-0126733141.Asd
		WebDriver driver;
		
		public MyCartPage(WebDriver driver) 
		{ 
			super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		} 


		 @FindBy(css = ".cartSection h3")
		 List<WebElement> cardProducts;
		 
		 @FindBy(css = "li[class='totalRow'] button")
		 WebElement checkOutBtn;
		 
		 
		 public List<WebElement> cardList() {
			 return cardProducts;
		 }
		 
		 public boolean checkProductName(String productName) {
			 boolean match= cardList().stream().anyMatch(cardProduct-> cardProduct.getText().equalsIgnoreCase(productName));
			 return match;
		 }
		 
		 public OrderPage clickONCheckOut() {
			 checkOutBtn.click(); 
			 OrderPage orderPage = new OrderPage(driver);
			 return orderPage;
		 }
		 

}
