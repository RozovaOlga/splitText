package parsable.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parsable.Parsable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Letter implements Parsable {
    private  Character letter;

    @Override
    public String toString() {
        return String.valueOf(letter);
    }

    @Override
    public void add(Parsable parsable) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Parsable> getChild() {
        throw new UnsupportedOperationException();
    }
}
