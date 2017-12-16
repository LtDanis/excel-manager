package eu.damodara.manager.poi;

import eu.damodara.manager.api.SheetManager;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class PoiSheetManager implements SheetManager {
    @Override
    public XSSFWorkbook deleteColumns(XSSFWorkbook workbook, Integer... columns) {
        for (int sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++)
            deleteSheetColumns(workbook.getSheetAt(sheetIndex), asList(columns));
        return workbook;
    }

    private void deleteSheetColumns(Sheet sheet, List<Integer> columnNumbers) {
        columnNumbers.stream()
                .sorted(reverseOrder())
                .collect(toList()).forEach(column ->
                deleteColumn(sheet, column));
    }

    private void deleteColumn(Sheet sheet, Integer columnNumber) {
        for (Object rowObject : sheet) {
            XSSFRow row = (XSSFRow) rowObject;
            XSSFCell cell = row.getCell(columnNumber);
            if (cell != null)
                row.removeCell(cell);
        }
        sheet.setColumnHidden(columnNumber, true);
    }
}