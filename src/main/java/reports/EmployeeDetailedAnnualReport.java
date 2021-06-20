package reports;

import java.util.ArrayList;
import java.util.HashMap;

import reportManagement.Menu;
import reportManagement.ProjectTask;

public class EmployeeDetailedAnnualReport {

	public static void printReport(String employeeName, int year) {

		ArrayList<ProjectTask> projects = findData(Menu.getProjectTasks(), employeeName, year);

		HashMap<String, Float> row = new HashMap<String, Float>();

		for (ProjectTask p : Menu.getProjectTasks()) {
			String key = p.getProjectName() + "#" + p.getDate().getMonth();
			float hours;

			if (row.get(p.getProjectName()) == null) {
				hours = 0;
			} else {
				hours = row.get(p.getProjectName());

			}

			row.put(key, hours + p.getHours());

		}

		for (String key : row.keySet()) {
			System.out.println(key + " | " + row.get(key));

		}

	}

	private static ArrayList<ProjectTask> findData(ArrayList<ProjectTask> projectTasks, String employeeName, int year) {
		ArrayList<ProjectTask> foundProjectTasks = new ArrayList<>();
		for (ProjectTask p : projectTasks) {
			if (p.getEmployeeName() == employeeName && p.getDate().getYear() == year) {
				foundProjectTasks.add(p);
			}
		}
		return foundProjectTasks;
	}
}
