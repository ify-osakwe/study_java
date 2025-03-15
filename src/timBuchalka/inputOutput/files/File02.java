package timBuchalka.inputOutput.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Instant;

public class File02 {
    public static void main(String[] args) {
        Path path = Path.of("files/test_file_03.txt");
        //printPathInfo(path);
        //logStatement(path);
        extraInfo(path);
    }

    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("fileName = " + path.getFileName());
        System.out.println("parent = " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Absolute Path: = " + absolutePath);
        System.out.println("Absolute Path Root: = " + absolutePath.getRoot());
        System.out.println("Root = " + path.getRoot());
        System.out.println("isAbsolute = " + path.isAbsolute());
        System.out.println();

        /*System.out.println("-----------------------");
        System.out.println(absolutePath.getRoot());
        int i = 1;
        var it = path.toAbsolutePath().iterator();
        while (it.hasNext()) {
            System.out.println(".".repeat(i++) + " " + it.next());
        }
        System.out.println("-----------------------");

        System.out.println("-----------------------");
        System.out.println(absolutePath.getRoot());
        int k = 1;
        for (Path value : path.toAbsolutePath()) {
            System.out.println(".".repeat(k++) + " " + value);
        }
        System.out.println("-----------------------");

        System.out.println("-----------------------");
        int pathParts = absolutePath.getNameCount();
        for (int j = 0; j < pathParts; j++) {
            System.out.println(".".repeat(j + 1) + " " + absolutePath.getName(j));
        }
        System.out.println("-----------------------");*/
    }

    private static void logStatement(Path path) {

        try {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                Files.createDirectories(parent);
            }
            Files.writeString(path, Instant.now() +
                            ": hello file world\n", StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void extraInfo(Path path) {
        try {
            var atts = Files.readAttributes(path, "*");
            atts.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path));
        } catch (IOException e) {
            System.out.println("Problem getting attributes");
        }
    }
}
