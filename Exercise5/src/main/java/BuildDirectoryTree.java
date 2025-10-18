import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuildDirectoryTree {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static List<DirectoryEntry> TransformFilesToObjects(Path directoryPath) throws IOException {

        List<Path> contents = new ArrayList<>();

        List<DirectoryEntry> entries = new ArrayList<>();

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
                String directoryName = entry.getFileName().toString();
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                new DirectoryEntry(directoryName, type, dateStr);
                List<DirectoryEntry> children = buildDirectoryTree(entry);


                try {
                    TransformFilesToObjects(entry);
                } catch (IOException e) {
                    throw e;
                }

            }else{
                if(entry.getFileName().toString().endsWith(".txt")) {
                    ReadTxtFiles.PrintFileContentInConsole(entry);
                }

                String type = "-F";
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                String fileName = entry.getFileName().toString();
               new DirectoryEntry(fileName, type, dateStr);



            }

        }

        return null;
    }
}
