package eu.damodara.manager.gui.swing.data;

import eu.damodara.manager.api.PatternEntity;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class Patterns {
    private Patterns() {
    }

    private static final PatternEntity PATTERN_1 = new PatternEntity("Šablonas - 1",
            asList(1, 2, 3),
            asList(0, 3));
    private static final PatternEntity PATTERN_2 = new PatternEntity("Šablonas - 2",
            singletonList(3),
            singletonList(4));
    private static final PatternEntity PATTERN_3 = new PatternEntity("Šablonas - 3",
            emptyList(),
            singletonList(1));

    public static List<PatternEntity> getExportPatterns() {
        return asList(PATTERN_1, PATTERN_2, PATTERN_3);
    }
}
