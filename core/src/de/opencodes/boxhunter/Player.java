package de.opencodes.boxhunter;

import com.badlogic.gdx.math.Vector2;

public class Player {
	private Vector2 position;
	private Vector2 velocity;
	private GameWorld world;
	private int width;
	private int height;
	private float delta = 0;

	// ------------------------constructor---------------------

	public Player(GameWorld world, int xPos, int yPos, int width, int height) {
		this.world = world;
		position = new Vector2(xPos, yPos);
		this.width = width;
		this.height = height;
		velocity = new Vector2(0, 0);
	}

	// ------------------------------methods----------------------------------

	public void update(float delta) {

		this.delta += delta;

		if (this.delta > 0.1) {
			this.delta = 0;

			// rectangle.x and rectangle.y denote the position of the player
			Vector2 mapPosition = world.getGameField().getPlayerPositionInArray(this.position.x, this.position.y);

			GameFieldTypes[][] map = world.getGameField().getMap();

			int xPos = (int) mapPosition.x;
			int yPos = (int) mapPosition.y;

			// System.out.println(xPosInsideTile);
			if (isWallRightSide(map, xPos, yPos)) {

				if (velocity.x > 0)
					velocity.x = 0;
				

			} else if (isWallLeftSide(map, xPos, yPos)) {

				if (velocity.x < 0)
					velocity.x = 0;
				
			} else if (isWallUpSide(map, xPos, yPos)) {
				
				if(velocity.y < 0)
					velocity.y = 0;
				
			} else if (isWallDownSide(map, xPos, yPos)) {
				
				if (velocity.y > 0)
					velocity.y = 0;
				
			}

			this.position.add(velocity);

		}

	}

	public void moveLeft() {
		velocity.x = -64;
	}

	public void stopMoveLeft() {
		velocity.x = 0;
	}

	public boolean isWallRightSide(GameFieldTypes[][] map, int xPos, int yPos) {
		return map[xPos + 1][yPos] == GameFieldTypes.BOX;
	}

	public boolean isWallLeftSide(GameFieldTypes[][] map, int xPos, int yPos) {
		if (xPos - 1 < 0)
		return false;
		return map[xPos - 1][yPos] == GameFieldTypes.BOX;
	}

	public boolean isWallUpSide(GameFieldTypes[][] map, int xPos, int yPos) {
		if (yPos - 1 < 0)
			return false;
		
		return map[xPos][yPos - 1] == GameFieldTypes.BOX;
	}

	public boolean isWallDownSide(GameFieldTypes[][] map, int xPos, int yPos) {

		return map[xPos][yPos + 1] == GameFieldTypes.BOX;
	}

	public void moveRight() {
		velocity.x = 64;
	}

	public void stopMoveRight() {
		velocity.x = 0;
	}

	public void moveUp() {
		velocity.y = 64;
	}

	public void stopMoveUp() {
		velocity.y = 0;
	}

	public void moveDown() {
		velocity.y = -64;
	}

	public void stopMoveDown() {
		velocity.y = 0;
	}

	// ------------------------getter and setter-----------------------------

	public int getHeigth() {
		return this.height;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public int getWidth() {
		return this.width;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public Vector2 getPosition() {
		return new Vector2(this.position.x, this.position.y);
	}
}
