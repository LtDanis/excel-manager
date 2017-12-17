package eu.damodara.manager.poi;

import eu.damodara.manager.api.SheetManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

public class PoiSheetManager implements SheetManager {
    @Override
    public Workbook deleteRows(Workbook workbook, Integer... rows) {
        IntStream.range(0, workbook.getNumberOfSheets())
                .forEach(sheetIndex ->
                        processRows(workbook.getSheetAt(sheetIndex), asList(rows)));
        return workbook;
    }

    private void processRows(Sheet sheet, List<Integer> rows) {
        reverseSort(rows).forEach(rowNum -> deleteRow(sheet, rowNum));
    }

    private void deleteRow(Sheet sheet, Integer rowNum) {
        Row row = sheet.getRow(rowNum);
        if (row != null) {
            sheet.removeRow(row);
            int lastRowNum = sheet.getLastRowNum();
            if (rowNum < lastRowNum)
                sheet.shiftRows(rowNum + 1, lastRowNum, -1);
        }
    }

    @Override
    public Workbook deleteColumns(Workbook workbook, Integer... columns) {
        IntStream.range(0, workbook.getNumberOfSheets())
                .forEach(sheetIndex ->
                        processColumns(workbook.getSheetAt(sheetIndex), asList(columns)));
        return workbook;
    }

    private void processColumns(Sheet sheet, List<Integer> columnNumbers) {
        reverseSort(columnNumbers).forEach(column ->
                deleteColumn(sheet, column));
    }

    private void deleteColumn(Sheet sheet, Integer columnNumber) {
        for (Row row : sheet) {
            Cell cell = row.getCell(columnNumber);
            if (cell != null)
                row.removeCell(cell);
        }
        sheet.setColumnHidden(columnNumber, true);
    }

    private List<Integer> reverseSort(List<Integer> columnNumbers) {
        return columnNumbers.stream()
                .sorted(reverseOrder())
                .collect(toList());
    }
}