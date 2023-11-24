package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	@FindBy(css = "#user-name")
	private WebElement userField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;
	@FindBy(css = "[data-test='error']")
	private WebElement errorLabel;

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	@Step("fill login details {0}, click login button")
	public void login(String user, String password) {
		fillText(userField, user);
		fillText(passwordField, password);
		click(loginBtn);
	}

	// Validation
	public String getErrorMsg() {
		return getText(errorLabel);
	}

}
