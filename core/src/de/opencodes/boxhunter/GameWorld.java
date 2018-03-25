package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each
 * entity
 */
public class GameWorld {

	private TiledMap tiledMap = new TmxMapLoader().load("map.tmx");;
    
  private Player player1 = new Player(this, 32, 32, 16, 16);
  private Player player2 = new Player(this, 90, 90, 16, 16);
  private GameField gameField = new GameField(64, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

  //TiledMapTileLayer collisionObjectLayer = tiledMap.getLayers().get("collision").getObjects();
  MapObjects collisionObjects = tiledMap.getLayers().get("collision").getObjects();
  
  int tileWidth = 32;
  int tileHeight = 32;

  
  // STOP WITH ZE CHANGING OF THE MAP I NEED TO DEBUG THIS IN PEACE PLS
  GameWorld() {
	  gameField.spawnBox();

  }

  public void update(float delta) {
    
    player1.update();

    //gameField.getPlayerPositionInArray(player2.getPosition().x, player2.getPosition().y);
    player2.update();

   
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
  
  public TiledMap getTileMap() {
	  return tiledMap;
  }
  
  public MapObjects getMapObjects() {
	  return collisionObjects;
  }



}
