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
		int iloscGodzin = 30;
		String month = "miesiąc";
		String percent = "%";
		
//		int namelength = name.length();
//		int name2length = name2.length();
//		int nameLengthMax;
//		
//		if (namelength < name2length)
//		{
//			nameLengthMax = name2length;
//			
//		}
		String format = "%-20.50s %-50.30s\\n";
		
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.println("------------------------------------------------------");
		//System.out.println("Nazwisko i imię \t\t|\t\th/rok");
		System.out.printf("| %-40s | %-15s|\n", "Nazwisko i imię", "h/rok");
		System.out.printf("| %-40s | %-15s|\n", name, iloscGodzin);
		System.out.printf("| %-40s | %-15s|\n", name2, iloscGodzin);
		System.out.println("------------------------------------------------------");
		
		
		System.out.println("\n\n\n\n\n\n");
		
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.println("------------------------------------------------------");
		System.out.println("Nazwisko i imię \t\t|\t\th/rok");
		System.out.printf("%s %35s\n",name, iloscGodzin);	
		System.out.printf("%s %35s\n",name2, iloscGodzin);
		System.out.println("------------------------------------------------------");
		
		System.out.printf("\n\n\nWyświetlenie raportu godzin projektowych w danym roku:\n");
		System.out.println("------------------------------------------------------");
		System.out.println("\nNazwa projektu\t\t\tilość godzin");
		System.out.printf("%s %25s\n", projectName, iloscGodzin);
		System.out.println("------------------------------------------------------");
		
		
		System.out.printf("\n\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez jednego pracownika:\n");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("\nMiesiąc\t\t\t\t\tProjekt\t\t\tlp. godzin");
		System.out.printf("%s %40s %25s\n",month, projectName, iloscGodzin);
		System.out.println("-------------------------------------------------------------------------------------");
		
		
		System.out.printf("\n\n\nWyświetlenie raportu procentowego udziału godzinowego w projektach dla danego pracownika:\n");
		System.out.println("------------------------------------------------------------------------------------------------");
		System.out.println("\nNazwisko i imię\t\t\tProjekt 1\tUdział proc.\t\tProjekt 2\t\tUdział proc.");
		System.out.printf("%s %30s %10s %30s %15s\n",name, projectName, percent, projectName, percent);
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		
		System.out.printf("\n\n\nWyświetlenie raportu sumarycznego godzin projektowych:\n");
		System.out.println("----------------------------------------------------------");
		System.out.println("Nazwisko i imię\t\t\tLączna suma godzin");
		System.out.printf("%s %30s\n",name, iloscGodzin);
		System.out.println("----------------------------------------------------------");
		
	}
	
}
