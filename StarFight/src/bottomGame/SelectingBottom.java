package bottomGame;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import game.Game;
import main.Main;
import types.Button;

public class SelectingBottom {
	
	String[] P1Moves;
	String[] P2Moves;
	Button[] options = new Button[5];
	Button[] Moves;
	int Scale = 80;
	int TurnIndex = 0;
	
	String SF;
	
	public String[] getP1Moves()
	{
		return P1Moves;
	}
	
	public String[] getP2Moves()
	{
		return P2Moves;
	}
	
	public void setup(int Turns)
	{
		P1Moves = new String[Turns];
		P2Moves = new String[Turns];
		
		Moves = new Button[Turns];
		for(int i = 0;i<Turns;i++)
		{
			if(i>4)
			{
				Moves[i]= new Button((Main.getJPanel().getWidth()*7/15)+(Scale*(44+((i-5)*4))/8),(Main.getJPanel().getHeight()*2/5)+(Scale*5/4),Scale/4);
			}
			else
			{
				Moves[i]= new Button((Main.getJPanel().getWidth()*7/15)+(Scale*(42+(i*4))/8),(Main.getJPanel().getHeight()*2/5)+(Scale*3/4),Scale/4);
			}
		}
		
		for (int i = -1;i<2;i++)
		{
			options[i+1] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*3*i)),Main.getJPanel().getHeight()*2/5,Scale);
		}
		options[0].setDisplay("F");
		options[1].setDisplay("V");
		options[2].setDisplay("S");
		options[3] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*11/2)),(Main.getJPanel().getHeight()*2/5)+(Scale*3/2),Scale/2,"B");
		options[4] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*13/2)),(Main.getJPanel().getHeight()*2/5)+(Scale*3/2),Scale/2,"C");
		
		SF = "P1";
		
		Main.getJPanel().addKeyListener(new KeyListener()
				{
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER)
						{
							if (TurnIndex == Turns) {
								if (SF == "P1") {
									SF = "P2";
									TurnIndex = 0;
								} else if (SF == "P2"){
									Game.setMode("Processing");
									SF = "None";
								} 
							}
						}
					}

					@Override
					public void keyReleased(KeyEvent arg0) {}

					@Override
					public void keyTyped(KeyEvent arg0) {}
			
				});
		
		Main.getJPanel().addMouseListener(new MouseListener() {
			
			//if mouse is clicked is clicked, trigger.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//if the mouse coordinates is contained within one
				//of the buttons minus the first button that was. 
				//pressed, Proceed to the game.
				for (int i = 0; i<5; i++)
				{
					if (options[i].collisionCheck(e.getX(), e.getY())) {
						switch (i)
						{
						case 0: 
							if(TurnIndex<Turns)
							{
								if(SF=="P1")
								{
									P1Moves[TurnIndex] = "F";
								}
								else
								{
									P2Moves[TurnIndex] = "F";
								}
								TurnIndex++;
							}
						break;
						case 1: 
							if(TurnIndex<Turns)
							{
								if(SF=="P1")
							{
								P1Moves[TurnIndex] = "V";
							}
							else
							{
								P2Moves[TurnIndex] = "V";
							}
							TurnIndex++;
							}
						break;
						case 2:if(TurnIndex<Turns) 
						{ 
							if(SF=="P1")
							{
								P1Moves[TurnIndex] = "S";
							}
							else
							{
								P2Moves[TurnIndex] = "S";
							}
							TurnIndex++;
						}
						break;
						case 3: 
							if(TurnIndex>0)
							{
								if(SF=="P1")
							{
								P1Moves[TurnIndex-1] = "";
							}
							else
							{
								P2Moves[TurnIndex-1] = "";
							}
							TurnIndex--;
							}
						break;
						case 4: if(SF=="P1")
						{
							P1Moves = new String[Turns];
						}
						else
						{
							P2Moves = new String[Turns];
						}
						TurnIndex=0;
						break;
						default : break;
						}
					} 
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			});

	}

	public void paintSelectingBottom(Graphics g, JComponent J)
	{
		for(Button O : options)
		{
			O.drawButton(g, J);
		}
		if (SF == "P1")
		{
			paintSelectingP1Bottom(g,J);
		}
		else
		{
			paintSelectingP2Bottom(g,J);
		}
	}
	
	public void paintSelectingP1Bottom(Graphics g, JComponent J)
	{
		g.drawString("P1", options[0].getX()/3, 400);
		for(int i = 0;i<P1Moves.length;i++)
		{
			if (P1Moves[i] == null) {
				Moves[i].setDisplay("");
			} else
			{
				Moves[i].setDisplay(P1Moves[i]);
			}
			Moves[i].drawButton(g, J);
		}
	}
	
	public void paintSelectingP2Bottom(Graphics g, JComponent J)
	{
		g.drawString("P2", options[0].getX()/3, 400);
		for(int i = 0;i<P2Moves.length;i++)
		{
			if (P2Moves[i] == null) {
				Moves[i].setDisplay("");
			} else
			{
				Moves[i].setDisplay(P2Moves[i]);
			}
			Moves[i].drawButton(g, J);
		}
	}

}
