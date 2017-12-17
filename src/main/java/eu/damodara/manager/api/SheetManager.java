package eu.damodara.manager.api;

import org.apache.poi.ss.usermodel.Workbook;

public interface SheetManager {
    Workbook deleteColumns(Workbook workbook, Integer... columns);

    Workbook deleteRows(Workbook workbook, Integer... rows);
}
