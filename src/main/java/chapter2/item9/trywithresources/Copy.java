package chapter2.item9.trywithresources;

import java.io.*;

public class Copy {

    private static final int BUFFER_SIZE = 8 * 1024;

    private static void copy(String src, String dst) throws IOException {

        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String src = "src/main/java/chapter2/item9/bak/file.bak";
        String dst = "src/main/java/chapter2/item9/bak/file-copy.bak";
        copy(src, dst);
    }
}
