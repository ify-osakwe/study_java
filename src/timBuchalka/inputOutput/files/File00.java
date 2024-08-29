package timBuchalka.inputOutput.files;

import timBuchalka.UtilsX;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;

public class File00 {
    public static void main(String[] args) {
        File aFile = new File("");
        System.out.println("Current working directory - absolute path: "
                + aFile.getAbsolutePath());
        try {
            System.out.println("Current working directory - canonical path: "
                    + aFile.getCanonicalPath());
        } catch (IOException e) {
            System.out.println("Oops! runtime exception");
        }
        UtilsX.newLineSpace();

        for (File f : File.listRoots()) {
            System.out.println(f);
        }
        System.out.println(FileSystems.getDefault().toString());


    }
}
