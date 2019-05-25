package topGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import game.Game;
import types.*;

//Takes in all the input from the BottomOfGame class &
//Draws it to the top of the Screen.
public class TopOfGame {
	
	//Tells the screen what to do and the screen
	//starts of by selecting your moves.
	String mode = "Selecting";
	
	//Creates the class which creates the ships actions.
	static CreateActions CA = new CreateActions();
	
	//Create the class which draws the ships moving.
	static PlayTop PT = new PlayTop();
	
	//stores the actions for P1 and P2,
	String[] P1Actions, P2Actions;
	
	//Stores the Ships of P1 & P2.
	Ship P1,P2;
	
	//Stores all the lasers drawn on the Screen.
	ArrayList<Laser> Lasers = new ArrayList<Laser>();

	//Gets the top of the Screen when in Play mode.
	public PlayTop getPlayTop()
	{return PT;}
	
	//Returns a clone of P1's ship.
	private Ship getP1()
	{
		Ship a = new Ship(P1.getColorNum(), P1.getScale(), P1.getXInt(), P1.getYInt(), P1.getRotationInt());
		a.setMovingRight(P1.getMovingRight());
		return a;
	}
	
	//Returns a clone of P2's ship.
	private Ship getP2()
	{
		Ship a = new Ship(P2.getColorNum(), P2.getScale(), P2.getXInt(), P2.getYInt(), P2.getRotationInt());
		a.setMovingRight(P2.getMovingRight());
		return a;
	}
	
	//Returns a clone of the list of Lasers
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
	
	//Sets the mode controlling the screen for this class.
	public void setMode(String Mode)
	{mode = Mode;}

	//Creates everything to get it ready for Play mode.
	public void process(String[]P1Moves, String[]P2Moves) {
		P1Actions = CA.CA(getP1(),P1Moves);
		P2Actions = CA.CA(getP2(),P2Moves);
		Game.setMode("Play");
	}
	
	public void paintTopOfScreen(Graphics g, JComponent J)
	{
		//If in play mode...
		if(mode == "Play")
		{
			//Draw the Ships at the point in time specified from the actions given.
			PT.getMovedShip(getP1(),P1Actions).drawShip(g,J);
			PT.getMovedShip(getP2(),P2Actions).drawShip(g,J);
			
			//Draw all the Lasers from both ships in the point
			//in time specified from the actions given
			for(Laser l : PT.getLasers(getP1(),getP2(),P1Actions,P2Actions,getLasers()))
			{
				l.drawLaser(g, J);
			}
		}
		//If in selecting mode, draw the ships in the
		//position of where they ended up or started the game.
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
