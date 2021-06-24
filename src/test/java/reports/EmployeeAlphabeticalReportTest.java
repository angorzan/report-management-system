package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import java.util.Map;


public class EmployeeAlphabeticalReportTest extends TestCase {


    private static Map<String, Float> tasksList;

    public void setUp() throws Exception {

        super.setUp();
        Menu menu = new Menu("../report-management-system/src/test/resources");

    }
    @Test
    public void testJanKowalski2012IsNull() {

        EmployeeAlphabeticalReport test = new EmployeeAlphabeticalReport(2012);
        tasksList = test.getData();
        Assert.assertNull(tasksList.get("Jan Kowalski"));
    }

    @Test
    public void testAdamTarczynek2012IsCorrect() {

        Assert.assertEquals(tasksList.get("Adam Tarczynek"), 340, 0.002);
    }
}