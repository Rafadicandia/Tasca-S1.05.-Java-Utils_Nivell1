import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class ReadTxtFiles {

    public static void PrintFileContentInConsole(Path filePath) throws IOException {

            List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
            for(String l: lines) {
                System.out.println(l);
            }


    }
}
