package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Issues;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import pageObjects.ProductsPage;
import utilities.AllureAttachment;

public class RemoveProductsFromProductsPageTestNG extends BaseLoginTestNG {
	@Link(name = "saucedemo", url = "https://www.saucedemo.com/")
	@TmsLinks({
		@TmsLink("550"),
		@TmsLink("800")
})
	@Issues({
		@Issue("550"),
		@Issue("800")
})
    @Owner("Israela Damoze")
	@Test(description = "check removing 1 product from product page")
	@Description("check removing 1 product from product page")
	public void tc01_remove() {
		ProductsPage product = new ProductsPage(driver);
		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		AllureAttachment.attachElementScreenshot(
				driver.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")));
		 product.removePrduct("Sauce Labs Bike Light");
		
		String jsonData = "{\"product name\": \"Sauce Labs Bike Light\"}";
		AllureAttachment.attachJson(jsonData);
		
		AllureAttachment.attachXml("<note>\n" +
				"<to>products</to>\n" +
				"<from>cart</from>\n" +
				"<heading>remove</heading>\n" +
				"<body>remove product from cart</body>\n" +
				"</note>");
		
		AllureAttachment.attachURL("https://www.saucedemo.com/");

		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(product.getNumbers_of_items().getText(), "1", "The product has not been removed");
		softAssert.assertAll();

	}

}
