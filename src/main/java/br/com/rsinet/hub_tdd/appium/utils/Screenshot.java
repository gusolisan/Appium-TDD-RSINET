package br.com.rsinet.hub_tdd.appium.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

	public final static String printPath = "C:\\My Workspace\\AppiumTDD\\target\\prints\\";

	public static String printScreen(WebDriver driver) throws Exception {
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);

		String imageFileDir = printPath;

		String setPrint = imageFileDir + System.currentTimeMillis() + ".png";
		File printConfig = new File(setPrint);

		try {
			FileUtils.copyFile(srcFile, printConfig);
		} catch (Exception e) {
		}
		return setPrint;
	}

}
