import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.*;

public class BuildDirectoryTree {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static DirectoryEntry TransformFilesToObjects(Path directoryPath) throws IOException {


        List<Path> contents = new ArrayList<>();

        //List<DirectoryEntry> entries = new ArrayList<>();

        FileTime rootObjectLastModified = Files.getLastModifiedTime(directoryPath);
        String rootObjectDate;
        rootObjectDate = DATE_FORMAT.format(new Date(rootObjectLastModified.toMillis()));

        DirectoryEntry rootObject = new DirectoryEntry(directoryPath.getFileName().toString().trim(), "D", rootObjectDate);

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
                String directoryName = entry.getFileName().toString().trim();
                FileTime lastModified = Files.getLastModifiedTime(entry);
                dateStr = DATE_FORMAT.format(new Date(lastModified.toMillis()));
                DirectoryEntry currentEntry = new DirectoryEntry(directoryName, type, dateStr);
                //entries.add(currentEntry);
                rootObject.addChild(currentEntry);

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
                DirectoryEntry currentEntry = new DirectoryEntry(fileName, type, dateStr);
                rootObject.addChild(currentEntry);

            }

        }

        return rootObject;
    }
}
