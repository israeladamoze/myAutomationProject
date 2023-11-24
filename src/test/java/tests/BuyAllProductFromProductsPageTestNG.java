package tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.CheckOutOverview;
import pageObjects.CheckoutPage;
import pageObjects.MenuPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class BuyAllProductFromProductsPageTestNG extends BaseLoginTestNG {

	@Severity(SeverityLevel.CRITICAL)
	@Test(description = "check buying all products from product page")
	@Description("check buying all products from product page")
	public void tc01_buyproductfromproductpage() {
		ProductsPage product = new ProductsPage(driver);
		MenuPage menu = new MenuPage(driver);
		YourCartPage cart= new YourCartPage(driver);
		CheckOutOverview over= new CheckOutOverview(driver);
		
		CheckoutPage checkout = new CheckoutPage(driver);

		List<WebElement> allProducts = product.getAdd_to_cart_btn();

		for (WebElement item : allProducts) {
			product.click(item);
		}

		menu.cart();
		cart.checkout();
		checkout.yourInformation("Isra", "Ela", "81573");

		checkout.infoContinue();
		over.finish();

		utilities.AllureAttachment.attachText("In this test the user is buying all the products in the list");

		// should check that we completed checkout and we are in the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(over.isorderCompleted(), "buying process is not completed");
		softAssert.assertAll();

	}

}
