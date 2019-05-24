package bottomGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import main.Main;

public class PlayBottom {
	
	static int Turns;
	static double speed;
	Color Yellow = new Color(255,196,0);
	volatile static Boolean running;
	volatile static Boolean playing;
	
	TimeControl TC =new TimeControl();
	
	public void setup(int Turns)
	{
		speed = 4;
		PlayBottom.Turns = Turns;
		running = false;
		playing = true;
		TC =new TimeControl();
		(new Thread(TC)).start();
		
		Main.getJPanel().addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if (TC.getTimeInt() == Turns*2000)
					{
						playing = false;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					speed = 1;
				}
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					if(Math.abs(speed) < 32)
					{
						speed *= 2;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					if(Math.abs(speed) > 1)
					{
						speed /= 2;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (!running) {
						if(speed < 0)
						{
							speed *= -1;
						}
						running = true;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (!running) {
						if(speed > 0)
						{
							speed *= -1;
						}
						running = true;
					}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (running) {
						running = false;
					}
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT)
				{
					if (running) {
						running = false;
					}
				}
			}

			@Override
			public void keyTyped(KeyEvent arg0) {}
	
		});
	}
	
	public static double getSpeed()
	{
		return speed;
	}
	
	public static Boolean getPlaying() {
		return playing;
	}

	public static Boolean TimerRunning()
	{
		return running;
	}
	
	public static int getTurns()
	{
		return Turns;
	}
	
	public int getTime()
	{
		return TC.getTimeInt();
	}
	
	public void paintPlayBottom(Graphics g, JComponent J)
	{
		g.setColor(Color.BLACK);
		g.fillRect((Main.getJPanel().getWidth()/4), 240, Main.getJPanel().getWidth()/2, 120);
		g.setColor(Yellow);
		g.fillRect((Main.getJPanel().getWidth()/4), 240, Main.getJPanel().getWidth()*TC.getTimeInt()/Turns/4000, 120);
		g.setColor(Color.YELLOW);
		for (int i = 0;i<(Turns-1);i++)
		{
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 240, 2, 24);
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 288, 2, 24);
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 336, 2, 24);
		}
	}
	
}
