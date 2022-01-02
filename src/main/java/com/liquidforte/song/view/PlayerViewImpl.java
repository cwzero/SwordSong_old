package com.liquidforte.song.view;

import com.liquidforte.song.math.geometry.three.Point3D;
import com.liquidforte.song.math.geometry.three.PointSet3D;
import com.liquidforte.song.math.geometry.two.Point2D;
import com.liquidforte.song.math.geometry.two.Size2D;
import com.liquidforte.song.player.Player;
import com.liquidforte.song.world.GameWorld;

public class PlayerViewImpl extends AbstractWorldView implements PlayerView {
    private final Size2D size;
    private final Player player;
    private Point3D target;

    public PlayerViewImpl(GameWorld world, Player player, Size2D size) {
        super(world, Point2D.space.filter(size).map(new Point2D(-(size.width() / 4), -(size.height() / 4))), Point3D.space);
        this.size = size;
        this.player = player;
        this.target = player.getPos();
    }

    public PlayerViewImpl(GameWorld world, Player player, int width, int height) {
        this(world, player, new Size2D(width, height));
    }

    @Override
    protected PointSet3D getViewTarget() {
        if (target == null) {
            target = player.getPos();
        } else {
            int x = target.x();
            int y = target.y();
            int z = player.getPos().z();

            int minX = target.x() + (int) (size.width() * (1.0 / 4.0));
            int maxX = target.x() + (int) (size.width() * (3.0 / 4.0));

            int minY = target.y() + (int) (size.height() * (1.0 / 4.0));
            int maxY = target.y() + (int) (size.height() * (3.0 / 4.0));

            if (player.getPos().x() <= minX) {
                x--;
            } else if (player.getPos().x() >= maxX) {
                x++;
            }

            if (player.getPos().y() <= minY) {
                y--;
            } else if (player.getPos().y() >= maxY) {
                y++;
            }

            target = new Point3D(x, y, z);
        }
        return Point3D.space.map(target);
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public Size2D getSize() {
        return size;
    }
}
