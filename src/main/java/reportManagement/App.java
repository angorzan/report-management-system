package reportManagement;

import java.io.IOException;

import utilities.PDFExporter;

public class App {
	public static void main(String[] args) throws IOException {

		Menu menu = new Menu("../report-management-system/src/test/resources");
		PDFExporter.generatePDF();
		menu.printMainMenu();

	}
}
