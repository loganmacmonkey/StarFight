package bottomGame;

import java.awt.Graphics;

import javax.swing.JComponent;

import main.Main;
import types.Button;

public class SelectingBottom {
	
	char[] P1Moves;
	char[] P2Moves;
	Button[] options = new Button[4];
	Button[] Moves;
	int Scale = 80;
	int TurnIndex = 0;
	
	String SearchingFor = "P1";
	
	public void setup(int Turns)
	{
		P1Moves = new char[Turns];
		P2Moves = new char[Turns];
		
		Moves = new Button[Turns];
		for(int i = 0;i<Turns;i++)
		{
			Moves[i]= new Button((Main.getJPanel().getWidth()*7/15)+(Scale*(42+(i*4))/8),(Main.getJPanel().getHeight()*2/5)+(Scale*3/4),Scale/4);
		}
		
		for (int i = -1;i<2;i++)
		{
			options[i+1] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*3*i)),Main.getJPanel().getHeight()*2/5,Scale);
		}
		options[0].setDisplay("F");
		options[1].setDisplay("V");
		options[2].setDisplay("S");
		options[3] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*11/2)),(Main.getJPanel().getHeight()*2/5)+(Scale*3/2),Scale/2,"B");

	}
	
	public void paintSelectingBottom(Graphics g, JComponent J)
	{
		for(Button O : options)
		{
			O.drawButton(g, J);
		}
		for(Button M : Moves)
		{
			M.drawButton(g, J);
		}
	}
	
	public void paintSelectingP1Bottom(Graphics g, JComponent J)
	{
		
	}
	
	public void paintSelectingP2Bottom(Graphics g, JComponent J)
	{
		
	}

}
