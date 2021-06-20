package reportManagement;

import reports.EmployeeDetailedAnnualReport;

public class App {
	public static void main(String[] args) {

		Menu menu = new Menu("../report-management-system/src/test/resources");
		menu.printMainMenu();
		EmployeeDetailedAnnualReport.printReport("Jan Kowalski", 2012);

	}
}
