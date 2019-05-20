package game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class GraphicsAid{

	public void drawBackground(Graphics g,JComponent J)
	{
		
		//uses a dark blue (space) color...
		g.setColor(new Color(0,0,30));
		
		//& fills the entire background with it.
		g.fillRect(0, 0, J.getWidth(), J.getHeight());
	}
}