package com.company;

/**
 * Created by miku on 2016/05/02.
 */
import java.awt.Graphics;

public class MoveSetting {
    public int x;
    public int y;
    public int xDirection;
    public int yDirection;
    //private Sprite sprite;
    public Mover mover;

    /** Create a Bouncer that positions sprite at (startX, startY). */
    public MoveSetting(int startX, int startY, Mover mover, int xIncrement, int yIncrement) {
        x = startX;
        y = startY;
        //this.sprite = sprite;
        this.mover = mover;
        setMovementVector(xIncrement, yIncrement);
    }

    /** Starts moving the object in the direction (xIncrement, yIncrement). */
    public void setMovementVector(int xIncrement, int yIncrement) {
        xDirection = xIncrement;
        yDirection = yIncrement;
    }

}


