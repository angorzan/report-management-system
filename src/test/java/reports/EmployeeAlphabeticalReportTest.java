package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
<<<<<<< HEAD

import java.util.HashMap;
=======
>>>>>>> 888b3308f3aa6482b106176d09e79e0aeb5913b0
import java.util.Map;

public class EmployeeAlphabeticalReportTest extends TestCase {

<<<<<<< HEAD

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
=======
    Map<String, Float> tasksList;
    public void setUp() throws Exception {

        Menu menu = new Menu("../report-management-system/src/test/resources");
        EmployeeAlphabeticalReport test = new EmployeeAlphabeticalReport(2012);
        tasksList = test.getData();
    }
    @Test
    public void testJanKowalski2012IsNull() {

        Assert.assertNull(tasksList.get("Jan Kowalski"));
    }
    @Test
    public void testAdamTarczynek2012IsCorrect() {

        Assert.assertEquals(tasksList.get("Adam Tarczynek"), 340, 0.002);
    }

}
>>>>>>> 888b3308f3aa6482b106176d09e79e0aeb5913b0
