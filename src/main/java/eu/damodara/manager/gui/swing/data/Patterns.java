package eu.damodara.manager.gui.swing.data;

import eu.damodara.manager.api.PatternEntity;

import java.util.List;

import static java.util.Arrays.asList;

public class Patterns {
    private Patterns() {
    }

    private static final PatternEntity PATTERN_1 = new PatternEntity("Šablonas - 1",
            asList(1, 2, 3),
            asList(0, 3));

    public static List<PatternEntity> getExportPatterns() {
        return asList(PATTERN_1);
    }
}