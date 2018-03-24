package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

public class GameScreen implements Screen {

	private GameWorld world;
    private GameRenderer renderer;
	
    public GameScreen() {
    	Gdx.app.log("GameScreen", "Attached");
        
    	// GameWorld behält Infos zu Positionen der Sprites
    	world = new GameWorld();
        
        // GameRenderer muss wissen WO was hingemalt werden soll
        renderer = new GameRenderer(world);
    }
    
	@Override
	public void show() { }

	@Override
	public void render(float delta) {
		world.update(delta);
        renderer.render();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void hide() { }

	@Override
	public void dispose() { }

}
