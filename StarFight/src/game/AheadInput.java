package game;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;
import game.GraphicsAid;
import main.Main;
import types.Button;

public class AheadInput{
	
	GraphicsAid GA = new GraphicsAid();
	MouseListener ML;
	Button B[] = new Button[9];
	
	int mouseX, mouseY, turns; 
	
	int width = Main.getWidth();
	int height = Main.getHeight();
	int scale = 55;
	
	public AheadInput()
	{
		//creates buttons 1-5 and puts
		//them in their proper place.
		int posX = (int)((width/2)-(7*scale));
		int posY = -25;
		for (int i=0;i<5;i++)
		{
			B[i]=new Button(posX, posY, scale, Integer.toString(i+1));
			posX += scale*3;
		}
		//creates buttons 6-9 and puts
		//them in their proper place.
		posX = (int)((width/2)-(5.5*scale));
		posY += scale*3;
		for (int i=5;i<9;i++)
		{
			B[i]=new Button(posX, posY, scale, Integer.toString(i+1));
			posX += scale*3;
		}
		
		//Creates the Graphics
		paintAheadInput PAI = new paintAheadInput();
		
		//Adds a Mouse Listener to my button.
		PAI.addMouseListener(new MouseListener() {
			
			//if mouse is clicked is clicked, trigger.
			@Override
			public void mouseClicked(MouseEvent e) {
				//if the mouse coordinates is contained within one
				//of the buttons, Proceed to next Input Panel.
				for (int i = 0; i<9; i++)
				{
					if(B[i].collisionCheck(e.getX(),e.getY()))
					{
						Main.proceed1(i+1);
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
		Main.getJPanel().add(PAI, "1");
	}
	
	private class paintAheadInput extends JComponent
	{
		//Paints to the Screen.
		@Override
		public void paint(Graphics g)
		{
			super.paintComponent(g);
			//Draws the dark Blue Background to the Screen.
			GA.drawBackground(g, this);
			//Draws all the Buttons to the Screen.
			for (Button b : B)
			{
				b.drawButton(g, this);
			}
			//draws String to the Screen.
			g.setFont(new Font("courier",1,50));
			g.drawString("Select how many turns you decide for at a time.", width/9, height/3);
		}	

	}
}
