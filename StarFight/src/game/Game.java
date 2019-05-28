package game;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import bottomGame.BottomOfGame;
import main.Main;
import topGame.SpaceCoordinates;
import topGame.TopOfGame;
import types.Ship;

//Takes in how many turns you'd like to decide at a time &
//P1 & 2's ships for the game & creates the game.
public class Game {
	
	//The Panel where the entire game will take place
	static JPanel GamePane = new JPanel();
	
	//Class which lets us draw the game.
	static paintGame PG;
	
	//Tells the screen what to do.
	static String mode = "Selecting";
	
	//Controls the top of the screen.
	static TopOfGame TOG;
	
	//Controls the bottom of the screen.
	static BottomOfGame BOG;
	
	//Stores the Ships for the BottomOfGame Class to use for Color.
	static Ship P1;
	static Ship P2;
	
	//Helps make drawing the Background quicker
	GraphicsAid GA = new GraphicsAid();
	
	//Allows to convert raw X & Y values to usable game coordinates.
	SpaceCoordinates SC = new SpaceCoordinates();
	
	public Game (int Turns, Ship P1, Ship P2)
	{	
		//Stores the selected ships into the class.
		Game.P1 = P1;
		Game.P2 = P2;
		
		//Takes P1 & 2's selected ships and modifies
		//them to be ready for the game.
		P1.setCoordinates(SC.getX(2), SC.getY(1));
		P1.setRotation(90);
		P1.setScale(Main.getJPanel().getWidth()/480);
		P1.setMovingRight(true);
		P2.setCoordinates(SC.getX(15), SC.getY(1));
		P2.setRotation(-90);
		P2.setScale(Main.getJPanel().getWidth()/480);
		P2.setMovingRight(false);
		
		//Create & setup the top & bottom of the game.
		TOG = new TopOfGame();
		TOG.setup(P1, P2);
		BOG = new BottomOfGame();
		BOG.setup(Turns);
		
		//Create the Component which draws it...
		PG = new paintGame();
		
		//& add it to the Main Panel
		Main.getJPanel().add(PG, "3");
		
	}
	/*  sets the mode for the Top & Bottom of the screen 
	 	as well as this main game class.   The modes are as follows...
	 Selecting: Top Screen is still while Bottom is selecting your moves.
	 Processing: Finished selecting your moves and turning them into actions.
	 Play: Actions are ready and you can watch your action take place.*/
	public static void setMode(String Mode)
	{
		TOG.setMode(Mode);
		BOG.setMode(Mode);
		mode = Mode;
	}
	
	//Draws everything related to the actual game.
	private class paintGame extends JComponent
	{
		public void paint(Graphics g)
		{
			if (mode != "Finished") {
			//If moves are selected, start creating the actions
			//necessary to move the ship.
			if(mode == "Processing")
			{
				TOG.process(getP1Moves(), getP2Moves());
			}
			//draws the background.
			GA.drawBackground(g, this);
			
			//draws the grid for the game.
			GA.DrawGameGrid(g, this);
			
			//draws everything for the Top of the Screen
			TOG.paintTopOfScreen(g, this);
			
			//draws everything for the Bottom of the Screen
			BOG.paintBottomOfScreen(g, this);
			
				//keeps the paint function always updating.
				repaint();
			}
		}
	}
	
	public static Ship getP1()
	{
		return P1;
	}
	
	public static Ship getP2()
	{
		return P2;
	}

	//grabs the P1 moves you selected in the Bottom of the
	//Screen in selecting mode.
	public String[] getP1Moves() {
		return BOG.getSelectingBottom().getP1Moves(); 
	}
	
	//grabs the P2 moves you selected in the Bottom of the
	//Screen in selecting mode.
	public String[] getP2Moves() {
		return BOG.getSelectingBottom().getP2Moves(); 
	}

	//grabs the time that you're at in the Bottom
	//of the Screen in play mode.
	public static int getTime() {
		return BOG.getTime();
	}
	
}
