package de.opencodes.boxhunter;

public abstract class Item {

  private int xPos;
  private int yPos;
  private Player player;
  private int countdown;
  private int radius;

  public Item(int xPos, int yPos, int countdown, int radius) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.countdown = countdown;
    this.radius = radius;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    this.radius = radius;
  }

  public abstract void activate();

  public int getxPos() {
    return xPos;
  }

  public void setxPos(int xPos) {
    this.xPos = xPos;
  }

  public int getyPos() {
    return yPos;
  }

  public void setyPos(int yPos) {
    this.yPos = yPos;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public int getCountdown() {
    return countdown;
  }

  public void setCountdown(int countdown) {
    this.countdown = countdown;
  }

  public void decrementCountdown() {
    this.countdown--;
  }
}
