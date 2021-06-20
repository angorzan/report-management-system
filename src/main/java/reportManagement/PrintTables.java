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
		
		System.out.println("Wyświetlenie raportu godzin pracownikow w danym roku:");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);		// wedlug tej lini wykonac tabele
		System.out.printf("\nLp%21s %24s %15s",name2, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s\n",name, projectName, iloscGodzin);
		
		System.out.printf("\n\nWyswietlenie raportu godzin projektowych w danym roku:");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		System.out.printf("\nLp%21s %24s %15s",name2, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s\n",name, projectName, iloscGodzin);
		
		System.out.printf("\n\nWy�wietlenie miesi�cznego raportu godzin przepracowanych przez jednego pracownika:");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		System.out.printf("\nLp%21s %24s %15s",name2, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s\n",name, projectName, iloscGodzin);
		
		System.out.printf("\n\nWy�wietlenie raportu procentowego udzia�u godzinowego w projektach dla danego pracownika:");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		System.out.printf("\nLp%21s %24s %15s",name2, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s\n",name, projectName, iloscGodzin);
		
		System.out.printf("\n\nWy�wietlenie raportu sumarycznego godzin projektowych:");
		System.out.printf("\nLp%15s %30s %15s",name, projectName, iloscGodzin);
		System.out.printf("\nLp%21s %24s %15s",name2, projectName, iloscGodzin);
		System.out.printf("\nLp%15s %30s %15s\n",name, projectName, iloscGodzin);
		
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
