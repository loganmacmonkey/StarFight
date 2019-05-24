package topGame;

import java.util.ArrayList;

import types.Laser;
import types.Ship;

public class MoveShip {

	SpaceCoordinates SC = new SpaceCoordinates();
	
	ArrayList<Laser> Lasers = new ArrayList<Laser>();
	
	public Ship Move(Ship S, String[] A, int time)
	{
		int T = time/1000;
		for(int i = 0;i < T;i++)
		{
			S = Action(S,A[i],1000);
		}
		
		int t = time%1000;
		if (t != 0) {
			S = Action(S, A[T], t);
		}
		
		return S;
	}
	
	public ArrayList<Laser> Move(Ship P1, Ship P2, String[] A1, String[] A2, ArrayList<Laser> L, int time)
	{
		Lasers = L;
		
		int T = time/1000;
		for(int i = 0;i < T;i++)
		{
			for(Laser l : L)
			{
				if (l.getRotationInt()==90) {
					l.setX(SC.getX(SC.getXSpace(l) + 2));
				} else {
					l.setX(SC.getX(SC.getXSpace(l) - 2));
				}
				if (SC.getXSpace(l) < 0 || SC.getXSpace(l) > 17)
				{
					Lasers.remove(l);
				}
			}
			P1 = Action(P1,A1[i],1000);
			P2 = Action(P1,A2[i],1000);
		}
		
		int t = time%1000;
		for(Laser l : L)
		{
			if (l.getRotationInt()==90) {
				l.setX(l.getX()+((SC.getX(SC.getXSpace(l)+1)-(l.getX()))*t/500));
			} else {
				l.setX(l.getX()-(((l.getX())-SC.getX(SC.getXSpace(l)-1))*t/500));
			}
			if (SC.getXSpace(l) < 0 || SC.getXSpace(l) > 17)
			{
				Lasers.remove(l);
			}
		}
		
		return Lasers; 
	}
	
	private Ship Action(Ship S, String a, int time)
	{
		switch (a)
		{
			case "RR":
			{
				S.setRotation(S.getRotation()+(time*90/1000));break;
			}
			case "RRS":
			{
				S.setRotation(S.getRotation()+(time*90/1000));
				S.setMovingRight(!S.getMovingRight()); break;
			}
			case "RL":
			{
				S.setRotation(S.getRotation()-(time*90/1000));break;
			}
			case "RLS":
			{
				S.setRotation(S.getRotation()-(time*90/1000));
				S.setMovingRight(!S.getMovingRight()); break;
			}
			case "F":
			{
				if(S.getMovingRight() && S.getRotationInt() == 90)
				{
					S.setX(S.getX()+(SC.getSpaceX()*time/1000));
				}
				else if (!S.getMovingRight() && S.getRotationInt() == 270)
				{
					S.setX(S.getX()-(SC.getSpaceX()*time/1000));
				}
				else if (S.getRotationInt() == 0)
				{
					S.setY(SC.getY(1)-(SC.getSpaceY()*time/1000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(SC.getY(2)+(SC.getSpaceY()*time/1000));
				}break;
			}
			case "B1":
			{
				if (S.getRotationInt() == 0)
				{
					S.setY(SC.getY(2)+(SC.getSpaceY()*time/7000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(SC.getY(1)-(SC.getSpaceY()*time/7000));
				}break;
			}
			case "B2":
			{
				if (S.getRotationInt() == 0)
				{
					S.setY((SC.getY(2)+(SC.getSpaceY()/7))+(SC.getSpaceY()*6*time/7000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY((SC.getY(1)-(SC.getSpaceY()/7))-(SC.getSpaceY()*6*time/7000));
				}break;
			}
			case "RB":
			{
				if(S.getRotationInt() == 90)
				{
					S.setX(S.getX()-(SC.getSpaceX()*time/4000));
				}
				else if (S.getRotationInt() == 270)
				{
					S.setX(S.getX()+(SC.getSpaceX()*time/4000));
				}
				else if (S.getRotationInt() == 0)
				{
					S.setY(SC.getY(1)-(SC.getSpaceY()*time/4000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(SC.getY(2)+(SC.getSpaceY()*time/4000));
				}break;
			}
			case "FR":
			{
				if(S.getRotationInt() == 90)
				{
					S.setX(S.getX()+(SC.getSpaceX()*7*time/4000));
				}
				else if (S.getRotationInt() == 270)
				{
					S.setX(S.getX()-(SC.getSpaceX()*7*time/4000));
				}
				else if (S.getRotationInt() == 0)
				{
					S.setY(SC.getY(2)+(SC.getSpaceY()*7*time/4000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(SC.getY(1)-(SC.getSpaceY()*7*time/4000));
				}
				break;
			}
			case "S":
			{
				if(time == 1000)
				{
					if (S.getRotationInt() == 90) 
					{
						Lasers.add(new Laser(S.getColor(), S.getScale(), SC.getX(SC.getXSpace(S) + 1), S.getYInt(), 90));
					}
					else
					{
						Lasers.add(new Laser(S.getColor(), S.getScale(), SC.getX(SC.getXSpace(S) - 1), S.getYInt(), 270));
					}
				}
			}
			case "RS":
			{
				if(S.getRotationInt() == 90)
				{
					S.setX(S.getX()+((SC.getSpaceX())*time/4000));
				}
				else
				{
					S.setX(S.getX()-((SC.getSpaceX())*time/4000));
				}
				if(time == 1000)
				{
					if (S.getRotationInt() == 90) 
					{
						Lasers.add(new Laser(S.getColor(), S.getScale(), SC.getX(SC.getXSpace(S) + 1), S.getYInt(), 90));
					}
					else
					{
						Lasers.add(new Laser(S.getColor(), S.getScale(), SC.getX(SC.getXSpace(S) - 1), S.getYInt(), 270));
					}
				}break;
			}
		}
		
		return S;
		
	}
	
}
