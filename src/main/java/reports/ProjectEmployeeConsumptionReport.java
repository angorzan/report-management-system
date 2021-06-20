package reports;

import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProjectEmployeeConsumptionReport {

    private static ArrayList<ProjectTask> projectTasks = Menu.getProjectTasks();
    public static void printReport(String projectName){

        Map<String, Integer> map = new HashMap<>();
        for (ProjectTask p: projectTasks) {

            if (p.getProjectName().equals(projectName)) {

                int hours;
                if (map.get(p.getEmployeeName()) == null) {
                    hours = 0;
                } else {
                    hours = map.get(p.getEmployeeName());
                }
                map.put(p.getEmployeeName(), hours + p.getHours());
            }
        }
        Map<String, Integer> result = new TreeMap<String, Integer>(map);

        System.out.printf("\n\nWyświetlenie raportu sumarycznego godzin projektowych:\n");

        int sumOfHours = 0;
        for (String key: result.keySet()) {

            System.out.printf("\n%30s %15s", key, result.get(key));
            sumOfHours += result.get(key);

        }

        System.out.printf("\n\nŁączna ilość pracy nad projektem " + sumOfHours + " godzin");


    }

}
