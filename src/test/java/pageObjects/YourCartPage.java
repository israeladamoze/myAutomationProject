package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class YourCartPage extends MenuPage {

	@FindBy(css = "#continue-shopping")
	private WebElement continueBtn;
	@FindBy(css = "#checkout")
	private WebElement checkoutBtn;
	@FindBy(css = "btn_small cart_button")
	private List<WebElement> removeBtn;
	@FindBy(css = ".inventory_item_name")
	private WebElement itemName;
	@FindBy(css = "span.shopping_cart_badge")
	private WebElement number_of_items;
	@FindBy(css = ".title")
	private WebElement titleLabel;
	@FindBy(css = ".cart_item_label")
	private List<WebElement> itemsList;

	public YourCartPage(WebDriver driver) {
		super(driver);

	}

	@Step("Click countinue shopping button")
	public void continueShopping() {
		click(continueBtn);
	}

	@Step("Click checkout button")
	public void checkout() {
		click(checkoutBtn);
	}

	@Step("Click item:{0}")
	public void itemsList(int i) {
		click(itemsList.get(i));
	}
	
	@Step("Click remove:{0}")
	public void remove() {
		List<WebElement> elementsRemoveBtn = driver
				.findElements(By.cssSelector(".btn.btn_secondary.btn_small.cart_button"));

		for (int i = 0; i < elementsRemoveBtn.size(); ++i) {
			WebElement remove = elementsRemoveBtn.get(1);
			click(remove);

		}

	}

	public String getProducts() {
		return getText(itemName);
	}

	public WebElement getItemName() {
		return itemName;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getCheckoutBtn() {
		return checkoutBtn;
	}

	public List<WebElement> getRemoveBtn() {
		return removeBtn;
	}

	public WebElement getNumbers_of_items() {
		return number_of_items;
	}

	public List<WebElement> getItemsList() {
		return itemsList;
	}

	// validations
	public boolean isYourCartPage() {
		if (getText(titleLabel).equalsIgnoreCase("Your Cart")) {
			return true;
		}
		return false;

	}

}
