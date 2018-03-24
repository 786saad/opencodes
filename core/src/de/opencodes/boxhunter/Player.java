package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player {

	private Rectangle myRectangle;

	private int width, heigth;

	private Vector2 velocity;
	private Vector2 position;

	// ------------------------constructor---------------------

	public Player(int xPos, int yPos, int width, int height) {
		myRectangle = new Rectangle(xPos, yPos, width, height);
		velocity = new Vector2(0, 0);
		position = new Vector2(xPos, yPos);
	}

	// ------------------------getter and setter-----------------------------
	public Rectangle getRectangle() {
		return myRectangle;
	}

	public void setRectangle(Vector2 position, int width, int height) {
		this.position = position;
		this.width = width;
		this.heigth = height;
	}

	public Vector2 getPosition() {
		return position;
	}

	public void setPosition(Vector2 position) {
		this.position = position;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

}
