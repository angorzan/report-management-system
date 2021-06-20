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
		char star = '*';
		String month = "miesiąc";
		String percent = "%";
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.println("Nazwisko i imię\t\t\th/rok");
		System.out.printf("%s %25s\n",name, iloscGodzin);		
		System.out.println("------------------------------------------------------");
		
		System.out.printf("\n\nWyświetlenie raportu godzin projektowych w danym roku:");
		System.out.println("\nNazwa projektu\t\t\tilość godzin");
		System.out.printf("%s %25s\n", projectName, iloscGodzin);
		System.out.println("------------------------------------------------------");
		
		
		System.out.printf("\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez jednego pracownika:");
		System.out.println("\nMiesiąc\t\t\t\t\tProjekt\t\t\tlp. godzin");
		System.out.printf("%s %40s %25s\n",month, projectName, iloscGodzin);
		System.out.println("-------------------------------------------------------------------------------------");
		
		
		System.out.printf("\n\nWyświetlenie raportu procentowego udziału godzinowego w projektach dla danego pracownika:");
		System.out.println("\nNazwisko i imię\t\t\tProjekt 1\tUdział proc.\t\tProjekt 2\t\tUdział proc.");
		System.out.printf("%s %30s %10s %30s %15s\n",name, projectName, percent, projectName, percent);
		System.out.println("----------------------------------------------------------------------------------------------------------");
		
		
		System.out.printf("\n\nWyświetlenie raportu sumarycznego godzin projektowych:\n");
		System.out.println("----------------------------------------------------------");
		System.out.println("\n\t\t\tNazwisko i imię\t\t\tLączna suma godzin");
		System.out.printf("%15s %30s %15s\n",name, projectName, iloscGodzin);
		System.out.println("----------------------------------------------------------");
		
	}
	
	public static void printEmployeesHours()
	{
		
	}
	
	public static void printProjectHours()
	{
		
	}
	
	public static void printEmployeProjectHour()
	{
		
	}
	
	public static void printProjectHoursSum()
	{
		
	}

}
