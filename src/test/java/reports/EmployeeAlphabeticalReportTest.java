package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;

import java.util.HashMap;
import java.util.Map;

public class EmployeeAlphabeticalReportTest extends TestCase {


		Menu menu = new Menu("../report-management-system/src/test/resources");
		EmployeeAlphabeticalReport test = new EmployeeAlphabeticalReport(2012);
//		Map<String, Float> tasksList = new HashMap<String, Float>();
		Map<String, Float> tasksList = test.getData();


	@Test
	public void testJanKowalski2012IsNull() {
		Assert.assertNull(tasksList.get("Tomasz Kowalski"));
	}

	@Test
	public void testAdamTarczynek2012IsCorrect() {
		Assert.assertEquals(tasksList.get("Adam Tarczynek"), 340, 0.002);
	}
}
