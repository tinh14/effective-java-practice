package chapter2.item9.trywithresources;

import chapter2.item9.tryfinally.DumbBufferedReader;

import java.io.BufferedReader;
import java.io.IOException;

public class TopLine {

//    Virtualize readLine() and close() to throw exceptions
    private static String firstLineOfLineWithDumpedReader(String path) throws IOException {
        try (BufferedReader dbr = new DumbBufferedReader(path)) {
            return dbr.readLine();
        }
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/java/chapter2/item9/bak/file.bak";
        System.out.println(firstLineOfLineWithDumpedReader(path));
    }
}
