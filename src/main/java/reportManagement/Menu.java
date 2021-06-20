package reportManagement;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;

import utilities.WorkbookScanner;

public class Menu {

	private ArrayList<ProjectTask> projectTasks;

	public Menu(String path) {
		this.scanLocation(path);
	}

	private void scanLocation(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {

			if (file.isDirectory()) {
				String newPath = file.getAbsolutePath();
				scanLocation(newPath);
			}

			if (file.getName().endsWith(".xlsx")) {
				WorkbookScanner.scanWorkbook(Paths.get(file.getAbsolutePath()));
			}
		}

	}

	private void printMainMenu() {
// TODO
	}

	public ArrayList<ProjectTask> getProjectTasks() {
		return projectTasks;
	}

}
