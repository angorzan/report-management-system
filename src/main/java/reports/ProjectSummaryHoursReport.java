package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectSummaryHoursReport {

    private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();

    public static void printReport(int year) {
        Map<String, Integer> map2 = new HashMap<>();
        for (ProjectTask p : projectTasks) {

            if (p.getDate().getYear() == year) {
                int hours;
                if (map2.get(p.getProjectName()) == null) {
                    hours = 0;
                } else {
                    hours = map2.get(p.getProjectName());
                }
                map2.put(p.getProjectName(), hours + p.getHours());
            }
        }
        Map<String, Integer> result = new TreeMap<String, Integer>(map2);

        System.out.printf("\n\nWyswietlenie raportu godzin projektowych w danym roku:");
        for (String key : result.keySet()) {

            System.out.println("" + key + " " + result.get(key));
            System.out.printf("\n%30s %15s", key, result.get(key));
        }
    }

}
