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
public class Word implements Parsable {

    private List<Parsable> letter = new ArrayList<>();


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Parsable lt : letter) {
            res.append(lt.toString());
        }
        return res.toString();
    }

    @Override
    public void add(Parsable parsable) {
        letter.add(parsable);
    }

    @Override
    public List<Parsable> getChild() {
        return this.getLetter();
    }
}
