package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

import main.Main;
import types.Button;
import types.Ship;

public class ShipSelect {

	GraphicsAid GA = new GraphicsAid();
	MouseListener ML;
	Button B[] = new Button[7];
	Ship S[] = new Ship[7];
	
	int mouseX, mouseY, turns, ST, P1, P2; 
	
	int width = Main.getWidth();
	int height = Main.getHeight();
	int scale = 55;

	public ShipSelect() {
		
		//creates buttons 1-3 & Ships 1-3
		//& puts them in their proper place.
		int posX = (int)((width/2)-(4*scale));
		int posY = -25;
		for (int i=0;i<3;i++)
		{
			B[i]=new Button(posX, posY, scale);
			S[i]=new Ship(i+1,5.0,posX, posY+(2*scale),0);
			posX += scale*3;
		}
		
		//creates buttons 4-7 & Ships 4-7
		//& puts them in their proper place.
		posX = (int)((width/2)-(5.5*scale));
		posY += scale*3;
		for (int i=3;i<7;i++)
		{
			B[i]=new Button(posX, posY, scale);
			S[i]=new Ship(i+1,5.0,posX, posY+(2*scale),0);
			posX += scale*3;
		}
		
		//Creates the Graphics of the first Panel
		paintShipSelect1 PSS1 = new paintShipSelect1();
		
		//Adds the Mouse Listener to my buttons
		//for the first Panel.
		PSS1.addMouseListener(new MouseListener() {
			
			//if mouse is clicked is clicked, trigger.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//if the mouse coordinates is contained within one
				//of the buttons, Proceed to next Input Panel.
				for (int i = 0; i<7; i++)
				{
					if(B[i].collisionCheck(e.getX(),e.getY()))
					{
						P1 = i;
						Main.getCardLayout().show(Main.getJPanel(), "2b");
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
		
		//Creates the Graphics of the first Panel
		paintShipSelect2 PSS2 = new paintShipSelect2();
		
		//Adds the Mouse Listener to my buttons
		//for the first Panel.
		PSS2.addMouseListener(new MouseListener() {
			
			//if mouse is clicked is clicked, trigger.
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//if the mouse coordinates is contained within one
				//of the buttons minus the first button that was. 
				//pressed, Proceed to the game.
				for (int i = 0; i<7; i++)
				{
					if (i != P1) {
						if (B[i].collisionCheck(e.getX(), e.getY())) {
							Main.proceed2(S[P1],S[i]);
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
		
		//Add Graphics to the Main Panel.
		Main.getJPanel().add(PSS1,"2a");
		Main.getJPanel().add(PSS2,"2b");
		//gets the current run time in Milliseconds (1000 = 1sec)
		ST = (int)System.currentTimeMillis();
	}
	
	private class paintShipSelect1 extends JComponent
	{
		//Paints to the Screen
		@Override
		public void paint(Graphics g)
		{
			super.paintComponent(g);
			
			//Draws the dark Blue Background to the Screen.
			GA.drawBackground(g, this);
			
			//Scrolls through all the indexes
			//for all the buttons and Ships.
			for (int i = 0;i<7;i++)
			{
				//draws the Buttons to the Screen.
				B[i].drawButton(g, this);
				
				//sets the rotation of the ship to the current
				//run time in Milliseconds divided by 10.
				S[i].setRotation((double)(ST-(int)System.currentTimeMillis())/10);
				
				//Draws the Ship to the Screen
				S[i].drawShip(g, this);
			}
			
			//Draws the String to the Screen.
			g.setFont(new Font("courier",1,50));
			g.drawString("Player 1, select your ship.", (int)(width/4), height/3);
			
			//Update the screen
			repaint();
		}
	}
	
	private class paintShipSelect2 extends JComponent
	{
		//Time variables to set the ships speed
		//in relation to time so that the ships
		//move the same speed on every computer
		//and that the String Reappears at the
		//time on every computer.
		double Time1, TimeS = (double)System.currentTimeMillis();
		double Time2 = 0.0;
		
		//Paints to the Screen.
		@Override
		public void paint(Graphics g)
		{
			super.paintComponent(g);
			//Draws the dark Blue Background to the Screen.
			GA.drawBackground(g, this);
			//Scrolls through all the indexes
			//for all the buttons and Ships.
			for (int i = 0;i<7;i++)
			{
				//Draws the Button to the Screen
				B[i].drawButton(g, this);
				
				//if the index is the same
				//as the one first selected...
				if(i==P1)
				{	
					//If Running for the first time, set
					//Time2 = to the current time in Milliseconds
					//before the first Step so our first step isn't
					//way bigger than the others.
					if (Time2 == 0.0) {
						Time2 = (double)System.currentTimeMillis();
					}
					
					//Move the ship forward the amount of pixels
					//as milliseconds which have past since last run
					//divided by 3.
					else
					{
						Time2 = (double)System.currentTimeMillis();
						S[i].forward((Time2-Time1)/3);
					}
					
					//Record the Time now to know the
					//difference of time for next run.
					Time1 = (double)System.currentTimeMillis();
				}else{
					
					//sets the rotation of the ship to the current
					//run time in Milliseconds divided by 10.
					S[i].setRotation((double)(ST-(int)System.currentTimeMillis())/10);
				}
				
				//Draws the Ship to the Screen.
				S[i].drawShip(g, this);
			}
			
			//Draws the String to the Screen as
			//long as 1000 milliseconds has past
			//since switching to this Panel.
			g.setFont(new Font("courier",1,50));
			if (((double)System.currentTimeMillis() - TimeS)>1000) {
				g.drawString("Player 2, select your ship.", (int) (width / 4), height / 3);
			}
			
			//Update the screen
			repaint();
		}
	}
	
}
