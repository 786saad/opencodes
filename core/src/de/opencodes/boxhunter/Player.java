package de.opencodes.boxhunter;

import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Vector2 position;
    private Vector2 velocity;
    private GameWorld world;
    private int width;
    private int height;
    
    // ------------------------constructor---------------------

    public Player(GameWorld world, int xPos, int yPos, int width, int height) {
        this.world = world;
    	this.position = new Vector2(xPos, yPos);
        this.velocity = new Vector2(0, 0);
        this.width = width;
        this.height = height;
    }


    //------------------------------methods----------------------------------

    public void update() {
    	System.out.println(velocity.x + ", " + velocity.y);
    	Vector2 temp = new Vector2(position);
    	temp.add(velocity);
    	
    	boolean collision = false;
	  	  for (RectangleMapObject rectangleObject : world.getMapObjects().getByType(RectangleMapObject.class)) {
	
		      Rectangle rectangle = rectangleObject.getRectangle();
		      if (Intersector.overlaps(rectangle, getRectangle())) {
		    	  position.sub(velocity);
		    	  velocity = new Vector2(0, 0);
		    	  collision = true;
		    	  break;
		      }
		  }
	  	  
	  	  if(!collision)
	  		  position.add(velocity);
    	
    }
    
    public void moveLeft() {
        velocity.x = -5;
    }
    
    public void stopMoveLeft() {
    	velocity.x = 0;
    }

    
    public void moveRight() {
        velocity.x = 5;
    }

    public void stopMoveRight() {
    	velocity.x = 0;
    }
    
    public void moveUp() {
        velocity.y = -5;
    }
    
    public void stopMoveUp() {
    	velocity.y = 0;
    }

    public void moveDown() {
        velocity.y = 5;
    }
    public void stopMoveDown() {
    	velocity.y = 0;    	
    }
    
 
    //------------------------getter and setter-----------------------------
    public Rectangle getRectangle() {
        return new Rectangle(position.x, position.y, this.width, this.height);
    }

    public void setX(int pos) {
    	position.x = pos;
    }
    
    public void setY(int pos) {
    	position.y = pos;
    }
    
    public int getHeigth() {
        return this.height;
    }


    public Vector2 getVelocity() {
        return velocity;
    }

    public int getWidth() {
        return this.width;
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 getPosition() {
        return position;
    }
}
