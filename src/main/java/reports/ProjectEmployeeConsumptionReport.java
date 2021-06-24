package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.*;

public class ProjectEmployeeConsumptionReport implements IReport {

	private String projectName;

	private ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();

	public ProjectEmployeeConsumptionReport(String projectName) {
		this.projectName = projectName;
	}

	public void printReport() {

		Map<String, Float> result = getData();
		int sumOfHours = 0;

		System.out.printf("\n\nZestawienie godzin projektowych dla projektu " + this.projectName.toUpperCase() + "\n");
		System.out.println("_____________________________________________________________________");
		System.out.printf("| %-40s | %-20s|\n", "Imię i nazwisko", "Liczba godzin");

		for (String key : result.keySet()) {

			System.out.println("---------------------------------------------------------------------");
			System.out.printf("| %-40s | %-20s|\n", key, result.get(key));
			sumOfHours += result.get(key);

		}

		System.out.printf("\n\nŁączna liczba godzin pracy nad projektem " + this.projectName.toUpperCase() + ": " + sumOfHours);
		System.out.println();
		System.out.println();
	}

	public Map<String, Float> getData() {

		Map<String, Float> map = new HashMap<>();
		for (ProjectTask p : projectTasks) {

			if (p.getProjectName().toLowerCase().equals(this.projectName.toLowerCase())) {

				float hours;
				if (map.get(p.getEmployeeName()) == null) {
					hours = 0;
				} else {
					hours = map.get(p.getEmployeeName());
				}
				map.put(p.getEmployeeName(), hours + p.getHours());
			}
		}
		return new TreeMap<String, Float>(map);
	}

}
