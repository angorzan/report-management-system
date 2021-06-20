package reportManagement;

public class PrintTables {
	
	public static void main(String[] args)
	{
		print();
	}
	
	public static void print()
	{
		String name = "Kowalski Jan";
		String name2 = "Kwiatkowska Monika";
		String projectName = "nazwa projektu";
		String projectName2 = "%";
		int iloscGodzin = 30;
		String month = "miesiąc";
		String percent = "%";
		int lp = 1;
	
		
//		int namelength = name.length();
//		int name2length = name2.length();
//		int nameLengthMax;
//		
//		if (namelength < name2length)
//		{
//			nameLengthMax = name2length;
//			
//		}
		
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.println("______________________________________________________________");
		System.out.printf("|%-5s| %-40s | %-10s|\n", "Lp", "Nazwisko i imię", "h/rok");
		System.out.println("--------------------------------------------------------------");
		System.out.printf("|%-5s| %-40s | %-10s|\n", lp, name, iloscGodzin);
		System.out.printf("|%-5s| %-40s | %-10s|\n", lp, name2, iloscGodzin);
		System.out.println("______________________________________________________________");
		
		
		System.out.printf("\n\n\nWyświetlenie raportu godzin projektowych w danym roku:\n");
		System.out.println("_______________________________________________________________");
		System.out.printf("|%-5s| %-40s | %-10s|\n", "Lp", "Nazwa projektu", "ilość godzin");
		System.out.println("----------------------------------------------------------------");
		System.out.printf("|%-5s| %-40s | %-12s|\n", lp, projectName, iloscGodzin);
		System.out.printf("|%-5s| %-40s | %-12s|\n", lp, projectName, iloscGodzin);
		System.out.println("_______________________________________________________________");
		
		
		System.out.printf("\n\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez jednego pracownika:\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", "Lp", "Miesiąc", "Nazwa projektu", "ilość godzin");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", lp, month, projectName, iloscGodzin);
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", lp, month, projectName, iloscGodzin);
		System.out.println("________________________________________________________________________________________");
		
		
		System.out.printf("\n\n\nWyświetlenie raportu procentowego udziału godzinowego w projektach dla danego pracownika:\n");
		System.out.println("________________________________________________________________________________________");
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", "Lp", "Nazwisko i imię", "Projekt 1", "Projekt 2");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", lp, name, projectName2, projectName2);
		System.out.printf("|%-5s|%-20s| %-40s | %-15s|\n", lp, name, projectName2, projectName2);
		System.out.println("________________________________________________________________________________________");

		
		
		System.out.printf("\n\n\nWyświetlenie raportu sumarycznego godzin projektowych:\n");
		System.out.println("______________________________________________________________________");
		System.out.printf("|%-5s|%-40s | %-20s|\n", "Lp", "Nazwisko i imię", "Lączna suma godzin");
		System.out.println("----------------------------------------------------------------------");
		System.out.printf("|%-5s|%-40s | %-20s|\n", lp, name, iloscGodzin);
		System.out.printf("|%-5s|%-40s | %-20s|\n", lp, name, iloscGodzin);
		System.out.println("______________________________________________________________________");

	}
	
}
