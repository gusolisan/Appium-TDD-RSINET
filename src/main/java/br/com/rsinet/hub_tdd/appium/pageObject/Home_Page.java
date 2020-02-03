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
		return driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]");
	}

	private WebElement menuDoUsuario() {
		return driver.findElementById("com.Advantage.aShopping:id/textViewMenuUser");
	}
	
	private WebElement botaoDeCadastro() {
		return driver.findElementById("com.Advantage.aShopping:id/textViewSingUpToday");
	}
	
	private WebElement botaoDeslogar() {
		return driver.findElementByXPath("//android.support.v4.widget.DrawerLayout[@content-desc=\"Main Menu\"]/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
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
	
	public boolean usuarioEstaLogado() {
		return botaoDeslogar().isEnabled();
	}
}