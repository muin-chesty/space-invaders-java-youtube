package spaceInvaders;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class GamePlay extends JPanel implements KeyListener{

	private static final int INIT_PLAYER_X = (int) ((int) GameManager.SCREEN_WIDTH/2.9);
	public static final int INIT_PLAYER_Y = GameManager.SCREEN_HEIGHT - 100;
	private final String PLAYER_SPRITE_PATH = "mod.png";
	private final int PLAYER_WIDTH = 50;
	private final int PLAYER_HEIGHT = 80;
	
	
	private JFrame window;
	private Player player;
	private int moveSpeed = 20;
	
	private Laser lasers[]; 
	private int amoIndex = 0;
	private final int AMO_SIZE = 5;
	private final int LASER_WIDTH = 50;
	private final int LASER_HEIGHT = 50;
	
	BaddieEasy[] baddieEasyLeft = new BaddieEasy[6];
	
	BaddieTricky[] baddieTricky = new BaddieTricky[7];
	
	
	private void initBaddieTricky()
	{
		int xPos = 10;
		int yPos = 10;
		
		int width = 60;
		int height = 70;
		for(int i = 0; i < baddieTricky.length; i++)
		{
			baddieTricky[i] = new BaddieTricky(xPos,yPos,width,height,"baddie hard", "baddie-2.png", this.lasers, window);
			Thread baddieThread = new Thread(baddieTricky[i]);
			baddieThread.start();
			xPos += 150;
		}
	}
	
	private void drawBaddieTricky(Graphics g)
	{
		for(int i = 0; i < baddieTricky.length; i++)
		{
			baddieTricky[i].drawSprite(g);
		}
	}
	

	
	private void initBaddieEasyLeft()
	{
		int xPos = 50;
		int yPos = GameManager.SCREEN_HEIGHT/2 - 200;
		
		int width = 65;
		int height = 75;
		for(int i = 0; i < baddieEasyLeft.length; i++)
		{
			baddieEasyLeft[i] = new BaddieEasy(xPos,yPos,width,height,"baddie easy", "baddie-1.png", this.lasers, window);
			Thread baddieThread = new Thread(baddieEasyLeft[i]);
			baddieThread.start();
			xPos += 150;
		}
	}
	private void drawBaddieEasyLeft(Graphics g)
	{
		for(int i = 0; i < baddieEasyLeft.length; i++)
		{
			baddieEasyLeft[i].drawSprite(g);
		}
	}
	
	private void initAmo()
	{
		for(int i = 0; i < AMO_SIZE; i++)
		{
			lasers[i] = new Laser(-250, -100, this.LASER_WIDTH, this.LASER_HEIGHT, "laser","laser.png", this);
		}
	}
	
	private void drawAmo(Graphics g)
	{
		for(int i = 0; i < AMO_SIZE; i++)
		{
			lasers[i].drawSprite(g);
		}
	}
	public GamePlay()
	{
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		this.addKeyListener(this);
		GameManager.baddieCount = (baddieEasyLeft.length + baddieTricky.length);
									 		
		
		window = new JFrame();
		lasers = new Laser[AMO_SIZE];
		player = new Player(this.INIT_PLAYER_X, this.INIT_PLAYER_Y, this.PLAYER_WIDTH, this.PLAYER_HEIGHT, "Player", this.PLAYER_SPRITE_PATH, 10);
		initAmo();
		initBaddieEasyLeft();
		initBaddieTricky();
		
		
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT));
		window.add(this);
		
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);

	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.moveRight(moveSpeed);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.moveLeft(moveSpeed);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(amoIndex <= (AMO_SIZE - 1))
			{
				lasers[amoIndex].setxPos(player.getxPos() + 25);
				lasers[amoIndex].setyPos(player.getyPos() - 10);
				Thread laserThread = new Thread(lasers[amoIndex]);
				laserThread.start();
				amoIndex++;
				if(amoIndex >= AMO_SIZE)
				{
					amoIndex = 0;
				}
			}

			
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			player.moveRight(moveSpeed);
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			player.moveLeft(moveSpeed);
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			if(amoIndex <= (AMO_SIZE - 1))
			{
				lasers[amoIndex].setxPos(player.getxPos() + 25);
				lasers[amoIndex].setyPos(player.getyPos() - 10);
				Thread laserThread = new Thread(lasers[amoIndex]);
				laserThread.start();
				amoIndex++;
				if(amoIndex >= AMO_SIZE)
				{
					amoIndex = 0;
				}
			}

			
		} 
	}
	
	public void paint(Graphics g)
	{
		g.drawImage(new ImageIcon("bg_red.jpg").getImage(), 0, 0, GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT, null);
		player.drawSprite(g);
		drawAmo(g);
		drawBaddieEasyLeft(g);
		 
		drawBaddieTricky(g);
		super.repaint();
		
	}

}
