package eu.damodara.manager.gui.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.stream.Collectors.toList;

public class RowParser {
    public List<Integer> parse(String data) {
        return data == null ? emptyList() :
                Arrays.stream(data.split(","))
                        .map(number -> number.replaceAll("[^0-9]", ""))
                        .map(this::parseInt)
                        .filter(Objects::nonNull)
                        .collect(toList());
    }

    private Integer parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            return null;
        }
    }
}
