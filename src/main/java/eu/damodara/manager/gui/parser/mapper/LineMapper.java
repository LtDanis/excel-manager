package eu.damodara.manager.gui.parser.mapper;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;

public class LineMapper {
    private static final Map<Character, Integer> LINE_MAPPER = createMapper();

    private LineMapper() {
    }

    public static Map<Character, Integer> getColumnMap() {
        return unmodifiableMap(LINE_MAPPER);
    }

    private static Map<Character, Integer> createMapper() {
        Map<Character, Integer> lineMap = new HashMap<>();
        lineMap.put('A', 0);
        lineMap.put('B', 1);
        lineMap.put('C', 2);
        lineMap.put('D', 3);
        lineMap.put('E', 4);
        lineMap.put('F', 5);
        lineMap.put('G', 6);
        lineMap.put('H', 7);
        lineMap.put('I', 8);
        lineMap.put('J', 9);
        lineMap.put('K', 10);
        lineMap.put('L', 11);
        lineMap.put('M', 12);
        lineMap.put('N', 13);
        lineMap.put('O', 14);
        lineMap.put('P', 15);
        lineMap.put('R', 16);
        lineMap.put('S', 17);
        lineMap.put('T', 18);
        lineMap.put('U', 19);
        lineMap.put('V', 20);
        lineMap.put('W', 21);
        lineMap.put('X', 22);
        lineMap.put('Y', 23);
        lineMap.put('Z', 24);
        return lineMap;
    }
}
