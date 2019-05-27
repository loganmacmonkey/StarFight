package bottomGame;

import java.awt.Graphics;

import javax.swing.JComponent;

//Gathers all the inputs for the TopOfGame class
//to draw to the Screen.
public class BottomOfGame {
	
	//Tells the screen what to do and the screen
	//starts of by selecting your moves.
	String mode = "Selecting";
	
	//Creates the class which controls what
	//selects your moves.
	SelectingBottom SB = new SelectingBottom();
	
	//Creates the class which controls
	//the speed your moves play out.
	PlayBottom PB = new PlayBottom();
	
	//How many turns you'd like to decide at a time.
	int Turns;
	
	//Gets the Time which the bottom of the screen is
	//controlling in play mode.
	public int getTime()
	{return PB.getTime();}
	
	//Gets the bottom of the screen when in selecting mode.
	public SelectingBottom getSelectingBottom()
	{return SB;}
	
	//Takes in how many turns you'd like to decide at
	//a time in the game from the Game class.
	public void setup(int Turns)
	{this.Turns = Turns;}
	
	//Sets the mode controlling the screen for this class.
	public void setMode(String Mode)
	{mode = Mode;}
	
	//Paints the bottom of the screen.
	public void paintBottomOfScreen(Graphics g, JComponent J)
	{
		//if in Selecting mode, setup for selecting mode
		//& switch the mode for this class to S
		//to show that setup is complete to start drawing.
		if(mode == "Selecting") {
			SB.setup(Turns);
			mode = "S";
		} else if (mode == "S") {
			SB.paintSelectingBottom(g, J);
		} else
			
		//if in Play mode, setup for Play mode
		//& switch the mode for this class to P
		//to show that setup is complete to start drawing.	
		if (mode == "Play") {
			PB.setup(Turns);
			mode = "P";
		} 
		else if (mode == "P")
		{
			PB.paintPlayBottom(g, J);
		}
		else if (mode == "Pre-Selecting")
		{
			SB = new SelectingBottom();
			PB = new PlayBottom();
			mode = "Selecting";
		}
	}

}
