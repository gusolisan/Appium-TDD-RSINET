package br.com.rsinet.hub_tdd.appium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import br.com.rsinet.hub_tdd.appium.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.appium.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados;

public class Funcionalidade_PesquisaDeProduto {
	
	private Home_Page homePage;
	private Register_Page registerPage;
	private AndroidDriverFactory driver;
	private MassaDeDados massaDeDados;
	
	@BeforeMethod
	public void testConfigsOn() throws Exception {
		driver = new AndroidDriverFactory();
		driver.driverOn();

		homePage = new Home_Page(driver.driverOn());
		registerPage = new Register_Page(driver.driverOn());

		massaDeDados = new MassaDeDados();
		ExcelUtils.setExcelFile(massaDeDados.getExcelPath(), massaDeDados.getSheetCadastro());
	}

	@AfterMethod
	public void testConfigsOff() {
		driver.driverOff();
	}
}
