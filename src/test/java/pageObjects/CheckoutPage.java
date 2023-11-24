package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutPage extends BasePage {

	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement postalcodeField;
	@FindBy(css = "#continue")
	private WebElement infoContinueBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;
	@FindBy(css = ".error h3")
	private WebElement errorLabel;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@Step("Fill information:{0}")
	public void yourInformation(String firstName, String lastName, String zip) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(postalcodeField, zip);
	}

	@Step("Click continue button")
	public void infoContinue() {
		click(infoContinueBtn);
	}

	@Step("Click cancel button")
	public void cancel() {
		click(cancelBtn);
	}

	// Validation
	public String getErrorMsg() {
		return getText(errorLabel);
	}

}
