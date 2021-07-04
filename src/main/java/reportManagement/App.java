package reportManagement;

import java.io.IOException;
import java.util.Scanner;

public class App {

	public static String path;

	public static void main(String[] args) throws IOException {

		if (args.length > 0) {
			path = args[0];
		} else {
			setPath();
		}

		runMenu();

	}

	private static void setPath() {
		System.out.println("Podaj ścieżkę dostępu do danych lub wpisz exit aby zakończyć program");
		Scanner scanner = new Scanner(System.in);

		path = scanner.nextLine();

		if (path.equals("Exit") || path.equals("exit")) {
			System.out.println("Koniec pracy programu. Dziękuję!");
			scanner.close();
			System.exit(0);
		}

	}

	private static void runMenu() {

		try {
			Menu menu = new Menu(path);

			int counter = 0;

			System.out.println("\nZnalezieni pracownicy:\n");

			for (String s : menu.getEmployees()) {

				if (counter != 0) {
					System.out.print("   |   ");
				}

				System.out.print(s);

				counter++;

				if (counter > 4) {
					System.out.println();
					counter = 0;

				}

			}

			System.out.print(
					"\n\n----------------------------------------------------------------------------------------------------\n\n");

			counter = 0;

			System.out.println("Znalezione projekty:\n");

			for (String s : menu.getProjects()) {

				if (counter != 0) {
					System.out.print("   |   ");
				}

				System.out.print(s);

				counter++;

				if (counter > 4) {
					System.out.println();
					counter = 0;

				}

			}

			System.out.print(
					"\n\n----------------------------------------------------------------------------------------------------\n\n");

			counter = 0;

			System.out.println("Znalezione lata:\n");

			for (int i : menu.getYears()) {

				if (counter != 0) {
					System.out.print("   |   ");
				}

				System.out.print(i);

				counter++;

				if (counter > 4) {
					System.out.println();
					counter = 0;

				}

			}

			System.out.print("\n\n\n");

			menu.printMainMenu();

		} catch (NullPointerException e) {
			System.out.println();
			System.out.println("Podana ścieżka jest niepoprawna lub nie zawiera danych.");
			System.out.println("________________________________________________________\n\n");
			setPath();
			runMenu();
		}

	}

}
