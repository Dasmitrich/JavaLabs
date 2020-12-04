package lab18;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResizingThreads extends Thread {

    private File[] files;
    private File dstFolder;

    public ResizingThreads(File[] files, File dstFolder) {
        this.files = files;
        this.dstFolder = dstFolder;
        //System.out.println("constructor done");
    }

    @Override
    public void run() {
        long timeStart = System.currentTimeMillis();

        try {
            if (!Files.exists(Paths.get("imgResized"))) {
                Files.createDirectories(Paths.get("imgResized"));
            }

            for(File file: files){
                BufferedImage image = ImageIO.read(file);
                if(image == null)
                    continue;

                int newWidth = image.getWidth() / 2;
                int newHeight = (int) Math.round(image.getHeight() / (image.getWidth() / (double) newWidth));

                BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);

                int widthStep = image.getWidth() / newWidth;
                int heightStep = image.getHeight() / newHeight;

                for(int x=0; x<newWidth; x++){
                    for(int y=0; y<newHeight; y++){
                        int rgb = image.getRGB(x * widthStep, y * heightStep);
                        newImage.setRGB(x, y, rgb);
                    }
                }

                File newFile = new File(dstFolder + "/" + file.getName());
                ImageIO.write(newImage, "jpg", newFile);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        long time = System.currentTimeMillis() - timeStart;
        System.out.println("Thread finished in " + time + " ms");
    }
}