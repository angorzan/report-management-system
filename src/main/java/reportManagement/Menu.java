package reportManagement;

import WorbookProcessor.WorkbookScanner;
import reports.*;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

	private static final ArrayList<ProjectTask> projectTasks = new ArrayList<ProjectTask>();

	private Scanner scanner;

	public Menu(String path) {

		this.scanLocation(path);
		scanner = new Scanner(System.in);
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

		System.out.println("****************************************************************************");
		System.out.println("Witaj uzytkowniku! To super raport do generowania statystyk w Twojej firmie!");
		System.out.println("**************************************************************************** \n");
		System.out.println("Wybierz opcje:");
		System.out.println("1. Generuj alfabetyczny raport godzin pracowników w danym roku");
		System.out.println("2. Generuj raport godzin projektowych w podanym roku");
		System.out.println("3. Generuj miesięczny raport godzin przepracowanych przez wybranego pracownika");
		System.out.println("4. Generuj procentowy udział w projektach dla danego pracownika");
		System.out.println("5. Generuj sumaryczny raport godzin projektowych ");
		System.out.println("6. Generuj procentowy udział w projektach dla wszystkich pracowników");
		System.out.println("0. Zakończ prace z programem \n");
		System.out.println("Podaj numer raportu:");

		try {
			int reportType = Integer.parseInt(scanner.nextLine());
			chooseOption(reportType);

		} catch (Exception e) {

		}
	}

	private void whatDoYouWantToDoNext() {

		System.out.println("\nWybierz co chcesz zrobić:");
		System.out.println("0 - przejście do menu głównego");
		System.out.println("1 - eksport danych do pliku PDF");
//		System.out.println("2 - wybierz inny rok");
//		System.out.println("3 - wybierz innego pracownika");
		System.out.println("9 - zakończenie pracy programu");
		System.out.print("Podaj swój wybór: ");

		int showMenu = Integer.parseInt(scanner.nextLine());

		try {
			if (showMenu == 0) {
				printMainMenu();
			} else if (showMenu == 1) {
				System.out.println("Generowanie pliku PDF...");
//            	PDFExporter();
			} else if (showMenu == 9) {
				System.out.println("Koniec pracy programu. Dziękuję!");
				System.exit(0);
			} else {
				System.out.println("Podałeś niepoprawny numer, wpisz jeszcze raz.");
				whatDoYouWantToDoNext();
			}

		} catch (InputMismatchException e) {
			System.out.println("Nie wpisales liczby takiej jak wymagana!");
		}

	}

	private void chooseOption(int choice) {

		switch (choice) {
		case 1:
			System.out.print("Podaj rok dla którego chcesz wygenerować raport: ");
			IReport reportEAR = new EmployeeAlphabeticalReport(Integer.parseInt(scanner.nextLine()));
			reportEAR.printReport();
			break;
		case 2:
			System.out.print("Podaj rok dla którego chcesz wygenerować raport: ");
			IReport projectPSHR = new ProjectSummaryHoursReport(Integer.parseInt(scanner.nextLine()));
			projectPSHR.printReport();
			break;
		case 3:
			System.out.println("Podaj imię i nazwisko pracownika w formacie: Imie Nazwisko");
			String empName = scanner.nextLine();

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");
			int year = Integer.parseInt(scanner.nextLine());

			IReport reportEDAR = new EmployeeDetailedAnnualReport(empName, year);
			reportEDAR.printReport();
			break;
		case 4:
			System.out.println("Podaj imię i nazwisko pracownika w formacie: Imie Nazwisko");
			String empName1 = scanner.nextLine();

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");

			int year1 = Integer.parseInt(scanner.nextLine());

			IReport reportEPER = new EmployeeProjectEngagementReport(empName1, year1);
			reportEPER.printReport();

			break;
		case 5:

			System.out.println("Podaj nazwę projektu dla którego chcesz wygenerować raport:");

			ProjectEmployeeConsumptionReport projectPECR = new ProjectEmployeeConsumptionReport(scanner.nextLine());
			projectPECR.printReport();
			break;

		case 6:

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");

			IReport reportPER = new ProjectEngagementReport(Integer.parseInt(scanner.nextLine()));
			reportPER.printReport();

			break;

		case 0:
			System.out.println("Koniec pracy programu. Dziękuję!");
			System.exit(0);
		default:
			System.out.println("Raport o podanym numerze nie istnieje. Spróbuj ponownie.");
			printMainMenu();
		}
		whatDoYouWantToDoNext();
	}

	public static ArrayList<ProjectTask> getProjectTasks() {
		return projectTasks;
	}

}