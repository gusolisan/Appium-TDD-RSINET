package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class Home_Page {

	private AndroidDriver<WebElement> driver;

	public Home_Page(AndroidDriver<WebElement> driver) {
		this.driver = driver;
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

//	ações dos elementos:

	public void clicaMenu() {
		menu().click();
	}

	public void clicaMenuDoUsuario() {
		menuDoUsuario().click();
	}

	public void clicaBotaoDeCadastro() {
		botaoDeCadastro().click();
	}

	public void clicaBotaoDeslogar() {
		botaoDeslogar().click();
	}

	public void clicaConfirmaDeslog() {
		confirmaDeslog().click();
	}

	public boolean usuarioEstaLogado() {
		return botaoDeslogar().isEnabled();
	}
}