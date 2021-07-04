package reports;

import reportManagement.ProjectTask;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectSummaryHoursReport implements IReport {

	private int year;

	private ArrayList<ProjectTask> projectTasks;

	public ProjectSummaryHoursReport(ArrayList<ProjectTask> projectTasks, int year) {
		this.year = year;
		this.projectTasks = projectTasks;
	}

    public String getReportName() {
    	return "ProjectSummaryHoursReport" + "_" + this.year;
    }
	
	public void printReport() {
		Map<String, Float> result = getData();
		System.out.printf("\n\nZestawienie godzin projektowych dla projektów w " + this.year + " roku \n");
		System.out.println("_________________________________________________________________");
		System.out.printf("| %-40s | %-15s|\n", "Nazwa projektu", "Liczba godzin");
		System.out.println("-----------------------------------------------------------------");
		for (String key : result.keySet()) {
			System.out.printf("| %-40s | %-15s|\n", key, result.get(key));
		}
	}

	public Map<String, Float> getData() {
		Map<String, Float> map2 = new HashMap<>();
		for (ProjectTask p : projectTasks) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(p.getDate());
			int result = calendar.get(Calendar.YEAR);
			if (result == this.year) {
				float hours;
				if (map2.get(p.getProjectName()) == null) {
					hours = 0;
				} else {
					hours = map2.get(p.getProjectName());
				}
				map2.put(p.getProjectName(), hours + p.getHours());
			}
		}
		return new TreeMap<String, Float>(map2);
	}
}