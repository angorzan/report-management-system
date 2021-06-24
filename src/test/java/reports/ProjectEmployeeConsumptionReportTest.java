package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.util.Map;

public class ProjectEmployeeConsumptionReportTest extends TestCase {

    private static Map<String, Float> tasksList;
    public void setUp() throws Exception {
        super.setUp();
        Menu menu = new Menu("../report-management-system/src/test/resources");
    }

    @Test
    public void testAndrzejCiombor2012IsNull() {

        ProjectEmployeeConsumptionReport test = new ProjectEmployeeConsumptionReport("Projekt1");
        tasksList = test.getData();
        Assert.assertNull(tasksList.get("Andrzej Ciombor"));
    }

    @Test
    public void testJanKowalski2012IsCorrect() {

        ProjectEmployeeConsumptionReport test = new ProjectEmployeeConsumptionReport("Projekt1");
        tasksList = test.getData();
        Assert.assertEquals(tasksList.get("Jan Kowalski"), 1184, 0.002);
    }
    @Test
    public void testTotalProjekt2012IsCorrect() {


        Float totalHours = 0.0f;
        for (String key : tasksList.keySet()){

            totalHours += tasksList.get(key);
        }
        Assert.assertEquals(totalHours, 4842, 0.002);
    }

}