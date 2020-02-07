package br.com.rsinet.hub_tdd.appium.screenObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Register_Screen {

	private AndroidDriver<WebElement> driver;
	private TouchAction action;
	private WebDriverWait wait;

	public Register_Screen(AndroidDriver<WebElement> driver) {
		this.driver = driver;
		action = new TouchAction(driver);
		wait = new WebDriverWait(driver, 5);
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
		wait.until(ExpectedConditions.elementToBeClickable(nomeUsuario())).sendKeys(usuario);
	}

	public void preencheCampoEmail(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(email())).sendKeys(email);
	}

	public void preencheCampoSenha(String senha) {
		wait.until(ExpectedConditions.elementToBeClickable(senha())).sendKeys(senha);
	}

	public void preencheCampoConfirmaSenha(String senha) {
		wait.until(ExpectedConditions.elementToBeClickable(confirmaSenha())).sendKeys(senha);
	}

	public void preencheCampoNome(String nome) {
		wait.until(ExpectedConditions.elementToBeClickable(nome())).sendKeys(nome);
	}

	public void preencheCampoSobrenome(String sobrenome) {
		wait.until(ExpectedConditions.elementToBeClickable(sobrenome())).sendKeys(sobrenome);
	}

	public void preencheCampoTelefone(String telefone) {
		wait.until(ExpectedConditions.elementToBeClickable(telefone())).sendKeys(telefone);
	}

	public void rolarParaPreencherEndereco() {
		action.press(PointOption.point(860, 1400)).moveTo(PointOption.point(814, 400)).release().perform();
	}

	public void selecionaPais(String nomeDoPais) {
		wait.until(ExpectedConditions.elementToBeClickable(pais())).click();

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
		wait.until(ExpectedConditions.elementToBeClickable(estado())).sendKeys(estado);
	}

	public void preencheCampoEndereco(String endereco) {
		wait.until(ExpectedConditions.elementToBeClickable(endereco())).sendKeys(endereco);
	}

	public void preencheCampoCidade(String cidade) {
		wait.until(ExpectedConditions.elementToBeClickable(cidade())).sendKeys(cidade);
	}

	public void preencheCampoCep(String cep) {
		wait.until(ExpectedConditions.elementToBeClickable(cep())).sendKeys(cep);
	}

	public void rolarParaSubmeterCadastro() {
		action.press(PointOption.point(668, 1030)).moveTo(PointOption.point(672, 387)).release().perform();
	}

	public void submeteCadastro() {
		wait.until(ExpectedConditions.elementToBeClickable(botaoRegistrarCadastro())).click();
	}
}