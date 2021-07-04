package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import java.util.ArrayList;

public class EmployeeProjectEngagementReportTest extends TestCase {

	Menu menu = new Menu("../report-management-system/src/test/resources");
	ProjectEngagementReport test = new ProjectEngagementReport(menu.getProjectTasks(), 2012);
	private ArrayList<String> tasksList = test.getData();

	@Test
	public void testNoProjekt3ForAleksandraSobolewska() {

		boolean result = true;
		for (String s : tasksList) {

			if (s.contains("Aleksandra Sobolewska#Projekt3")) {

				result = false;
			}
		}
		Assert.assertTrue(result);
	}

	@Test
	public void testNoProjectForAndrzejCiombor() {

		boolean result = false;
		for (String s : tasksList) {

			if (s.contains("Andrzej Ciombor")) {

				result = true;
			}
		}
		Assert.assertFalse(result);
	}

	@Test
	public void testProjekt1IsCorrect() {
		System.out.println("3");
		String[] splitted = new String[10];
		for (String s : tasksList) {

			if (s.contains("Aleksandra Sobolewska#Projekt1")) {
				splitted = s.split("#");
			}
		}
		Float hours = Float.parseFloat(splitted[2]);
		Assert.assertEquals(hours, 504, 0.02);
	}
}