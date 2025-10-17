import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuildDirectoryTree {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void TransformFilesToObjects(Path directoryPath, int depth) throws IOException {

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


                try {
                    TransformFilesToObjects(entry, depth + 1);
                } catch (IOException e) {
                    throw e;
                }

            }else{
                if(entry.getFileName().toString().endsWith(".txt")) {
                    ReadTxtFiles.PrintFileContentInConsole(entry);
                }

                String type = "-F";
                String indent = " ".repeat(depth);
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                String fileName = entry.getFileName().toString();



            }

        }

    }
}
