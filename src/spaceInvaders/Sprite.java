package spaceInvaders;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Sprite {
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private String name;
	private String filePath;
	
	public Sprite()
	{
		super();
		xPos = 0;
		yPos = 0;
	}
	public Sprite(int xPos, int yPos, String name)
	{
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.name = name;
	}
	public Sprite(int xPos, int yPos, int width, int height, String name, String filePath)
	{
		this.setxPos(xPos);
		this.setyPos(yPos);
		this.name = name;
		this.filePath = filePath;
		this.width = width;
		this.height = height;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public String getName()
	{
		return this.name;
	}
	public String toString()
	{
		return "Object - " + name + " is at x : " + xPos + ", y : " + yPos;
	}
	public int getWidth()
	{
		return width;
	}
	public int getHeigth()
	{
		return height;
	}
	public void drawSprite(Graphics g)
	{
		g.drawImage(new ImageIcon(filePath).getImage(), xPos, yPos, width, height, null);
	}
}
