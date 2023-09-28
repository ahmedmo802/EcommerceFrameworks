package EcommeraceFrameworks.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import EcommeraceFrameworks.AbstractComponents.AbstractComponent;


public class ProductCatalogue extends AbstractComponent{
WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) 
	{ 
		super(driver);
	this.driver = driver; 
	PageFactory.initElements(driver, this);
	} 

	 @FindBy(css = ".mb-3")
	 List<WebElement> products;	 
	 
	 @FindBy(id = "toast-container")
	 WebElement toast;	
	 
	 @FindBy(css = "button[routerlink='/dashboard/cart']")
	 WebElement Cardsubmit;	
	 
	 By productsappear = By.cssSelector(".mb-3");
	 By addToCard = By.xpath("//div[@class='card-body']// button[2]");
	 By toastMassage = By.id("toast-container");
	 By animatinggoes = By.cssSelector(".ng-animating");
	 
	 public List<WebElement> getProductList() {

		 WaitForElementToAppear(productsappear);
		 return products;
	 }
	  public WebElement addToCardProduct(String productName){
		WebElement prod = products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector("div[class='card-body'] button:last-of-type")).click();
			return prod;
						
}
				 	

	 
	 
	 public MyCartPage clickONCartBtn() throws InterruptedException {
		 WaitForElementToAppear(toastMassage);
		 waitForElementToDissappear(animatinggoes);
		
		 WaitForElementToBeClickable(Cardsubmit);
		  Thread.sleep(3000);
		 Cardsubmit.click();
	   MyCartPage myCartPage = new MyCartPage(driver);
	   return myCartPage;


	 }

}
