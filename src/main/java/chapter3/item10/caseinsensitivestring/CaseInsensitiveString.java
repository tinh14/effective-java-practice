package chapter3.item10.caseinsensitivestring;

import java.util.Objects;

public abstract class CaseInsensitiveString {
    private final String s;

    protected CaseInsensitiveString(String s) {
        this.s = Objects.requireNonNull(s);
    }

    public String getValue() {
        return s;
    }
}
