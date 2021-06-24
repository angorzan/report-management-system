package reportManagement;

import java.io.IOException;

import reports.*;
import utilities.BarChart;
import utilities.PDFExporter;

public class App {
	public static void main(String[] args) throws IOException {

		Menu menu = new Menu("../report-management-system/src/test/resources");
//		menu.printMainMenu();

		IReport report = new EmployeeDetailedAnnualReport("Jan Kowalski", 2015);
//		IReport report = new EmployeeDetailedAnnualReport("Joanna Maj", 2016);
		
		PDFExporter.generatePDF(report);
		
	}
}
