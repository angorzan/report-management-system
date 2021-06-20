package reportManagement;

public class App {
	public static void main(String[] args) {
		
		Menu menu = new Menu("src/test/java/resources/reporter-dane");
		
		Menu menu2 = new Menu("src/main/java/Resources/Kowalski_Jan.xls");

		

		menu.printMainMenu();

	}
}
