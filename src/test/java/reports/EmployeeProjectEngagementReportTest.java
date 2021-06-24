package reports;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import reportManagement.Menu;
import java.util.ArrayList;


public class EmployeeProjectEngagementReportTest extends TestCase {

    private static ArrayList<String> tasksList;

    public void setUp() throws Exception {
        super.setUp();
        Menu menu = new Menu("../report-management-system/src/test/resources");
    }
    @Test
    public void noProjekt3ForAleksandraSobolewska() {

        ProjectEngagementReport test = new ProjectEngagementReport(2012);
        tasksList = test.getData();
        boolean result = true;
        for (String s: tasksList) {

            if(s.contains("Aleksandra Sobolewska#Projekt3")){

                result = false;
            }
        }
        Assert.assertTrue(result);
    }
    @Test
    public void noProjectForAndrzejCiombor() {
        ProjectEngagementReport test = new ProjectEngagementReport(2012);
        tasksList = test.getData();
        boolean result = false;
        for (String s: tasksList) {

            if(s.contains("Andrzej Ciombor")){
                result = true;
            }
        }
        Assert.assertFalse(result);
    }
    @Test
    public void testProjekt1IsCorrect() {
        ProjectEngagementReport test = new ProjectEngagementReport(2012);
        tasksList = test.getData();
        String [] splitted = new String[10];
        for (String s: tasksList) {

            if(s.contains("Aleksandra Sobolewska#Projekt1")){
                splitted = s.split("#");
            }
        }
        Float hours = Float.parseFloat(splitted[2]);
        Assert.assertEquals(hours, 504, 0.02);
    }
}