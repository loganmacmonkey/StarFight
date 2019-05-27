package game;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JComponent;

import main.Main;
import types.Ship;

public class WinScreen {
	
	Ship a,b;
	String WS;
	
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
			time2 = System.currentTimeMillis();
			time += (double)(time2 - time1)/100;
			time1 = System.currentTimeMillis();
			if(WS == "Tie")
			{
				a.setX(Main.getJPanel().getWidth()/2 + (Math.sin(time)*a.getScale()*50));
				a.setY(Main.getJPanel().getHeight()/2 + Math.cos(time)*a.getScale()*50);
				b.setX(Main.getJPanel().getWidth()/2 + Math.sin(time - 180)*b.getScale()*50);
				b.setY(Main.getJPanel().getHeight()/2 + Math.cos(time - 180)*b.getScale()*50);
				a.drawShip(g, this);
				b.drawShip(g, this);
				g.setFont(new Font("courier",1,50));
				g.drawString(WS, Main.getJPanel().getWidth()/2-40, Main.getJPanel().getHeight()/2);
			}
			repaint();
		}
	}
	
}
