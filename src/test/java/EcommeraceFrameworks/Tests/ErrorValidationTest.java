package EcommeraceFrameworks.Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import EcommeraceFrameworks.PageObjects.MyCartPage;
import EcommeraceFrameworks.PageObjects.ProductCatalogue;
import EcommeraceFrameworks.TestComponents.BaseTest;

public class ErrorValidationTest extends BaseTest {
	
	@Test(groups= {"ErrorHandls"})
	public void logINErrorValidation() throws IOException, InterruptedException {

		landingePage.longIn("am2827450@gmail.com", "01265733141.Asd");
		String Errormassage= landingePage.checkErrormessage();
		//assertEquals(Errormassage, "Incorrect email or password.");
		Assert.assertEquals(Errormassage, "Incorrect email  password.");
	}
	
	@Test
	public void orderErrorValidation() throws IOException, InterruptedException {

		
		String productName = "ZARA COAT 3";
		ProductCatalogue ProductCatalogue = landingePage.longIn("am227450@gmail.com", "0126733141.Asd");
		ProductCatalogue.getProductList();
		ProductCatalogue.addToCardProduct(productName);
		MyCartPage myCartPage= ProductCatalogue.clickONCartBtn();
		myCartPage.cardList();
		myCartPage.checkProductName(productName);
	}

}
