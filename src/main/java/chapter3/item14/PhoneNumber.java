package chapter3.item14;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import static java.util.Comparator.comparing;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {

    final short areaCode, prefix, lineNum;

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = rangeCheck(areaCode, 999, "area code");
        this.prefix   = rangeCheck(prefix,   999, "prefix");
        this.lineNum  = rangeCheck(lineNum, 9999, "line num");
    }

    private static short rangeCheck(int val, int max, String arg) {
        if (val < 0 || val > max)
            throw new IllegalArgumentException(arg + ": " + val);
        return (short) val;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof PhoneNumber pn))
            return false;

        return pn.lineNum == lineNum && pn.prefix == prefix
                && pn.areaCode == areaCode;
    }

    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }

    /**
     * Returns the string representation of this phone number.
     * The string consists of twelve characters whose format is
     * "XXX-YYY-ZZZZ", where XXX is the area code, YYY is the
     * prefix, and ZZZZ is the line number. Each of the capital
     * letters represents a single decimal digit.
     *
     * If any of the three parts of this phone number is too small
     * to fill up its field, the field is padded with leading zeros.
     * For example, if the value of the line number is 123, the last
     * four characters of the string representation will be "0123".
     */
    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    // Works fine for classes with no references to mutable state.
    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            // Throws Checked Exception for Object.clone() is a bad design
            // This is can't happen
            throw new AssertionError();
        }
    }

    private static final Comparator<PhoneNumber> COMPARATOR =
            comparing((PhoneNumber pn) -> pn.areaCode)
                    .thenComparing(pn -> pn.prefix)
                    .thenComparing(pn -> pn.lineNum);

    @Override
    public int compareTo(PhoneNumber other) {
        return COMPARATOR.compare(this, other);
    }

    public static void main(String[] args) {
        Set<PhoneNumber> s = new TreeSet<>();

        s.add(new PhoneNumber(222, 222, 2222));
        s.add(new PhoneNumber(111, 111, 1111));
        s.add(new PhoneNumber(333, 333, 3333));

        s.add(new PhoneNumber(111, 111, 1111));
        s.add(new PhoneNumber(111, 555, 6666));

        System.out.println(s);
    }
}
