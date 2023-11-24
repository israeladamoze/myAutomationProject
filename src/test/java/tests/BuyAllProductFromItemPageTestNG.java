package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.CheckOutOverview;
import pageObjects.CheckoutPage;
import pageObjects.ItemPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class BuyAllProductFromItemPageTestNG extends BaseLoginTestNG {

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "check buying all the products from item page")
	@Description("check buying all the products from item page")
	public void tc01_buyAllProductFromItemPage() {
		ProductsPage product = new ProductsPage(driver);
		ItemPage item = new ItemPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.chooseProduct("Sauce Labs Fleece Jacket");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Sauce Labs Bike Light");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Sauce Labs Bolt T-Shirt");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Sauce Labs Onesie");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		item.addToCart();
		item.backToProducts();
		product.chooseProduct("Sauce Labs Backpack");
		item.addToCart();
		item.backToProducts();
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");
		checkout.infoContinue();
		over.finish();

		// should check that we completed checkout and we are in the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(over.isorderCompleted(), "buying process is not completed");
		softAssert.assertAll();

	}

}
