package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import java.util.Map;

public class ProjectSummaryHoursReportTest extends TestCase {

	Menu menu = new Menu("../report-management-system/src/test/resources");
	ProjectSummaryHoursReport test = new ProjectSummaryHoursReport(menu.getProjectTasks(), 2012);
	private Map<String, Float> tasksList = test.getData();

	@Test
	public void testProjekt32012IsNull() {

		Assert.assertNull(tasksList.get("Projekt3"));
	}

	@Test
	public void testProjekt12012IsCorrect() {

		Assert.assertEquals(tasksList.get("Projekt1"), 1176, 0.02);
	}

	@Test
	public void testProjekt22012IsCorrect() {

		Assert.assertEquals(tasksList.get("Projekt2"), 1371, 0.02);
	}
}