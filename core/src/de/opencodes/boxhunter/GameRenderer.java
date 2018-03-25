package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

/**
 * While GameWorld changes/modifies/saves entities the GameRenderer draws the
 * entities to the screen.
 * 
 */
public class GameRenderer {

	// To access each entity via getters
	private GameWorld myWorld;

	// Main Camera
	private OrthographicCamera cam;

	// shapeRenderer can draw Circles/Rectangles/etc.
	private ShapeRenderer shapeRenderer;

	public GameRenderer(GameWorld world) {
		myWorld = world;
		cam = new OrthographicCamera();
		cam.setToOrtho(true, 136, 204);
		shapeRenderer = new ShapeRenderer();
	}

	public void render() {

		// TODO: Remove (Debugging purposes)
		//myWorld.getGameField().debugField();
		
		// Schwarzer Hintergrund
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Draw background
		shapeRenderer.begin(ShapeType.Filled);
		shapeRenderer.setColor(Color.GREEN);

		GameFieldTypes[][] gameField = myWorld.getGameField().getMap();
		int tileSize = myWorld.getGameField().getTileSize();

		for (int h = 0; h < myWorld.getGameField().getHeight(); h++) {
			for (int w = 0; w < myWorld.getGameField().getWidth(); w++) {
				if (gameField[w][h] == GameFieldTypes.BOX) {
					shapeRenderer.rect(w * tileSize, ((myWorld.getGameField().getHeight() - h) - 1) * tileSize, tileSize, tileSize);
				}
			}
		}
		shapeRenderer.end();

		// Fange an zu malen
		shapeRenderer.begin(ShapeType.Filled);

		// Male in rot
		shapeRenderer.setColor(Color.RED);

		// Zeichne den Spieler
		shapeRenderer.rect(myWorld.getPlayer1().getPosition().x, myWorld.getPlayer1().getPosition().y,
				myWorld.getPlayer1().getWidth(), myWorld.getPlayer1().getHeigth());

		// Höre auf mit malen
		shapeRenderer.end();

	}
}
