package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectSummaryHoursReport {

    private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();

    public static void printReport(int year) {
        Map<String, Float> map2 = new HashMap<>();
        for (ProjectTask p : projectTasks) {

        	Calendar calendar = Calendar.getInstance();
        	
        	calendar.setTime(p.getDate());
        	
        	int result = calendar.get(Calendar.YEAR);
        	
            if (result == year) {
                float hours;
                if (map2.get(p.getProjectName()) == null) {
                    hours = 0;
                } else {
                    hours = map2.get(p.getProjectName());
                }
                map2.put(p.getProjectName(), hours + p.getHours());
            }
        }
        Map<String, Float> result = new TreeMap<String, Float>(map2);

        System.out.printf("\n\nWyswietlenie raportu godzin projektowych w danym roku: \n");
        for (String key : result.keySet()) {

            System.out.printf("\n%30s %15s", key, result.get(key) + "\n");
        }
    }

}
