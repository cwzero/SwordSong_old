package com.liquidforte.song.main;

import com.liquidforte.song.generator.GeneratorConfig;
import com.liquidforte.song.generator.WorldGenerator;
import com.liquidforte.song.generator.WorldGeneratorImpl;
import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.ui.GridWindow;
import com.liquidforte.song.view.WorldView;
import com.liquidforte.song.view.WorldViewImpl;
import com.liquidforte.song.world.GameWorld;

public class Main {
    public static void main(String[] args) {
        GeneratorConfig config = new GeneratorConfig(256, 256, 5);
        WorldGenerator generator = new WorldGeneratorImpl(config);
        GameWorld gameWorld = generator.generate();

        Size2D size = new Size2D(101, 57);
        WorldView view = new WorldViewImpl(gameWorld, Point2D.space.filter(size), Point3D.space.map(new Point3D(1, 1, 0)));
        GridWindow window = new GridWindow(view, size);
        window.start();
    }
}
