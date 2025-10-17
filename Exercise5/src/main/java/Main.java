import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class Main {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java PrintDirectoryTree <directory_path>");
            return;
        }

        Path directoryPath = Paths.get(args[0]);


        if (!Files.exists(directoryPath)) {
            System.err.println("Error: The path does not exist:" + directoryPath);
            return;
        }

        if (!Files.isDirectory(directoryPath)) {
            System.err.println("Error: The path is not a directory: " + directoryPath);
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("directoryTree.ser");

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}
