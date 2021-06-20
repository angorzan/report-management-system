package reportManagement;

import reports.EmployeeDetailedAnnualReport;

public class App {
	public static void main(String[] args) {
		
		Menu menu = new Menu("src/test/resources/reporter-dane");
		EmployeeDetailedAnnualReport.printReport("Jan Kowalski", 2012);
		//menu.printMainMenu();
		menu.printMainMenu();

	}
}
