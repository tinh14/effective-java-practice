package chapter3.item11;

public class PhoneNumberWithHashCode extends PhoneNumber {

    public PhoneNumberWithHashCode(int areaCode, int prefix, int lineNum) {
        super(areaCode, prefix, lineNum);
    }

    // Objects.hash method boxes primitive values and creates an array on each call.
//    @Override
//    public int hashCode() {
//        return Objects.hash(lineNum, prefix, areaCode);
//    }

    // Lazily initializes cached hash code.
//    private int hashCode;
//
//    @Override
//    public int hashCode() {
//        int result = hashCode;
//        if (result == 0) {
//            result = Short.hashCode(areaCode);
//            result = 31 * result + Short.hashCode(prefix);
//            result = 31 * result + Short.hashCode(lineNum);
//            hashCode = result;
//        }
//        return result;
//    }

    // Perfectly good hashCode implementation.
    // This is comparable in equality to the one found in Java platform libraries.
    @Override
    public int hashCode() {
        int result = Short.hashCode(areaCode);
        result = 31 * result + Short.hashCode(prefix);
        result = 31 * result + Short.hashCode(lineNum);
        return result;
    }
}
