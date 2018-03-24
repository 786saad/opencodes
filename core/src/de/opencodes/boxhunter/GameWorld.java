package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * Any new entity (Player, Enemy, Map, Items...) is initialized in GameWorld.
 * Getters are required for GameRenderer to access the positional data of each
 * entity
 */
public class GameWorld {

	private Player player1 = new Player(0, 0, 12, 18);

	// testvariable
	int x = 0;

	public void update(float delta) {
		Gdx.app.log("GameWorld", "update");

		// teest

		int y = (int) getPlayer1().getPosition().y;

		player1.setPosition(new Vector2(x++, y));

		if (player1.getPosition().x > 137) {
			player1.setPosition(new Vector2(0, y));
		}
	}

	// --------------getter and setter-------------

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

}
