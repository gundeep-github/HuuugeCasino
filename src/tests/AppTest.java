package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class AppTest {

	private AndroidDriver driver;

	@BeforeClass
	public void setUp() {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "OnePlus 6");
		caps.setCapability("udid", "26c606c9"); // device id
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10");
		caps.setCapability("appPackage", "com.huuuge.casino.slots");
		caps.setCapability("appActivity", "com.huuuge.casino.BootActivity");
		caps.setCapability("noReset", "true");

		try {
			driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps); // Instantiate Android Driver

		} catch (MalformedURLException e) {
			System.out.println(e.getMessage());
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void test() throws InterruptedException {
		Thread.sleep(6000);
		WebElement w1 = (WebElement) driver.findElements(By.className("android.view.View")).get(0);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); // to handle popup
		TouchAction action = new TouchAction(driver);
		Thread.sleep(3000);
		action.tap(PointOption.point(291, 71)).perform(); // open profile
		Thread.sleep(3000);
		action.tap(PointOption.point(1726, 62)).perform(); // close profile
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDown() {
		driver.closeApp(); // kill app
	}
}
