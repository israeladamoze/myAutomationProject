package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.CheckOutOverview;
import pageObjects.CheckoutPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class BuyProductFromProductsPageTestNG extends BaseLoginTestNG {

	@Test(description = "check buying a product from products page")
	@Description("check buying a product from products page")
	public void tc01_buyProductFromProductPage() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.add_to_cart_btn(0);
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");
		checkout.infoContinue();
		over.finish();

		// should check that we completed checkout and we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(over.isorderCompleted(), "buying process is not completed");
		softAssert.assertAll();

	}

}
