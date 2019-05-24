package topGame;

import types.Ship;

public class CreateActions {
	
	MoveToAction MA = new MoveToAction();
	MoveShip MS = new MoveShip();
	
	public String[] CA(Ship S, String[] M)
	{
		String[] A = new String[M.length*2];
		int AIndex = 0;
		
		for(String m : M)
		{
			switch (m)
			{
			case "F" : String[] f = MA.Forward(S);
				for(String a : f)
			{A[AIndex] = a;System.out.print(a+", ");AIndex++;}
				S = MS.Move(S, f, 2000);
				break;
			case "V" : String[] v = MA.Veer(S);
				for(String a : v)
			{A[AIndex] = a;System.out.print(a+", ");AIndex++;}
				S = MS.Move(S, v, 2000);
				break;
			case "S" : String[] s = MA.Shoot(S);
				for(String a : s)
			{A[AIndex] = a;System.out.print(a+", ");AIndex++;}
				S = MS.Move(S, s, 2000);
				break;
			}
		}
		System.out.println("");
		return A;
	}
	
}
