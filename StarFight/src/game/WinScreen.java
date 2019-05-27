package game;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;

import main.Main;
import types.Ship;

public class WinScreen {
	
	Ship a,b;
	String WS;
	
	GraphicsAid GA = new GraphicsAid();
	
	public void setup(Ship Winner, Ship Loser, String P)
	{
		a = Winner;
		a.setBurnedAmount(0);
		b = Loser;
		b.setBurnedAmount(0);
		WS = P;
		Main.getJPanel().add(new paintWinScreen(), "4");
	}
	
	public void setup(Ship First, Ship Second)
	{
		a = First;
		a.setBurnedAmount(0);
		b = Second;
		b.setBurnedAmount(0);
		WS = "Tie";
		Main.getJPanel().add(new paintWinScreen(), "4");
	}
	
	private class paintWinScreen extends JComponent
	{
		long time1 = System.currentTimeMillis();
		long time2;
		double time = 0;
		public void paint(Graphics g)
		{
			Graphics2D g2d = (Graphics2D) g;
			
			GA.drawBackground(g, this);
					
			g2d.setStroke(new BasicStroke(5));
			g2d.setFont(new Font("courier", 1, 50));
			g2d.setColor(Color.WHITE);
			g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
			
			time2 = System.currentTimeMillis();
			time += (double)(time2 - time1)/300;
			time1 = System.currentTimeMillis();
			
			if(WS == "Tie")
			{
				a.setX(Main.getJPanel().getWidth()/2 + (Math.sin(time)*a.getScale()*50));
				a.setY(Main.getJPanel().getHeight()/2 + Math.cos(time)*a.getScale()*50);
				a.setRotation(time*-180/Math.PI + 90);
				b.setX(Main.getJPanel().getWidth()/2 + Math.sin(time - Math.PI)*b.getScale()*50);
				b.setY(Main.getJPanel().getHeight()/2 + Math.cos(time - Math.PI)*b.getScale()*50);
				b.setRotation(time*-180/Math.PI - 90);
				a.drawShip(g, this);
				b.drawShip(g, this);
				g.setFont(new Font("courier",1,50));
				
				g.drawString(WS, Main.getJPanel().getWidth()/2-40, Main.getJPanel().getHeight()/2);
			} 
				else
			{
					a.setX(Main.getJPanel().getWidth()/2 + (Math.sin(time)*a.getScale()*25));
					a.setY(Main.getJPanel().getHeight()*3/4 + Math.cos(time)*a.getScale()*25);
					a.setRotation(time*-180/Math.PI + 90);
					b.setX(Main.getJPanel().getWidth()/2);
					b.setY(Main.getJPanel().getHeight()*3/4);
					b.setBurnedAmount((int)(time*25));
					a.drawShip(g, this);
					b.drawShip(g, this);
					g.setFont(new Font("courier",1,50));
					
					g.drawString(WS + " Wins", Main.getJPanel().getWidth()/2-80, Main.getJPanel().getHeight()/4);
			}
			repaint();
		}
	}
	
}
