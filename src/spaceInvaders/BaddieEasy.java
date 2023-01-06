package spaceInvaders;

import java.awt.Rectangle;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaddieEasy extends Sprite implements Runnable{
	
	public Laser lasers[];
	private Rectangle[] laserRect;
	private Rectangle baddieRect;
	private JFrame window;
	private boolean isAlive = true;
	public BaddieEasy(int xPos, int yPos, int width, int height, String name, String filePath, Laser[] lasers, JFrame window)
	{
		super(xPos, yPos, width, height, name, filePath);
		this.lasers = lasers;
		laserRect = new Rectangle[lasers.length];
		this.window = window;
	
	}

	@Override
	public void run() {
		if(!GameManager.isGameOver)
		{
			while(super.getyPos() >= 20 && isAlive)
			{
				baddieRect = new Rectangle(super.getxPos(), super.getyPos(), super.getWidth(), super.getHeigth());
				for(int i= 0; i < lasers.length && isAlive; i++)
				{
					laserRect[i] = new Rectangle(lasers[i].getxPos(), 
							lasers[i].getyPos(),
							lasers[i].getWidth(),
							lasers[i].getHeigth());
					
					if(baddieRect.intersects(laserRect[i]))
					{
						lasers[i].setxPos(-1500);
						super.setyPos(-5000000);
						super.setxPos(500000);
						isAlive = false;
						GameManager.baddieCount--;
						GameManager.Win(window);
					}
				}
				
				
				try {
					Thread.sleep(100);
					movement();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}

		
	}
	
	private void movement()
	{
		if(super.getyPos() >= GamePlay.INIT_PLAYER_Y)
		{
			window.dispose();
			super.setyPos(0);
			JOptionPane.showMessageDialog(null, "YOU LOSE!");
			GameManager.isGameOver = true;
			System.exit(0);
		}
		else
		{
			super.setyPos(super.getyPos() + (int)(5 * Math.random()));
		}
		
	}

}
