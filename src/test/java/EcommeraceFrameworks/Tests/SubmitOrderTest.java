package EcommeraceFrameworks.Tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import EcommeraceFrameworks.PageObjects.ConfirmationPage;
import EcommeraceFrameworks.PageObjects.MyCartPage;
import EcommeraceFrameworks.PageObjects.OrderPage;
import EcommeraceFrameworks.PageObjects.OrderlistPage;
import EcommeraceFrameworks.PageObjects.ProductCatalogue;
import EcommeraceFrameworks.TestComponents.BaseTest;
import EcommeraceFrameworks.TestComponents.Retry;



public class SubmitOrderTest  extends BaseTest {
	
	

	@Test(dataProvider="getData", groups= {"Purches"})
	public void sumbitOrder(HashMap<String,String> input) throws IOException, InterruptedException {

	
		String Mycountry = "Egypt";
		ProductCatalogue ProductCatalogue = landingePage.longIn(input.get("email"),input.get("password"));
		List<WebElement>products= ProductCatalogue.getProductList();
		ProductCatalogue.addToCardProduct(input.get("productName"));
		MyCartPage myCartPage= ProductCatalogue.clickONCartBtn();
		List<WebElement>cardProducts= myCartPage.cardList();
		boolean match = myCartPage.checkProductName(input.get("productName"));
		Assert.assertTrue(match);
		OrderPage orderPage = myCartPage.clickONCheckOut();
		orderPage.entrCountryName(Mycountry);
		orderPage.selectCountry(Mycountry);
		ConfirmationPage confirmationPage = orderPage.clickOnPlaceOrder();
		String confText= confirmationPage.checkConfText();
		Assert.assertTrue(confText.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


} 
	@Test(dataProvider="getData",dependsOnMethods= {"sumbitOrder"},retryAnalyzer=Retry.class)
	public void orderhistoryTest(HashMap<String,String> input){

		ProductCatalogue ProductCatalogue = landingePage.longIn("am227450@gmail.com", "0126733141.Asd");
		
		 OrderlistPage oderlistpage = ProductCatalogue.gotToOrderListPage();
		 Assert.assertTrue(oderlistpage.checkProductName(input.get("productName")));
	

}
	

@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String,String>> data= getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\EcommeraceFrameworks\\data\\PurchaseOrder.json");
		return  new Object[][] {{data.get(0)},{data.get(1)}};
	
		
		
	}
	
	

	/*@DataProvider
	public Object[][] getData() {
		return new Object[][] {{"am227450@gmail.com","0126733141.Asd","ADIDAS ORIGINAL"},{"m.mido2008@yahoo.com","Ahmed.28","ZARA COAT 3"}};
	}*/
	
	
	/*@DataProvider
	public Object[][] getData() throws IOException {
		HashMap<String, String> map = new HashMap<String,String>();
		map.put("email", "am227450@gmail.com");
		map.put("password", "0126733141.Asd");
		map.put("productName", "ADIDAS ORIGINAL");
		
		HashMap<String, String> map1 = new HashMap<String,String>();
		map1.put("email", "m.mido2008@yahoo.com");
		map1.put("password", "Ahmed.28");
		map1.put("productName", "ZARA COAT 3");

		return  new Object[][] {{map},{map1}};
		
	
	

}*/
}