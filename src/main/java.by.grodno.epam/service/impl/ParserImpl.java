package service.impl;

import lombok.extern.slf4j.Slf4j;
import parsable.Parsable;
import parsable.impl.*;
import service.Parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static parsable.impl.Elements.*;

@Slf4j
public class ParserImpl implements Parser {
    @Override
    public Parsable parserText(String tx) {
        Parsable text = new Text();
        log.info("Parsing text start");
        List<String> partsT = new ArrayList<>(Arrays.asList(tx.split(PARAGRAPH.getElements())));
        for (String s : partsT) {
            text.add(parserParagraph(s));
        }
        log.info("Parsing text finished");
        return text;
    }

    @Override
    public Parsable parserParagraph(String pr) {
        Parsable paragraph = new Paragraph();
        List<String> partsP = new ArrayList<>(Arrays.asList(pr.split((SENTENCE.getElements()))));
        for (String s : partsP) {
            paragraph.add(parserSentence(s));
        }
        return paragraph;
    }

    @Override
    public Parsable parserSentence(String sn) {
        log.info("Parsing sentence start");
        Parsable sentence = new Sentence();
        List<String> split = new ArrayList<>(Arrays.asList(sn.split((SPLIT_REGEX.getElements()))));
        for (String rawWord : split) {
            if (rawWord.matches(WORD.getElements())) {
                sentence.add(parserWord(rawWord));
            } else if (!rawWord.matches(MARKS.getElements())) {
                sentence.add(new Mark(rawWord));
            } else {
                sentence.add(new Space(rawWord));
            }
        }
        log.info("Parsing sentence finished");
        return sentence;
    }

    @Override
    public Parsable parserWord(String wrd) {
        log.info("Parsing word start");
        Parsable word = new Word();
        List<Character> partsW = wrd.chars().mapToObj((i) -> (char) i).collect(Collectors.toList());
        for (Character s : partsW) {
            word.add(new Letter(s));
        }
        log.info("Parsing word finished");
        return word;
    }
}
