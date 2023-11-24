package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.ItemPage;
import pageObjects.ProductsPage;

public class RemoveProductsFromItemPageTestNG extends BaseLoginTestNG {
	@Test(description = "check removing 1 product from the item page ")
	@Description("check removing 1 product from item page")

	public void tc01_remove() {
		ProductsPage product = new ProductsPage(driver);
		ItemPage item = new ItemPage(driver);
		product.chooseProduct("Sauce Labs Backpack");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Sauce Labs Bike Light");
		item.addToCart();
		item.removeBtn();

		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(product.getNumbers_of_items().getText(), "1","The product has not been removed");
		softAssert.assertAll();

	}

}
