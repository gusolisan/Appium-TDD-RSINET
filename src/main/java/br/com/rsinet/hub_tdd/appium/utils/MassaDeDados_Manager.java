package br.com.rsinet.hub_tdd.appium.utils;

public class MassaDeDados_Manager {

	private final String excelPath = "C:\\My Workspace\\AppiumTDD\\src\\main\\java\\br\\com\\rsinet\\hub_tdd\\appium\\dadosParaTeste\\DadosParaTeste.xlsx";
	private final String sheetCadastro = "Cadastro";
	private final String sheetLupa = "Pesquisar pela barra";
	private final String sheetPesquisa = "Pesquisar pela pagina";

	public String getExcelPath() {
		return excelPath;
	}

	public String getSheetCadastro() {
		return sheetCadastro;
	}

	public String getSheetLupa() {
		return sheetLupa;
	}

	public String getSheetPesquisa() {
		return sheetPesquisa;
	}

	public String usuario(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 2);
	}

	public String senha(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 3);
	}

	public String email(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 4);
	}

	public String nome(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 5);
	}

	public String sobrenome(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 6);
	}

	public String telefone(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 7);
	}

	public String nacionalidade(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 8);
	}

	public String estado(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 9);
	}

	public String endereco(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 10);
	}

	public String cidade(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 11);
	}

	public String cep(int numeroDoUsuario) throws Exception {
		return ExcelUtils.getCellData(numeroDoUsuario, 12);
	}
}