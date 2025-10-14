package chapter2.item9.tryfinally;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class DumbBufferedReader extends BufferedReader {

   public DumbBufferedReader(String path) {
       super(new StringReader(path));
   }

   @Override
   public String readLine() throws IOException {
       throw new IOException("readLine() failed");
   }

   @Override
   public void close() throws IOException {
       throw new IOException("close() failed");
   }
}
