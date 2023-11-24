package pageObjects;

import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class MenuPage extends BasePage {

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;
	@FindBy(css = "#logout_sidebar_link")
	private WebElement menuLogoutBtn;
	@FindBy(css = "#about_sidebar_link")
	private WebElement aboutBtn;
	@FindBy(css = "#inventory_sidebar_link")
	private WebElement allItemstBtn;
	@FindBy(css = "#react-burger-cross-btn")
	private WebElement closeMenuBtn;
	@FindBy(css = ".shopping_cart_link")
	private WebElement openCart;
	@FindBy(css = ".social_twitter a")
	private WebElement twitterBtn;
	@FindBy(css = ".social_facebook a")
	private WebElement facebookBtn;
	@FindBy(css = ".social_linkedin a")
	private WebElement linkedinBtn;

	public MenuPage(WebDriver driver) {
		super(driver);

	}

	@Step("Click logout button")
	public void logout() {
		click(menuBtn);
		click(menuLogoutBtn);
	}

	@Step("Click all items button")
	public void allItemstBtn() {
		click(allItemstBtn);
	}

	@Step("Click about button")
	public void about() {
		click(aboutBtn);
	}

	@Step("Click open cart button")
	public void cart() {
		click(openCart);

	}

	@Step("Click close menu button")
	public void closeMenu() {
		click(closeMenuBtn);

	}

	@Step("Click twitter button")
	public void twitter() {
		click(twitterBtn);
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
			sleep(2000);
		}
	}

	@Step("Click facebook button")
	public void facebook() {
		click(facebookBtn);
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
			sleep(2500);
		}
	}

	@Step("Click linkedin button")
	public void linkedin() {
		click(linkedinBtn);
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
			sleep(2000);
		}
	}

}
