package reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

import reportManagement.Menu;
import reportManagement.ProjectTask;
import utilities.MonthsConversionTable;

public class EmployeeDetailedAnnualReport {

	public static void printReport(String employeeName, int year) {
		System.out.println();
		System.out.printf("\n\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez " + employeeName
				+ " w roku: " + year + "\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-20s| %-40s | %-15s|\n", "Miesiąc", "Nazwa projektu", "ilość godzin");

		ArrayList<ProjectTask> projects = findData(employeeName, year);

		for (ProjectTask p : projects) {

			String key = hasher(p);

			String[] projectName = key.split("#");

			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.printf("|%-20s| %-40s | %-15s|\n",
					MonthsConversionTable.MONTHS_NAME[Integer.parseInt(projectName[0])], projectName[1], p.getHours());

		}

	}

	private static ArrayList<ProjectTask> findData(String employeeName, int year) {

		HashMap<String, ProjectTask> foundProjectTasks = new HashMap<String, ProjectTask>();
		Calendar calendar = Calendar.getInstance();

		for (ProjectTask p : Menu.getProjectTasks()) {

			calendar.setTime(p.getDate());

			int resultYear = calendar.get(Calendar.YEAR);
			String key = hasher(p);
			if (p.getEmployeeName().equals(employeeName) && resultYear == year) {

				if (!foundProjectTasks.containsKey(key)) {

					foundProjectTasks.put(key, p);
				} else {

					for (String k : foundProjectTasks.keySet()) {

						if (hasher(foundProjectTasks.get(k)).equals(hasher(p))) {
							foundProjectTasks.get(key).setHours(foundProjectTasks.get(key).getHours() + p.getHours());
						}

					}

				}
			}
		}
		ArrayList<ProjectTask> sortedProjectTasksList = hashMapToArrayListSorted(foundProjectTasks);
		return sortedProjectTasksList;
	}

	private static String hasher(ProjectTask projectTask) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(projectTask.getDate());

		String key = calendar.get(Calendar.MONTH) + "#" + projectTask.getProjectName();

		return key;
	}

	private static ArrayList<ProjectTask> hashMapToArrayListSorted(HashMap<String, ProjectTask> map) {
		ArrayList<String> arrayListHashes = new ArrayList<String>();
		ArrayList<ProjectTask> arrayListProjectTasksSorted = new ArrayList<ProjectTask>();

		for (String k : map.keySet()) {
			arrayListHashes.add(k);
		}

		Collections.sort(arrayListHashes);

		for (String s : arrayListHashes) {
			arrayListProjectTasksSorted.add(map.get(s));
		}

		return arrayListProjectTasksSorted;
	}

}
