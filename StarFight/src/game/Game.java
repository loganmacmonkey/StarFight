package game;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JPanel;

import main.Main;
import types.Ship;

public class Game {

	static JPanel GamePane = new JPanel();
	//GridBagLayout GBL = new GridBagLayout();
	
	public Game (int Turns, Ship P1, Ship P2)
	{
		//GamePane.setLayout(GBL);
		new GameBoard();
		
		Main.getJPanel().add(GamePane, "3");
		
	}
	
	public static JPanel getGamePane()
	{
		return GamePane;
	}
	
	public static void addComp(JComponent comp, int xPos, int yPos, int compWidth, int compHeight, int Weightx, int Weighty, int place, int stretch, int Top, int Left, int Bottom, int Right)
	{
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = Weightx;
        gridConstraints.weighty = Weighty;
        gridConstraints.insets = new Insets(Top,Left,Bottom,Right);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;
        GamePane.add(comp, gridConstraints);
    }
	
}
