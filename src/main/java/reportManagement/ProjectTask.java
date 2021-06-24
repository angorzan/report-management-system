package reportManagement;

import java.util.Date;

public class ProjectTask {

	private String sheetName;
	private String employeeName;
	private Date date;
	private float hours;

	public String getProjectName() {
		return sheetName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Date getDate() {
		return date;
	}

	public float getHours() {
		return hours;
	}

	public ProjectTask(String sheetName, String employeeName, Date date, float hours) {
		this.sheetName = sheetName;
		this.employeeName = employeeName;
		this.date = date;
		this.hours = hours;
	}

	@Override
	public String toString() {
		return "ProjectTask{" +
				"sheetName='" + sheetName + '\'' +
				", employeeName='" + employeeName + '\'' +
				", date=" + date +
				", hours=" + hours +
				'}';
	}
}
