package de.opencodes.boxhunter;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BoxhunterMain extends Game {
	
	GameWorld world;
	GameRenderer renderer;
	
	@Override
    public void create() {
        Gdx.app.log("Game", "created");
        setScreen(new GameScreen());
    }
}
