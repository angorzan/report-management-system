package reportManagement.reportManagement;

import java.util.Scanner;

public class Menu {
	
    public static void main( String[] args )
    {
    	
		Scanner scanner = new Scanner(System.in);
		
    	System.out.println("****************************************************************************");
		System.out.println("Witaj uzytkowniku! To super raport do generowania statystyk w Twojej firmie!");
		System.out.println("****************************************************************************");
		
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
}
