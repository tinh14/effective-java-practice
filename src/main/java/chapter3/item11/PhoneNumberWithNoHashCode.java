package chapter3.item11;

public class PhoneNumberWithNoHashCode extends PhoneNumber {

    public PhoneNumberWithNoHashCode(int areaCode, int prefix, int lineNum) {
        super(areaCode, prefix, lineNum);
    }
}
