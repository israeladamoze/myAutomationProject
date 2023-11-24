package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckOutOverview extends BasePage {

	@FindBy(css = "#finish")
	private WebElement finishBtn;
	@FindBy(css = ".title")
	private WebElement titleLabel;
	@FindBy(css = ".complete-header")
	private WebElement thank_you_message;
	@FindBy(css = "#back-to-products")
	private WebElement backHomeBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;

	public CheckOutOverview(WebDriver driver) {
		super(driver);

	}

	@Step("Click finish button")
	public void finish() {
		click(finishBtn);
	}

	@Step("Click cancel button")
	public void cancel() {
		click(cancelBtn);
	}

	@Step("Click back home button")
	public void backHome() {
		click(backHomeBtn);
	}

	// validations

	public boolean ischeckoutOverviewPage() {
		if (getText(titleLabel).equalsIgnoreCase("Checkout: Overview")) {
			return true;
		}
		return false;

	}

	public boolean isorderCompleted() {
		if (getText(thank_you_message).equalsIgnoreCase("Thank you for your order!")) {
			return true;
		}
		return false;

	}

}
