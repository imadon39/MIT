package com.company;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class DrawGraphics {
    List<Bouncer> movingSprites;
    List<StraightMover> movingStraights;
    List<Mover> movers;

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Oval box2 = new Oval(25, 30, Color.BLUE);
        movingSprites = new ArrayList<Bouncer>();
        movingSprites.add(new Bouncer(new MoveSetting(100, 170, box,3,1)));
        movingSprites.add(new Bouncer(new MoveSetting(50, 80, box2,2,2)));
        movingStraights = new ArrayList<StraightMover>();
        movingStraights.add(new StraightMover(new MoveSetting(30, 10, box,2,4)));
        movingStraights.add(new StraightMover(new MoveSetting(20, 90, box2,2,3)));
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
        for(Bouncer sprite:movingSprites ){
            sprite.draw(surface);
        }
        for(StraightMover stright:movingStraights){
            stright.draw(surface);
        }
        //movingSprite.draw(surface);
    }
}
