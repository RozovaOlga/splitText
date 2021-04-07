package by.grodno.epam.test;

import service.impl.ParserImpl;
import org.junit.Test;
import parsable.Parsable;
import service.SolutionTasks;
import service.impl.SolutionTasksImpl;

import static org.junit.Assert.assertEquals;

public class TaskTest {

    @Test
    public void orderByAlphabetTest() {
        SolutionTasks solutionTasks = new SolutionTasksImpl();
        ParserImpl parserImpl = new ParserImpl();
        String string = " b C : a c   A A";
        Parsable text = parserImpl.parserText(string);
        String valueWithPrefix = solutionTasks.orderByAlphabet(text);
        assertEquals(valueWithPrefix, "\n\ta: a - 3 \n\tb: b - 1 \n\tc: c - 2 ");
    }

    @Test
    public void swapTest() {
        SolutionTasks solutionTasks = new SolutionTasksImpl();
        ParserImpl parserImpl = new ParserImpl();
        String string = "Hello world!";
        Parsable text = parserImpl.parserText(string);
        String valueWithPrefix = solutionTasks.swap(text);
        assertEquals(valueWithPrefix, "world Hello!");
    }

}
