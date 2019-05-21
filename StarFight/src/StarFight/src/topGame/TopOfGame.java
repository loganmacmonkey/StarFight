package topGame;

import java.awt.Graphics;

import javax.swing.JComponent;

import types.Ship;

public class TopOfGame {
	
	String mode = "Selecting";
	
	Ship P1,P2;

	public void setup(Ship P1, Ship P2)
	{
		this.P1 = P1;
		this.P2 = P2;
	}
	
	public void paintTopOfScreen(Graphics g, JComponent J)
	{
		P1.drawShip(g, J);
		P2.drawShip(g, J);
	}
	
}
