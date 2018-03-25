package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Vector2;
import java.util.Random;

public class GameField {

  private static final int REMOVE_PB = 3;
  private static final int ADD_PB = 9;
  private static final int FULL_RESET_PB = 0;

  private static final int FIRST_SPAWN = 20;

  private GameFieldTypes[][] map;
  private int width;
  private int height;
  private int tileSize;

  private float cooldown;
  private float timer = 0;
  private float boxSize = 0;

  public GameField(int tileSize, int gameWidth, int gameHeight, float cooldown) {
    this.tileSize = tileSize;
    this.width = (int) Math.floor(gameWidth / tileSize);
    this.height = (int) Math.floor(gameHeight / tileSize);
    this.map = new GameFieldTypes[width][height];
    this.cooldown = cooldown;

    clearField();
    randomFill();
  }

  private void randomFill() {
    int random;

    for (int h = 0; h < height; h++) {
      for (int w = width / 4; w < (3 * width / 4); w++) {
        random = new Random().nextInt(100);
        if (random <= FIRST_SPAWN) {
          map[w][h] = GameFieldTypes.BOX;
        }
      }
    }
  }


  public void clearField() {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        map[w][h] = GameFieldTypes.AIR;
      }
    }
  }

  public void spawnBox(float delta) {
    timer += delta;

    if (timer >= cooldown) {
      timer -= cooldown;
      Random random = new Random();
      int randomInt = random.nextInt(10);

      if (randomInt <= REMOVE_PB) {
        removeBox();
      }

      randomInt = random.nextInt(10);
      if (randomInt <= ADD_PB) {
        int randomHeight = new Random().nextInt(height);
        int randomWidth = new Random().nextInt(width);

        if (map[randomWidth][randomHeight] == GameFieldTypes.AIR) {
          map[randomWidth][randomHeight] = GameFieldTypes.BOX;
        }
      }
    }


  }

  private void removeBox() {
    int randomHeight = new Random().nextInt(height);
    int randomWidth = new Random().nextInt(width);

    if (map[randomWidth][randomHeight] == GameFieldTypes.BOX) {
      map[randomWidth][randomHeight] = GameFieldTypes.AIR;
    }
  }

  /**
   * @param xPos player x-Coordinate
   * @param yPos player y-Coordinate
   */
  public Vector2 getPlayerPositionInArray(float xPos, float yPos) {
    //System.out.println("POS: " + (Math.floor(xPos / tileSize)-1) + ", " + (Math.floor((Gdx.graphics.getHeight() - yPos)-1) / tileSize));
    int convertedX = (int) xPos;
    int convertedY = (int) yPos;
    return new Vector2(convertedX / tileSize, convertedY / tileSize);
    //  return new Vector2((float)Math.floor(xPos / tileSize) - 1, (float)(Math.floor((Gdx.graphics.getHeight() - yPos) / tileSize) - 1));
  }

  /*
  public void debugField() {
	  
	  for(int i = 0; i < width; i++) {
		  for(int j = 0; j < height; j++) {
			  switch(map[i][j]) {
			  
			  	case BOX:
			  		System.out.print("[XXX]");
			  		break;
			  	case AIR:
			  		System.out.print("[   ]");
			  		break;
			  	case PLAYER:
			  		System.out.print("[ P ]");
			  		break;
			  	default:
			  		System.out.println("ERRROR");
			  }
		  }
		  System.out.println();
	  }
	  System.out.println();
  }
  */

  public GameFieldTypes[][] getMap() {
    return map;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getTileSize() {
    return tileSize;
  }

  public float getBoxSize() {
    return boxSize;
  }

  public void setBoxSize(float boxSize) {
    this.boxSize = boxSize;
  }
}
