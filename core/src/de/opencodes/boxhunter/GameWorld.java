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

	private Player player1 = new Player(30, 30, 40, 40);




	public void update(float delta) {

		if (player1.getPosition().x < 137) {
			player1.moveRight();
		}
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

}
