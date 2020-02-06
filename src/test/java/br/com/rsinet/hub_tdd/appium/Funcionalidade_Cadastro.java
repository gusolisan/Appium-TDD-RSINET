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
import br.com.rsinet.hub_tdd.appium.screenObject.Register_Screen;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados;
import br.com.rsinet.hub_tdd.appium.utils.Relatorio;

public class Funcionalidade_Cadastro {

	private AndroidDriverFactory driver;
	private MassaDeDados massaDeDados;
	private Home_Screen homeScreen;
	private Register_Screen registerScreen;
	private ExtentTest cadastroPositivo;
	private ExtentTest cadastroNegativo;
	private ExtentReports report;
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

		homeScreen = new Home_Screen(driver.driverOn());
		registerScreen = new Register_Screen(driver.driverOn());

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
			homeScreen.clicaMenu();
			cadastroPositivo.createNode("Menu do aplicativo acessado");

			homeScreen.clicaMenuDoUsuario();
			cadastroPositivo.createNode("Tela de login acessada");

			homeScreen.clicaBotaoDeCadastro();
			cadastroPositivo.createNode("Tela de cadastro acessada");

			registerScreen.preencheCampoUsuario(massaDeDados.usuario(i));
			registerScreen.preencheCampoEmail(massaDeDados.email(i));
			registerScreen.preencheCampoSenha(massaDeDados.senha(i));
			registerScreen.preencheCampoConfirmaSenha(massaDeDados.senha(i));
			registerScreen.preencheCampoNome(massaDeDados.nome(i));
			registerScreen.preencheCampoSobrenome(massaDeDados.sobrenome(i));
			registerScreen.preencheCampoTelefone(massaDeDados.telefone(i));

			registerScreen.rolarParaPreencherEndereco();

			registerScreen.selecionaPais(massaDeDados.nacionalidade(i));
			registerScreen.preencheCampoEstado(massaDeDados.estado(i));
			registerScreen.preencheCampoEndereco(massaDeDados.endereco(i));
			registerScreen.preencheCampoCidade(massaDeDados.cidade(i));
			registerScreen.preencheCampoCep(massaDeDados.cep(i));

			registerScreen.rolarParaSubmeterCadastro();

			registerScreen.submeteCadastro();
			cadastroPositivo.createNode("Formulario de cadastro preenchido e submetido");

			homeScreen.clicaMenu();
			cadastroPositivo.createNode("Nome de usuario aparece no menu do aplicativo");

			assertTrue(homeScreen.usuarioEstaLogado());

			if (i < indexDeUsuario) {
				homeScreen.clicaBotaoDeslogar();
				homeScreen.clicaConfirmaDeslog();
			}
		}
	}

	@Test
	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		teste = "cadastro negativo";

		cadastroNegativo = Relatorio.criaRelatorio("Cenario: Cadastro com falha");

		int indexDeUsuario = 1;

		homeScreen.clicaMenu();
		cadastroNegativo.createNode("Menu do aplicativo acessado");
		
		homeScreen.clicaMenuDoUsuario();
		cadastroNegativo.createNode("Tela de login acessada");

		homeScreen.clicaBotaoDeCadastro();
		cadastroNegativo.createNode("Tela de cadastro acessada");

		registerScreen.preencheCampoUsuario(massaDeDados.usuario(indexDeUsuario));
		registerScreen.preencheCampoEmail(massaDeDados.email(indexDeUsuario));
		registerScreen.preencheCampoSenha(massaDeDados.senha(indexDeUsuario));
		registerScreen.preencheCampoConfirmaSenha(massaDeDados.senha(indexDeUsuario));
		registerScreen.preencheCampoNome(massaDeDados.nome(indexDeUsuario));
		registerScreen.preencheCampoSobrenome(massaDeDados.sobrenome(indexDeUsuario));
		registerScreen.preencheCampoTelefone(massaDeDados.telefone(indexDeUsuario));

		registerScreen.rolarParaPreencherEndereco();

		registerScreen.selecionaPais(massaDeDados.nacionalidade(indexDeUsuario));
		registerScreen.preencheCampoEstado(massaDeDados.estado(indexDeUsuario));
		registerScreen.preencheCampoEndereco(massaDeDados.endereco(indexDeUsuario));
		registerScreen.preencheCampoCidade(massaDeDados.cidade(indexDeUsuario));
		registerScreen.preencheCampoCep(massaDeDados.cep(indexDeUsuario));

		registerScreen.rolarParaSubmeterCadastro();

		registerScreen.submeteCadastro();

		homeScreen.clicaMenu();
		cadastroNegativo.createNode("Usuario ja existente nao se cadastra novamente");

		assertTrue(homeScreen.menuDeLoginContinuaAtivo());
	}
}