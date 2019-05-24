package topGame;

import main.Main;
import types.Laser;
import types.Ship;

public class SpaceCoordinates {

	public int getSpaceX()
	{
		return Main.getJPanel().getWidth()/16;
	}
	
	public int getX(int X)
	{
		return ((Main.getJPanel().getWidth()*((2*(X-1))+1))/32);
	}
	
	public int getXSpace(Ship X)
	{
		return ((((32*(X.getXInt()+1))/Main.getJPanel().getWidth())+1)/2);
	}
	
	public int getXSpace(Laser X)
	{
		return ((((32*(X.getXInt()+1))/Main.getJPanel().getWidth())+1)/2);
	}
	
	public int getSpaceY()
	{
		return Main.getJPanel().getHeight()/4;
	}
	
	public int getY(int Y)
	{
		if (Y == 1)
		{
			return Main.getJPanel().getHeight()*3/8;
		}
		else
		{
			return Main.getJPanel().getHeight()/8;
		}
	}
	
	public int getYSpace(Ship Y)
	{
		if (Y.getYInt() > 120)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	
	public int getYSpace(Laser Y)
	{
		if (Y.getYInt() > 120)
		{
			return 1;
		}
		else
		{
			return 2;
		}
	}
	
}
