package com.liquidforte.song.util;

import java.awt.*;
import java.awt.image.*;

public class Colorizer {
    private static RGBImageFilter colorize(Color color) {
        int cRgb = color.getRGB();
        return new RGBImageFilter() {
            @Override
            public int filterRGB(int x, int y, int rgb) {
                int alpha = (rgb & 0xff000000) >>> 24;
                int c = rgb & 0xffffff;
                boolean copy = (alpha == 0 || c == 0 || rgb == 0);
                System.out.println("rgb: " + rgb + " c: " + c + " alpha: " + alpha);
                return copy ? rgb : cRgb;
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

    public static BufferedImage colorize(BufferedImage input, Color color) {
        /*BufferedImage result = new BufferedImage(input.getWidth(), input.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics2D graphics = result.createGraphics();
        graphics.setColor(color);
        graphics.fillRect(0, 0, input.getWidth(), input.getHeight());
        graphics.setComposite(AlphaComposite.DstIn);
        graphics.drawImage(input, 0, 0, input.getWidth(), input.getHeight(), 0, 0, input.getWidth(), input.getHeight(), null);
         */
        return input;
    }
}
