package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * A scene is for example a menu, a game screen, the game over screen, option
 * screen, pause screen, etc.
 */
public class GameScreen implements Screen {

  private GameWorld world;
  private GameRenderer renderer;

  public GameScreen() {
    Gdx.app.log("GameScreen", "Attached");

    // GameWorld behält Infos zu Positionen der Sprites
    world = new GameWorld();

    // GameRenderer muss wissen WO was hingemalt werden soll
    renderer = new GameRenderer(world);

    Gdx.input.setInputProcessor(new InputHandler(world.getPlayer1(), world.getPlayer2()));
  }

  @Override
  public void show() {
    Gdx.app.log("GameScreen", "show called");
  }

  @Override
  public void render(float delta) {
    world.update(delta);
    renderer.render();
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
