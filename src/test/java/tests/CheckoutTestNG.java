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

public class CheckoutTestNG extends BaseLoginTestNG {

	@Test(description = "check checkout error message in  when first name field missing")
	@Description("check checkout error message in  when first name field missing")
	public void tc01_CheckoutFirstNameEmpty() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		menu.cart();
		cart.checkout();
		checkout.yourInformation("", "Ela", "81573");
		checkout.infoContinue();

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Error: First Name is required";
		String actualErrorMessage = checkout.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "error message is not right");
		softAssert.assertAll();

	}

	@Test(description = "check checkout error message when last name field missing")
	@Description("check checkout error message when last name field missing")
	public void tc02_CheckoutLastNameEmpty() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		menu.cart();
		cart = new YourCartPage(driver);
		cart.checkout();
		checkout.yourInformation("Isra", "", "81573");
		checkout.infoContinue();

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Error: Last Name is required";
		String actualErrorMessage = checkout.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "error message is not right");
		softAssert.assertAll();

	}

	@Test(description = "check checkout error message when postal code field missing")
	@Description("check checkout error message when postal code field missing")
	public void tc03_CheckoutPostalCodeEmpty() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "");
		checkout.infoContinue();

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Error: Postal Code is required";
		String actualErrorMessage = checkout.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "error message is not right");
		softAssert.assertAll();

	}
	
	@Test(description = "check fiiling checkout form ")
	@Description("check fiiling checkout form ")
	public void tc04_checkoutFormComplete() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");
		checkout.infoContinue();
	

		// should check that we completed checkout form and we are on the right page 
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(over.ischeckoutOverviewPage(), "checkout form is not completed");
		softAssert.assertAll();

	}
}
