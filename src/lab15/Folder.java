package lab15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Folder {

    public static void folder(String input, String fpath) throws IOException {
        File fileDir = new File(fpath);

        if(!fileDir.exists())
            fileDir.mkdir();

        fpath += "\\log.txt";

        FileOutputStream out = new FileOutputStream(fpath, true);

        out.write(input.getBytes());
        out.close();
        System.out.println("added log");
    }

    public long folderSize(File dir) {
        long length = 0;

        File[] files = dir.listFiles();

        for (File file : files) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }

    public String converter(double bytes){
        int i = 0;
        String[] nameSize = {"Bytes", "KB", "MB", "GB", "TB"};

        while(bytes > 999){
            bytes = bytes/1024;
            i++;
        }

        return new DecimalFormat("#.#").format(bytes) + " " + nameSize[i];
    }

    public static void main(String[] args) throws IOException {
        Folder F = new Folder();
        System.out.println("Введите путь до папки:");
        String pathDir = new Scanner(System.in).nextLine();

        File dir = new File(pathDir);
        long size = F.folderSize(dir);

        String weight = F.converter(size);
        F.folder("folder: " + pathDir + " weights " + weight, pathDir);

        System.out.println("Размер папки " + pathDir + " составляет " + weight);
    }
}
