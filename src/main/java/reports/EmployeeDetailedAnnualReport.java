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

    public String getReportName() {
    	return "EmployeeDetailedAnnualReport" + "_" + this.year + "_" + this.name;
    }
	
	public void printReport() {

		System.out.println();
		System.out.printf("\n\nZestawienie miesięczne godzin przepracowanych przez " + this.name.toUpperCase()
				+ " w roku " + this.year + "\n");
		System.out.println("______________________________________________________________________________________");
		System.out.printf("| %-20s| %-40s | %-15s|\n", "Miesiąc", "Nazwa projektu", "Ilość godzin");

		ArrayList<String> fullHashes = getData();

		for (String s : fullHashes) {

			String[] toPrint = s.split(HASH_SPLITTER);

			System.out
					.println("--------------------------------------------------------------------------------------");
			System.out.printf("| %-20s| %-40s | %-15s|\n",
					MonthsConversionTable.MONTHS_NAME[Integer.parseInt(toPrint[0]) - 10], toPrint[1], toPrint[2]);

		}

	}

	private ArrayList<String> getData() {

		HashMap<String, Float> foundProjectTasks = new HashMap<String, Float>();
		Calendar calendar = Calendar.getInstance();

		for (ProjectTask p : Menu.getProjectTasks()) {

			calendar.setTime(p.getDate());

			int resultYear = calendar.get(Calendar.YEAR);

			String hash = hasher(p);

			if (p.getEmployeeName().toLowerCase().equals(this.name.toLowerCase()) && resultYear == this.year) {

				if (!foundProjectTasks.containsKey(hash)) {

					foundProjectTasks.put(hash, p.getHours());

				} else {

					foundProjectTasks.put(hash, foundProjectTasks.get(hash) + p.getHours());

				}

			}

		}
		ArrayList<String> sortedProjectTasksList = hashMapToArrayListSorted(foundProjectTasks);
		
		
		
		return sortedProjectTasksList;
	}

	private static String hasher(ProjectTask projectTask) {

		Calendar calendar = Calendar.getInstance();

		calendar.setTime(projectTask.getDate());

		String hash = calendar.get(Calendar.MONTH) + 10 + HASH_SPLITTER + projectTask.getProjectName();

		return hash;
	}

	private static String fullHasher(String hash, String hour) {
		String fullHash = hash + HASH_SPLITTER + hour;
		return fullHash;
	}

	private static ArrayList<String> hashMapToArrayListSorted(HashMap<String, Float> foundProjectTasks) {
		ArrayList<String> arrayListFullHashes = new ArrayList<String>();

		for (String k : foundProjectTasks.keySet()) {

			arrayListFullHashes.add(fullHasher(k, Float.toString(foundProjectTasks.get(k))));
		}

		Collections.sort(arrayListFullHashes);

		return arrayListFullHashes;
	}

}