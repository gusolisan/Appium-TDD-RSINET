package br.com.rsinet.hub_tdd.appium.utils;

import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;

public class Relatorio {

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private static ExtentTest logger;

	public static ExtentReports inicializaRelatorio() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/Report.html");
		htmlReporter.config().setDocumentTitle("Relatorio de automacao de testes em ambiente mobile");
		htmlReporter.config().setReportName("Funcionalidades: Cadastro, Pesquisa por campo, Pesquisa pela tela");

		extent = new ExtentReports();

		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		extent.setSystemInfo("Machine", "Windows 10 " + "64 Bit");
		extent.setSystemInfo("Selenium", "3.141.59");
		extent.setSystemInfo("Appium", "1.15.1");
		extent.setSystemInfo("Maven", "4.0.0");
		extent.setSystemInfo("Java Version", "1.8.0_231");

		extent.attachReporter(htmlReporter);

		return extent;
	}

	/* Fecha o relatorio */
	public static void encerraRelatorio(ExtentReports extent) {
		extent.flush();
	}

	/* Cria o Report */
	public static ExtentTest inicializaTeste(String report) {
		logger = extent.createTest(report);
		return logger;
	}

	/* Verifica se o teste passou, falhou ou pulou e tira screenshot */
	public static void encerraTeste(ITestResult result, ExtentTest test, AndroidDriver<WebElement> driver)
			throws Exception {
		String screenshotPath = Screenshot.printScreen(driver);
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste falho: " + result.getName());
			test.log(Status.FAIL, "Caso de teste falho: " + result.getThrowable());

		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste pulado: " + result.getName());

		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste passado com sucesso: " + result.getName());
		}
		test.addScreenCaptureFromPath(screenshotPath);
	}
}