package reports;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

import reportManagement.Menu;
import reportManagement.ProjectTask;
import utilities.MonthsConversionTable;

public class EmployeeDetailedAnnualReport implements IReport {

	private static final String HASH_SPLITTER = "#";

	private String name;

	private int year;

	public EmployeeDetailedAnnualReport(String empName, int year) {
		this.name = empName;
		this.year = year;

	}

	public void printReport() {

		System.out.println();
		System.out.printf("\n\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez " + this.name
				+ " w roku: " + this.year + "\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-20s| %-40s | %-15s|\n", "Miesiąc", "Nazwa projektu", "ilość godzin");

		ArrayList<String> fullHashes = findData();

		for (String s : fullHashes) {

			String[] toPrint = s.split(HASH_SPLITTER);

			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.printf("|%-20s| %-40s | %-15s|\n",
					MonthsConversionTable.MONTHS_NAME[Integer.parseInt(toPrint[0])], toPrint[1], toPrint[2]);

		}

	}

	private ArrayList<String> findData() {

		HashMap<String, Float> foundProjectTasks = new HashMap<String, Float>();
		Calendar calendar = Calendar.getInstance();

		for (ProjectTask p : Menu.getProjectTasks()) {

			calendar.setTime(p.getDate());

			int resultYear = calendar.get(Calendar.YEAR);

			String key = hasher(p);

			if (p.getEmployeeName().equals(this.name) && resultYear == this.year) {

				if (!foundProjectTasks.containsKey(key)) {

					foundProjectTasks.put(key, p.getHours());

				} else {

					foundProjectTasks.put(key, foundProjectTasks.get(key) + p.getHours());

				}

			}

		}
		ArrayList<String> sortedProjectTasksList = hashMapToArrayListSorted(foundProjectTasks);
		return sortedProjectTasksList;
	}

	private static String hasher(ProjectTask projectTask) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(projectTask.getDate());

		String key = calendar.get(Calendar.MONTH) + HASH_SPLITTER + projectTask.getProjectName();

		return key;
	}

	private static String fullHasher(String hash, String hour) {
		String fullHash = hash + HASH_SPLITTER + hour;
		return fullHash;
	}

	private static ArrayList<String> hashMapToArrayListSorted(HashMap<String, Float> map) {
		ArrayList<String> arrayListFullHashes = new ArrayList<String>();

		for (String k : map.keySet()) {

			arrayListFullHashes.add(fullHasher(k, Float.toString(map.get(k))));
		}

		Collections.sort(arrayListFullHashes);

		return arrayListFullHashes;
	}

}