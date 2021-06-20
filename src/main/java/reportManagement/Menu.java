package reportManagement;

import WorbookProcessor.WorkbookScanner;
import reports.EmployeeDetailedAnnualReport;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {

	private static ArrayList<ProjectTask> projectTasks;

	
	public Menu(String path) {
		projectTasks = new ArrayList<ProjectTask>();
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

			if (file.getName().endsWith(".xls")) {
				WorkbookScanner.scanWorkbook(Paths.get(file.getAbsolutePath()));
			}
		}

	}

	public void printMainMenu() {
		Scanner scanner = new Scanner(System.in);
		
    	System.out.println("****************************************************************************");
		System.out.println("Witaj uzytkowniku! To super raport do generowania statystyk w Twojej firmie!");
		System.out.println("**************************************************************************** \n");
		System.out.println("Wybierz opcje:");
		System.out.println("1. Generuj alfabetyczny raport godzin pracowników w danym roku (pytanie o rok - jakie lata, )");
		System.out.println("2. Generuj raport godzin projektowych w podanym roku");
		System.out.println("3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika");
		System.out.println("4. Generuj procentowy udział godzinowy w projektach dla danego pracownika");
		System.out.println("5. Generuj sumaryczny raport godzin projektowych ");
		System.out.println("6. Wygeneruj całościowy raport");
		System.out.println("0. Zakończ prace z programem \n");
		
		System.out.println("Wpisz numer typu raportu:");
		
		try {
			int reportType = scanner.nextInt();
			chooseOption(reportType);
			
		} catch (Exception e) {
			
		}
	}
	
    
	public static void chooseOption(int choice) {
		
		switch(choice) {
			case 1:
				System.out.println("raport_sumaryczny_godzin_projektowych_rok.java");
				break;
			case 2:
				System.out.println("raport_godziny_projektowych_wroku.java");
				break;
			case 3:
				System.out.println("raport_godziny_przepracowanych_pracownik_wroku.java");
				//EmployeeDetailedAnnualReport.printReport("Jan Kowalski", 2012);
				break;
			case 4:
				System.out.println("raport_procentowy_zaangazowania_pracownikow_rok.java");
				break;
			case 5:
				System.out.println("raport_sumaryczny_godzin_projektowych_rok.java");
				break;
			default:
				System.out.println("Nie ma takiej opcji generowania raportow do wyboru");
				break;
			
		}
    

}

	public static ArrayList<ProjectTask> getProjectTasks() {
		return projectTasks;
	}

}
