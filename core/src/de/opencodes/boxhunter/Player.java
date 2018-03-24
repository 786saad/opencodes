package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Rectangle rectangle;
    private Vector2 velocity;

    // ------------------------constructor---------------------

    public Player(int xPos, int yPos, int width, int height) {
        rectangle = new Rectangle(xPos, yPos, width, height);
        velocity = new Vector2(0, 0);
    }


    //------------------------------methods----------------------------------

    public void update() {
    	movePosition();
    }
    
    public void moveLeft() {
        //todo change dummy speed
        velocity.x = -5;
        //todo check if there is obstacle on left side?

        //check if there is the map wall on left side??
    }
    
    public void stopMoveLeft() {
    	velocity.x = 0;
    	
    }

    public void moveRight() {
        //todo chaneg dummy speed
        velocity.x = 5;
        //todo check if there is obstacle on right side?
        //check if there is map wall right on side`???

    }

    public void stopMoveRight() {
    	velocity.x = 0;
    }
    
    public void moveUp() {
        velocity.y = 5;
    }
    
    public void stopMoveUp() {
    	velocity.y = 0;
    }

    public void moveDown() {
        velocity.y = -5;
    }
    public void stopMoveDown() {
    	velocity.y = 0;    	
    }
    
    public void movePosition() {
        this.rectangle.x += this.velocity.x;
        this.rectangle.y += this.velocity.y;
    }


    //------------------------getter and setter-----------------------------
    public Rectangle getRectangle() {
        return rectangle;
    }


    public int getHeigth() {
        return (int) rectangle.getHeight();
    }


    public Vector2 getVelocity() {
        return velocity;
    }

    public int getWidth() {
        return (int) rectangle.getWidth();
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return new Vector2(this.rectangle.x, this.rectangle.y);
    }
}
