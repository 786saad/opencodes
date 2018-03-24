package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each entity
 */
public class GameWorld {

	private Rectangle player = new Rectangle(0, 0, 17, 12);
	
	public void update(float delta) {
        Gdx.app.log("GameWorld", "update");
        player.x++;
        if (player.x > 137) {
        	player.x = 0;
        }
    }
	
	public Rectangle getPlayer() {
        return player;
    }
	
}
