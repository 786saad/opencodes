package de.opencodes.boxhunter;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;

/**
 * Handling of user inputs is done here.
 * The getter/setter of Player class expose the moveset
 * that is used here.
 */
// TODO: Unfinished http://www.kilobolt.com/day-10-gamestates-and-high-score.html
public class InputHandler implements InputProcessor {

	private Player player;

	InputHandler(Player player) {
		this.player = player;	
	}
	
	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case Keys.LEFT:
				player.moveLeft();
				break;
			case Keys.RIGHT:
				player.moveRight();
				break;
			case Keys.DOWN:
				player.moveDown();
				break;
			case Keys.UP:
				player.moveUp();
				break;
			default:
				break;
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		
		switch(keycode) {
		case Keys.LEFT:
			player.stopMoveLeft();
			break;
		case Keys.RIGHT:
			player.stopMoveRight();
			break;
		case Keys.DOWN:
			player.stopMoveDown();
			break;
		case Keys.UP:
			player.stopMoveUp();
			break;
		default:
			break;
	}
	
	return true;
		
	}

	@Override
	public boolean keyTyped(char character) { return false; }

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) { return false; }

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) { return false; }

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) { return false; }

	@Override
	public boolean mouseMoved(int screenX, int screenY) { return false; }

	@Override
	public boolean scrolled(int amount) { return false; }
	
}
