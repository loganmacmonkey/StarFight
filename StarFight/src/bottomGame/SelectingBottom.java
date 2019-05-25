package bottomGame;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import game.Game;
import main.Main;
import types.Button;

//Asks Player 1 & 2 for the moves they'd like to do
//and sends them to the top of the screen.
public class SelectingBottom {
	
	//Stores the moves P1 selects.
	String[] P1Moves;
	
	//Stores the moves P2 selects.
	String[] P2Moves;
	
	//Creates the 5 clickable buttons for the screen.
	Button[] options = new Button[5];
	
	//Creates the Buttons which show you the moves you've selected.
	Button[] Moves;
	
	//An arbitrary size for all the buttons to make them fit nice.
	int Scale = 80;
	
	//The current move your deciding - 1.
	int TurnIndex = 0;
	
	//Tells us which player's moves we're searching for.
	String SF;
	
	public String[] getP1Moves()
	{return P1Moves;}
	
	public String[] getP2Moves()
	{return P2Moves;}
	
	//sets up everything to draw and take in input.
	public void setup(int Turns)
	{
		//Stores the amount of moves as Turns needed
		//to be decided at a time for P1 & 2. 
		P1Moves = new String[Turns];
		P2Moves = new String[Turns];
		
		//Makes as many buttons as there are moves to be made
		Moves = new Button[Turns];
		
		//Sets up all the buttons which show you your moves.
		for(int i = 0;i<Turns;i++)
		{
			//Top row of buttons (up to 4 if needed)
			if(i>4)
			{
				Moves[i]= new Button((Main.getJPanel().getWidth()*7/15)+(Scale*(44+((i-5)*4))/8),(Main.getJPanel().getHeight()*2/5)+(Scale*5/4),Scale/4);
			}
			//Bottom row of buttons (for having 5 to 9 buttons if needed)
			else
			{
				Moves[i]= new Button((Main.getJPanel().getWidth()*7/15)+(Scale*(42+(i*4))/8),(Main.getJPanel().getHeight()*2/5)+(Scale*3/4),Scale/4);
			}
		}
		//Positions the big 3 buttons
		for (int i = -1;i<2;i++)
		{
			options[i+1] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*3*i)),Main.getJPanel().getHeight()*2/5,Scale);
		}
		//Gives each big button it's proper label.
		options[0].setDisplay("F");
		options[1].setDisplay("V");
		options[2].setDisplay("S");
		
		//Positions & labels the "Back" & "Clear" Button.
		options[3] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*11/2)),(Main.getJPanel().getHeight()*2/5)+(Scale*3/2),Scale/2,"B");
		options[4] = new Button(((Main.getJPanel().getWidth()*7/15)+(Scale*13/2)),(Main.getJPanel().getHeight()*2/5)+(Scale*3/2),Scale/2,"C");
		
		//Tells the computer we're searching for P1 Moves.
		SF = "P1";
		
		//A key listener which reads when the enter key is pressed
		Main.getJPanel().addKeyListener(new KeyListener()
				{
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER)
						{
							//If all moves have been decided...
							if (TurnIndex == Turns) {
								//If just finished P1's moves, find P2's moves.
								if (SF == "P1") {
									SF = "P2";
									
									//start back at the first move again.
									TurnIndex = 0;
									
								//If just finished P2's moves, go on to
								//let the top screen start processing them.
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
		
		//Checks for which buttons you've clicked to know what moves you want
		//or if you want to clear your moves or backspace a move.
		Main.getJPanel().addMouseListener(new MouseListener() {
			
			//if mouse is clicked is clicked, trigger.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Check all 5 buttons.  If the mouse coordinates is 
				//contained within one of the buttons, perform the
				//action corresponding with that button.
				for (int i = 0; i<5; i++)
				{
					//If a button has been pressed
					if (options[i].collisionCheck(e.getX(), e.getY())) {
						switch (i)
						{
						//If Button "F" was pressed, put in F down
						//as the next move.
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
						
						//If Button "V" was pressed, put a V down
						//as the next move.
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
						
						//If Button "S" was pressed, put a S down
						//as the next move.
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
						
						//If Button "B" was pressed, Backspace the last
						//made move and remake the last move.
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
						
						//If Button "C" was pressed, Clear all made
						//Moves and start back to the first one.
						case 4: if(SF=="P1")
						{
							P1Moves = new String[Turns];
						}
						else
						{
							P2Moves = new String[Turns];
						}
						TurnIndex=0;
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

	//Paints the screen.
	public void paintSelectingBottom(Graphics g, JComponent J)
	{
		//Draws all the bigger buttons to Screen
		for(Button O : options)
		{
			O.drawButton(g, J);
		}
		//If Searching for P1 moves...
		if (SF == "P1")
		{
			//Draws P1's moves to the screen
			paintSelectingP1Bottom(g,J);
		}
		else
		{
			//Draws P2's moves to the screen
			paintSelectingP2Bottom(g,J);
		}
	}	
	//Draws P1's moves to the screen
	public void paintSelectingP1Bottom(Graphics g, JComponent J)
	{
		//Draw to screen P1 in the bottom left.
		g.drawString("P1", options[0].getX()/3, 400);
		
		//Scrolls through all the button for P1's moves
		for(int i = 0;i<P1Moves.length;i++)
		{
			//Fills any null button.
			if (P1Moves[i] == null)
			{
				P1Moves[i] = "";
			}
			
			//If Caps lock is on, star any button which has a move in it.
			if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) 
			{
				if (i<TurnIndex) {
					
					Moves[i].setDisplay("*");
				}
				else
				{
					Moves[i].setDisplay("");
				}
			} 
			//Otherwise, each button with a move will display their move.
			else
			{
				Moves[i].setDisplay(P1Moves[i]);
			}
			//Draw each button.
			Moves[i].drawButton(g, J);
		}
	}
	//Draws P1's moves to the screen
	public void paintSelectingP2Bottom(Graphics g, JComponent J)
	{
		//Draw to screen P2 in the bottom left.
		g.drawString("P2", options[0].getX()/3, 400);
		
		//Scrolls through all the button for P2's moves
		for(int i = 0;i<P2Moves.length;i++)
		{
			//Fills any null button.
			if (P2Moves[i] == null)
			{
				P2Moves[i] = "";
			}
			//If Caps lock is on, star any button which has a move in it.
			if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) 
			{
				if (i<TurnIndex) {
					
					Moves[i].setDisplay("*");
				}
				else
				{
					Moves[i].setDisplay("");
				}
			} 
			//Otherwise, each button with a move will display their move.
			else
			{
				Moves[i].setDisplay(P2Moves[i]);
			}
			//Draw each button.
			Moves[i].drawButton(g, J);
			
		}
	}

}
