package chapter2.item6.romannumerals;

public class DumbRomanNumerals implements RomanNumerals {

    @Override
    public boolean isRomanNumeral(String s) {
        return s.matches("^(?=.)M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}
