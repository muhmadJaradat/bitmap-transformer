package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitmap {

    private Path bmpOutputPath;
    private BufferedImage bmpData;

    public Bitmap(String inputPath, String outputPath) throws IOException {

        Path bmpInputPath = Paths.get(inputPath);
        this.bmpOutputPath = Paths.get(outputPath);
        this.bmpData = ImageIO.read(bmpInputPath.toFile());
    }

    public void flipVertically() {

        int height = bmpData.getHeight();
        int width = bmpData.getWidth();

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height / 2; y++) {
                int topColor = bmpData.getRGB(x, y);
                int bottomColor = bmpData.getRGB(x, height - 1 - y);
                bmpData.setRGB(x, y, bottomColor);
                bmpData.setRGB(x, height - 1 - y, topColor);
            }
        }
    }

    public void flipHorizontally() {

        int height = bmpData.getHeight();
        int width = bmpData.getWidth();

        for(int x = 0; x < width / 2; x++) {
            for(int y = 0; y < height; y++) {
                int leftColor = bmpData.getRGB(x, y);
                int rightColor = bmpData.getRGB(width - 1 - x, y);
                bmpData.setRGB(x, y, rightColor);
                bmpData.setRGB(width - 1 - x, y, leftColor);
            }
        }
    }

    public void addRedBorder() {

        int height = bmpData.getHeight();
        int width = bmpData.getWidth();
        System.out.println(width);
        System.out.println(height);

        int borderWidth = 5;

        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(y < borderWidth || y + borderWidth >= height || x < borderWidth || x + borderWidth >= width) {
                    this.bmpData.setRGB(x, y, Color.red.getRGB());
                }
            }
        }
    }

    public void save() throws IOException {

        ImageIO.write(bmpData, "bmp", bmpOutputPath.toFile());
        System.out.println("Saved file to: " + bmpOutputPath);
    }

    public Path getBmpOutputPath() {
        return bmpOutputPath;
    }

    public BufferedImage getBmpData() {
        return bmpData;
    }
}