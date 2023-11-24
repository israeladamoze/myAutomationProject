package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import pageObjects.LoginPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;

public class MenuOptionsTestNG extends BaseTestNG {

	@Epic("Menu")
	@Feature("Click about page")
	@Story("As a User when I click on about at the menu about page appears")
	@Test(description = "check about page is displayed")
	@Description("check about page is displayed")

	public void tc01_aboutPage() {
		LoginPage login = new LoginPage(driver);
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);

		login.login("standard_user", "secret_sauce");
		product.menuBtn();
		menu.about();
		String URL = driver.getCurrentUrl();

		// should check that we are on about page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(URL.contains("https://saucelabs.com/"), "About page is not displayed");
		softAssert.assertAll();

	}

	@Epic("Menu")
	@Feature("Click logout option in the menu")
	@Story("As a User when I click on logout button at the menu, it leads to login page and im not logged in anymore")
	@Test(description = "check that you can logout")
	@Description("check that you can logout")
	public void tc02_logoutOption() {
		MenuPage menu = new MenuPage(driver);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");

		menu.logout();
		String URL = driver.getCurrentUrl();

		// should check that we are on login page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(URL, "https://www.saucedemo.com/", "Login page is not displayed");
		softAssert.assertAll();

	}

	@Epic("Menu")
	@Feature("Click all items option in the menu")
	@Story("As a User when I click on all items button, products page appears")
	@Test(description = "check all items option display products page")
	@Description("check all items option display products page")
	public void tc03_allItemsOption() {
		LoginPage login = new LoginPage(driver);
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);

		login.login("standard_user", "secret_sauce");
		product.menuBtn();
		menu.allItemstBtn();

		String URL = driver.getCurrentUrl();

		// should check that we are on products page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(URL.contains("https://www.saucedemo.com/inventory.html"), "Products page is not displayed");
		softAssert.assertAll();

	}

	@Epic("Menu")
	@Feature("Click open and close menu option")
	@Story("As a User when I click on open button the menu will open and when I click X it will close the menu")
	@Test(description = "check the option of openeing and closing the menu")
	@Description("check the option of openeing and closing the menu")
	public void tc04_openAndCloseOption() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);

		menu.closeMenu();

		// should check that we are on products page
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Open Menu";
		String actualErrorMessage = product.getBtnTitle();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Menu is still open");
		softAssert.assertAll();

	}
}
