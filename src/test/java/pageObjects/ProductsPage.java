package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class ProductsPage extends BasePage {

	@FindBy(css = ".inventory_item")
	private List<WebElement> itemsList;

	@FindBy(css = ".product_sort_container")
	private WebElement filterBtn;

	@FindBy(css = "[value='az']")
	private WebElement aTozBtn;

	@FindBy(css = "[value='za']")
	private WebElement zToaBtn;

	@FindBy(css = "[value='lohi']")
	private WebElement lowToHighBtn;

	@FindBy(css = "[value='hilo']")
	private WebElement highToLowBtn;

	@FindBy(css = ".title")
	private WebElement titleLabel;

	@FindBy(css = ".shopping_cart_link")
	private WebElement cartBtn;

	@FindBy(css = ".btn_inventory")
	private List<WebElement> add_to_cart_btn;

	@FindBy(css = ".shopping_cart_badge")
	private WebElement numbers_of_items;

	@FindBy(css = ".inventory_item_name")
	private List<WebElement> productList;

	@FindBy(css = ".inventory_item_price")
	private List<WebElement> pricetList;

	@FindBy(css = "#react-burger-menu-btn")
	private WebElement menuBtn;

	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	@Step("Choose product:{0}")
	public void chooseProduct(String productName) {
		for (WebElement el : itemsList) {
			WebElement titleEl = el.findElement(By.cssSelector(".inventory_item_name"));
			String name = getText(titleEl);
			if (name.equalsIgnoreCase(productName)) {
				click(titleEl);
				break;
			}
		}
	}

	@Step("Add to cart:{0}")
	public void addToCart(String productName) {
		for (WebElement el : itemsList) {
			String title = getText(el.findElement(By.cssSelector(".inventory_item_name")));
			if (title.equalsIgnoreCase(productName)) {
				click(el.findElement(By.cssSelector(".btn_inventory.btn_primary")));
				break;
			}
		}
	}
	
	@Step("Remove product from cart:{0}")
	public void removePrduct(String productName) {
		for (WebElement el : itemsList) {
			String title = getText(el.findElement(By.cssSelector(".inventory_item_name")));
			if (title.equalsIgnoreCase(productName)) {
				click(el.findElement(By.cssSelector(".btn.btn_secondary.btn_small.btn_inventory")));
				break;
			}
		}

	}

	@Step("Click sort a to z")
	public void sortAtoZ() {
		click(filterBtn);
		click(aTozBtn);
	}

	@Step("Click sort z to a")
	public void sortZtoA() {
		click(filterBtn);
		click(zToaBtn);
	}

	@Step("Click sort low to high")
	public void sortPriceLowToHigh() {
		click(filterBtn);
		click(lowToHighBtn);
	}

	@Step("Click sort high to low")
	public void sortPriceHighToLow() {
		click(filterBtn);
		click(highToLowBtn);
	}

	@Step("Click cart button")
	public void cartBtn() {
		click(cartBtn);
	}
	
	@Step("Click menu button")
	public void menuBtn() {
		click(menuBtn);
	}

	@Step("Add to cart")
	public void add_to_cart_btn(int i) {
		click(add_to_cart_btn.get(i));
	}

	public WebElement getNumbers_of_items() {
		return numbers_of_items;
	}

	public List<WebElement> getProductList() {
		List<WebElement> listproduct = new ArrayList<>(productList);
		return listproduct;
	}

	public List<WebElement> getpPricetList() {
		List<WebElement> listprice = new ArrayList<>(pricetList);
		return listprice;
	}

	public String getBtnTitle() {
		return getText(menuBtn);
	}

	public List<WebElement> getAdd_to_cart_btn() {
		return add_to_cart_btn;
	}

	// Validation

	public boolean isProductsPage() {
		if (getText(titleLabel).equalsIgnoreCase("products")) {
			return true;
		}
		return false;

	}

}
