import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

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

        DirectoryEntry rootObject = BuildDirectoryTree.TransformFilesToObjects(directoryPath);

        try (FileOutputStream fileOutputStream = new FileOutputStream("directoryTree.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(rootObject);
            System.out.println("   -> Serialization completed");

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
//deserialization
        DirectoryEntry deserializedRoot;
        try (FileInputStream fileInputStream = new FileInputStream("directoryTree.ser");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)){

            deserializedRoot = (DirectoryEntry) objectInputStream.readObject();

            System.out.println("   -> Deserialization completed");

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
