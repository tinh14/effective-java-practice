package chapter3.item10.filewrapper;

import java.io.IOException;
import java.net.URISyntaxException;

public class Test {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // File Wrapper test
        System.out.println("File Wrapper");
        String filePath1 = "src/main/java/chapter3/item10/filewrapper/data1.txt";
        String filePath2 = "src/main/java/chapter3/item10/filewrapper/data2.txt";
        FileWrapper f1 = new FileWrapper(filePath1);
        FileWrapper f2 = new FileWrapper(filePath2);

        System.out.println("First equals: " + f1.equals(f2));
        System.out.println("F1 content: " + f1.readData());
        System.out.println("F2 content: " + f2.readData());

        System.out.println("Modify the file, then press Enter...");
        System.in.read();

        System.out.println("Second equals: " + f1.equals(f2));
        System.out.println("F1 content: " + f1.readData());
        System.out.println("F2 content: " + f2.readData());
    }
}
