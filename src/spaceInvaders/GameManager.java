package spaceInvaders;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

public class GameManager {
	
	public final static int SCREEN_WIDTH = 1000;
	public final static int SCREEN_HEIGHT = 700;
	public static Clip clip;
	public static AudioInputStream stream;
	public static int baddieCount = 0;
	public static boolean isGameOver = false;
	
	public static void Win(JFrame frame)
	{
		if(baddieCount <= 0)
		{
			frame.dispose();
			Thread gameThread = new Thread(new Intro());
			gameThread.run();
			try {
				stream.close();
				clip.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
