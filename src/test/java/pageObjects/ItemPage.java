package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ItemPage extends BasePage {

	@FindBy(css = "[id^='add-to-cart']")
	private WebElement addToCartBtn;
	@FindBy(css = "#back-to-products")
	private WebElement backBtn;
	@FindBy(css = "#remove-sauce-labs-bike-light")
	private WebElement removeBtn;

	public ItemPage(WebDriver driver) {
		super(driver);
	}

	@Step("click add to cart button")
	public void addToCart() {
		click(addToCartBtn);
	}

	@Step("click back to products button")
	public void backToProducts() {
		click(backBtn);
	}

	@Step("click remove button")
	public void removeBtn() {
		click(removeBtn);
	}

}