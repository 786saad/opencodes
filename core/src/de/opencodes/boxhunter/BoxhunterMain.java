package de.opencodes.boxhunter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

/**
 * This is the initial entry point. The DesktopLauncher launches this class and
 * the screen is immediately set to the main game
 *
 */
public class BoxhunterMain extends Game {

	@Override
	public void create() {
		Gdx.app.log("Game", "created");
		setScreen(new GameScreen());
	}
}
