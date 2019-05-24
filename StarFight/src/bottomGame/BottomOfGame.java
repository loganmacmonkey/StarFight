package bottomGame;

import java.awt.Graphics;

import javax.swing.JComponent;

public class BottomOfGame {
	
	String mode = "Selecting";
	SelectingBottom SB = new SelectingBottom();
	PlayBottom PB = new PlayBottom();
	int Turns;
	
	public int getTime()
	{
		return PB.getTime();
	}
	
	public SelectingBottom getSelectingBottom()
	{
		return SB;
	}
	
	public void setup(int Turns)
	{
		this.Turns = Turns;
	}
	
	public void setMode(String Mode)
	{
		mode = Mode;
	}
	
	public void paintBottomOfScreen(Graphics g, JComponent J)
	{
		if(mode == "Selecting") {
			SB.setup(Turns);
			mode = "S";
		} else if (mode == "S") {
			SB.paintSelectingBottom(g, J);
		} else if (mode == "Play") {
			PB.setup(Turns);
			mode = "P";
		} else if (mode == "P")
		{
			PB.paintPlayBottom(g, J);
		}
	}

}
