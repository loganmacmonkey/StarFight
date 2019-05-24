package game;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import bottomGame.BottomOfGame;
import main.Main;
import topGame.SpaceCoordinates;
import topGame.TopOfGame;
import types.Ship;

public class Game {
	
	//The Panel where the entire game will take place
	static JPanel GamePane = new JPanel();
	
	static paintGame PG;
	
	static String mode = "Selecting";
	
	//Controls the top of the screen.
	static TopOfGame TOG;
	
	//Controls the bottom of the screen.
	static BottomOfGame BOG;
	
	//Helps make drawing the Background quicker
	GraphicsAid GA = new GraphicsAid();
	
	SpaceCoordinates SC = new SpaceCoordinates();
	
	public Game (int Turns, Ship P1, Ship P2)
	{	
		
		P1.setCoordinates(SC.getX(1), SC.getY(1));
		P1.setRotation(90);
		P1.setScale(Main.getJPanel().getWidth()/480);
		P1.setMovingRight(true);
		P2.setCoordinates(SC.getX(16), SC.getY(1));
		P2.setRotation(-90);
		P2.setScale(Main.getJPanel().getWidth()/480);
		P2.setMovingRight(false);
		
		//Create the top & bottom of the game.
		TOG = new TopOfGame();
		TOG.setup(P1, P2);
		BOG = new BottomOfGame();
		BOG.setup(Turns);
		
		//Create the Component which draws it...
		PG = new paintGame();
		
		//& add it to the Main Panel
		Main.getJPanel().add(PG, "3");
		
	}
	
	public static void setMode(String Mode)
	{
		TOG.setMode(Mode);
		BOG.setMode(Mode);
		mode = Mode;
	}
	
	private class paintGame extends JComponent
	{
		public void paint(Graphics g)
		{
			if(mode == "Processing")
			{
				TOG.process(getP1Moves(), getP2Moves());
			}
			GA.drawBackground(g, this);
			GA.DrawGameGrid(g, this);
			TOG.paintTopOfScreen(g, this);
			BOG.paintBottomOfScreen(g, this);
			repaint();
		}
	}

	public String[] getP1Moves() {
		return BOG.getSelectingBottom().getP1Moves(); 
	}
	
	public String[] getP2Moves() {
		return BOG.getSelectingBottom().getP2Moves(); 
	}

	public static int getTime() {
		return BOG.getTime();
	}
	
}
