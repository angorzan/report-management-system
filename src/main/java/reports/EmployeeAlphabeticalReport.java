package reports;

import reportManagement.ProjectTask;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeAlphabeticalReport implements IReport {

    private int year;

    private ArrayList<ProjectTask> projectTasks;

    public EmployeeAlphabeticalReport(ArrayList<ProjectTask> projectTasks, int year) {
        this.year = year;
        this.projectTasks = projectTasks;
    }

    public String getReportName() {
    	return "EmployeeAlphabeticalReport" + "_" + year;
    }
    
	public void printReport() {


        Map<String, Float> result = getData();

        System.out.println("\n\nZestawienie godzin projektowych dla pracownikow w roku " + this.year);
        System.out.println("____________________________________________________________");
        System.out.printf("| %-40s | %-10s|\n", "Imię i nazwisko", "h/rok");

        for (String key : result.keySet()) {

            System.out.println("------------------------------------------------------------");
            System.out.printf("| %-40s | %-10s|\n", key, result.get(key));

        }
    }

    public Map<String, Float> getData() {

        Map<String, Float> map = new HashMap<>();
        for (ProjectTask p : projectTasks) {

            Calendar calendar = Calendar.getInstance();

            calendar.setTime(p.getDate());

            int result = calendar.get(Calendar.YEAR);

            if (result == this.year) {

                float hours;
                if (map.get(p.getEmployeeName()) == null) {
                    hours = 0;
                } else {
                    hours = map.get(p.getEmployeeName());
                }
                map.put(p.getEmployeeName(), hours + p.getHours());
            }
        }
        return new TreeMap<String, Float>(map);
    }
}


