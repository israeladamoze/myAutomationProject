package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.qameta.allure.Description;
import pageObjects.ProductsPage;

public class OrderByProductsTestNG extends BaseLoginTestNG {

	@Test(description = "check ordering products from A to Z")
	@Description("check ordering products from A to Z")
	public void tc01_orderAZ() {
		ProductsPage product = new ProductsPage(driver);

		// before filter capture the order
		List<WebElement> before = product.getProductList();
		List<String> before_text = new ArrayList<String>();

		// convert WebElement to string
		for (WebElement wb : before) {
			before_text.add(product.getText(wb));
		}

		// filter AZ from the drop down
		product.sortAtoZ();

		// after filter capture the order
		List<WebElement> after = product.getProductList();
		List<String> after_text = new ArrayList<String>();

		// convert webelement to string
		for (WebElement wb : after) {
			after_text.add(product.getText(wb));
		}

		// compare the values 
		SoftAssert softAssert = new SoftAssert();
		Collections.sort(before_text);
		Assert.assertEquals(before_text, after_text, "List is not sorted from A to Z.");
		softAssert.assertAll();

	}

	@Test(description = "check ordering products from Z to A")
	@Description("check ordering products from Z to A")
	public void tc02_orderZA() {
		ProductsPage product = new ProductsPage(driver);

		// before filter capture the order
		List<WebElement> before = product.getProductList();
		List<String> before_text = new ArrayList<String>();

		// convert WebElement to string
		for (WebElement wb : before) {
			before_text.add(product.getText(wb));
		}

		// filter ZA from the drop down
		product.sortZtoA();

		// after filter capture the order
		List<WebElement> after = product.getProductList();
		List<String> after_text = new ArrayList<String>();

		// convert webelement to string
		for (WebElement wb : after) {
			after_text.add(product.getText(wb));
		}

		// convert webelement to string
		SoftAssert softAssert = new SoftAssert();
		Collections.sort(before_text);
		Collections.sort(before_text, Collections.reverseOrder());
		Assert.assertEquals(before_text, after_text, "List is not sorted from Z to A.");
		softAssert.assertAll();

	}

	@Test(description = "check ordering products price from low to high ")
	@Description("check ordering products price from low to high")
	public void tc03_orderPriceLowHigh() {
		ProductsPage product = new ProductsPage(driver);

		// before filter capture the prices
		List<WebElement> beforeFilterPrice = product.getpPricetList();

		// convert the string to double and remove the $ sign
		List<Double> beforeFilterPriceList = new ArrayList<>();

		for (WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}

		// filter the price from the drop down
		product.sortPriceLowToHigh();

		// after filter capture the prices
		List<WebElement> aftreFilterPrice = product.getpPricetList();
		List<Double> aftreFilterPriceList = new ArrayList<>();

		// convert the string to double and remove the $ sign
		for (WebElement p : aftreFilterPrice) {
			aftreFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}

		// compare the values /Assert the values
		SoftAssert softAssert = new SoftAssert();
		Collections.sort(beforeFilterPriceList);// it will sort the values in the list
		Assert.assertEquals(beforeFilterPriceList, aftreFilterPriceList,"List is not sorted from low to high prices");
		softAssert.assertAll();

	}

	@Test(description = "check ordering products price from high to low")
	@Description("check ordering products price from high to low")
	public void tc04_orderPriceHighLow() {
		ProductsPage product = new ProductsPage(driver);

		// before filter capture the prices
		List<WebElement> beforeFilterPrice = product.getpPricetList();

		// convert the string to double and remove the $ sign
		List<Double> beforeFilterPriceList = new ArrayList<>();

		for (WebElement p : beforeFilterPrice) {
			beforeFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}

		// filter the price from the drop down
		product.sortPriceHighToLow();

		// after filter capture the prices
		List<WebElement> aftreFilterPrice = product.getpPricetList();
		List<Double> aftreFilterPriceList = new ArrayList<>();

		// convert the string to double and remove the $ sign
		for (WebElement p : aftreFilterPrice) {
			aftreFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}

		// compare the values /Assert the values
		SoftAssert softAssert = new SoftAssert();
		Collections.sort(beforeFilterPriceList);// it will sort the values in the list
		Collections.sort(beforeFilterPriceList, Collections.reverseOrder());
		Assert.assertEquals(beforeFilterPriceList, aftreFilterPriceList, "List is not sorted from high to low prices");
		softAssert.assertAll();

	}
}
