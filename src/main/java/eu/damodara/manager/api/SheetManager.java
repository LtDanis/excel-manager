package eu.damodara.manager.api;

import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SheetManager {
    Workbook deleteColumns(Workbook workbook, List<Integer> columns);

    Workbook deleteRows(Workbook workbook, List<Integer> rows);

    default Workbook delete(Workbook workbook, List<Integer> columns, List<Integer> rows) {
        Workbook withDeletedColumns = deleteColumns(workbook, columns);
        return deleteRows(withDeletedColumns, rows);
    }
}
