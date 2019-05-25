package topGame;

import main.Main;
import types.Laser;
import types.Ship;

//Allows to convert raw X & Y values to usable game coordinates.
public class SpaceCoordinates {

	//Gets the distance for a ship to go forward one space.
	public int getSpaceX()
	{
		return Main.getJPanel().getWidth()/16;
	}
	
	//Gets the X value of the space you input
	public int getX(int Space)
	{
		return ((Main.getJPanel().getWidth()*((2*(Space-1))+1))/32);
	}
	
	//Gets the X coordinate of the Space
	//that the Ship is currently in.
	public int getXSpace(Ship X)
	{
		return ((((32*(X.getXInt()+1))/Main.getJPanel().getWidth())+1)/2);
	}
	
	//Gets the X coordinate of the Space
	//that the Laser is currently in.
	public int getXSpace(Laser X)
	{
		return ((((32*(X.getXInt()+1))/Main.getJPanel().getWidth())+1)/2);
	}
	
	//Gets the distance for a ship to go up or down one space.
	public int getSpaceY()
	{
		return Main.getJPanel().getHeight()/4;
	}
	
	//Gets the Y value of the space you input
	public int getY(int Space)
	{
		if (Space == 1)
		{
			return Main.getJPanel().getHeight()*3/8;
		}
		else
		{
			return Main.getJPanel().getHeight()/8;
		}
	}
	
	//Gets the X coordinate of the Space
	//that the Ship is currently in.
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
	
	//Gets the X coordinate of the Space
	//that the Laser is currently in.
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
