package eu.damodara.manager.api;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public interface SheetManager {
    XSSFWorkbook deleteColumns(XSSFWorkbook workbook, Integer... columns);
}
