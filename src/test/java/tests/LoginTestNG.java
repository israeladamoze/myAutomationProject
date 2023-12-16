package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utilities.AllureAttachment;

public class LoginTestNG extends BaseTestNG {
	@Owner("Israela Damoze")
	@Epic("Login")
	@Feature("Validation")
	@Story("Entring only password, getting an error message and not be able to login")
	@Test(description = "check login with empty username")
	@Description("check login with empty username")
	public void tc01_loginFailed() {
		LoginPage login = new LoginPage(driver);

		login.login("", "secret_sauce");

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Epic sadface: Username is required";
		String actualErrorMessage = login.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Error message is not right");
		softAssert.assertAll();
	}

	@Epic("Login")
	@Feature("Validation")
	@Story("Entring only user name getting an error message and not be able to login")
	@Test(description = "check login with empty password")
	@Description("check login with empty password")
	public void tc02_loginFailed() {
		LoginPage login = new LoginPage(driver);
		driver.navigate().refresh();

		login.login("standard_user", "");

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Epic sadface: Password is required";
		String actualErrorMessage = login.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Error message is not right");
		softAssert.assertAll();
	}

	@Epic("Login")
	@Feature("Validation")
	@Story("Entring wrong password, getting an error message and not be able to login")
	@Test(description = "check login with wrong password")
	@Description("check login with wrong passwor")
	public void tc03_loginFailed() {
		LoginPage login = new LoginPage(driver);
		login.login("standard_user", "1211");

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMessage = login.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Error message is not right");
		softAssert.assertAll();

	}

	@Epic("Login")
	@Feature("Validation")
	@Story("Entring wrong user name, getting an error message and not be able to login")
	@Test(description = "check login with wrong username")
	@Description("check login with wrong username")
	public void tc04_loginFailed() {
		LoginPage login = new LoginPage(driver);
		login.login("user", "secret_sauce");

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMessage = login.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Error message is not right");
		softAssert.assertAll();

	}

	@Epic("Login")
	@Feature("Validation")
	@Story("Entring wrong user name and password, getting an error message and not be able to login")
	@Test(dataProvider = "getData", description = "check login with wrong username and password")
	@Description("check login with wrong username and password")
	public void tc05_loginFailed(String user, String password) {
		LoginPage login = new LoginPage(driver);
		login.login(user, password);

		// should check that we get the right message
		SoftAssert softAssert = new SoftAssert();
		String exepctedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
		String actualErrorMessage = login.getErrorMsg();
		Assert.assertEquals(exepctedErrorMessage, actualErrorMessage, "Error message is not right");
		softAssert.assertAll();

	}

	@Epic("Login")
	@Feature("Login success")
	@Story("Entering a correct username and password and entering the products page")
	@Test(description = "check login with valid user name and password ")
	@Description("check login with valid user name and password ")
	public void tc06_login() {
		LoginPage login = new LoginPage(driver);
		ProductsPage product = new ProductsPage(driver);

		 login.login("standard_user", "secret_sauce");

		AllureAttachment.attachCSV("user,secret\n" + "gali,_sauce\n" + "yonit ,567889\n" + "dan,34567\n");

		// should check that we are logged in
		SoftAssert softAssert = new SoftAssert();
		Assert.assertTrue(product.isProductsPage(), "You can't login, wrong details");
		softAssert.assertAll();

	}

	@DataProvider
	public Object[][] getData() {
		Object[][] myData = { { "user", "secret" }, { "gali", "_sauce" }, { "yonit", "567889" }, { "dan", "34567" }, };
		return myData;
	}

}
