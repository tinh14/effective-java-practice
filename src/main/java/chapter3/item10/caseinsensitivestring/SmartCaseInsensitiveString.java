package chapter3.item10.caseinsensitivestring;

public class SmartCaseInsensitiveString extends CaseInsensitiveString {

    protected SmartCaseInsensitiveString(String s) {
        super(s);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof SmartCaseInsensitiveString scis) {
            return getValue().equalsIgnoreCase(scis.getValue());
        }
        return false;
    }
}
