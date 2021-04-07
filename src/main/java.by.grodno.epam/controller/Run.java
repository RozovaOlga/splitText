package controller;

import parsable.Parsable;
import service.DataOperation;
import service.impl.DataOperationImpl;
import service.impl.ParserImpl;
import service.SolutionTasks;
import service.impl.SolutionTasksImpl;


public class Run {
    public static void main(String[] args) {
        DataOperation dataOperation = new DataOperationImpl();
        String textOnParts = dataOperation.readFile("text.txt");
        SolutionTasks st = new SolutionTasksImpl();
        ParserImpl parserImpl = new ParserImpl();
        Parsable text = parserImpl.parserText(textOnParts);
        System.out.println(st.swap(text));
        System.out.println(st.orderByAlphabet(text));
    }
}
