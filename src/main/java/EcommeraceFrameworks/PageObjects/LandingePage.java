package EcommeraceFrameworks.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;


public class LandingePage extends AbstractComponent{
	//am227450@gmail.com-0126733141.Asd
		WebDriver driver;
		
		public LandingePage(WebDriver driver) 
		{ 
			super(driver);
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		} 


		 @FindBy(id = "userEmail")
		 WebElement usrEmail;
		 
		 @FindBy(id = "userPassword")
		 WebElement usrPassword;
		 
		 @FindBy(id = "login")
		 WebElement submit;
		 
		 @FindBy(css = "[class*='flyInOut']")
		 WebElement ErrorPopUP;
		 
		 //	String ErrorPopUP = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]")).getText();
		 
		 public ProductCatalogue longIn(String email, String password) {
			 
			 usrEmail.sendKeys(email);
			 usrPassword.sendKeys(password);
			 submit.click();
			 ProductCatalogue ProductCatalogue = new ProductCatalogue(driver);
			 return ProductCatalogue;
		 }

		 public String checkErrormessage() {
			 WaitForWebElementToAppear(ErrorPopUP);
			return ErrorPopUP.getText();
			 
		 }
		 
		 public void goTo() {
		 
			 driver.get("https://rahulshettyacademy.com/client");
	}

}
