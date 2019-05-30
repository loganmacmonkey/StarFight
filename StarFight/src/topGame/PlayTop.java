package topGame;

import java.util.ArrayList;

import game.Game;
import types.Laser;
import types.Ship;

//gets all the information on time, Ships, Lasers & actions & returns
//the Ships and Lasers at any specified point in time from the actions given.
public class PlayTop {
	
	//Create the class which moves the ships for us.
	MoveShip MA = new MoveShip();
	
	SpaceCoordinates SC = new SpaceCoordinates();
	
	//Creates a moved Ship for a point in time specified from the actions given.
	public Ship getMovedShip(Ship S, String[] A)
	{
		//gets the moment of time to display from the Game class.
		int Time = Game.getTime();		
		
		return MA.Move(S, A, Time);
	}
	//Creates a moved Ship for a point in time directly specified from the actions given.
		public Ship getMovedShip(Ship S, String[] A, int Time)
		{	
			return MA.Move(S, A, Time);
		}
	//Draws the Lasers at the point in time specified from the actions given.
	public ArrayList<Laser> getLasers(Ship P1, Ship P2,String[] P1A,String[] P2A,ArrayList<Laser> Lasers)
	{
		//gets the moment of time to display from the Game class.
		int Time = Game.getTime();
		
		return MA.Move(P1, P2, P1A, P2A, Lasers, Time);
	}
	//Draws the Lasers at the point in time specified from the actions given.
	public ArrayList<Laser> getLasers(Ship P1, Ship P2,String[] P1A,String[] P2A,ArrayList<Laser> Lasers,int Time)
	{
		return MA.Move(P1, P2, P1A, P2A, Lasers, Time);
	}
	
}
