package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

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
