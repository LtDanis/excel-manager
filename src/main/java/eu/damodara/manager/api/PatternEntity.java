package eu.damodara.manager.api;

import java.util.List;

public class PatternEntity {
    private final String name;
    private final List<Integer> rows;
    private final List<Integer> columns;

    public PatternEntity(String name, List<Integer> columns, List<Integer> rows) {
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getRows() {
        return rows;
    }

    public List<Integer> getColumns() {
        return columns;
    }
}
