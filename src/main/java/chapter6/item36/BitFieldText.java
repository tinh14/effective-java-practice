package chapter6.item36;

import java.util.Map;

public class BitFieldText {
    public static final int STYLE_BOLD = 1 << 0; // 0001 -> 1
    public static final int STYLE_ITALIC = 1 << 1; // 0010 -> 2
    public static final int STYLE_UNDERLINE = 1 << 2; // 0100 -> 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3; // 1000 -> 8

    private static final Map<Integer, String> styleNames = Map.of(
            STYLE_BOLD, "BOLD",
            STYLE_ITALIC, "ITALIC",
            STYLE_UNDERLINE, "UNDERLINE",
            STYLE_STRIKETHROUGH, "STRIKETHROUGH"
    );

    public void applyStyles(int styles) {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, String> entry : styleNames.entrySet()) {
            int style = entry.getKey();

            // Example of input styles is 1011 -> BOLD + ITALIC + STRIKETHROUGH
            // For each iteration:
            //
            //   1011 -> BOLD + ITALIC + STRIKETHROUGH
            //AND
            //   0001 -> BOLD (in the map)
            //   ----
            //   0001 -> 1 != 0 -> BOLD style is used

            //   1011 -> BOLD + ITALIC + STRIKETHROUGH
            //AND
            //   0100 -> UNDERLINE (in the map)
            //   ----
            //   0000 -> 0 == 0 -> UNDERLINE style is not used
            //
            // So on...

            if ((styles & style) != 0) {
                sb.append(entry.getValue())
                        .append(" ");
            }
        }

        System.out.printf("Applying styles %s to text%n", sb.toString().trim());
    }

    public static void main(String[] args) {
        BitFieldText text = new BitFieldText();

        //  0001 -> BOLD
        //OR
        //  0010 -> ITALIC
        //OR
        //  1000 -> STRIKETHROUGH
        //  ----
        //  1011 -> BOLD + ITALIC + STRIKETHROUGH
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC | STYLE_STRIKETHROUGH);
    }
}
