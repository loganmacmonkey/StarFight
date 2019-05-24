package topGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import game.Game;
import types.*;

public class TopOfGame {
	
	String mode = "Selecting";
	
	static CreateActions CA = new CreateActions();
	static PlayTop PT = new PlayTop();
	
	String[] P1Actions, P2Actions;
	
	Ship P1,P2;
	ArrayList<Laser> Lasers = new ArrayList<Laser>();

	public PlayTop getPlayTop()
	{
		return PT;
	}
	
	private Ship getP1()
	{
		Ship a = new Ship(P1.getColorNum(), P1.getScale(), P1.getXInt(), P1.getYInt(), P1.getRotationInt());
		a.setMovingRight(P1.getMovingRight());
		return a;
	}
	
	private Ship getP2()
	{
		Ship a = new Ship(P2.getColorNum(), P2.getScale(), P2.getXInt(), P2.getYInt(), P2.getRotationInt());
		a.setMovingRight(P2.getMovingRight());
		return a;
	}
	
	private ArrayList<Laser> getLasers()
	{
		ArrayList<Laser> a = new ArrayList<Laser>();
		for(Laser l : Lasers)
		{
			a.add(l);
		}
		return a;
	}
	
	public void setup(Ship P1, Ship P2)
	{
		this.P1 = P1;
		this.P2 = P2;
	}
	
	public void setMode(String Mode)
	{
		mode = Mode;
	}

	public void process(String[]P1Moves, String[]P2Moves) {
		P1Actions = CA.CA(getP1(),P1Moves);
		P2Actions = CA.CA(getP2(),P2Moves);
		Game.setMode("Play");
	}
	
	public void paintTopOfScreen(Graphics g, JComponent J)
	{
		if(mode == "Play")
		{
			PT.getP1(getP1(),P1Actions).drawShip(g,J);
			PT.getP2(getP2(),P2Actions).drawShip(g,J);
			for(Laser l : PT.getLasers(getP1(),getP2(),P1Actions,P2Actions,getLasers()))
			{
				l.drawLaser(g, J);
			}
		}
		else if (mode == "Selecting")
		{
			P1.drawShip(g, J);
			P2.drawShip(g, J);
			for (Laser L : Lasers) {
				L.drawLaser(g, J);
			}
		}
	}
	
}
