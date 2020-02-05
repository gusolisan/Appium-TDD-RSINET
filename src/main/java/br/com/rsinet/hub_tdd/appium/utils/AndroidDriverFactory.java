package br.com.rsinet.hub_tdd.appium.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverFactory {

	private AndroidDriver driver;
	private DesiredCapabilities caps;

	public AndroidDriverFactory() {
		caps = new DesiredCapabilities();
	}

	public AndroidDriver driverOn() throws MalformedURLException {
		if (driver == null) {
			caps.setCapability("deviceName", "DrGusPhone");
			caps.setCapability("platformVersion", "9");
			caps.setCapability("platformName", "Android");
			caps.setCapability("appPackage", "com.Advantage.aShopping");
			caps.setCapability("appActivity", ".SplashActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		return driver;
	}

	public AndroidDriver driverOff() {
		if (driver != null) {
			driver.quit();
		}
		return driver = null;
	}

}
