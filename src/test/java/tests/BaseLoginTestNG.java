package tests;

import org.testng.annotations.BeforeClass;

import pageObjects.LoginPage;

public class BaseLoginTestNG extends BaseTestNG {

	@BeforeClass
	public void setupLogin() {
		LoginPage lp = new LoginPage(driver);
		lp.login("standard_user", "secret_sauce");
	}

}
