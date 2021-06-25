package reportManagement;

import WorbookProcessor.WorkbookScanner;
import reports.*;
import utilities.BarChart;
import utilities.PDFExporter;
import utilities.PiecakeChart;

import java.io.File;
import java.io.IOException;
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

			if (file.getName().endsWith(".xls") || file.getName().endsWith(".xlsx")) {
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
			System.out.println("podana wartość nie jest liczbą");
			whatDoYouWantToDoNext();
		
		}
	}

	private void whatDoYouWantToDoNext() {

		System.out.println("\nWybierz co chcesz zrobić:");
		System.out.println("0 - zakończenie pracy programu");
		System.out.println("9 - przejście do menu głównego");
		System.out.print("Podaj swój wybór: ");

		try {
			int showMenu = Integer.parseInt(scanner.nextLine());
			if (showMenu == 0) {
				System.out.println("Koniec pracy programu. Dziękuję!");
				System.exit(0);
			} else if (showMenu == 9) {
				printMainMenu();			
			} else {
				System.out.println("Podałeś niepoprawny numer, wpisz jeszcze raz.");
				whatDoYouWantToDoNext();
			}

		} catch (Exception e) {
			System.out.println("podana wartość nie jest liczbą");
			whatDoYouWantToDoNext();
		}

	}

	private void generatePdf(IReport report) throws IOException {

		System.out.print("Czy chcesz wygenerowac plik PDF z raportem? n - NIE, y - TAK: ");
		String choiceYN = scanner.nextLine();

		if (choiceYN.equals("y") || choiceYN.equals("Y")) {
			PDFExporter.generatePDF(report);
		} else if (choiceYN.equals("n") || choiceYN.equals("N")) {
			System.out.println("Nie wygenerowales raportu.");
		} else {
			System.out.println("Nie podales poprawnej opcji.");
		}
	}

	private void chooseOption(int choice) throws IOException {

		switch (choice) {
		case 1:
			System.out.print("Podaj rok dla którego chcesz wygenerować raport: ");
			IReport reportEAR = new EmployeeAlphabeticalReport(Integer.parseInt(scanner.nextLine()));
			reportEAR.printReport();
			generatePdf(reportEAR);
			break;
		case 2:
			System.out.print("Podaj rok dla którego chcesz wygenerować raport: ");
			ProjectSummaryHoursReport projectPSHR = new ProjectSummaryHoursReport(Integer.parseInt(scanner.nextLine()));
			projectPSHR.printReport();

			System.out.print("Czy chcesz wygenerowac wykres slupkowy z raportu? n - NIE, y - TAK: ");
			String choiceYN = scanner.nextLine();

			if (choiceYN.equals("y") || choiceYN.equals("Y")) {
				
				String defaultChartfileename = projectPSHR.getReportName();
				System.out.println(
						"Podaj nazwę pliku z wykresem lub pozostaw puste aby użyć domyślnej nazwy i naciśnij enter (domyślna nazwa: "
								+ defaultChartfileename + ")");
				String nameChart = scanner.nextLine();
				
				BarChart.saveChart(App.path + "/" + nameChart, projectPSHR);
			} else if (choiceYN.equals("n") || choiceYN.equals("N")) {
				System.out.println("Nie wygenerowales wykresu.");
			} else {
				System.out.println("Nie podales wybranej opcji.");
			}

			generatePdf(projectPSHR);

			break;

		case 3:
			System.out.println("Podaj imię i nazwisko pracownika w formacie: Imie Nazwisko");
			String empName = scanner.nextLine();

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");
			int year = Integer.parseInt(scanner.nextLine());

			IReport reportEDAR = new EmployeeDetailedAnnualReport(empName, year);
			reportEDAR.printReport();

			generatePdf(reportEDAR);
			break;
		case 4:
			System.out.println("Podaj imię i nazwisko pracownika w formacie: Imie Nazwisko");
			String empName1 = scanner.nextLine();

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");

			int year1 = Integer.parseInt(scanner.nextLine());

			EmployeeProjectEngagementReport reportEPER = new EmployeeProjectEngagementReport(empName1, year1);
			reportEPER.printReport();

			System.out.print("Czy chcesz wygenerowac wykres kolowy z raportu? n - NIE, y - TAK: ");
			String choiceYN1 = scanner.nextLine();

			if (choiceYN1.equals("y") || choiceYN1.equals("Y")) {
				
				String defaultChartfileename = reportEPER.getReportName();
				System.out.println(
						"Podaj nazwę pliku z wykresem lub pozostaw puste aby użyć domyślnej nazwy i naciśnij enter (domyślna nazwa: "
								+ defaultChartfileename + ")");
				String nameChart = scanner.nextLine();
				
				PiecakeChart.saveChart(App.path + "/" + nameChart, reportEPER);
			} else if (choiceYN1.equals("n") || choiceYN1.equals("N")) {
				System.out.println("Nie wygenerowales wykresu.");
			} else {
				System.out.println("Nie podales wybranej opcji.");
			}

			generatePdf(reportEPER);
			break;
		case 5:

			System.out.println("Podaj nazwę projektu dla którego chcesz wygenerować raport:");

			ProjectEmployeeConsumptionReport projectPECR = new ProjectEmployeeConsumptionReport(scanner.nextLine());
			projectPECR.printReport();
			generatePdf(projectPECR);
			break;

		case 6:

			System.out.println("Podaj rok dla którego chcesz wygenerować raport");

			IReport reportPER = new ProjectEngagementReport(Integer.parseInt(scanner.nextLine()));
			reportPER.printReport();
			generatePdf(reportPER);
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