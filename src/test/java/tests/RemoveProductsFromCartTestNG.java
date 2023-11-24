package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class RemoveProductsFromCartTestNG extends BaseLoginTestNG {

	@Test(description = "check removing product from cart ")
	@Description("check removing product from cart")

	public void remove() {
		ProductsPage product = new ProductsPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		product.cartBtn();
		
		try {
			cart.remove();

		} catch (Exception e) {
			System.out.println("Something went wrong.");

		}

		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(cart.getNumbers_of_items().getText(), "1","The product has not been removed");
		softAssert.assertAll();

	}

}
