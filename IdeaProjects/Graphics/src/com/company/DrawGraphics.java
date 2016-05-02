package com.company;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class DrawGraphics {
    //BouncingBox box;
    List<BouncingBox> boxs;


    /** Initializes this class for drawing. */
    public DrawGraphics() {
        boxs = new ArrayList<BouncingBox>();
        boxs.add(new BouncingBox(100, 50, Color.RED,9,3));
        boxs.add(new BouncingBox(30, 60, Color.GREEN,4,8));
        boxs.add(new BouncingBox(50, 80, Color.BLUE,6,4));
        //box = new BouncingBox(100, 50, Color.RED);
    }

    /** Draw the contents of the window on surface. Called 20 times per second. */
    public void draw(Graphics surface) {
        surface.drawLine(20, 50, 250, 250);
        surface.setColor(Color.CYAN);
        surface.fillArc(10, 20, 145, 60, 30, 150);
        surface.setColor(Color.MAGENTA);
        surface.fillRoundRect(60,80,70,60,150,30);
        surface.setColor(Color.GREEN);
        surface.draw3DRect(90,50, 50, 45, true);
        surface.setColor(Color.BLUE);
        surface.drawOval(150, 150, 30, 40);
        surface.setColor(Color.YELLOW);
        surface.fillOval(180, 180, 40, 50);
        surface.setColor(Color.ORANGE);
        surface.drawOval(180, 180, 40, 50);
        for(BouncingBox box:boxs){
            box.draw(surface);
        }
    }
}
