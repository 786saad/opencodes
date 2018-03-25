package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each
 * entity
 */
public class GameWorld {

  private Player player1 = new Player(this, 157, 47, 16, 16);
  private Player player2 = new Player(this, 157, 47, 16, 16);


  private GameField gameField = new GameField(64, Gdx.graphics.getWidth(),
      Gdx.graphics.getHeight());

  // STOP WITH ZE CHANGING OF THE MAP I NEED TO DEBUG THIS IN PEACE PLS
  GameWorld() {
	  gameField.spawnBox();


  }

  public void update(float delta) {
    //Gdx.app.log("GameWorld", "update");

    gameField.getPlayerPositionInArray(player1.getPosition().x, player1.getPosition().y);
    if (player1.isWallRightSide()) {
        System.out.println("collission");
    } else {
        player1.update();

    }

    gameField.getPlayerPositionInArray(player2.getPosition().x, player2.getPosition().y);
    player2.update();

    //System.out.println("SpielerposX = " + player1.getPosition().x);
    //System.out.println("SpielerposY = " + player1.getPosition().y);
    // teest

    //System.out.println("SpielerposX = " + player1.getPosition().x);
    //System.out.println("SpielerposY = " + player1.getPosition().y);
  }


  // --------------getter and setter-------------

  public Player getPlayer1() {
    return player1;
  }

  public void setPlayer1(Player player1) {
    this.player1 = player1;
  }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public GameField getGameField() {
    return gameField;
  }



}
