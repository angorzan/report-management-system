package reportManagement;

import reports.EmployeeAlphabeticalReport;
import reports.EmployeeDetailedAnnualReport;
import reports.ProjectEmployeeConsumptionReport;
import reports.ProjectSummaryHoursReport;

public class App {
	public static void main(String[] args) {

		Menu menu = new Menu("../report-management-system/src/test/resources");
		menu.printMainMenu();
		
//		EmployeeAlphabeticalReport.printReport(2012);	//raport 1
//
//		ProjectSummaryHoursReport.printReport(2012);	// raport2
//
//		EmployeeDetailedAnnualReport.printReport("Jan Kowalski", 2012);	// raport 3
//
//		ProjectEmployeeConsumptionReport.printReport("Projekt2");	// raport 5
	}
}
