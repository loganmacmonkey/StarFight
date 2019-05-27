package topGame;

import java.util.ArrayList;

import main.Main;
import types.Laser;
import types.Ship;

//This controls where all the Lasers & Ships are at every point in time.
public class MoveShip {

	//Allows to convert raw X & Y values to usable game coordinates.
	SpaceCoordinates SC = new SpaceCoordinates();
	
	//Stores all the Lasers in a list.
	ArrayList<Laser> Lasers = new ArrayList<Laser>();
	
	//Returns a Ship (S) at the point in time specified (time) from the actions given (A).
	public Ship Move(Ship S, String[] A, int time)
	{
		//Stores the number of Actions which are already completed (1 action = 1000 units of time).
		int T = time/1000;
		
		//Runs the Ship through each completed Action one by one.
		for(int i = 0;i < T;i++)
		{
			S = Action(S,A[i],1000);
		}
		
		//Draws the action that the Ship is currently part way through
		//Corresponding to the specified time
		//(if time = 3750, time%3750 = 750 = three quarters of an action)
		int t = time%1000;
		if (t != 0 && A[T] != null) {
			S = Action(S, A[T], t);
		} 
		else if (T < A.length)
		{
			if (A[T] == "BRN") {
				S = Action(S, A[T], 10);
			}
		}
		
		//return the now moved Ship.
		return S;
	}
	
	//Returns a list of Lasers (Lasers) at the point in time specified (time) from any past lasers
	//on the screen needed to be moved (L) and any newly shot lasers from Ships and their actions (P1,P2,A1,A2).
	public ArrayList<Laser> Move(Ship P1, Ship P2, String[] A1, String[] A2, ArrayList<Laser> L, int time)
	{
		//Get all the past lasers in the list of lasers to begin with.
		Lasers.clear();
		for (Laser l : L)
		{
			Lasers.add(l);
		}
		
		//Stores the number of Actions which are already completed (1 action = 1000 units of time).
		int T = time/1000;
		
		//Runs the Ships and Lasers through each completed Action one by one.
		for(int i = 0;i < T;i++)
		{
			//Runs through each Laser individually and
			//moves them each forward one space.
			for(Laser l : Lasers)
			{
				if (l.getRotationInt()==90) {
					l.setX(l.getX() + SC.getSpaceX());
				} else {
					l.setX(l.getX() - SC.getSpaceX());
				}
				//Set any Lasers off the Screen to Black & White.
				if (l.getXInt() < SC.getSpaceX()*-1 || l.getXInt() > Main.getJPanel().getWidth()+SC.getSpaceX())
				{
					l.setColor("B&W");
				}
			}
			try {
				//Runs through each Action of each ship to add the Lasers necessary.
				P1 = Action(P1, A1[i], 1000);
				P2 = Action(P2, A2[i], 1000);
			} catch (Exception e) {}
		}
		
		//Draws the Laser part ways to the next space.
		int t = time%1000;
		for(Laser l : Lasers)
		{
			if (l.getRotationInt()==90) {
				l.setX(l.getX()+((SC.getSpaceX())*t/1000));
			} else {
				l.setX(l.getX()-((SC.getSpaceX())*t/1000));
			}
		}
		//Removes all Black & White Lasers.
		for(int i = 0;i<Lasers.size();i++)
		{
			if (Lasers.get(i).getColor() == "B&W")
			{
				Lasers.remove(i);
				i--;
			}
		}
		//Returns the now moved list of Lasers.
		return Lasers; 
	}
	//Takes in a ship(S) and runs it through a the specified action(a).
	//If time is less than 1000, it will only complete a portion of the action.
	private Ship Action(Ship S, String a, int time)
	{
		switch (a)
		{
			//Rotates the Ship right.
			case "RR":
			{
				S.setRotation(S.getRotation()+(time*90/1000));break;
			}
			//Rotates the Ship right & switches direction.
			case "RRS":
			{
				S.setRotation(S.getRotation()+(time*90/1000));
				S.setMovingRight(!S.getMovingRight()); break;
			}
			//Rotates the Ship left.
			case "RL":
			{
				S.setRotation(S.getRotation()-(time*90/1000));break;
			}
			//Rotates the Ship left & switches direction.
			case "RLS":
			{
				S.setRotation(S.getRotation()-(time*90/1000));
				S.setMovingRight(!S.getMovingRight()); break;
			}
			//Whatever direction the Ship is facing, move it forward one space.
			case "F":
			{
				if(S.getRotationInt() == 90)
				{
					S.setX(S.getX()+(SC.getSpaceX()*time/1000));
				}
				else if (S.getRotationInt() == 270)
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
			//Whatever direction the Ship is facing,
			//Back up the Ship 1/7 of the way from one lane to the other.
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
			//Whatever direction the Ship is facing, 
			//Back up the Ship the 6/7 of the way left from one lane to the other.
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
			//Whatever direction the Ship is facing, Roll the Ship back a 1/4 space.
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
					S.setY(SC.getY(1)+(SC.getSpaceY()*time/4000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(SC.getY(2)-(SC.getSpaceY()*time/4000));
				}break;
			}
			//Whatever direction the Ship is facing, move it forward 5/4 of a space.
			case "FR":
			{
				if(S.getRotationInt() == 90)
				{
					S.setX(S.getX()+(SC.getSpaceX()*5*time/4000));
				}
				else if (S.getRotationInt() == 270)
				{
					S.setX(S.getX()-(SC.getSpaceX()*5*time/4000));
				}
				else if (S.getRotationInt() == 0)
				{
					S.setY(S.getY()-(SC.getSpaceY()*5*time/4000));
				}
				else if (S.getRotationInt() == 180)
				{
					S.setY(S.getY()+(SC.getSpaceY()*5*time/4000));
				}
				break;
			}
			//Wait for the action to be completed sitting still and shoot at the end of the action.
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
				break;
			}
			//Whatever direction the Ship is facing, Roll the Ship forward a 1/4 space
			//& shoot at the end of the action.
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
						Lasers.add(new Laser(S.getColor(), S.getScale(), S.getXInt() + SC.getSpaceX(), S.getYInt(), 90));
					}
					else
					{
						Lasers.add(new Laser(S.getColor(), S.getScale(), S.getXInt() - SC.getSpaceX(), S.getYInt(), 270));
					}
				}break;
			}
			case "BRN":
			{
				S.setBurnedAmount(S.getBurnedAmount() + time);
			} break;
			case "D":
			{
				S.setX(Main.getJPanel().getWidth()+SC.getSpaceX()*2);
				S.setBurnedAmount(S.getBurnedAmount() + time);
			} break;
		}
		
		//return the ship after being moved one action or partial action.
		return S;
		
	}
	
}
