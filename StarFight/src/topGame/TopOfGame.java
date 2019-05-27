package topGame;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JComponent;

import game.Game;
import main.Main;
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
	
	//Returns a clone of the list of Lasers
	private ArrayList<Laser> getLasers()
	{
		ArrayList<Laser> a = new ArrayList<Laser>();
		for(Laser l : Lasers)
		{
			Laser L = new Laser(l.getColorNum(), l.getScale(), l.getXInt(), l.getYInt(), l.getRotationInt());
			a.add(L);
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
		String[] P1A = CA.CA(P1.clone(),P1Moves);
		String[] P2A = CA.CA(P2.clone(),P2Moves);
		P1Actions = CA.CAwithBurning(P1.clone(), P2.clone(), P1A.clone(), P2A.clone(), getLasers());
		P2Actions = CA.CAwithBurning(P2.clone(), P1.clone(), P2A.clone(), P1A.clone(), getLasers());
		P1Actions = CA.CAwithBurning(P1.clone(), P2.clone(), P1A.clone(), P2Actions.clone(), getLasers());
		P2Actions = CA.CAwithBurning(P2.clone(), P1.clone(), P2A.clone(), P1Actions.clone(), getLasers());
		Game.setMode("Play");
	}
	
	public void paintTopOfScreen(Graphics g, JComponent J)
	{
		//If in play mode...
		if(mode == "Play")
		{
			//Draw the Ships at the point in time specified from the actions given.
			PT.getMovedShip(P1.clone(),P1Actions).drawShip(g,J);
			PT.getMovedShip(P2.clone(),P2Actions).drawShip(g,J);
			
			//Draw all the Lasers from both ships in the point
			//in time specified from the actions given
			for(Laser L : PT.getLasers(P1.clone(),P2.clone(),P1Actions,P2Actions,getLasers()))
			{
				L.drawLaser(g, J);
				//System.out.println(PT.getMovedShip(getP2(),P2Actions).getXInt() - L.getXInt());
				//System.out.println(PT.getMovedShip(getP2(),P2Actions).ContainsPoint(L.getXInt(), L.getYInt()));
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
		else if (mode == "Pre-Selecting")
		{
			ArrayList<Laser> LaserPlaceholder = new ArrayList<Laser>();
			for (Laser L : Lasers)
			{
				LaserPlaceholder.add(L);
			}
			Lasers.clear();
			for (Laser L : PT.getLasers(P1.clone(),P2.clone(),P1Actions,P2Actions,LaserPlaceholder))
			{
				Lasers.add(L);
			}
			P1 = PT.getMovedShip(P1.clone(),P1Actions);
			P2 = PT.getMovedShip(P2.clone(),P2Actions);
			if(P1.getBurnedAmount()>0 ||  P2.getBurnedAmount()>0)
			{
				if (P1.getBurnedAmount()>P2.getBurnedAmount())
				{
					Main.proceed3(P2, P1, "P2");
				} 
				else if (P2.getBurnedAmount()>P1.getBurnedAmount())
				{
					Main.proceed3(P1, P2, "P1");
				}
				else
				{
					Main.proceed3(P1, P2);
				}
				Game.setMode("Finished");
			}
			else
			{
				mode = "Selecting";
			}
		}
	}
	
}
