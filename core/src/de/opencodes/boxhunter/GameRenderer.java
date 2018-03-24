package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class GameRenderer {

	private GameWorld myWorld;
	private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
	
	public GameRenderer(GameWorld world) {
        myWorld = world;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);
        shapeRenderer = new ShapeRenderer();
    }
	
	public void render() {
        Gdx.app.log("GameRenderer", "render");
        
        // Schwarzer Hintergrund
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
        // Fange an zu malen
        shapeRenderer.begin(ShapeType.Filled);
        
        // Male in rot
        shapeRenderer.setColor(Color.RED);
        
        // Zeichne den Spieler
        shapeRenderer.rect(myWorld.getPlayer().x, myWorld.getPlayer().y,
                myWorld.getPlayer().width, myWorld.getPlayer().height);
        
        // Höre auf mit malen
        shapeRenderer.end();
        
        
    }
}
