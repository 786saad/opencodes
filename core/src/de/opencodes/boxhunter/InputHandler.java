package de.opencodes.boxhunter;

import com.badlogic.gdx.InputProcessor;

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
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
