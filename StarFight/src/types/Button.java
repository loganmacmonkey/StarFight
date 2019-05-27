package types;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

//holds everything about a Button's functionality
//& the ability to create them.
public class Button{
	
	private int x;	
	private int y;
	private int scale;
	private String display;
	
	//creates button
	public Button(int x, int y,int scale, String display)
	{
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.display = display;
	}
	//creates button
	public Button(int x, int y,int scale)
	{
		this.x = x;
		this.y = y;
		this.scale = scale;
		this.display = " ";
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getScale() {
		return scale;
	}
	public void setScale(int scale) {
		this.scale = scale;
	}
	public String getDisplay() {
		return display;
	}
	//sets the texts which to be displayed to the button (only works for single characters).
	public void setDisplay(String display) {
		this.display = display;
	}
	//Draws the Button to the JComponent of your choosing.
	public void drawButton(Graphics g, JComponent F)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
		g2d.setColor(new Color(255, 255, 255));
		g2d.setStroke(new BasicStroke(5));
		g2d.drawRect(getX() - scale, getY() + scale, 2 * scale, 2 * scale);
		g2d.setFont(new Font("courier", 1, scale * 2));
		g2d.drawString(display, (int) (getX() - (scale * 0.5)), (int) (getY() + (scale * 2.625)));
	}
	
	public void drawButton(Graphics g, JComponent F, Color C)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
		g2d.setColor(new Color(255, 255, 255));
		g2d.setStroke(new BasicStroke(5));
		g2d.setColor(C);
		g2d.drawRect(getX() - scale, getY() + scale, 2 * scale, 2 * scale);
		g2d.setFont(new Font("courier", 1, scale * 2));
		g2d.setColor(Color.WHITE);
		g2d.drawString(display, (int) (getX() - (scale * 0.5)), (int) (getY() + (scale * 2.625)));
	}
	
	//Checks if a set of coordinates are contained
	//within your button.
	public boolean collisionCheck(int x,int y)
	{
		return ((getX()-scale) <= x & x <= (getX()+scale) & (getY()+scale) <= y & y <= (getY()+(scale*3)));
	}
	
}
