import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DirectoryLister {

    public static void sortList( Path directoryPath){

        List<String> contents = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {


            for (Path entry : stream) {
                contents.add(entry.toString());
            }

            // 2. Ordenar la lista alfabéticamente.
            // [TU CÓDIGO AQUÍ: Ordenar la lista 'contents']
            contents.sort();

        } catch (IOException e) {
            // Manejo de errores de IO (por ejemplo, falta de permisos).
            throw e;
        }

        return contents;
    }



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