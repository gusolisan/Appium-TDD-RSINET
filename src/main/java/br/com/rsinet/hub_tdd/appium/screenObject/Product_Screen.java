package br.com.rsinet.hub_tdd.appium.screenObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Product_Screen {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;
	
	public Product_Screen(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}
	
	private WebElement nomeDoProdutoNaTelaDeCompra() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView");

	}
	
	private WebElement botaoAdicionaAoCarrinho() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.Button");
	}
	
	public void clicaBotaoAdicionaAoCarrinho() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoAdicionaAoCarrinho())).click();
	}
	
	public String nomeDoProdutoNaTela() {
		return nomeDoProdutoNaTelaDeCompra().getText();
	}
}
