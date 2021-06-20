package reports;

import java.util.ArrayList;

import reportManagement.Menu;
import reportManagement.ProjectTask;

public class EmployeeDetailedAnnualReport {


	public static void printReport(String employeeName, int year) {
		
		ArrayList<ProjectTask> projects = findData(Menu.getProjectTasks(), employeeName, year);
		for (ProjectTask p : Menu.getProjectTasks()) {
			System.out.println(p.getDate().getMonth() + " | " + p.getProjectName() + " | " + p.getHours());
		}
	}

	private static ArrayList<ProjectTask> findData(ArrayList<ProjectTask> projectTasks, String employeeName, int year) {
		ArrayList<ProjectTask> foundProjectTasks = new ArrayList<>();
		for (ProjectTask p : projectTasks) {
			//if (p.getEmployeeName() == employeeName && p.getDate().getYear() == year) {
				foundProjectTasks.add(p);
			//}
		}
		return foundProjectTasks;
	}
}
