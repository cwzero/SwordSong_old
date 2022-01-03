package com.liquidforte.song.generator.room;

import com.liquidforte.song.world.GameWorldLayer;

import java.util.Random;

public class BSPTree {
    private static final Random random = new Random();
    private final BSPNode root;
    private final int targetWidth = 20, targetHeight = 20;

    public BSPTree(GameWorldLayer layer) {
        root = new BSPNode(0, 0, layer.getWidth(), layer.getHeight());
    }

    public void split() {
        root.split();
        root.connect();
    }

    public void draw(GameWorldLayer layer) {
        root.draw(layer);
    }

    public class BSPNode {
        private final int x, y;
        private final int width, height;

        private boolean split = false;
        private boolean leaf = false;
        private BSPNode left = null, right = null;

        public BSPNode(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public BSPNode getLeft() {
            return left;
        }

        public BSPNode getRight() {
            return right;
        }

        public void split() {
            if (!leaf && !split) {
                boolean horizontal = false;
                leaf = true;
                if (width > (2 * targetWidth) && height > (2 * targetHeight)) {
                    horizontal = random.nextBoolean();
                } else if (width > (2 * targetWidth)) {
                    horizontal = true;
                } else if (height > (2 * targetHeight)) {
                } else {
                    return;
                }

                split = true;
                leaf = false;

                if (horizontal) {
                    int minX = targetWidth;
                    int maxX = (width - targetWidth);
                    int x = random.nextInt(minX, maxX);
                    int leftWidth = x;
                    int rightWidth = (width - x);
                    int leftX = this.x;
                    int rightX = this.x + x;

                    left = new BSPNode(leftX, y, leftWidth, height);
                    right = new BSPNode(rightX, y, rightWidth, height);
                } else {
                    int minY = targetHeight;
                    int maxY = (height - targetHeight);
                    int y = random.nextInt(minY, maxY);
                    int leftHeight = (y);
                    int rightHeight = (height - y);
                    int leftY = this.y;
                    int rightY = this.y + y;

                    left = new BSPNode(x, leftY, width, leftHeight);
                    right = new BSPNode(x, rightY, width, rightHeight);
                }

                left.split();
                right.split();
            }
        }

        public void connect() {
            if (split) {
                left.connect();
                right.connect();
            }

        }

        public void draw(GameWorldLayer layer) {
            if (split) {
                left.draw(layer);
                right.draw(layer);
            } else {
                int dx = random.nextInt(1, this.width - 9);
                int dy = random.nextInt(1, this.height - 9);

                int width = random.nextInt(7, this.width - dx - 1);
                int height = random.nextInt(7, this.height - dy - 1);

                RoomDigger.digRoom(layer, x + dx, y + dy, width, height);
            }
        }
    }
}
