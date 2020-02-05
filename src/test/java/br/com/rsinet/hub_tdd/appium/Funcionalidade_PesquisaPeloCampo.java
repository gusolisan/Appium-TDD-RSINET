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

import br.com.rsinet.hub_tdd.appium.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.appium.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.appium.utils.Relatorio;

public class Funcionalidade_PesquisaPeloCampo {

	private AndroidDriverFactory driver;
	private MassaDeDados massaDeDados;
	private Home_Page homePage;
	private Register_Page registerPage;
	private ExtentReports report;
	private ExtentTest cadastroPositivo;
	private ExtentTest cadastroNegativo;
	private String teste;

	@BeforeTest
	public void inicializaRelatorio() {
		report = Relatorio.setExtent("Relatorio de automacao de testes em ambiente mobile",
				"Funcionalidade de Pesquisa pelo Campo");
	}

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
	public void testConfigsOff(ITestResult result) throws Exception {
		if (teste == "cadastro positivo") {
			Relatorio.tearDown(result, cadastroPositivo, driver.driverOn());
		} else if (teste == "cadastro negativo") {
			Relatorio.tearDown(result, cadastroNegativo, driver.driverOn());
		}
		driver.driverOff();
	}

	@AfterTest
	public void finalizaRelatorio() {
		Relatorio.fechaRelatorio(report);
	}

	@Test
	public void deveCadastrarNovoUsuario() throws Exception {
		teste = "cadastro positivo";

		cadastroPositivo = Relatorio.criaRelatorio("Cenario: Cadastro com sucesso");

		int indexDeUsuario = 1;

		for (int i = 1; i <= indexDeUsuario; i++) {
			homePage.clicaMenu();
			cadastroPositivo.createNode("Menu do aplicativo acessado");

			homePage.clicaMenuDoUsuario();
			cadastroPositivo.createNode("Pagina de login acessado");

			homePage.clicaBotaoDeCadastro();
			cadastroPositivo.createNode("Pagina de cadastro acessado");

			registerPage.preencheCampoUsuario(massaDeDados.usuario(i));
			registerPage.preencheCampoEmail(massaDeDados.email(i));
			registerPage.preencheCampoSenha(massaDeDados.senha(i));
			registerPage.preencheCampoConfirmaSenha(massaDeDados.senha(i));
			registerPage.preencheCampoNome(massaDeDados.nome(i));
			registerPage.preencheCampoSobrenome(massaDeDados.sobrenome(i));
			registerPage.preencheCampoTelefone(massaDeDados.telefone(i));

			registerPage.rolarParaPreencherEndereco();

			registerPage.selecionaPais(massaDeDados.nacionalidade(i));
			registerPage.preencheCampoEstado(massaDeDados.estado(i));
			registerPage.preencheCampoEndereco(massaDeDados.endereco(i));
			registerPage.preencheCampoCidade(massaDeDados.cidade(i));
			registerPage.preencheCampoCep(massaDeDados.cep(i));

			registerPage.rolarParaSubmeterCadastro();

			registerPage.submeteCadastro();
			cadastroPositivo.createNode("Formulario de cadastro preenchido e submetido");

			Thread.sleep(2000);

			homePage.clicaMenu();
			cadastroPositivo.createNode("Nome de usuario aparece no menu do aplicativo");

			assertTrue(homePage.usuarioEstaLogado());

			if (i < indexDeUsuario) {
				homePage.clicaBotaoDeslogar();
				homePage.clicaConfirmaDeslog();
			}
		}
	}

	@Test
	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		teste = "cadastro negativo";

		cadastroNegativo = Relatorio.criaRelatorio("Cenario: Cadastro com falha");

		int indexDeUsuario = 1;

		homePage.clicaMenu();
		cadastroNegativo.createNode("Menu do aplicativo acessado");
		
		homePage.clicaMenuDoUsuario();
		cadastroNegativo.createNode("Pagina de login acessada");

		homePage.clicaBotaoDeCadastro();
		cadastroNegativo.createNode("Pagina de cadastro acessada");

		registerPage.preencheCampoUsuario(massaDeDados.usuario(indexDeUsuario));
		registerPage.preencheCampoEmail(massaDeDados.email(indexDeUsuario));
		registerPage.preencheCampoSenha(massaDeDados.senha(indexDeUsuario));
		registerPage.preencheCampoConfirmaSenha(massaDeDados.senha(indexDeUsuario));
		registerPage.preencheCampoNome(massaDeDados.nome(indexDeUsuario));
		registerPage.preencheCampoSobrenome(massaDeDados.sobrenome(indexDeUsuario));
		registerPage.preencheCampoTelefone(massaDeDados.telefone(indexDeUsuario));

		registerPage.rolarParaPreencherEndereco();

		registerPage.selecionaPais(massaDeDados.nacionalidade(indexDeUsuario));
		registerPage.preencheCampoEstado(massaDeDados.estado(indexDeUsuario));
		registerPage.preencheCampoEndereco(massaDeDados.endereco(indexDeUsuario));
		registerPage.preencheCampoCidade(massaDeDados.cidade(indexDeUsuario));
		registerPage.preencheCampoCep(massaDeDados.cep(indexDeUsuario));

		registerPage.rolarParaSubmeterCadastro();

		registerPage.submeteCadastro();

		Thread.sleep(2000);

		homePage.clicaMenu();
		cadastroNegativo.createNode("Usuario ja existente nao e cadastrado");

		assertTrue(homePage.paginaDeLoginContinuaAtiva());
	}
}