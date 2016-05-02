package com.company;

import java.awt.Graphics;

public class Bouncer {
    private MoveSetting setting;


    public Bouncer(MoveSetting set) {
        setting = set;
    }

    /** Draws the sprite at its current position on to surface. */
    public void draw(Graphics surface) {
        // Draw the sprite
        setting.mover.draw(surface, setting.x, setting.y);

        // Move the object each time we draw it
        setting.x += setting.xDirection;
        setting.y += setting.yDirection;

        // If we have hit the edge and are moving in the wrong direction, reverse direction
        // We check the direction because if a box is placed near the wall, we would get "stuck"
        // rather than moving in the right direction
        if ((setting.x <= 0 && setting.xDirection < 0) ||
                (setting.x + setting.mover.getWidth() >= SimpleDraw.WIDTH && setting.xDirection > 0)) {
            setting.xDirection = -setting.xDirection;
        }
        if ((setting.y <= 0 && setting.yDirection < 0) ||
                (setting.y + setting.mover.getHeight() >= SimpleDraw.HEIGHT && setting.yDirection > 0)) {
            setting.yDirection = -setting.yDirection;
        }
    }
}
