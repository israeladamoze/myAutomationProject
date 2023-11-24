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

public class DifferentButtonsTestNG extends BaseLoginTestNG {

	@Test(description = "check the option of conitinue shopping on the cart")
	@Description("check the option of conitinue shopping on the cart")

	public void tc01_continueShopping() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		product.addToCart("Sauce Labs Bike Light");
		menu.cart();
		cart.continueShopping();

		// should check that we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(product.isProductsPage(), "Continue shopping is not clicked, products page is not displayed");
		softAssert.assertAll();

	}

	
	@Test(description = "check the option of back home on check out")
	@Description("check the option of back home on check out")
	public void tc02_backHome() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.addToCart("Sauce Labs Backpack");
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");
		checkout.infoContinue();
		over.finish();
		over.backHome();

		// should check that we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(product.isProductsPage(), "Back home  is not clicked, products page is not displayed");
		softAssert.assertAll();

	}
	
	@Test(description = "check the option of cancel on your information page")
	@Description("check the option of cancel on your information page")
	public void tc03_cancelInformationPage() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		menu.cart();
		cart.checkout();
		checkout.cancel();

		// should check that we are in the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(cart.isYourCartPage(), "Cancel button  is not clicked, catr page is not displayed");
		softAssert.assertAll();

	}

	@Test(description = "check the option of cancel on overview page")
	@Description("check the option of cancel on overview page")
	public void tc04_cancelOverviewPage() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart = new YourCartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CheckOutOverview over = new CheckOutOverview(driver);

		product.addToCart("Sauce Labs Fleece Jacket");
		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");
		checkout.infoContinue();
		over.cancel();
	

		// should check that we are in the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(product.isProductsPage(), "Cancel btn  is not clicked, products page is not displayed");
		softAssert.assertAll();

	}

}
