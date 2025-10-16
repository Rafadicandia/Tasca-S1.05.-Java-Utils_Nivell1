import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PrintDirectoryTree {



    public static void sortList(Path directoryPath) throws IOException {

        List<Path> contents = new ArrayList<>();

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directoryPath)) {


            for (Path entry : stream) {
                contents.add(entry);
            }

            Collections.sort(contents,
                    Comparator.comparing(p -> p.getFileName().toString())
            );

        } catch (IOException e) {

            throw e;
        }


        for (Path entry: contents){
            if(Files.isDirectory(entry)){
                String type = "-D";
                int lasIndex = entry.getNameCount();
                String directoryName = entry.getName(lasIndex).toString();
                System.out.println(
                        directoryName+
                                type
                );

            }else{
                String type = "-F";
                String lastModified = "Last modified: "+ Files.getLastModifiedTime(entry);
                String fileName = entry.getFileName().toString();
                System.out.println(
                        fileName+type+" "+
                                lastModified

                );
            }
        }

    }


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
            sortList(directoryPath);
//            List<String> sortedContents = sortList(directoryPath);
//
//            for(String e:sortedContents){
//                System.out.println(e);
//            }

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}
