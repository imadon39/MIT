package com.company;

import java.awt.Graphics;

public class StraightMover {
    private MoveSetting setting;


    public StraightMover(MoveSetting set) {
        setting = set;
    }

    public void draw(Graphics graphics) {
        setting.mover.draw(graphics, setting.x, setting.y);

        // Move the center of the object each time we draw it
        setting.x += setting.xDirection;
        setting.y += setting.yDirection;
    }
}


