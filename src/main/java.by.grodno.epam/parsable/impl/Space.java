package parsable.impl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parsable.Parsable;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Space implements Parsable {
    private String space;

    @Override
    public String toString() {
        return space;
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
