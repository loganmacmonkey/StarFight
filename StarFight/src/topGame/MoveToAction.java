package topGame;

import types.Ship;

public class MoveToAction {

	SpaceCoordinates SC = new SpaceCoordinates();
	
	public String[] Forward(Ship S)
	{
		int X = SC.getXSpace(S);
		int Y = SC.getYSpace(S);
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
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
		
		return null;
		
	}
	
	public String[] Veer(Ship S)
	{
		int X = SC.getXSpace(S);
		int Y = SC.getYSpace(S);
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
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
		else if(MR)
		{
			if(SC.getYSpace(S)==1)
			{
				if(R==90)
				{
					return new String[] {"RL","F"};
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
		else
		{
			if(Y==1)
			{
				if(R==270)
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
				if(R==270)
				{
					return new String[] {"RL","F"};
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
	}
	
	public String[] Shoot(Ship S)
	{
		int Y = SC.getYSpace(S);
		int R = S.getRotationInt();
		Boolean MR = S.getMovingRight();
		
		if((MR==true&&R==90)||(!MR==true&&R==270))
		{
			return new String[] {"RB","RS"};
		}
		else if(MR)
		{
			if(Y==1)
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
		else
		{
			if(Y==1)
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
			else
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
		}
	}
	
}
