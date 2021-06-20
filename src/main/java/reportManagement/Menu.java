package reportManagement;

import WorbookProcessor.WorkbookScanner;
import reports.EmployeeAlphabeticalReport;
import reports.EmployeeDetailedAnnualReport;
import reports.ProjectEmployeeConsumptionReport;
import reports.ProjectSummaryHoursReport;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
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

	public static void printMainMenu() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("****************************************************************************");
		System.out.println("Witaj uzytkowniku! To super raport do generowania statystyk w Twojej firmie!");
		System.out.println("**************************************************************************** \n");
		System.out.println("Wybierz opcje:");
		System.out.println("1. Generuj alfabetyczny raport godzin pracowników w danym roku");
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
	
	public static int getYearForGenerateReport() {
        Scanner scanner = new Scanner(System.in);
//        System.out.print("Podaj rok z którego chcesz wygenerować raport: ");
        return scanner.nextInt();
	}
	
	public static String getNameAndSurnameForReport() {
        Scanner scanner = new Scanner(System.in);
//		System.out.println("Podaj imie pracownika w formacie: Imie Nazwisko");
        return scanner.nextLine();
	}
	
	public static String getProjectNameForReport() {
        Scanner scanner = new Scanner(System.in);
//		System.out.println("Podaj nazwe projektu dla ktorego chcesz wyswietlic raport:");
        return scanner.nextLine();
	}
	
public static void whatDoYouWantToDoNext() {
		
		System.out.println("\n Wybierz co chcesz zrobic:");
		System.out.println("0 - przejscie do menu glownego");
		System.out.println("1 - eksport danych do pliku PDF");
//		System.out.println("2 - wybierz inny rok");
//		System.out.println("3 - wybierz innego pracownika");
		System.out.println("9 - zakonczenie pracy programu");
		System.out.print("Wpisz swoj wybor: ");
		
        Scanner scanner = new Scanner(System.in);
        String showMenu = scanner.nextLine();
        
        try {
        	if (showMenu.equals("0")){
        		printMainMenu();
            } else if(showMenu.equals("1")){
            	System.out.println("Generowanie pliku PDF...");
//            	PDFExporter();
            } else if(showMenu.equals("9")){
            	System.out.println("Koniec pracy programu. Dziekuje!");
            	System.exit(0);
            }
        } catch(InputMismatchException e) {
        	System.out.println("Nie wpisales liczby takiej jak wymagana!");
        }
        
	}

	public static void chooseOption(int choice) {

		switch (choice) {
		case 1:
			System.out.print("Podaj rok z którego chcesz wygenerować raport: ");
			EmployeeAlphabeticalReport.printReport(getYearForGenerateReport());
			break;
		case 2:
			System.out.print("Podaj rok z którego chcesz wygenerować raport: ");
			ProjectSummaryHoursReport.printReport(getYearForGenerateReport());
			break;
		case 3:
			System.out.println("Podaj imie pracownika w formacie: Imie Nazwisko");
			String empName = getNameAndSurnameForReport();
			System.out.println("Podaj rok z ktorego chcesz wygenerowac raport");
			int year = getYearForGenerateReport(); 
			
			EmployeeDetailedAnnualReport.printReport(empName, year);
			break;
		case 4:
			System.out.println("raport_sumaryczny_godzin_projektowych_rok.java");
			break;
		case 5:
			System.out.print("Podaj nazwe projektu dla ktorego chcesz wyswietlic raport:");
			ProjectEmployeeConsumptionReport.printReport(getProjectNameForReport());
			break;
		case 0:
        	System.out.println("Koniec pracy programu. Dziekuje!");
            System.exit(0);
		default:
			System.out.println("Nie ma takiego raportu do wyboru. Sprobuj ponownie.");
			printMainMenu();
		}
		whatDoYouWantToDoNext();
	}

	public static ArrayList<ProjectTask> getProjectTasks() {
		return projectTasks;
	}

}