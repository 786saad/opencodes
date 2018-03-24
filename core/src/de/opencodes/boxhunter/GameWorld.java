package de.opencodes.boxhunter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class GameWorld {

    private Player player1 = new Player(0,0,12,18);

	
	public void update(float delta) {
        Gdx.app.log("GameWorld", "update");


        //teest
        int x = 0;
        player1.setxPos(x++);

        if (player1.getxPos() > 137) {
        	player1.setxPos(0);
        }
    }
	

	
}
