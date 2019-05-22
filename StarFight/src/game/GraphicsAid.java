package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

public class GraphicsAid{

	//Draws the dark Blue Background.
	public void drawBackground(Graphics g,JComponent J)
	{
		//uses a dark blue (space) color...
		g.setColor(new Color(0,0,30));
		
		//& fills the entire background with it.
		g.fillRect(0, 0, J.getWidth(), J.getHeight());
	}
	
	public void DrawGameGrid(Graphics g,JComponent J)
	{
		//Gives me a few more drawing functions.
		Graphics2D g2d = (Graphics2D)g;
		
		//Makes the graphics look pretty.
		g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
		
		//Makes the lines thick when I draw them.
		g2d.setStroke(new BasicStroke(4));
		
		//Sets the color to Dark Grey.
		g2d.setColor(new Color(30,30,90));
		
		//Draws all of the vertical Lines.
		for(int i=0;i<15;i++)
		{
			g2d.drawLine(J.getWidth()*(i+1)/16, 0, J.getWidth()*(i+1)/16, J.getHeight()/2);
		}
		
		//Draws the Horizontal Line.
		g2d.drawLine(0, J.getHeight()/4, J.getWidth(), J.getHeight()/4);
	}
}