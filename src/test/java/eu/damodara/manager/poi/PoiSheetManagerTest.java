package eu.damodara.manager.poi;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class PoiSheetManagerTest {
    private static final String FILE_NAME = "test.xlsx";
    private static final String OUTPUT_FILE_NAME = "data/result.xlsx";

    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        XSSFWorkbook workbook = new XSSFWorkbook(resourceAsStream);

        new PoiSheetManager().deleteColumns(workbook, 3, 1, 10);

        FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
}