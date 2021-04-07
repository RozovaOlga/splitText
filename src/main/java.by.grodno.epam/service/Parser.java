package service;

import parsable.Parsable;

public interface Parser {
    Parsable parserText(String text);
    Parsable parserParagraph(String paragraph);
    Parsable parserSentence(String sentence);
    Parsable parserWord(String word);
}
