package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Rectangle myRectangle;

    private int width, heigth;
    private Vector2 velocity;
    private Vector2 position;

    // ------------------------constructor---------------------

    public Player(int xPos, int yPos, int width, int height) {
        myRectangle = new Rectangle(xPos, yPos, width, height);
        velocity = new Vector2(0, 0);
        position = new Vector2(xPos, yPos);
    }


    //------------------------------methods----------------------------------


    public void moveLeft() {
        //todo change dummy speed
        velocity.x = -5;
        //todo check if there is obstacle on left side?

        //check if there is the map wall on left side??
        movePosition();
        velocity.x = 0;
    }

    public void moveRight() {
        //todo chaneg dummy speed
        velocity.x = 5;
        //todo check if there is obstacle on right side?
        //check if there is map wall right on side`???
        movePosition();

        velocity.x = 0;
    }

    public void moveUp() {
        velocity.y = 5;
        movePosition();
    }

    public void moveDown() {
        velocity.y = -5;
        movePosition();

    }

    public void movePosition() {
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
    }


    //------------------------getter and setter-----------------------------
    public Rectangle getRectangle() {
        return myRectangle;
    }

    public void setRectangle(Vector2 position, int width, int height) {
        this.position = position;
        this.width = width;
        this.heigth = height;
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

    public Vector2 getVelocity() {
        return velocity;
    }

    public int getWidth() {
        return width;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }
}
