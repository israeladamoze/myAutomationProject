 package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.MenuPage;

public class FooterSocialNetworksTestNG extends BaseLoginTestNG {

	@Test(description = "check opening twitter link ")
	@Description("check opening twitter link")
	public void tc01_openTwitter() {
		MenuPage menu = new MenuPage(driver);
		menu.twitter();
		String URL = driver.getCurrentUrl();

		// should check that we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(URL.contains("https://twitter.com/"),"Twitter link is not opening");
		softAssert.assertAll();

	}

	@Test(description = "check opening facebook link ")
	@Description("check opening facebook link ")
	public void tc02_openFacebook() {
		MenuPage menu = new MenuPage(driver);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		menu.facebook();
		String URL = driver.getCurrentUrl();

		// should check that we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(URL.contains("https://www.facebook.com/saucelabs"),"Facebook link is not opening");
		softAssert.assertAll();

	}

	@Test(description = "check opening linkedin link ")
	@Description("check opening linkedin link")
	public void tc03_openLinkedin() {
		MenuPage menu = new MenuPage(driver);
		driver.navigate().to("https://www.saucedemo.com/inventory.html");
		menu.linkedin();
		String URL = driver.getCurrentUrl();

		// should check that we are on the right page
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(URL.contains("https://www.linkedin.com/"),"Linkedin link is not opening");
		softAssert.assertAll();

	}

}
