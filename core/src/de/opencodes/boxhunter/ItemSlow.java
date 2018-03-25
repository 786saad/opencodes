package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Vector2;

public class ItemSlow extends Item {

  private Vector2 velocity = null;

  public ItemSlow(int xPos, int yPos, int countdown, int radius) {
    super(xPos, yPos, countdown, radius);
  }

  @Override
  public void activate() {
    if (getCountdown() > 0) {
      if (velocity == null) {
        velocity = getPlayer().getVelocity();
        getPlayer().setVelocity(velocity.scl(0.75f));
      }
    } else {
      getPlayer().setVelocity(velocity);
    }
  }
}
