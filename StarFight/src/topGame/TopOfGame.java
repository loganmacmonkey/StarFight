package topGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import types.*;

public class TopOfGame {
	
	String mode = "Selecting";
	
	static CreateActions CA = new CreateActions();
	
	static Ship P1,P2;
	ArrayList<Laser> Lasers = new ArrayList<Laser>();

	public void setup(Ship P1, Ship P2)
	{
		TopOfGame.P1 = P1;
		TopOfGame.P2 = P2;
	}
	
	public static void process(String[] P1Moves, String[] P2Moves) {
		String[] P1Actions = CA.CA(P1,P1Moves);
		String[] P2Actions = CA.CA(P2,P2Moves);
	}
	
	public void paintTopOfScreen(Graphics g, JComponent J)
	{
		P1.drawShip(g, J);
		P2.drawShip(g, J);
		if (!Lasers.isEmpty()) {
			for (Laser L : Lasers) {
				L.drawLaser(g, J);
			} 
		}
	}
	
}
