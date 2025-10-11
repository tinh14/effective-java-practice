package chapter2.item6.romannumerals;

import java.util.regex.Pattern;

public class SmartRomanNumerals implements RomanNumerals{
    private static final Pattern ROMAN_PATTERN = Pattern.compile(
            "^(M{0,3})(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

    @Override
    public boolean isRomanNumeral(String s) {
        return ROMAN_PATTERN.matcher(s).matches();
    }
}
