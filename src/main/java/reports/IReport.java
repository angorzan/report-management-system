package reports;

import java.util.ArrayList;

import reportManagement.ProjectTask;

public interface IReport {
ArrayList<ProjectTask> findData(ArrayList<ProjectTask> projectTasks);
void printReport();
String capturedString();	//TODO abstract + implementation or another class?? 
}
