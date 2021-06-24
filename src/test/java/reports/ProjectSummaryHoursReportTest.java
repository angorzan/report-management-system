package reports;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import java.util.Map;

public class ProjectSummaryHoursReportTest extends TestCase {

    private static Map<String, Float> tasksList;

    public void setUp() throws Exception {

        super.setUp();
        Menu menu = new Menu("../report-management-system/src/test/resources");
    }

    @Test
    public void testProjekt32012IsNull() {

        ProjectSummaryHoursReport test = new ProjectSummaryHoursReport(2012);
        tasksList = test.getData();
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