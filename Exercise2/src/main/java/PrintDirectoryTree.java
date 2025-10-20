import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class PrintDirectoryTree {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void PrintDirectoryTree(Path directoryPath, int depth) throws IOException {

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
            String dateStr;
            if(Files.isDirectory(entry)){
                String type = "-D";
                String indent = " ".repeat(depth);
                String directoryName = entry.getFileName().toString();

                System.out.println(indent+
                        directoryName+
                                type
                );
                try {
                    PrintDirectoryTree(entry, depth + 1);
                } catch (IOException e) {
                }

            }else{
                String type = "-F";
                String indent = " ".repeat(depth);
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                String fileName = entry.getFileName().toString();

                System.out.println(indent+
                        fileName+type+" "+
                        dateStr

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

            PrintDirectoryTree(directoryPath, 0);

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}
