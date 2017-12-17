package eu.damodara.manager.gui.parser;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ColumnParserTest {
    private ColumnParser parser;

    @BeforeEach
    void setUp() {
        parser = new ColumnParser();
    }

    @Test
    void parse() {
        assertEquals(parser.parse("AB,3"), asList(0, 1));
        assertEquals(parser.parse("a,2,3"), singletonList(0));
        assertEquals(parser.parse(""), emptyList());
        assertEquals(parser.parse("z"), singletonList(24));
        assertEquals(parser.parse("1,2,3"), emptyList());
        assertEquals(parser.parse(null), emptyList());
    }
}