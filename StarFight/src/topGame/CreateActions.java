package topGame;

import java.util.ArrayList;

import types.Laser;
import types.Ship;

//Creates the list of actions for the ships.
public class CreateActions {
	
	//Creates the class which turns individual Turns
	//into two separate actions.
	MoveToAction MA = new MoveToAction();
	
	//Creates the class which moves the ship.
	MoveShip MS = new MoveShip();
	
	//Allows to convert raw X & Y values to usable game coordinates.
	SpaceCoordinates SC = new SpaceCoordinates();
	
	//Returns a List of actions for the ship to
	//do to complete the moves given.
	public String[] CA(Ship S, String[] M)
	{
		//Stores the list of actions.
		String[] A = new String[M.length*2];
		
		//Stores the index of the current action.
		int AIndex = 0;
		
		//Goes through each move in the list of moves.
		for(String m : M)
		{
			//Looks at the move and checks the value.
			switch (m)
			{
			//If the value is F, create the actions to move the ship
			//forward & store them in the action List.
			case "F" : String[] f = MA.Forward(S);
				for(String a : f)
			{A[AIndex] = a;AIndex++;}
			
			//move the Ship from where it is to where it would
			//be if it had completed both of the newly found actions.
				S = MS.Move(S, f, 2000);
				break;
			
			//If the value is V, create the Actions to veer the ship to
			//the other lane & store them in the Action List.
			case "V" : String[] v = MA.Veer(S);
				for(String a : v)
			{A[AIndex] = a;AIndex++;}
				
				//move the Ship from where it is to where it would
				//be if it had completed both of the newly found actions.
				S = MS.Move(S, v, 2000);
				break;
			
			//If the value is S, create the Actions to for the ship
			//to shoot & store them in the Action List.
			case "S" : String[] s = MA.Shoot(S);
				for(String a : s)
			{A[AIndex] = a;AIndex++;}
				
				//move the Ship from where it is to where it would
				//be if it had completed both of the newly found actions.
				S = MS.Move(S, s, 2000);
				break;
			}
		}
		//Return the Action list.
		return A;
	}
	
	public String[] CAwithBurning(Ship M, Ship S,String[] MA,String[] SA,ArrayList<Laser> Lasers)
	{
		String[] NMA = new String[MA.length+1];
		for(int i = 0;i<MA.length;i++)
		{
			NMA[i] = MA[i];
		}
		
		for(int i = 0;i < MA.length*4;i++)
		{
			ArrayList<Laser> CheckLasers = new ArrayList<Laser>();
			ArrayList<Laser> L = new ArrayList<Laser>();
			for (Laser l : Lasers)
			{
				L.add(l);
			}
			for (Laser l : MS.Move(M.clone(), S.clone(), MA, SA, L, (i+1)*250))
			{
				CheckLasers.add(l);
			}
			Ship m = MS.Move(M.clone(), MA, (i+1)*250);
			for  (Laser l : CheckLasers)
			{
				if(SC.getXSpace(m) == SC.getXSpace(l) && SC.getYSpace(m) == SC.getYSpace(l))
					{
						int I = Math.floorDiv(i*250, 1000);
						System.out.println(I);
						for (int k = I+1;k<MA.length+1;k++)
						{
							if (k == I+1 && NMA[k]!="D")
							{
								NMA[k] = "BRN";
							}
							else
							{
								NMA[k] = "D";
							}
						}
						return NMA;
					}
			}
			Ship s = MS.Move(S.clone(), SA, (i+1)*250);
			if(m.ContainsPoint(s.getXInt(), s.getYInt()))
			{
				int I = Math.floorDiv(i*250, 1000);
				System.out.println(I);
				for (int k = I+1;k<MA.length+1;k++)
				{
					if (k == I+1 && NMA[k]!="D")
					{
						NMA[k] = "BRN";
					}
					else
					{
						NMA[k] = "D";
					}
				}
				return NMA;
			}
		}
		
		return NMA;
	}
	
}
