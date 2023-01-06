package spaceInvaders;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class BaddieTricky extends Sprite implements Runnable{
	
	public Laser lasers[];
	private Rectangle[] laserRect;
	private Rectangle baddieRect;
	private int hp = 4;
	private JFrame window;
	
	private boolean isAlive = true;
	
	public BaddieTricky(int xPos, int yPos, int width, int height, String name, String filePath, Laser[] lasers, JFrame window)
	{
		super(xPos, yPos, width, height, name, filePath);
		this.lasers = lasers;
		laserRect = new Rectangle[lasers.length];
		this.window = window;
	}

	@Override
	public void run() {
		if(isAlive)
		{
			while(super.getyPos() >= 0)
			{
				baddieRect = new Rectangle(super.getxPos(), super.getyPos(), super.getWidth() - 10, super.getHeigth()-10);
				for(int i= 0; i < lasers.length &&  isAlive; i++)
				{
					laserRect[i] = new Rectangle(lasers[i].getxPos(), 
							lasers[i].getyPos(),
							lasers[i].getWidth(),
							lasers[i].getHeigth());
					
					if(baddieRect.intersects(laserRect[i]))
					{
						hp--;
						lasers[i].setxPos(-15000);

						if(hp <= 0)
						{
							super.setyPos(-5000000);
							super.setxPos(500000);
							GameManager.baddieCount--;
							GameManager.Win(window);
							isAlive = false;
							System.out.println("Collision!" + GameManager.baddieCount);
							
						}
					}
				}
				
				
				try {
					Thread.sleep(100);
					if(super.getyPos() >= GamePlay.INIT_PLAYER_Y)
					{
						System.exit(0);
					}else
					{
						super.setyPos(super.getyPos() + 1);
					}
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		
	}
}
