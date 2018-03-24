package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each entity
 */
public class GameWorld {

    private Player player1 = new Player(0,0,12,18);

	
	public void update(float delta) {
        Gdx.app.log("GameWorld", "update");


        //teest

       int x = 0;
        player1.setxPos(x++);

        if (player1.getxPos() > 137) {
        	player1.setxPos(0);
        }
    }



    //--------------getter and setter-------------

    public Player getPlayer1() {
        return player1;
    }
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

	
}
