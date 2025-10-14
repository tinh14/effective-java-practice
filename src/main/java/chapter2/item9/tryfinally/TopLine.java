package chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.IOException;

public class TopLine {

//    Virtualize readLine() and close() to throw exceptions
    private static String firstLineOfLineWithDumpedReader(String path) throws IOException {
        BufferedReader dbr = new DumbBufferedReader(path);
        try {
            return dbr.readLine();
        } finally {
            // This exception will mask the exception from readLine()
            dbr.close();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/java/chapter2/item9/bak/file.bak";
        System.out.println(firstLineOfLineWithDumpedReader(path));
    }
}
