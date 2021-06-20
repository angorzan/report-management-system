package reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import reportManagement.Menu;
import reportManagement.ProjectTask;

public class EmployeeDetailedAnnualReport {

	public static void printReport(String employeeName, int year) {
		System.out.println();
		System.out.printf("\n\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez " + employeeName
				+ " w roku: " + year + "\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-20s| %-40s | %-15s|\n", "Miesiąc", "Nazwa projektu", "ilość godzin");

		ArrayList<ProjectTask> projects = findData(Menu.getProjectTasks(), employeeName, year);

		HashMap<String, Float> row = new HashMap<String, Float>();

		for (ProjectTask p : Menu.getProjectTasks()) {

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(p.getDate());

			int resultMonth = calendar.get(Calendar.MONTH) + 1;

			String key = p.getProjectName() + "#" + (resultMonth);
			float hours;

			if (row.get(p.getProjectName()) == null) {
				hours = 0;
			} else {
				hours = row.get(p.getProjectName());

			}

			row.put(key, hours + p.getHours());

		}

		for (String key : row.keySet()) {

			String[] projectName = key.split("#");
			
			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.printf("|%-20s| %-40s | %-15s|\n", projectName[1], projectName[0], row.get(key));

		}

	}

	private static ArrayList<ProjectTask> findData(ArrayList<ProjectTask> projectTasks, String employeeName, int year) {
		ArrayList<ProjectTask> foundProjectTasks = new ArrayList<>();
		for (ProjectTask p : projectTasks) {

			Calendar calendar = Calendar.getInstance();

			calendar.setTime(p.getDate());

			int resultYear = calendar.get(Calendar.YEAR);

			if (p.getEmployeeName() == employeeName && resultYear == year) {
				foundProjectTasks.add(p);
			}
		}
		return foundProjectTasks;
	}
}
