package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Rectangle;

public class Player {


    private Rectangle myRectangle;
    private int xPos, yPos, width, heigth;


    //------------------------constructor---------------------

    public Player(int xPos, int yPos, int width, int height) {
        myRectangle = new Rectangle(xPos,yPos,width,height);
    }

    //------------------------getter and setter-----------------------------
    public Rectangle getRectangle() {
        return myRectangle;
    }

    public void setRectangle(int xPos, int yPos, int width, int height) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.heigth = height;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
}
