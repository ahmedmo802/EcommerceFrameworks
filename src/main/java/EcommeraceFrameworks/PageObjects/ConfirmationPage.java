package EcommeraceFrameworks.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent{
WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) 
	{ 
		super(driver);
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	} 


	 @FindBy(css = "h1")
	 WebElement confirmationText;
	 
	 By ConfTex= By.cssSelector("h1");
	 
	 public String checkConfText()  {
		
		 WaitForElementToAppear(ConfTex);
		return confirmationText.getText();
		
	 }

}
