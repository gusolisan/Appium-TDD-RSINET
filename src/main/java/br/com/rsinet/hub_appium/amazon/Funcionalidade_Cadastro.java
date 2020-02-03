package br.com.rsinet.hub_appium.amazon;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import br.com.rsinet.hub_tdd.appium.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.appium.pageObject.Register_Page;
import io.appium.java_client.android.AndroidDriver;

public class Funcionalidade_Cadastro {

	private static AndroidDriver<WebElement> driver;
	private Home_Page homePage;
	private Register_Page registerPage;

	@Before
	public void teste() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "DrGusPhone");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		homePage = new Home_Page(driver);
		registerPage = new Register_Page(driver);
	}

	
	@After
	public void encerraTeste() {
		driver.quit();
	}

	@Test
	public void deveCadastrarNovoUsuario() {
		homePage.clicaMenu();
		homePage.clicaMenuDoUsuario();
		homePage.clicaBotaoDeCadastro();
		
		registerPage.preencheCampoUsuario("meuMaoar");
		registerPage.preencheCampoEmail("test@email.comis");
		registerPage.preencheCampoSenha("Gus!123");
		registerPage.preencheCampoConfirmaSenha("Gus!123");
		registerPage.preencheCampoNome("Gustavo");
		registerPage.preencheCampoSobrenome("Santos");
		registerPage.preencheCampoTelefone("(11)91234-5678");
		
		registerPage.rolarParaPreencherEndereco();
		
		registerPage.selecionaPais();
		registerPage.preencheCampoEstado("SP");
		registerPage.preencheCampoEndereco("Rua teste, 00");
		registerPage.preencheCampoCidade("Guarulhos");
		registerPage.preencheCampoCep("12345-678");
		
		registerPage.rolarParaSubmeterCadastro();
		
		registerPage.submeteCadastro();
		
		homePage.clicaMenu();

		assertTrue(homePage.usuarioEstaLogado());
	}
}