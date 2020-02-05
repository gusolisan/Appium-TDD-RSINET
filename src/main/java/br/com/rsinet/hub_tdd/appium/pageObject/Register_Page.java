package br.com.rsinet.hub_tdd.appium.pageObject;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Register_Page {

	private AndroidDriver driver;
	private TouchAction action;

	public Register_Page(AndroidDriver driver) {
		this.driver = driver;
		action = new TouchAction(driver);
	}

//	elementos da pagina de cadastro do aplicativo:

	private WebElement nomeUsuario() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement email() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement senha() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement confirmaSenha() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement nome() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText");
	}

	private WebElement sobrenome() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText");
	}

	private WebElement telefone() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement pais() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]");
	}

	private WebElement paisDesejado(String nomeDoPais) {
		return driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ nomeDoPais + "\").instance(0))");
	}

	private WebElement estado() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement endereco() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText");
	}

	private WebElement cidade() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText");
	}

	private WebElement cep() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText");
	}

	private WebElement botaoTermos() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.CheckBox[2]");
	}

	private WebElement botaoRegistrarCadastro() {
		return driver.findElementByXPath(
				"//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button");
	}

//	ações dos elementos:

	public void preencheCampoUsuario(String usuario) {
		nomeUsuario().sendKeys(usuario);
	}

	public void preencheCampoEmail(String email) {
		email().sendKeys(email);
	}

	public void preencheCampoSenha(String senha) {
		senha().sendKeys(senha);
	}

	public void preencheCampoConfirmaSenha(String senha) {
		confirmaSenha().sendKeys(senha);
	}

	public void preencheCampoNome(String nome) {
		nome().sendKeys(nome);
	}

	public void preencheCampoSobrenome(String sobrenome) {
		sobrenome().sendKeys(sobrenome);
	}

	public void preencheCampoTelefone(String telefone) {
		telefone().sendKeys(telefone);
//		action.press(PointOption.point(961, 1752)).moveTo(PointOption.point(983, 143)).release().perform();
	}

	public void rolarParaPreencherEndereco() {
		action.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 400)).release().perform();
	}

	public void selecionaPais(String nomeDoPais) {
		pais().click();

		boolean achouPais = false;

		while (achouPais == false) {
			try {
				paisDesejado(nomeDoPais).click();
				achouPais = true;
				break;
			} catch (Exception e) {
				(new TouchAction(driver)).press(PointOption.point(677, 1139)).moveTo(PointOption.point(693, 315))
						.release().perform();
			}
		}
	}

	public void preencheCampoEstado(String estado) {
		estado().sendKeys(estado);
	}

	public void preencheCampoEndereco(String endereco) {
		endereco().sendKeys(endereco);
	}

	public void preencheCampoCidade(String cidade) {
		cidade().sendKeys(cidade);
	}

	public void preencheCampoCep(String cep) {
		cep().sendKeys(cep);
	}

	public void rolarParaSubmeterCadastro() {
		action.press(PointOption.point(668, 1030)).moveTo(PointOption.point(672, 387)).release().perform();
	}

	public void submeteCadastro() {
		botaoRegistrarCadastro().click();
	}
}