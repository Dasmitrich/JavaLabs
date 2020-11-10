package lab15;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class FolderCopy {

    public void copyFile(File origin , File destination) throws IOException {

        if (origin.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdir();
            }

            String[] children = origin.list();
            for (int i=0; i<children.length; i++) {
                copyFile(new File(origin, children[i]),
                        new File(destination, children[i]));
            }
        } else {

            InputStream in = new FileInputStream(origin);
            OutputStream out = new FileOutputStream(destination);

            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }


    public static void main(String[] args) throws IOException {

        String pathOriginal, pathDestination;

        System.out.println("Enter original directory path:");
        pathOriginal = new Scanner(System.in).nextLine();
        System.out.println("Enter destination directory path:");
        pathDestination = new Scanner(System.in).nextLine();

        FolderCopy cpy = new FolderCopy();
        cpy.copyFile(new File(pathOriginal), new File(pathDestination));
        new Folder().folder("файлы скопированы\n", pathDestination);
    }
}
