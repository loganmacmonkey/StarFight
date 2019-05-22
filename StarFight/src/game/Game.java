package game;

import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import bottomGame.BottomOfGame;
import main.Main;
import topGame.TopOfGame;
import types.Ship;

public class Game {
	
	//The Panel where the entire game will take place
	static JPanel GamePane = new JPanel();
	
	static paintGame PG;
	
	//Controls the top of the screen.
	TopOfGame TOG;
	
	//Controls the bottom of the screen.
	BottomOfGame BOG;
	
	//Helps make drawing the Background quicker
	GraphicsAid GA = new GraphicsAid();
	
	public Game (int Turns, Ship P1, Ship P2)
	{	
		
		P1.setCoordinates(Main.getJPanel().getWidth()/32, Main.getJPanel().getHeight()*3/8);
		P1.setRotation(90);
		P1.setScale(Main.getJPanel().getWidth()/480);
		P1.setMovingRight(true);
		P2.setCoordinates(Main.getJPanel().getWidth()*31/32, Main.getJPanel().getHeight()*3/8);
		P2.setRotation(-90);
		P2.setScale(Main.getJPanel().getWidth()/480);
		P1.setMovingRight(false);
		
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
	
	private class paintGame extends JComponent
	{
		public void paint(Graphics g)
		{
			GA.drawBackground(g, this);
			GA.DrawGameGrid(g, this);
			TOG.paintTopOfScreen(g, this);
			BOG.paintBottomOfScreen(g, this);
			repaint();
		}
	}
	
}
