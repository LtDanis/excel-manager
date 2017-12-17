package eu.damodara.manager.acceptance;

import eu.damodara.manager.poi.PoiSheetManager;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import static java.util.Arrays.asList;

class AcceptanceTest {
    private static final String FILE_NAME = "test.xlsx";
    private static final String OUTPUT_FILE_NAME = "data/result.xlsx";
    private PoiSheetManager poiSheetManager;

    @BeforeEach
    void setUp() {
        poiSheetManager = new PoiSheetManager();
    }

    @Test
    void acceptanceTest() throws IOException {
        XSSFWorkbook workbook = readFromFile();

        poiSheetManager.deleteColumns(workbook, asList(3, 1, 10));
        poiSheetManager.deleteRows(workbook, asList(0, 19, 1));

        writeWorkbookToFile(workbook);
    }

    private XSSFWorkbook readFromFile() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(FILE_NAME);
        return new XSSFWorkbook(resourceAsStream);
    }

    private void writeWorkbookToFile(XSSFWorkbook workbook) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(OUTPUT_FILE_NAME);
        workbook.write(outputStream);
        workbook.close();
    }
}