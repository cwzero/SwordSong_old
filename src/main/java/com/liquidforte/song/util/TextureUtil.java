package com.liquidforte.song.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class TextureUtil {
    private static final String DEFAULT_SET = "16x16-sb-ascii";

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

    public static BufferedImage getTexture(String set, char tile) {
        return getSet(set).getTile(tile);
    }

    public static BufferedImage getTexture(char tile) {
        return getTexture(DEFAULT_SET, tile);
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

    private static class ColoredTileSet {
        private final Color color;
        private final BufferedImage set;
        private final BufferedImage[][] tiles = new BufferedImage[16][16];

        public ColoredTileSet(Color color, BufferedImage set) {
            this.color = color;
            this.set = Colorizer.colorize(set, color);
        }

        public BufferedImage getTile(char tile) {
            return getTile(TileUtil.encodeTile(tile));
        }

        public BufferedImage getTile(byte tile) {
            int t = tile & 0xFF;
            return getTile(t);
        }

        private BufferedImage getTile(int tile) {
            return getTile(tile % 16, tile / 16);
        }

        private BufferedImage getTile(int x, int y) {
            if (x < 0) {
                x += 16;
            }
            if (y < 0) {
                y += 16;
            }
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
