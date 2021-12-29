package com.liquidforte.song.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TextureUtil {
    private static final Colorizer colorizer = new Colorizer();
    private static final String DEFAULT_SET = "16x16-RogueYun-AgmEdit";

    private static final Map<String, TileSet> sets = new HashMap<>();

    private static TileSet getSet(String set) {
        if (!sets.containsKey(set)) {
            sets.put(set, new TileSet(loadSet(set)));
        }
        return sets.get(set);
    }

    private static ColoredTileSet getSet(String set, Color color) {
        return getSet(set).getColor(color);
    }

    public static BufferedImage getTexture(String set, Color color, char tile) {
        return getSet(set, color).getTile(tile);
    }

    public static BufferedImage getTexture(Color color, char tile) {
        return getTexture(DEFAULT_SET, color, tile);
    }

    private static InputStream getInput(String fileName) {
        return TextureUtil.class.getClassLoader().getResourceAsStream(fileName);
    }

    private static BufferedImage loadSet(String set) {
        try {
            return ImageIO.read(getInput(set + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static class Colorizer {
        private static final int backIn = -65281;

        private RGBImageFilter transparent() {
            return new RGBImageFilter() {
                @Override
                public int filterRGB(int x, int y, int rgb) {
                    return rgb == backIn ? 0 : rgb;
                }
            };
        }

        private RGBImageFilter colorize(Color color) {
            int cRgb = color.getRGB();
            RGBImageFilter transparent = transparent();
            return new RGBImageFilter() {
                @Override
                public int filterRGB(int x, int y, int rgb) {
                    return rgb == -1 ? cRgb : transparent.filterRGB(x, y, rgb);
                }
            };
        }

        private BufferedImage toBufferedImage(Image img) {
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

        private Image filter(Image input, ImageFilter filter) {
            ImageProducer producer = new FilteredImageSource(input.getSource(), filter);
            return Toolkit.getDefaultToolkit().createImage(producer);
        }

        public BufferedImage colorize(Image input, Color color) {
            return toBufferedImage(filter(input, colorize(color)));
        }
    }

    private static class ColoredTileSet {
        private final Color color;
        private final BufferedImage set;
        private final BufferedImage[][] tiles = new BufferedImage[16][16];

        public ColoredTileSet(Color color, BufferedImage set) {
            this.color = color;
            this.set = colorizer.colorize(set, color);
        }

        public BufferedImage getTile(char tile) {
            return getTile(TileUtil.encodeTile(tile));
        }

        private BufferedImage getTile(int tile) {
            return getTile(tile % 16, tile / 16);
        }

        private BufferedImage getTile(int x, int y) {
            return set.getSubimage(x * 16, y * 16, 16, 16);
        }
    }

    private static class TileSet {
        private final BufferedImage set;
        private final Map<Color, ColoredTileSet> colors = new HashMap<>();

        public TileSet(BufferedImage set) {
            this.set = set;
        }

        public BufferedImage getTile(char tile) {
            return getTile(TileUtil.encodeTile(tile));
        }

        private BufferedImage getTile(int tile) {
            return getTile(tile % 16, tile / 16);
        }

        private BufferedImage getTile(int x, int y) {
            return set.getSubimage(x * 16, y * 16, 16, 16);
        }

        public BufferedImage getTile(Color color, char tile) {
            return getColor(color).getTile(tile);
        }

        private ColoredTileSet getColor(Color color) {
            if (!colors.containsKey(color)) {
                colors.put(color, new ColoredTileSet(color, set));
            }
            return colors.get(color);
        }
    }
}
