package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.CheckOutOverview;
import pageObjects.CheckoutPage;
import pageObjects.ItemPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class BuyProductFromItemPageTestNG extends BaseLoginTestNG {

	@Test(description = "check buying a product from item page")
	@Description("check buying a product from item page")
	public void tc01_BuyProductfromItemPage() {
		ProductsPage product = new ProductsPage(driver);
		ItemPage item = new ItemPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.chooseProduct("Sauce Labs Fleece Jacket");
		item.addToCart();
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
