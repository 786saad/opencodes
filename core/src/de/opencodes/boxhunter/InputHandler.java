package de.opencodes.boxhunter;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

/**
 * Handling of user inputs is done here.
 * The getter/setter of Player class expose the moveset
 * that is used here.
 */
// TODO: Unfinished http://www.kilobolt.com/day-10-gamestates-and-high-score.html
public class InputHandler implements InputProcessor {

  private Player player1, player2;

  InputHandler(Player player1, Player player2) {
    this.player1 = player1;
    this.player2 = player2;
  }

  @Override
  public boolean keyDown(int keycode) {
    switch (keycode) {
      //------player 1 movements----
      case Keys.LEFT:
        player1.moveLeft();
        break;
      case Keys.RIGHT:
        player1.moveRight();
        break;
      case Keys.DOWN:
        player1.moveDown();
        break;
      case Keys.UP:
        player1.moveUp();
        break;
      //----------player 2 movements------
      case Keys.W:
        player2.moveUp();
        break;
      case Keys.A:
        player2.moveLeft();
        break;
      case Keys.D:
        player2.moveRight();
        break;
      case Keys.S:
        player2.moveDown();
        break;
      case Keys.R:
        player1.restartGame();
        break;
      default:
        break;
    }

    return true;
  }

  @Override
  public boolean keyUp(int keycode) {

    switch (keycode) {
      //------player 1 movements----
      case Keys.LEFT:
        player1.stopMoveLeft();
        break;
      case Keys.RIGHT:
        player1.stopMoveRight();
        break;
      case Keys.DOWN:
        player1.stopMoveDown();
        break;
      case Keys.UP:
        player1.stopMoveUp();
        break;
      //-----player 2 movements
      case Keys.W:
        player2.stopMoveUp();
        break;
      case Keys.A:
        player2.stopMoveLeft();
        break;
      case Keys.D:
        player2.stopMoveRight();
        break;
      case Keys.S:
        player2.stopMoveDown();
        break;
      default:
        break;
    }

    return true;

  }

  @Override
  public boolean keyTyped(char character) {
    return false;
  }

  @Override
  public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    return false;
  }

  @Override
  public boolean touchDragged(int screenX, int screenY, int pointer) {
    return false;
  }

  @Override
  public boolean mouseMoved(int screenX, int screenY) {
    return false;
  }

  @Override
  public boolean scrolled(int amount) {
    return false;
  }

}
