package spaceInvaders;

public class Player extends Sprite{
	
	private boolean isAlive;
	private int lives;
	public Player()
	{
		super();
		isAlive = true;
		lives = 1;
	}
	public Player(int xPos, int yPos, int width, int height, String name, String filePath, int lives)
	{
		super(xPos, yPos, width, height, name, filePath);
		isAlive = true;
		this.lives = lives;
	}
	public void takeDamage(int amount)
	{
		lives -= amount;
		if(lives <= 0)
		{
			isAlive = false;
			lives = 0;
		}
	}
	public void moveRight(int pos)
	{
		if(super.getxPos() <= GameManager.SCREEN_WIDTH - 100)
		{
			super.setxPos(super.getxPos() + pos);
		}
		else
		{
			System.out.println("MAX RIGHT REACHED! PRINTED FROM PLAYER moveRight Function");
		}
	}
	public void moveLeft(int pos)
	{
		if(super.getxPos() >= 0)
		{
			super.setxPos(super.getxPos() - pos);
		}
		else
		{
			System.out.println("MAX LEFT REACHED! PRINTED FROM PLAYER moveRight Function");
		}
	}

}
