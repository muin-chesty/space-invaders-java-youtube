package spaceInvaders;
import javax.sound.sampled.AudioSystem;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Intro extends JPanel implements Runnable{

	JFrame window = new JFrame();

	
	public Intro()
	{
		playAudio();
		this.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT));
		
		window.add(this);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.pack();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.setVisible(true);
	}

	private void playAudio()
	{
		try {
			File audioPath = new File("bg-music.wav");
			GameManager.stream = AudioSystem.getAudioInputStream(audioPath);
			GameManager.clip = AudioSystem.getClip();
			GameManager.clip.open(GameManager.stream);
			GameManager.clip.start();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void paint(Graphics g)
	{
		g.drawImage(new ImageIcon("intro.jpg").getImage(), -200, 0, null);
		
	}
	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			window.dispose();
			Menu menu = new Menu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
