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
		String projectName = "Nazwa projektu";
		int iloscGodzin = 30;
		char star = '*';
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.println("Lp\t\tNazwisko i imię\t\t\th/rok");
		System.out.printf("1%35s %30s %15s",name, projectName, iloscGodzin);		
		System.out.println(star * 30);
		
		System.out.printf("\n\nWyświetlenie raportu godzin projektowych w danym roku:");
		System.out.println("\nLp\t\t\tNazwa projektu\t\t\tilość godzin");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		
		
		System.out.printf("\n\nWyświetlenie miesięcznego raportu godzin przepracowanych przez jednego pracownika:");
		System.out.println("\nLp\t\t\tMiesiąc\t\t\tProjekt\t\t\tlp. godzin");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		
		
		System.out.printf("\n\nWyświetlenie raportu procentowego udziału godzinowego w projektach dla danego pracownika:");
		System.out.println("\nLp\t\t\tNazwisko i imię\t\t\tProjekt 1\t\t\tUdział procentowy\t\t\tProjekt 2\t\t\tUdział procentowy");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		
		
		System.out.printf("\n\nWyświetlenie raportu sumarycznego godzin projektowych:");
		System.out.println("\nLp\t\t\tNazwisko i imię\t\t\tLączna suma godzin");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		
		
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
