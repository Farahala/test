import java.net.URL;
import java.net.MalformedURLException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileBy;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class IosTest {
	IOSDriver<IOSElement> driver;
	BrowserStack BS= new BrowserStack();
	@BeforeClass
	  public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();

		  caps.setCapability("device", "iPhone 11 Pro");
		    caps.setCapability("os_version", "13");
		    caps.setCapability("project", "IOT Project");
		    caps.setCapability("build", "IOT First Build");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");
	    caps.setCapability("app", "bs://444bd0308813ae0dc236f8cd461c02d3afa7901d");
	    driver  = new IOSDriver<IOSElement>(new URL("http://"+BS.userName+":"+BS.accessKey+"@hub-cloud.browserstack.com/wd/hub"), caps);
	} 
		
  @Test
  public void f() throws InterruptedException {
	  IOSElement textButton = (IOSElement) new WebDriverWait(driver, 30).until(
		        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Button")));
		    textButton.click();
		    IOSElement textInput = (IOSElement) new WebDriverWait(driver, 30).until(
		        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Input")));
		    textInput.sendKeys("hello@browserstack.com\n");

		    Thread.sleep(5000);

		    IOSElement textOutput = (IOSElement) new WebDriverWait(driver, 30).until(
		        ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("Text Output")));

		    if(textOutput != null && textOutput.getText().equals("hello@browserstack.com"))
		        assert(true);
		    else
		        assert(false);
  }
  @AfterClass
  
  public void close()
  {
 	 driver.quit();
  }
}
