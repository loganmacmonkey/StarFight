package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;

import main.Main;
import types.Ship;

public class Game {

	//The Panel where the entire game will take place
	static JPanel GamePane = new JPanel();
	
	//The way things are going to be added to the GamePane
	//where everything is placed in a very detailed
	//& controlled grid-like fashion.
	GridBagLayout GBL = new GridBagLayout();
	
	public Game (int Turns, Ship P1, Ship P2)
	{
		GamePane.setLayout(GBL);
		new GameBoard();
		Main.getJPanel().add(GamePane, "3");
		
	}
	
	public static JPanel getGamePane()
	{return GamePane;}
	
	//Creates the GridBagConstraints for the JComponent &
	//adds it to the GamePane Panel.
	public static void addComp(JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int Weightx, int Weighty, int place, int stretch, int Top, int Left, int Bottom, int Right)
	{
        GridBagConstraints gridConstraints = new GridBagConstraints();

        //Relative coordinates of the Component.
        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        
        //dimensions of the Component relative to the other Components.
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        
        //How pushy it is.
        gridConstraints.weightx = Weightx;
        gridConstraints.weighty = Weighty;
        
        //The spaces around the Component.
        gridConstraints.insets = new Insets(Top,Left,Bottom,Right);
        
        //The Placement of where the Component is.
        gridConstraints.anchor = place;
        
        //Direction of stretch if needed to fill empty space
        gridConstraints.fill = stretch;
        
        //Adds the Component to the GamePane in the specified way.
        GamePane.add(comp, gridConstraints);
    }
	
}
