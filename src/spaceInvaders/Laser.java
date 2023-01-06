package spaceInvaders;

public class Laser extends Sprite implements Runnable{

	public GamePlay gp;
	public Laser(int xPos, int yPos, int width, int height, String name, String filePath, GamePlay gp)
	{
		super(xPos, yPos, width, height, name, filePath);
		this.gp = gp;

	}
	@Override
	public void run() {
		while(super.getyPos() >= -1000)
		{
			try {
				Thread.sleep(10);
				super.setyPos(super.getyPos() - 10);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			gp.repaint();
			
		}
		
	}

}
