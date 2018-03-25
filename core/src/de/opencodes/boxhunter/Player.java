package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

    private Rectangle rectangle;
    private Vector2 velocity;
    private GameWorld world;
    
    // ------------------------constructor---------------------

    public Player(GameWorld world, int xPos, int yPos, int width, int height) {
        this.world = world;
    	rectangle = new Rectangle(xPos, yPos, width, height);
        velocity = new Vector2(0, 0);
    }


    //------------------------------methods----------------------------------

    public void update() {
    	
    	// rectangle.x and rectangle.y denote the position of the player
    	Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.rectangle.x, this.rectangle.y);
    	
    	GameFieldTypes[][] map = world.getGameField().getMap(); 
    	
    	int xPos = (int)mapPosition.x;
    	int yPos = (int)mapPosition.y;
    	
    	System.out.println(xPos + ", " + yPos);
    	
    	float xPosInsideTile = (this.rectangle.x + this.rectangle.width) % 64;
		float yPosInsideTile = (this.rectangle.y + this.rectangle.height) % 64;
		
		System.out.println("Inside Tile: " + xPosInsideTile + ", " + yPosInsideTile); // 64 = tileSize
    	
    	if(isWallRightSide(map, xPos, yPos)) {
    		
    		//float xPosInsideTile = (this.rectangle.x + this.rectangle.width) % 64;
    		//float yPosInsideTile = (this.rectangle.y + this.rectangle.height) % 64;
    		
    		if(xPosInsideTile + 30 <= 60) {
    			
    			if(velocity.x > 0) {
        			velocity.x = 0;
    			}
    		}
    	}
    	
    	
    	this.rectangle.x += this.velocity.x;    			
        this.rectangle.y += this.velocity.y;
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

    public boolean isWallRightSide(GameFieldTypes[][] map, int xPos, int yPos) {
    	return map[xPos + 1][yPos] == GameFieldTypes.BOX;
    }
    
    public void moveRight() {
        //todo chaneg dummy speed
        velocity.x = 5;
        //todo check if there is obstacle on right side?
        //check if there is map wall right on side`???
        this.rectangle.x += this.velocity.x;
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
