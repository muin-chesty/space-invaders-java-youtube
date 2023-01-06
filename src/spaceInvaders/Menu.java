package spaceInvaders;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu{

	private static JFrame frame;
	
private static void setupStartButton(Container pane)
{
	JButton button = new JButton();
	button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT/5));
	button.setIcon(new ImageIcon("start.png"));
	
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			GamePlay gp = new GamePlay();
			
		}
	});
	
	pane.add(button, BorderLayout.PAGE_START);
}

private static void setupCenterImage(Container pane)
{
	JLabel label = new JLabel();
	label.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/2, GameManager.SCREEN_HEIGHT/3));
	label.setIcon(new ImageIcon("menu_1.png"));
	pane.add(label, BorderLayout.CENTER);
}

// EXIT BUTTON
private static void setupLeftButton(Container pane)
{
	JButton button = new JButton();
	button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/5, GameManager.SCREEN_HEIGHT/3));
	button.setIcon(new ImageIcon("exit.png"));
	
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Exit Button is pressed!");
			GameManager.clip.close();
			frame.dispose();
			try {
				GameManager.stream.close();
			}catch (Exception ex)
			{
				ex.printStackTrace();
			}
			
			
		}
		
	});
	pane.add(button, BorderLayout.LINE_START);
}


// CREDITS BUTTON
private static void setupRightButton(Container pane)
{
	JButton button = new JButton();
	button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH/5, GameManager.SCREEN_HEIGHT/3));
	button.setIcon(new ImageIcon("q.png"));
	
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Q BUTTON IS PRESSED");
			
		}
		
	});
	pane.add(button, BorderLayout.LINE_END);
}


// ABOUT BUTTON
private static void setupBottomButton(Container pane)
{
	JButton button = new JButton();
	button.setPreferredSize(new Dimension(GameManager.SCREEN_WIDTH, GameManager.SCREEN_HEIGHT/5));
	button.setIcon(new ImageIcon("about.png"));
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("About button is pressed!");
			
		}
		
	});
	pane.add(button, BorderLayout.PAGE_END);
}
public static void addComponents(Container pane)
{
//	if (!(pane.getLayout() instanceof BorderLayout)) {
//		pane.add(new JLabel("Container doesn't use BorderLayout!"));
//		return;
//	}

	
	// SET ORIENTATION
	pane.setComponentOrientation(java.awt.ComponentOrientation.LEFT_TO_RIGHT);
	
	// CALL TO SETUP_START_BUTTON
	setupStartButton(pane);
	// CALL TO SETUP_CENTER_IMAGE
	setupCenterImage(pane);
	// CALL TO SETUP_LEFT_BUTTON
	setupLeftButton(pane);
	// CALL TO SETUP_RIGHT_BUTTON
	setupRightButton(pane);
	// CALL TO SETUP_BOTTOM_BUTTON
	setupBottomButton(pane);
	
}

private static void createFrame()
{
	frame = new JFrame("MENU");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	addComponents(frame.getContentPane());
	
	frame.pack();
	
	frame.setVisible(true);
}

public Menu()
{
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
		public void run()
		{
			createFrame();
		}
	});
}



}
