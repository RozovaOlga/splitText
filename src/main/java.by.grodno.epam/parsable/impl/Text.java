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
public class Text implements Parsable {
    private List<Parsable> paragraph = new ArrayList<>();


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Parsable pr : paragraph) {
            res.append(pr.toString());
        }
        return res.toString();
    }


    @Override
    public void add(Parsable parsable) {
        paragraph.add(parsable);
    }

    @Override
    public List<Parsable> getChild() {
        return this.getParagraph();
    }
}