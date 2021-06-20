package reportManagement;

import reports.EmployeeAlphabeticalReport;
import reports.EmployeeDetailedAnnualReport;
import reports.ProjectEmployeeConsumptionReport;
import reports.ProjectSummaryHoursReport;

public class App {
	public static void main(String[] args) {

		Menu menu = new Menu("../report-management-system/src/test/resources");
//		menu.printMainMenu();
		
		EmployeeAlphabeticalReport.printReport(2012);	//raport 1
		System.out.println("------------------------");
		System.out.println("------------------------");
		ProjectSummaryHoursReport.printReport(2012);	// raport2
		System.out.println("------------------------");
		System.out.println("------------------------");
		EmployeeDetailedAnnualReport.printReport("Jan Kowalski", 2012);	// raport 3
		System.out.println("------------------------");
		System.out.println("------------------------");
		ProjectEmployeeConsumptionReport.printReport("Projekt2");	// raport 4
	}
}
