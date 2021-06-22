package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectEmployeeConsumptionReport {

	private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();

	public static void printReport(String projectName) {

		Map<String, Float> map = new HashMap<>();
		for (ProjectTask p : projectTasks) {

			if (p.getProjectName().equals(projectName)) {

				float hours;
				if (map.get(p.getEmployeeName()) == null) {
					hours = 0;
				} else {
					hours = map.get(p.getEmployeeName());
				}
				map.put(p.getEmployeeName(), hours + p.getHours());
			}
		}
		Map<String, Float> result = new TreeMap<String, Float>(map);

		int sumOfHours = 0;

		System.out.printf("\n\n\nWyświetlenie raportu sumarycznego godzin projektowych dla projektu " + projectName + ":\n");
		System.out.println("______________________________________________________________________");
		System.out.printf("|%-40s | %-20s|\n", "Nazwisko i imię", "Lączna suma godzin");

		for (String key : result.keySet()) {

			System.out.println("----------------------------------------------------------------------");
			System.out.printf("|%-40s | %-20s|\n", key, result.get(key));
			sumOfHours += result.get(key);

		}

		System.out.printf("\n\nŁączna ilość pracy nad projektem " + sumOfHours + " godzin");
		System.out.println();
		System.out.println();
	}

}
