package de.opencodes.boxhunter;

import java.util.Random;

public class GameField {

  private static final int REMOVE_PB = 3;
  private static final int ADD_PB  = 9;
  private static final int FULL_RESET_PB  = 0;

  private int[][] gameField;
  private int width;
  private int height;
  private int tileSize;

  public GameField(int tileSize, int gameWidth, int gameHeight) {
    this.tileSize = tileSize;
    this.width = (int) Math.floor(gameWidth / tileSize);
    this.height = (int) Math.floor(gameHeight  / tileSize);
    this.gameField = new int[width][height];

    clearField();
  }

  private void clearField() {
    for (int h = 0; h < height; h++) {
      for (int w = 0; w < width; w++) {
        gameField[w][h] = GameFieldTypes.AIR.ordinal();
      }
    }
  }

  public void spawnBox() {
    Random random  = new Random();
    int randomInt = random.nextInt(1000);

    if (randomInt <= FULL_RESET_PB){
      clearField();
    }


    randomInt = random.nextInt(10);
    if (randomInt <= REMOVE_PB){
      removeBox();
    }


    randomInt = random.nextInt(10);
    if (randomInt <= ADD_PB){
      int randomHeight = new Random().nextInt(height);
      int randomWidth = new Random().nextInt(width);

      if (gameField[randomWidth][randomHeight] == GameFieldTypes.AIR.ordinal()) {
        gameField[randomWidth][randomHeight] = GameFieldTypes.BOX.ordinal();
      }
    }

  }

  private void removeBox() {
      int randomHeight = new Random().nextInt(height);
      int randomWidth = new Random().nextInt(width);

      if (gameField[randomWidth][randomHeight] == GameFieldTypes.BOX.ordinal()) {
        gameField[randomWidth][randomHeight] = GameFieldTypes.AIR.ordinal();
      }
  }

  public int[][] getGameField() {
    return gameField;
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
}
