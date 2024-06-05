package ShoppingApp;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    public static void saveToFile(String filename, String content) {
        try (FileWriter fileWriter = new FileWriter(new File(filename), true)) {
            fileWriter.write(content + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

