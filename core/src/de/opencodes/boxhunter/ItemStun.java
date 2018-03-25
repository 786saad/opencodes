package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Vector2;

public class ItemStun extends Item {

  private Vector2 velocity = null;

  public ItemStun(int xPos, int yPos, int countdown, int radius) {
    super(xPos, yPos, countdown, radius);
  }

  @Override
  public void activate() {
    if (getCountdown() > 0){
      if (velocity == null){
        velocity = getPlayer().getVelocity();
        getPlayer().setVelocity(new Vector2(0,0));
      }
    } else {
      getPlayer().setVelocity(velocity);
    }
  }

}
