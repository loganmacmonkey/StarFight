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
		//stores all the actions of the Main Ship into a new Main actions array.
		String[] NMA = new String[MA.length+1];
		for(int i = 0;i<MA.length;i++)
		{
			NMA[i] = MA[i];
		}
		
		//Checks through every action and in between every action to check if the ship got hit.
		for(int i = 0;i < MA.length*2;i++)
		{
			//This List of Lasers is what's used to see if any Laser is touching a Ship.
			ArrayList<Laser> CheckLasers = new ArrayList<Laser>();
			
			//This List of Lasers is what's used to add all previously shoot Lasers to the list.
			ArrayList<Laser> L = new ArrayList<Laser>();
			
			//Adds all the Lasers from "Lasers" into L.
			for (Laser l : Lasers)
			{
				L.add(l);
			}
			
			//Moves all the Lasers and adds all the newly made or moved ones into
			//the CheckLasesr Array.
			for (Laser l : MS.Move(M.clone(), S.clone(), MA, SA, L, (i+1)*500))
			{
				CheckLasers.add(l);
			}
			//Makes a ship is simply the moved version of the original.
			Ship m = MS.Move(M.clone(), MA, (i+1)*500);
			
			//Goes through every Laser in "CheckLasers".
			for  (Laser l : CheckLasers)
			{
				//If they are in the same space...
				if(SC.getAXSpace(m) == SC.getAXSpace(l) && SC.getAYSpace(m) == SC.getAYSpace(l))
					{
						
						int I = (i+1)*500%1000 != 0 ? Math.floorDiv((i+1)*500, 1000) + 1 : Math.floorDiv((i+1)*500, 1000);
						for (int k = I;k<MA.length+1;k++)
						{
							if (k == I && NMA[k] != "D")
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
			Ship s = MS.Move(S.clone(), SA, (i+1)*500);
			if(m.ContainsPoint(s.getXInt(), s.getYInt()))
			{
				int I = Math.floorDiv((i)*500, 1000);
				for (int k = I;k<MA.length+1;k++)
				{
					if (k == I && NMA[k] != "D")
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
