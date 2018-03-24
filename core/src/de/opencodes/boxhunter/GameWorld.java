package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each
 * entity
 */
public class GameWorld {

  private Player player1 = new Player(30, 30, 40, 40);
  private GameField gameField = new GameField(32, Gdx.graphics.getWidth(),
      Gdx.graphics.getHeight());


  public void update(float delta) {
    Gdx.app.log("GameWorld", "update");

    gameField.spawnBox();
    player1.update();

    System.out.println("SpielerposX = " + player1.getPosition().x);
    System.out.println("SpielerposY = " + player1.getPosition().y);
    // teest

    System.out.println("SpielerposX = " + player1.getPosition().x);
    System.out.println("SpielerposY = " + player1.getPosition().y);
  }

  // --------------getter and setter-------------

  public Player getPlayer1() {
    return player1;
  }

  public void setPlayer1(Player player1) {
    this.player1 = player1;
  }

  public GameField getGameField() {
    return gameField;
  }

}
