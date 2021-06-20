package WorbookProcessor;

import org.apache.poi.ss.usermodel.*;
import reportManagement.Menu;
import reportManagement.ProjectTask;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class WorkbookScanner {

	public static void scanWorkbook(Path path) {

		Workbook workbook = WorkbookLoader.openWorkbook(path);
		ArrayList<ProjectTask> list = Menu.getProjectTasks();

		for (Sheet sheet : workbook) {

			String sheetName = sheet.getSheetName();
			sheet.removeRow(sheet.getRow(0));
			for (Row row : sheet) {
				if (row.getCell(0) != null && row.getCell(2) != null) {
					float hours = (float) row.getCell(2).getNumericCellValue();

					Date date = (Date) row.getCell(0).getDateCellValue();
					list.add(new ProjectTask(sheetName, employeeNameFormater(path), date, hours));
				}
			}
		}
	}

	private static String employeeNameFormater(Path path) {

		String employeeName = path.getFileName().toString();
		String[] result = employeeName.substring(0, employeeName.length() - 4).split("_");
		String formattedEmployeeName = result[1] + " " + result[0];
		return formattedEmployeeName;
	}
}
