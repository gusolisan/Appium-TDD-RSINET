package br.com.rsinet.hub_tdd.appium.screenObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Search_Screen {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public Search_Screen(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

//	Metodos para asserts:

	public boolean mensagemProdutoNaoEncontradoAparece() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "No results for" + "\").instance(0))")))
				.isDisplayed();
	}

	public boolean produtoApareceNaTela(String produto) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ produto + "\").instance(0))")))
				.isDisplayed();
	}
}