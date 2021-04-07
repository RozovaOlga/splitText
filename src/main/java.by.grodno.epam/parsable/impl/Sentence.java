package parsable.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import parsable.Parsable;

import java.util.*;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class Sentence implements Parsable {

    private List<Parsable> wordMarksSpace = new ArrayList<>();


    @Override
    public void add(Parsable parsable) {
        wordMarksSpace.add(parsable);
    }

    @Override
    public List<Parsable> getChild() {
        return this.getWordMarksSpace();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Parsable i : wordMarksSpace) {
            sb.append(i.toString());
        }
        return sb.toString();
    }
}

