package parsable;

import java.util.List;

public interface Parsable {
    void add(Parsable parsable);
    List<Parsable> getChild();

}
