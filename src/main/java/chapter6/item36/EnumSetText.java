package chapter6.item36;

import java.util.EnumSet;
import java.util.Objects;

import static chapter6.item36.EnumSetText.Style.*;

public class EnumSetText {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // Should use Set instead of EnumSet.
    public void applyStyles(EnumSet<Style> styles) {
        System.out.printf("Applying styles %s to text%n", Objects.requireNonNull(styles));
    }

    public static void main(String[] args) {
        EnumSetText text = new EnumSetText();

        // Joshua Bloch did the hard work for us
        text.applyStyles(EnumSet.of(BOLD, UNDERLINE));
    }
}
