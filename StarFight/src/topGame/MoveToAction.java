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
	
}
