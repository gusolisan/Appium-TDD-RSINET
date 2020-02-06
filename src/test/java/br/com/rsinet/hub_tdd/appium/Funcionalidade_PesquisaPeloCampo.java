package br.com.rsinet.hub_tdd.appium;

import static org.testng.Assert.assertTrue;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.hub_tdd.appium.screenObject.Home_Screen;
import br.com.rsinet.hub_tdd.appium.screenObject.Search_Screen;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.appium.utils.Relatorio;

public class Funcionalidade_PesquisaPeloCampo {

	private AndroidDriverFactory driver;
	private MassaDeDados massaDeDados;
	private Home_Screen homeScreen;
	private Search_Screen searchScreen;;
	private ExtentReports report;
	private ExtentTest pesquisaPositiva;
	private ExtentTest pesquisaNegativa;
	private String cenario;

	@BeforeTest
	public void inicializaRelatorio() {
		report = Relatorio.setExtent("Relatorio de automacao de testes em ambiente mobile",
				"Funcionalidade de Pesquisa pelo Campo");
	}

	@BeforeMethod
	public void testConfigsOn() throws Exception {
		driver = new AndroidDriverFactory();
		driver.driverOn();

		homeScreen = new Home_Screen(driver.driverOn());
		searchScreen = new Search_Screen(driver.driverOn());

		massaDeDados = new MassaDeDados();

		ExcelUtils.setExcelFile(massaDeDados.getExcelPath(), massaDeDados.getSheetLupa());
	}

	@AfterMethod
	public void testConfigsOff(ITestResult result) throws Exception {
		if (cenario == "pesquisa positiva") {
			Relatorio.tearDown(result, pesquisaPositiva, driver.driverOn());
		} else if (cenario == "pesquisa negativa") {
			Relatorio.tearDown(result, pesquisaNegativa, driver.driverOn());
		}
		driver.driverOn().resetApp();
	}

	@AfterTest
	public void finalizaRelatorio() {
		Relatorio.fechaRelatorio(report);
		driver.driverOff();
	}

	@Test
	public void deveEncontrarProdutoExistentePelaBarraDePesquisa() throws Exception {
		cenario = "pesquisa positiva";
		pesquisaPositiva = Relatorio.criaRelatorio("Cenario: Pesquisar e encontrar produto existente");

		homeScreen.insereNoCampoDePesquisa(massaDeDados.nomeDoProdutoExistente());
		pesquisaPositiva.createNode("Nome do produto inserido no campo de pesquisa");

		homeScreen.clicaBotaoPesquisar();
		pesquisaPositiva.createNode("Pesquisa executada");

		assertTrue(searchScreen.produtoApareceNaTela(massaDeDados.nomeDoProdutoExistente()));
		pesquisaPositiva.createNode("Produto encontrado com sucesso");
	}

	@Test
	public void naoDeveEncontrarProdutoInexistentePelaBarraDePesquisa() throws Exception {
		cenario = "pesquisa negativa";
		pesquisaNegativa = Relatorio.criaRelatorio("Cenario: Pesquisar e nao encontrar produto inexistente");

		homeScreen.insereNoCampoDePesquisa(massaDeDados.nomeDoProdutoInexistente());
		pesquisaNegativa.createNode("Nome do produto inexistente inserido no campo de pesquisa");

		homeScreen.clicaBotaoPesquisar();
		pesquisaNegativa.createNode("Pesquisa executada");

		assertTrue(searchScreen.mensagemProdutoNaoEncontradoAparece());
		pesquisaNegativa.createNode("Produto inexistente nao aparece na tela");
	}
}