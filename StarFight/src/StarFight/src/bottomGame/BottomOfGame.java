package bottomGame;

import java.awt.Graphics;

import javax.swing.JComponent;

public class BottomOfGame {
	
	String mode = "Selecting";
	SelectingBottom SB = new SelectingBottom();
	
	public void setup(int Turns)
	{
		SB.setup(Turns);
	}
	
	public void paintBottomOfScreen(Graphics g, JComponent J)
	{
		if(mode == "Selecting")
		{
			SB.paintSelectingBottom(g, J);
		}
	}

}
