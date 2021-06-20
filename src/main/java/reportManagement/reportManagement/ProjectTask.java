package reportManagement.reportManagement;
import java.util.Date;

public class ProjectTask {

    String project;
    String employeeName;
    Date date;
    int hours;

    public ProjectTask(String project, String employeeName, Date date, int hours) {
        this.project = project;
        this.employeeName = employeeName;
        this.date = date;
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "ProjectTask{" +
                "project='" + project + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", date=" + date +
                ", hours=" + hours +
                '}';
    }
}
