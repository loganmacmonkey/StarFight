package topGame;

import types.Ship;

/*Takes in a Ship and a move and figures out
what two actions will make that move happen.
Possible actions to be given:
 	F:Forward
 	S:Shoot
 	RR:Rotate Right
 	RL:Rotate Left
 	RRS:Rotate Right and switch directions
 	RLS:Rotate Left and switch directions
 	RB:Roll back
 	FR:Forward after a Roll back
 	SR:Roll forward & shoot
 	B1:First step in backing up
 	B2:Second step in backing up*/
public class MoveToAction {

	//Allows to convert raw X & Y values to usable game coordinates.
	SpaceCoordinates SC = new SpaceCoordinates();
	
	//Returns the actions to move the Ship forward.
	public String[] Forward(Ship S)
	{
		//Gathers all the information on the Ship necessary
		//to determine the actions to move forward.
		int X = SC.getXSpace(S);
		int Y = SC.getYSpace(S);
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
		//If the Ship is at an end facing the wall, turn around & switch directions
		if(X==31&&MR==true&&R==90) {
			if(Y==1) {
				return new String[] {"RR", "RRS"};
			}
			else {
				return new String[] {"RL", "RLS"};
			}
		}
		else if (X==1&&MR==false&&R==270){
			if(Y==2) {
				return new String[] {"RR", "RRS"};
			}
			else {
				return new String[] {"RL", "RLS"};
			}
		}
		
		//Otherwise, correct the rotation of the Ship and move him
		//forward.  If he's already facing the correct direction,
		//roll back and then go forward.
		else if (MR==true)
		{
			if(R==90){
				return new String[] {"RB", "FR"};
			}
			else if (R==0) {
				return new String[] {"RR", "F"};
			}
			else if (R==180) {
				return new String[] {"RL", "F"};
			}
		}
		else {
			if(R==270){
				return new String[] {"RB", "FR"};
			}
			else if (R==0) {
				return new String[] {"RL", "F"};
			}
			else if (R==180) {
				return new String[] {"RR", "F"};
			}
		}
		
		//Just in case of none of these actions apply to 
		//the Ship which would be an error.
		return null;
		
	}
	//Returns the actions to Veer the ship into the other lane.
	public String[] Veer(Ship S)
	{
		//Gathers all the information on the Ship necessary
		//to determine the actions to Veer the ship into the other lane.
		int X = SC.getXSpace(S);
		int Y = SC.getYSpace(S);
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
		//If the Ship is at an end where it must switch directions, veer to
		//the other lane and switch directions.
		if(X==16&&MR)
		{
			if(Y==1)
			{
				return new String[] {"RLS","F"};
			}
			else
			{
				return new String[] {"RRS","F"};
			}
		}
		else if(X==1&&!MR)
		{
			if(Y==1)
			{
				return new String[] {"RRS","F"};
			}
			else
			{
				return new String[] {"RLS","F"};
			}
		}
		//Otherwise, Switch to the other lane by rotating 90 degrees to face the
		//other lane and move forward or backing up for avoiding turning 180 degrees.
		//If already facing the proper direction, roll back and then go forward.
		else if(SC.getYSpace(S)==1)
		{
			if(R==90)
			{
				return new String[] {"RL","F"};
			} 
			else if(R==270)
			{
				return new String[] {"RR","F"};
			}
			else if (R==0)
			{
				return new String[] {"RB","FR"};
			}
			else
			{
				return new String[] {"B1","B2"};
			}
		}
		else
		{
			if(R==90)
			{
				return new String[] {"RR","F"};
			}
			else if(R==270)
			{
				return new String[] {"RR","F"};
			}
			else if (R==0)
			{
				return new String[] {"B1","B2"};
			}
			else
			{
				return new String[] {"RB","FR"};
			}
		}
	}
	//Returns the actions for the Ship to shoot.
	public String[] Shoot(Ship S)
	{
		//Gathers all the information on the Ship necessary
		//to determine the actions to shoot.
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
		//If facing the proper way to shoot, roll back,
		//roll forward again and then shoot.
		if((MR==true&&R==90)||(!MR==true&&R==270))
		{
			return new String[] {"RB","RS"};
		}
		//otherwise, correct the rotation and shoot.
		else if(MR)
		{
				if (R==0)
				{
					return new String[] {"RR","S"};
				}
				else
				{
					return new String[] {"RL","S"};
				}
		}
		else
		{
				if (R==0)
				{
					return new String[] {"RL","S"};
				}
				else
				{
					return new String[] {"RR","S"};
				}
		}
	}
	
}
