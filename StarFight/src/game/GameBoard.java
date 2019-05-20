package game;

import java.awt.Graphics;
import java.awt.GridBagConstraints;

import javax.swing.JComponent;

public class GameBoard {

	GraphicsAid GA = new GraphicsAid();
	
	public GameBoard()
	{
		paintGameBoard PGB  = new paintGameBoard();
		Game.getGamePane().add(PGB);
		//Game.addComp(PGB,0,0,GridBagConstraints.REMAINDER,2,0,0,GridBagConstraints.NORTH,1,0,0,0,0);
	}
	
	private class paintGameBoard extends JComponent
	{
		public void paint(Graphics g)
		{
			GA.drawBackground(g, this);
		}
	}
	
}
