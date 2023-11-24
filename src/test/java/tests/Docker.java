package tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.Utils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class Docker {
	 @SuppressWarnings("serial")
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
	        ChromeOptions options = new ChromeOptions();
	        options.setCapability("browserVersion", "117.0");
	        options.setCapability("selenoid:options", new HashMap<String, Object>() {{
	            /* How to add test badge */
	            put("name", "Test badge...");
	            /* How to set session timeout */
	            put("sessionTimeout", "15m");
	            /* How to set timezone */
	            put("env", new ArrayList<String>() {{
	                add("TZ=UTC");
	            }});
	            /* How to add "trash" button */
	            put("labels", new HashMap<String, Object>() {{
	                put("manual", "true");
	            }});
	            /* How to enable video recording */
	            put("enableVideo", true);
	            put("enableVnc", true);
	        }});
	        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
	    	driver.get(Utils.readProperty("url"));
	        Thread.sleep(20000);
	    }
	}
