package parsable.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parsable.Parsable;


import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paragraph implements Parsable {
    private List<Parsable> sentences = new ArrayList<>();

    @Override
    public void add(Parsable parsable) {
        sentences.add(parsable);
    }

    @Override
    public  List<Parsable> getChild(){
        return this.getSentences();
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Parsable snt : sentences) {
            res.append(snt.toString());
        }
        return res.toString();
    }
}

