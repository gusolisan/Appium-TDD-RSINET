package br.com.rsinet.hub_tdd.appium;


import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.hub_tdd.appium.pageObject.Home_Page;
import br.com.rsinet.hub_tdd.appium.pageObject.Register_Page;
import br.com.rsinet.hub_tdd.appium.utils.AndroidDriverFactory;
import br.com.rsinet.hub_tdd.appium.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.appium.utils.MassaDeDados_Manager;

public class Funcionalidade_Cadastro {

	private Home_Page homePage;
	private Register_Page registerPage;
	private AndroidDriverFactory driver;
	private MassaDeDados_Manager massaDeDados;

	@BeforeMethod
	public void testConfigsOn() throws Exception {
		driver = new AndroidDriverFactory();
		driver.driverOn();

		homePage = new Home_Page(driver.driverOn());
		registerPage = new Register_Page(driver.driverOn());

		massaDeDados = new MassaDeDados_Manager();
		ExcelUtils.setExcelFile(massaDeDados.getExcelPath(), massaDeDados.getSheetCadastro());
	}

	@AfterMethod
	public void testConfigsOff() {
		
		driver.driverOff();
	}

	@Test
	public void deveCadastrarNovoUsuario() throws Exception {

		int numeroDeUsuariosParaCadastrar = 2;

		for (int i = 1; i <= numeroDeUsuariosParaCadastrar; i++) {
			homePage.clicaMenu();
			homePage.clicaMenuDoUsuario();
			homePage.clicaBotaoDeCadastro();

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

			Thread.sleep(2000);

			homePage.clicaMenu();

			assertTrue(homePage.usuarioEstaLogado());
			
			homePage.clicaBotaoDeslogar();
			homePage.clicaConfirmaDeslog();
		}
	}

	public void naoDeveCadastrarUsuarioExistente() throws Exception {
		int indexDeUsuario = 1;
		homePage.clicaMenu();
		homePage.clicaMenuDoUsuario();
		homePage.clicaBotaoDeCadastro();

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

		assertFalse(homePage.usuarioEstaLogado());
	}
}