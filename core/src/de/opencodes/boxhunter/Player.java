package de.opencodes.boxhunter;

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
        position = new Vector2(xPos, yPos);
    	this.width = width;
    	this.height = height;
        velocity = new Vector2(0, 0);
    }


    //------------------------------methods----------------------------------

    public void update() {
    	
    	// rectangle.x and rectangle.y denote the position of the player
    	Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.position.x, this.position.y);
    	
    	GameFieldTypes[][] map = world.getGameField().getMap(); 
    	
    	int xPos = (int)mapPosition.x;
    	int yPos = (int)mapPosition.y;
    	
  //  	System.out.println(xPos + ", " + yPos);
    	
    	float xPosInsideTile = (this.position.x + this.width) % 64;
		float yPosInsideTile = (this.position.y + this.height) % 64;
		
//		System.out.println("Inside Tile: " + (xPosInsideTile-20) + ", " + yPosInsideTile); // 64 = tileSize
    
		System.out.println(xPosInsideTile);
    	if(isWallRightSide(map, xPos, yPos)) {
    	
    		
    		if(xPosInsideTile == 60) {
    			if(velocity.x > 0) {
        			velocity.x = 0;
    			}
    		}
    	}else if(isWallLeftSide(map, xPos, yPos)) {
    		if(xPosInsideTile == 5) {
    			if(velocity.x < 0) {
        			velocity.x = 0;
    			}
    		}
    	}
    	
    	this.position.add(velocity);
  
    }
    
    public void moveLeft() {
        velocity.x = -5;
    }
    
    public void stopMoveLeft() {
    	velocity.x = 0;
    }

    public boolean isWallRightSide(GameFieldTypes[][] map, int xPos, int yPos) {
    	System.out.println(map[xPos +1][yPos]);
    	return map[xPos + 1][yPos] == GameFieldTypes.BOX;
    }
    
    public boolean isWallLeftSide(GameFieldTypes[][] map, int xPos, int yPos) {
    	System.out.println(map[xPos - 1][yPos]);
    	return map[xPos - 1][yPos] == GameFieldTypes.BOX;
    }
    
    public void moveRight() {
        velocity.x = 5;
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
        return new Vector2(this.position.x, this.position.y);
    }
}
