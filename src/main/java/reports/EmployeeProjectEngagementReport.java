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
	private String name;
	private int year;

	private static DecimalFormat df = new DecimalFormat("0.00");

	public EmployeeProjectEngagementReport(String name, int year) {
		this.name = name;
		this.year = year;
	}

	public String getReportName() {
		return "EmployeeProjectEngagementReport" + "_" + this.year;
	}
	public void printReport() {

		System.out.println();
		System.out.printf("\n\n\nWyświetlenie zaangażowania rocznego pracownika " + this.name
				+ " w dany projekt w roku: " + this.year + "\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-40s| %-15s|\n", "Nazwa projektu", "zaangażowanie %");

		ArrayList<String> projectEngagement = getData();

		Collections.sort(projectEngagement);

		float totalHours = 0;

		for (String s : projectEngagement) {

			totalHours = totalHours + Float.parseFloat(s.split(HASH_SPLITTER)[1]);
		}

		for (String s : projectEngagement) {

			String[] toPrint = s.split(HASH_SPLITTER);

			Float engagement = Float.parseFloat(toPrint[1]) * 100 / totalHours;

			System.out
					.println("---------------------------------------------------------------------------------------");
			System.out.printf("|%-40s| %-15s|\n", toPrint[0], df.format(engagement));
		}
	}

	public ArrayList<String> getData() {

		HashMap<String, Float> foundProjectTasks = new HashMap<String, Float>();
		Calendar calendar = Calendar.getInstance();

		for (ProjectTask p : Menu.getProjectTasks()) {

			calendar.setTime(p.getDate());

			int resultYear = calendar.get(Calendar.YEAR);

			if (p.getEmployeeName().equals(this.name) && resultYear == this.year) {

				if (!foundProjectTasks.containsKey(p.getProjectName())) {
					foundProjectTasks.put(p.getProjectName(), p.getHours());
				} else {

					foundProjectTasks.put(p.getProjectName(), foundProjectTasks.get(p.getProjectName()) + p.getHours());

				}

			}

		}

		ArrayList<String> hashes = hasher(foundProjectTasks);

		return hashes;
	}

	private ArrayList<String> hasher(HashMap<String, Float> foundProjectTasks) {

		ArrayList<String> hashes = new ArrayList<String>();

		for (String s : foundProjectTasks.keySet()) {
			hashes.add(s + HASH_SPLITTER + Float.toString(foundProjectTasks.get(s)));
		}

		return hashes;
	}

}
