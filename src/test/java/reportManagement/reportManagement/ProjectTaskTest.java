package reportManagement.reportManagement;

import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Date;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.edu.agh.mwo.invoice.Invoice;
import pl.edu.agh.mwo.invoice.product.OtherProduct;
import pl.edu.agh.mwo.invoice.product.Product;
import reportManagement.ProjectTask;

/**
 * Unit test for simple App.
 */
public class ProjectTaskTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    @Test
    public void testProjectNameIsCorrect() {
    	Date date = new Date();
    	ProjectTask projectTask = new ProjectTask("Project1", "Kowalski", date, 2.5f);
        Assert.assertEquals("Project1", projectTask.getProjectName());
    }
    @Test
    public void testEmployeeNameIsCorrect() {
    	Date date = new Date();
    	ProjectTask projectTask = new ProjectTask("Project1", "Kowalski", date, 2.5f);
        Assert.assertEquals("Kowalski", projectTask.getEmployeeName());
    }
    @Test
    public void testDateIsCorrect() {
    	Date date = new Date();
    	ProjectTask projectTask = new ProjectTask("Project1", "Kowalski", date, 2.5f);
        Assert.assertEquals(date, projectTask.getDate());
    }
    
    @Test
    public void testHoursIsCorrect() {
    	Date date = new Date();
    	ProjectTask projectTask = new ProjectTask("Project1", "Kowalski", date, 2.5f);
        Assert.assertEquals(2.5f, projectTask.getHours(), 0);
    }
}
