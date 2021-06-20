package WoorbookProcessor;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class WorkbookLoader {

    public static Workbook openWorkbook(Path path) {
        try {
            return WorkbookFactory.create(new File(String.valueOf(path)));
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
