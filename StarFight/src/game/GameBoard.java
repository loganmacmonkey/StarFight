package game;

import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JComponent;

public class GameBoard {

	GraphicsAid GA = new GraphicsAid();
	
	public GameBoard()
	{
		paintGameBoard PGB  = new paintGameBoard();
		Game.addComp(PGB,2,1,1,1,10,2,GridBagConstraints.CENTER, GridBagConstraints.NONE,5,2,5,2);
	}
	
	private class paintGameBoard extends JComponent
	{
		public void paint(Graphics g)
		{
			GA.drawBackground(g, this);
		}
	}
	
}
