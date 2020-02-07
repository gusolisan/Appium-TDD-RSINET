package br.com.rsinet.hub_tdd.appium;

import static org.testng.Assert.assertEquals;
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
import br.com.rsinet.hub_tdd.appium.screenObject.Product_Screen;
import br.com.rsinet.hub_tdd.appium.screenObject.Search_Screen;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.appium.utils.Relatorio;

public class Funcionalidade_PesquisaDeProduto {

	private AndroidDriverFactory driver;
	private MassaDeDados massaDeDados;
	private Home_Screen homeScreen;
	private Search_Screen searchScreen;;
	private Product_Screen productScreen;
	private ExtentReports report;
	private ExtentTest pesquisaCliquePositiva;
	private ExtentTest pesquisaCliqueNegativa;
	private String cenario;

	@BeforeTest
	public void inicializaRelatorio() {
		report = Relatorio.inicializaRelatorio();
	}

	@BeforeMethod
	public void testConfigsOn() throws Exception {
		driver = new AndroidDriverFactory();

		driver.driverOn();

		homeScreen = new Home_Screen(driver.driverOn());
		searchScreen = new Search_Screen(driver.driverOn());
		productScreen = new Product_Screen(driver.driverOn());

		massaDeDados = new MassaDeDados();

		ExcelUtils.setExcelFile(massaDeDados.getExcelPath(), massaDeDados.getSheetPesquisa());
	}

	@AfterMethod
	public void testConfigsOff(ITestResult result) throws Exception {
		if (cenario == "Cenario: Pesquisa por produto existente com filtros") {
			Relatorio.encerraTeste(result, pesquisaCliquePositiva, driver.driverOn());
		} else if (cenario == "Cenario: Pesquisa por produto inexistente com filtros") {
			Relatorio.encerraTeste(result, pesquisaCliqueNegativa, driver.driverOn());
		}
		driver.driverOn().resetApp();
	}

	@AfterTest
	public void finalizaRelatorio() {
		Relatorio.encerraRelatorio(report);
		driver.driverOff();
	}

	@Test
	public void deveEncontrarProdutoComDeterminadoSFiltros() throws Exception {
		cenario = "Cenario: Pesquisa por produto existente com filtros";

		pesquisaCliquePositiva = Relatorio.inicializaTeste(cenario);

		homeScreen.clicaBotaoHeadphones();
		pesquisaCliquePositiva.createNode("Categoria Headphones acessada");

		searchScreen.clicaFiltro();
		pesquisaCliquePositiva.createNode("Filtro acessado");

		searchScreen.clicaFiltroCompatibilidade();
		pesquisaCliquePositiva.createNode("Filtro compatibilidade acessado");

		searchScreen.clicaFiltroCompatibilidade_AcrossAllDevices();
		pesquisaCliquePositiva.createNode("Produtos com conector 3.5mm selecionado");

		searchScreen.clicaApplyFiltro();
		pesquisaCliquePositiva.createNode("Filtro aplicado");

		String nomeDoProduto = searchScreen.nomePrimeiroProduto();
		pesquisaCliquePositiva.createNode("Produto com as especificacoes aparece na tela de pesquisa");

		searchScreen.clicaPrimeiroProduto();
		pesquisaCliquePositiva.createNode("Produto com as especificacoes corresponde ao que aparece na tela de produto");

		assertEquals(nomeDoProduto, productScreen.nomeDoProdutoNaTela());
	}

	@Test
	public void naoDeveEncontrarProdutoComDeterminadosFiltros() {
		cenario = "Cenario: Pesquisa por produto inexistente com filtros";
		
		pesquisaCliqueNegativa = Relatorio.inicializaTeste(cenario);
		
		homeScreen.clicaBotaoHeadphones();
		pesquisaCliqueNegativa.createNode("Categoria Headphones acessada");

		searchScreen.clicaFiltro();
		pesquisaCliqueNegativa.createNode("Filtro acessado");

		searchScreen.clicaFiltroCompatibilidade();
		pesquisaCliqueNegativa.createNode("Filtro compatibilidade acessado");

		searchScreen.clicaFiltroCompatibilidade_AcrossAllDevices();
		pesquisaCliqueNegativa.createNode("Produtos com conector 3.5mm selecionado");

		searchScreen.clicaFiltroConnector();
		pesquisaCliqueNegativa.createNode("Filtro conector acessado");

		searchScreen.clicaFiltroConnector_Bluetooth();
		pesquisaCliqueNegativa.createNode("Conector bluetooth selecionado");
		
		searchScreen.clicaApplyFiltro();
		pesquisaCliqueNegativa.createNode("Filtro aplicado");
		
		assertTrue(searchScreen.mensagemProdutoNaoEncontradoAparece());
		pesquisaCliqueNegativa.createNode("Sem resultados de produtos disponiveis com os filtros selecionados");
	}
}