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

//	elementos da pagina de cadastro do aplicativo:

	private WebElement primeiroProduto() {
		return driver.findElementByXPath(
				"//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.TextView[1]");
	}

	private WebElement botaoFiltro() {
		return driver.findElementByXPath(
				"//android.widget.RelativeLayout[@content-desc=\"Headphones\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView");
	}

	private WebElement filtroCompatibilidade() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView");
	}

	private WebElement filtroCompatibilidade_AcrossAllDevices() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView");
	}

	private WebElement applyFiltro() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView[3]");
	}

	private WebElement filtroConnector() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[6]/android.widget.LinearLayout/android.widget.TextView");
	}

	private WebElement filtroConnector_Bluetooth() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ExpandableListView/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView");
	}

//	ações dos elementos:

	public String nomePrimeiroProduto() {
		return primeiroProduto().getText();
	}

	public void clicaPrimeiroProduto() {
		wait.until(ExpectedConditions.elementToBeClickable(primeiroProduto())).click();
	}

	public void clicaFiltro() {
		wait.until(ExpectedConditions.visibilityOf(primeiroProduto()));
		wait.until(ExpectedConditions.elementToBeClickable(botaoFiltro())).click();
	}

	public void clicaFiltroCompatibilidade() {
		wait.until(ExpectedConditions.elementToBeClickable(filtroCompatibilidade())).click();
	}

	public void clicaFiltroCompatibilidade_AcrossAllDevices() {
		wait.until(ExpectedConditions.elementToBeClickable(filtroCompatibilidade_AcrossAllDevices())).click();
	}

	public void clicaFiltroConnector() {
		wait.until(ExpectedConditions.elementToBeClickable(filtroConnector())).click();
	}

	public void clicaFiltroConnector_Bluetooth() {
		wait.until(ExpectedConditions.elementToBeClickable(filtroConnector_Bluetooth())).click();
	}

	public void clicaApplyFiltro() {
		wait.until(ExpectedConditions.elementToBeClickable(applyFiltro())).click();
	}

//	Metodos para asserts:

	public boolean mensagemProdutoNaoEncontradoAparece() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "No results" + "\").instance(0))")))
				.isDisplayed();
	}

	public boolean produtoApareceNaTela(String produto) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ produto + "\").instance(0))")))
				.isDisplayed();
	}
}