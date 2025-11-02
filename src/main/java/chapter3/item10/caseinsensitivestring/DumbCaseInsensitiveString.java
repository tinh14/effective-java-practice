package chapter3.item10.caseinsensitivestring;

public class DumbCaseInsensitiveString extends CaseInsensitiveString{

    protected DumbCaseInsensitiveString(String s) {
        super(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DumbCaseInsensitiveString dcis) {
            return getValue().equalsIgnoreCase(dcis.getValue());
        }
        if (o instanceof String str) { // One-way interoperability
            return getValue().equalsIgnoreCase(str);
        }
        return false;
    }
}
