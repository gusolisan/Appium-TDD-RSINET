package br.com.rsinet.hub_tdd.appium.screenObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class Home_Screen {

	private AndroidDriver<WebElement> driver;
	private WebDriverWait wait;

	public Home_Screen(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 10);
	}

//	elementos da pagina principal do aplicativo:

	private WebElement menu() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]");
	}

	private WebElement menuDoUsuario() {
		return driver.findElementByXPath(
				"//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView");
	}

	private WebElement botaoDeCadastro() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView[2]");
	}

	private WebElement botaoDeslogar() {
		return driver.findElementByXPath(
				"//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
	}

	private WebElement confirmaDeslog() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]");
	}

	private WebElement campoDePesquisa() {
		return driver.findElementById("com.Advantage.aShopping:id/editTextSearch");
	}

	private WebElement botaoPesquisar() {
		return driver.findElementById("com.Advantage.aShopping:id/imageViewSearch");
	}

	private WebElement botaoHeadphones() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.ImageView");
	}

	private WebElement botaoLaptop() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.ImageView");
	}

	private WebElement botaoTablets() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[3]/android.widget.ImageView");
	}

	private WebElement botaoMice() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView");
	}

//	ações dos elementos:

	public void clicaMenu() {
		wait.until(ExpectedConditions.elementToBeClickable(menu())).click();
	}

	public void clicaMenuDoUsuario() {
		wait.until(ExpectedConditions.elementToBeClickable(menuDoUsuario())).click();
	}

	public void clicaBotaoDeCadastro() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoDeCadastro())).click();
	}

	public void clicaBotaoDeslogar() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoDeslogar())).click();
	}

	public void clicaConfirmaDeslog() {
		wait.until(ExpectedConditions.elementToBeClickable(confirmaDeslog())).click();
	}

	public void insereNoCampoDePesquisa(String pesquisa) {
		wait.until(ExpectedConditions.elementToBeClickable(campoDePesquisa())).sendKeys(pesquisa);
	}

	public void clicaBotaoPesquisar() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoPesquisar())).click();
	}

	public void clicaBotaoLaptop() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoLaptop())).click();
	}

	public void clicaBotaoHeadphones() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoHeadphones())).click();
	}

	public void clicaBotaoTablets() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoTablets())).click();
	}

	public void clicaBotaoMice() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoMice())).click();
	}

//	Métodos para asserts:

	public boolean usuarioEstaLogado() {
		return botaoDeslogar().isEnabled();
	}

	public boolean menuDeLoginContinuaAtivo() {
		return menuDoUsuario().isEnabled();
	}
}