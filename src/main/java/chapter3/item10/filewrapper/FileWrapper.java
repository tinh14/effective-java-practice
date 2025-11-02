package chapter3.item10.filewrapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class FileWrapper {
    private final Path path;

    public FileWrapper(String filePath) {
        this.path = Path.of(filePath);
    }

    // Violates consistency requirement of the equals contract
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FileWrapper)) return false;
        FileWrapper other = (FileWrapper) o;
        try {
            byte[] a = Files.readAllBytes(this.path);
            byte[] b = Files.readAllBytes(other.path);
            return Arrays.equals(a, b);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String readData() throws IOException {
        return Files.readString(path);
    }
}
