package eu.damodara.manager.gui.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RowParserTest {
    private RowParser parser;

    @BeforeEach
    void setUp() {
        parser = new RowParser();
    }

    @Test
    void parse() {
        assertEquals(parser.parse("1,2,3"), asList(1, 2, 3));
        assertEquals(parser.parse("1a,2,3"), asList(1, 2, 3));
        assertEquals(parser.parse("a,2,3"), asList(2, 3));
        assertEquals(parser.parse(""), emptyList());
        assertEquals(parser.parse("999"), singletonList(999));
        assertEquals(parser.parse(null), emptyList());
    }
}