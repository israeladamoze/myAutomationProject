package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);

	}

	public void fillText(WebElement el, String text) {
		// highlight
		js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow; border: 1px solid blue;');", el);
		el.clear();
		sleep(300);
		el.sendKeys(text);
	}

	protected void openUrl(String url) {
		driver.get(url);
	}

	public void click(WebElement el) {
		// highlight
		js.executeScript("arguments[0].setAttribute('style', 'background-color:yellow; border: 1px solid blue;');", el);
		sleep(300);
		el.click();
	}

	public String getText(WebElement el) {
		// highlight
		js.executeScript("arguments[0].setAttribute('style', 'background-color:green; border: 1px solid orange;');",
				el);
		return el.getText();
	}

	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void scroll_down_by_y(int y) {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0," + y + ")", "");

	}

	private JavascriptExecutor getDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
