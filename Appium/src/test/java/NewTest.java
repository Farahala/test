import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class NewTest {
	 AndroidDriver<AndroidElement> driver;
	@BeforeClass
	  public void setUp() throws MalformedURLException {
		 DesiredCapabilities caps = new DesiredCapabilities();

		    caps.setCapability("device", "Google Pixel 3");
		    caps.setCapability("os_version", "9.0");
		    caps.setCapability("project", "My First Project");
		    caps.setCapability("build", "My First Build");
		    caps.setCapability("name", "Bstack-[Java] Sample Test");
		    caps.setCapability("app", "bs://ee57780e8e32cf5658631b516d9d2be405f4bb47");

		    driver  = new AndroidDriver<AndroidElement>(new URL("https://farahalaamohamed1:ftPhAePNrA6ebm2uxuGu@hub-cloud.browserstack.com/wd/hub"), caps);
		
	}
		
  @Test
  public void f() throws InterruptedException {
	 

	    AndroidElement searchElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	            ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Search Wikipedia")));
	        searchElement.click();
	        AndroidElement insertTextElement = (AndroidElement) new WebDriverWait(driver, 30).until(
	            ExpectedConditions.elementToBeClickable(MobileBy.id("org.wikipedia.alpha:id/search_src_text")));
	        insertTextElement.sendKeys("BrowserStack");
	        Thread.sleep(5000);

	        List<AndroidElement> allProductsName = driver.findElementsByClassName("android.widget.TextView");
	        assert(allProductsName.size() > 0);

  }
 @AfterClass
 
 public void close()
 {
	 driver.quit();
 }
}

