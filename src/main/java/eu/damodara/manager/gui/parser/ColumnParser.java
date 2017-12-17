package eu.damodara.manager.gui.parser;

import java.util.List;

import static eu.damodara.manager.gui.parser.mapper.LineMapper.getColumnMap;
import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class ColumnParser {
    public List<Integer> parse(String data) {
        return data == null ? emptyList() :
                collectColumns(data.toUpperCase().replaceAll("[^A-Z]", ""));
    }

    private List<Integer> collectColumns(String data) {
        return data.chars().mapToObj(c -> (char) c).collect(toList()).stream()
                .distinct()
                .map(getColumnMap()::get)
                .collect(toList());
    }
}
