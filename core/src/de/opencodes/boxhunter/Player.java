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
        //float xPosInsideTile = (this.rectangle.x + this.rectangle.width) % 64;
        //float yPosInsideTile = (this.rectangle.y + this.rectangle.height) % 64;

        Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.rectangle.x, this.rectangle.y);
        GameFieldTypes[][] map = world.getGameField().getMap();
        int mapPosX = (int)mapPosition.x;
        int mapPosY = (int)mapPosition.y;

        if (isWallRightSide()) {
            System.out.println("collission right side");
        } else if (isWallUpSide()) {
            System.out.println("collission up side");
        }else if (isWallLeftSide()) {
            System.out.println("collission left side");
        } else if(isWallDownSide()) {
            System.out.println("collission down side");
        } else {

            this.rectangle.x += this.velocity.x;
            this.rectangle.y += this.velocity.y;
        }
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

    public boolean isWallLeftSide() {
        return false;
    }
    public boolean isWallDownSide() {
        boolean coolide = false;
        boolean grobCollide = false;
        boolean fineCollide = false;

        Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.rectangle.x, this.rectangle.y);
        GameFieldTypes[][] map = world.getGameField().getMap();
        int mapPosX = (int)mapPosition.x;
        int mapPosY = (int)mapPosition.y;

        grobCollide = (map[(mapPosX )][mapPosY + 1] == GameFieldTypes.BOX);
        fineCollide = (((mapPosY +1) * 64) - ( rectangle.y + velocity.y)   <= 9);

        coolide = grobCollide && fineCollide;

        return coolide;
    }
    public boolean isWallRightSide() {
        boolean coolide = false;
        boolean grobCollide = false;
        boolean fineCollide = false;

        Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.rectangle.x, this.rectangle.y);
        GameFieldTypes[][] map = world.getGameField().getMap();
        int mapPosX = (int)mapPosition.x;
        int mapPosY = (int)mapPosition.y;

        grobCollide = (map[(mapPosX + 1)][mapPosY] == GameFieldTypes.BOX);
        fineCollide = (((mapPosX +1) * 64) - ( rectangle.x + velocity.x)   <= 13);

        coolide = grobCollide && fineCollide;

        return coolide;
    }
    public boolean isWallUpSide() {
        boolean coolide = false;
        boolean grobCollide = false;
        boolean fineCollide = false;

        Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.rectangle.x, this.rectangle.y);
        GameFieldTypes[][] map = world.getGameField().getMap();
        int mapPosX = (int)mapPosition.x;
        int mapPosY = (int)mapPosition.y;

        grobCollide = (map[(mapPosX )][mapPosY + 1] == GameFieldTypes.BOX);
        fineCollide = (((mapPosY +1) * 64) - ( rectangle.y + velocity.y)   <= 13);

        coolide = grobCollide && fineCollide;

        return coolide;
    }
    public void moveRight() {
        if (!isWallRightSide()) {
            velocity.x = 5;
        }
    }
    public void moveUp() {
        if (!isWallUpSide()) {
            velocity.y = 5;
        }
    }

    public void stopMoveRight() {
    	velocity.x = 0;
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
