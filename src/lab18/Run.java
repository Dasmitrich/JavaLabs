package lab18;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Run {
    File srcFile = new File("image");
    File dstFolder = new File("imgResized");
    File[] files = srcFile.listFiles();
    int division;

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors() + " cores");

        Run run = new Run();
        run.division = run.files.length / 8;

        run.resize();
       // System.out.println(run.files.length - run.division * 7);
    }

    void resize() {

        try {
            if (!Files.exists(Paths.get("imgResized"))) {
                Files.createDirectories(Paths.get("imgResized"));
            }

            for(int i=1; i<9; i++){
                if(i < 8) {
                    File[] tempFile = new File[division];
                    System.arraycopy(files, division * i, tempFile, 0, tempFile.length);
                    ResizingThreads runthread = new ResizingThreads(tempFile, dstFolder);
                    System.out.println("Thread " + i + " started");
                    runthread.start();
                }
                else {
                    File[] tempFile = new File[files.length - division * i];
                    System.arraycopy(files, division * i, tempFile, 0, files.length - division * i);
                    ResizingThreads runthread = new ResizingThreads(tempFile, dstFolder);
                    System.out.println("Thread " + i + " started");
                    runthread.start();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}