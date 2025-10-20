import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class PrintDirectoryTree {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static void PrintDirectoryTree(Path directoryPath, int depth, PrintWriter writer) throws IOException {

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
                writer.println(indent+
                        directoryName+
                        type);

                try {
                    PrintDirectoryTree(entry, depth + 1, writer);
                } catch (IOException e) {
                    throw e;
                }


            }else{

                String type = "-F";
                String indent = " ".repeat(depth);
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                String fileName = entry.getFileName().toString();

                writer.println(indent+
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
            PrintWriter writer = new PrintWriter("ListedDirectoryTree.txt", "UTF-8");
            PrintDirectoryTree(directoryPath, 0, writer);
            writer.close();

        } catch (IOException e) {
            System.err.println("Error reading directory: " + e.getMessage());
        }
    }
}
