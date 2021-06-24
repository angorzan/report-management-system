package reports;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;

import reportManagement.Menu;
import reportManagement.ProjectTask;

public class EmployeeProjectEngagementReport implements IReport {

	private static final String HASH_SPLITTER = "#";

	private int year;

	private static DecimalFormat df = new DecimalFormat("0.00");

	public EmployeeProjectEngagementReport(int year) {
		this.year = year;
	}

	public void printReport() {

		System.out.println();
		System.out.printf("\n\n\nWyświetlenie zaangażowania rocznego pracowników " + " w dany projekt w roku: "
				+ this.year + "\n");
		System.out.println(
				"______________________________________________________________________________________________________________");
		System.out.printf("| %-40s| %-40s | %-20s|\n", "Imię i nazwisko", "Nazwa projektu", "zaangażowanie %");

		ArrayList<String> projectEngagement = findData();

		for (String s : projectEngagement) {
			float totalHours = 0;
			String[] toPrint = s.split(HASH_SPLITTER);

			for (String st : projectEngagement) {
				String[] stChecker = st.split(HASH_SPLITTER);

				if (stChecker[0].equals(toPrint[0])) {

					totalHours = totalHours + Float.parseFloat(st.split(HASH_SPLITTER)[2]);
				}
			}

			Float engagement = Float.parseFloat(toPrint[2]) * 100 / totalHours;

			System.out.println(
					"--------------------------------------------------------------------------------------------------------------");
			System.out.printf("| %-40s| %-40s | %-20s|\n", toPrint[0], toPrint[1], df.format(engagement));
		}
	}

	private ArrayList<String> findData() {
		HashMap<String, Float> foundProjectTasks = new HashMap<String, Float>();

		Calendar calendar = Calendar.getInstance();

		for (ProjectTask p : Menu.getProjectTasks()) {
			calendar.setTime(p.getDate());
			int resultYear = calendar.get(Calendar.YEAR);

			String hash = hasher(p);

			if (resultYear == this.year) {

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

	private ArrayList<String> hashMapToArrayListSorted(HashMap<String, Float> foundProjectTasks) {
		ArrayList<String> arrayListFullHashes = new ArrayList<String>();

		for (String s : foundProjectTasks.keySet()) {
			arrayListFullHashes.add(fullHasher(s, Float.toString(foundProjectTasks.get(s))));
		}

		Collections.sort(arrayListFullHashes);

		return arrayListFullHashes;
	}

	private String fullHasher(String hash, String hour) {

		String fullHash = hash + HASH_SPLITTER + hour;
		return fullHash;

	}

	private String hasher(ProjectTask p) {

		String hash = p.getEmployeeName() + HASH_SPLITTER + p.getProjectName();

		return hash;
	}

}
