import java.io.File;

public class DirectoryLister {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: java DirectoryLister <directory_path>");
            return;
        }

        String directoryPath = args[0];


        File directory = new File(directoryPath);


        if (!directory.exists()) {
            System.err.println("Error: The path does not exist: " + directoryPath);
            return;
        }

        if (!directory.isDirectory()) {
            System.err.println("Error: The path is not a directory: " + directoryPath);
            return;
        }


    }
}