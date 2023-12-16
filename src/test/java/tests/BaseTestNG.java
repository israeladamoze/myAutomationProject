package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import java.awt.*;
import java.net.URISyntaxException;

public class BaseTestNG {
	WebDriver driver;

	@Parameters({ "browser" })
	@BeforeClass

	public void setup(ITestContext testContext, @Optional("Chrome") String browser) {
		driver = WebDriverManager.chromedriver().create();
		testContext.setAttribute("WebDriver", this.driver);
	switch (browser) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(Utils.readProperty("url"));
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(Utils.readProperty("url"));
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(Utils.readProperty("url"));
			break;
		default:
			throw new IllegalArgumentException("no such browser " + browser);
		}	
	}
   
	public void setup() throws URISyntaxException, IOException {
		WebDriverManager webDriverManager = WebDriverManager.chromedriver().browserInDocker().enableVnc()
				.enableRecording();
		driver = webDriverManager.create();
		Desktop.getDesktop().browse(webDriverManager.getDockerNoVncUrl().toURI());
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url"));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	/*
	 * This method will run after wach test, it will take screen shot only for tests
	 * that failed
	 */

	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// result.getname() method will give you current test case name.
			// ./ScreenShots/ tell you that, in your current directory, create folder
			// ScreenShots. dot represents current directory
		}
	}
}
