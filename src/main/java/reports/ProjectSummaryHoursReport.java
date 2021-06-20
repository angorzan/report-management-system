package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        System.out.printf("\n\nWyswietlenie raportu godzin projektowych w danym roku:");
        for (String key : map2.keySet()) {

            System.out.println("" + key + " " + map2.get(key));
            System.out.printf("\nLp%15s %30s %15s", key, map2.get(key));
        }
    }

}
