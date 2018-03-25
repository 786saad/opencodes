package de.opencodes.boxhunter;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * A scene is for example a menu, a game screen, the game over screen, option
 * screen, pause screen, etc.
 */
public class MenuScreen implements Screen {

	SpriteBatch batch;
	BitmapFont font;
	OrthographicCamera camera;
	Game game;
	
	public MenuScreen(Game game) {
		batch = new SpriteBatch();
		font = new BitmapFont();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 1280, 736);
		
		this.game = game;
	}

	@Override
	public void show() {
		Gdx.app.log("GameScreen", "show called");
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();
		font.draw(batch, "Welcome to Boxhunter ", 100, 150);
		font.draw(batch, "Tap anywhere to begin.", 100, 100);
		batch.end();

		if (Gdx.input.isTouched()) {
			game.setScreen(new GameScreen());
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {
		//Gdx.app.log("GameScreen", "resize called");
	}

	@Override
	public void hide() {
		//Gdx.app.log("GameScreen", "hide called");
	}

	@Override
	public void pause() {
		//Gdx.app.log("GameScreen", "pause called");
	}

	@Override
	public void resume() {
		//Gdx.app.log("GameScreen", "resume called");
	}

	@Override
	public void dispose() {
		// Leave blank
	}
}
