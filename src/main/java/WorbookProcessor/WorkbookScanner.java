package WorbookProcessor;

import org.apache.poi.ss.usermodel.*;
import reportManagement.reportManagement.App;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class WorkbookScanner {

    public static void scanWorkbook(Path path) {

        Workbook workbook = WorkbookLoader.openWorkbook(path);
        ArrayList<ProjectTask> list = App.getProjectTask();

        for (Sheet sheet : workbook) {

            String sheetName = sheet.getSheetName();
            sheet.removeRow(sheet.getRow(0));
            for (Row row : sheet) {

                int hours = (int) row.getCell(2).getNumericCellValue();
                Date date = row.getCell(0).getDateCellValue();
                list.add(new ProjectTask(sheetName, employeeNameFormater(path), date, hours));
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

