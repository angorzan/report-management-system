package reportManagement;

import java.util.Date;

public class ProjectTask {

	private String sheetName;
	private String employeeName;
	private Date date;
	private int hours;



	public String getProjectName() {
		return sheetName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public Date getDate() {
		return date;
	}

	public int getHours() {
		return hours;
	}

	public ProjectTask(String sheetName, String employeeName, Date date, int hours) {
		this.sheetName = sheetName;
		this.employeeName = employeeName;
		this.date = date;
		this.hours = hours;
	}


}
