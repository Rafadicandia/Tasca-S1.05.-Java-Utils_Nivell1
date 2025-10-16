import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class ReadTxtFiles {

    public static void PrintFileContentInConsole(Path directoryPath) throws IOException {
        if(directoryPath.getFileName().endsWith(".txt")){
            List<String> lines = Files.readAllLines(directoryPath, StandardCharsets.UTF_8);
            for(String l: lines) {
                System.out.println(l);
            }
        }


    }

}
