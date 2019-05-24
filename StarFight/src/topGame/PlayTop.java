package topGame;

import java.util.ArrayList;

import game.Game;
import types.Laser;
import types.Ship;

public class PlayTop {
	
	MoveShip MA = new MoveShip();
	
	public Ship getP1(Ship P1, String[] P1A)
	{
		int Time = Game.getTime();
		return MA.Move(P1, P1A, Time);
	}
	
	public Ship getP2(Ship P2, String[] P2A)
	{
		int Time = Game.getTime();
		return MA.Move(P2, P2A, Time);
	}
	
	public ArrayList<Laser> getLasers(Ship P1, Ship P2,String[] P1A,String[] P2A,ArrayList<Laser> Lasers)
	{
		int Time = Game.getTime();
		return MA.Move(P1, P2, P1A, P2A, Lasers, Time);
	}
	
}
