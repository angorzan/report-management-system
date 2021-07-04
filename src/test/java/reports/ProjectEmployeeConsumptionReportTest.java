package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;

import java.util.Map;

public class ProjectEmployeeConsumptionReportTest extends TestCase {

	Menu menu = new Menu("../report-management-system/src/test/resources");
	ProjectEmployeeConsumptionReport test = new ProjectEmployeeConsumptionReport(menu.getProjectTasks(), "Projekt1");
	private Map<String, Float> tasksList = test.getData();

	@Test
	public void testAndrzejCiombor2012IsNull() {

		Assert.assertNull(tasksList.get("Andrzej Ciombor"));
	}

	@Test
	public void testJanKowalski2012IsCorrect() {

		Assert.assertEquals(tasksList.get("Jan Kowalski"), 1184, 0.002);
	}

	@Test
	public void testTotalProjekt2012IsCorrect() {

		Float totalHours = 0.0f;
		for (String key : tasksList.keySet()) {

			totalHours += tasksList.get(key);
		}
		Assert.assertEquals(totalHours, 4842, 0.002);
	}

}