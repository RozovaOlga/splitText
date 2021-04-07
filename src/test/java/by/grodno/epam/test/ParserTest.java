package by.grodno.epam.test;

import org.junit.Test;
import parsable.Parsable;
import service.impl.ParserImpl;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void countChar() {
        ParserImpl parserImpl = new ParserImpl();
        String string = " 1 2 world# . ";
        Parsable text = parserImpl.parserText(string);
        char[] chars = text.toString().toCharArray();
        int count = chars.length;
        assertEquals(count, 14);
    }
}
