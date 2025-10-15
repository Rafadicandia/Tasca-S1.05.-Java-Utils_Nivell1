import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryLister {

    public static void sortList( Path filePath){

        List<String> contents = new ArrayList<>();



    }


    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java DirectoryLister <directory_path>");
            return;
        }
        Path directoryPath = Paths.get(args[0]);



        if (!Files.exists(directoryPath)) {
            System.err.println("Error: The file does not exist in the path" + directoryPath);
            return;
        }

        if (!Files.isDirectory(directoryPath) ) {
        System.err.println("Error: The path is not a directory: " + directoryPath);
        return;
    }



    }
}