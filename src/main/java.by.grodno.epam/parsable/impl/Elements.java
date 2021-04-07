package parsable.impl;

public enum Elements {
    PARAGRAPH("(?m)(?=^\\s{4})"),
    SENTENCE("(?<=[^?!.]{1,5}[?!.]{1,5}[\\s+]{0,5})(?=[A-Z])"),
    WORD("^[0-9a-zA-Z]+$"),
    SPLIT_REGEX("\\b|(?=\\s+)"),
    MARKS("[\\s+]|[Az]");
    private final String elements;

    Elements(String elements) {
        this.elements = elements;
    }

    public String getName() {
        return this.name();
    }

    public String getElements() {
        return this.elements;
    }
}
