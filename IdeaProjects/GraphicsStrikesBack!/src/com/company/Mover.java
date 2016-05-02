package com.company;

import java.awt.Graphics;

/**
 * Created by miku on 2016/05/02.
 */
public interface Mover {
    void draw(Graphics surface, int leftX, int topY);

    int getWidth();
    int getHeight();
}
