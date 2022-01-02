package com.liquidforte.song.util;

import java.awt.*;
import java.awt.image.*;

public class Colorizer {
    private static final int backIn = -65281;

    private static RGBImageFilter transparent() {
        return new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                return rgb == backIn ? 0 : rgb;
            }
        };
    }

    private static RGBImageFilter colorize(Color color) {
        int cRgb = color.getRGB();
        RGBImageFilter transparent = transparent();
        return new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                return rgb == -1 ? cRgb : transparent.filterRGB(x, y, rgb);
            }
        };
    }

    private static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    private static Image filter(Image input, ImageFilter filter) {
        ImageProducer producer = new FilteredImageSource(input.getSource(), filter);
        return Toolkit.getDefaultToolkit().createImage(producer);
    }

    public static BufferedImage colorize(Image input, Color color) {
        return toBufferedImage(filter(input, colorize(color)));
    }
}
