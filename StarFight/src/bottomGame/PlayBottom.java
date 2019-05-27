package bottomGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;

import game.Game;
import main.Main;

//Controls and sends the moment of time to display.
public class PlayBottom {
	
	//How many turns you'd like to decide at a time.
	static int Turns;
	
	//How fast time moves when you press the left or right arrow.
	static double speed;
	
	//A specific yellow color for the bar.
	Color Yellow = new Color(255,196,0);
	
	//Tests if TimeControl is changing the time.
	//(volatile means "Expect to be changed by other classes")
	volatile static Boolean running;
	
	//Tests if PlayBottom is still running (Still in Play mode);
	//(volatile means "Expect to be changed by other classes")
	volatile static Boolean playing;
	
	//Creates the TimeControl class.
	TimeControl TC = new TimeControl();
	
	public void setup(int Turns)
	{
		//An arbitrary speed which is starts at a nice pace.
		speed = 4;
		
		//grabs how many moves we're dealing with.
		PlayBottom.Turns = Turns;
		
		//setup
		running = false;
		playing = true;
		TC =new TimeControl();
		
		//Start TimeControl to start checking if running.
		(new Thread(TC)).start();
		
		//Listens for the keyboard to know when to
		//change the time, speed & to continue.
		Main.getJPanel().addKeyListener(new KeyListener()
		{
			@Override
			public void keyPressed(KeyEvent e) {
				
				//If pressed enter & the moves have been played out,
				//continue to select new moves.
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					if (TC.getTimeInt() == Turns*2000)
					{
						playing = false;
						Game.setMode("Pre-Selecting");
						Main.getJPanel().removeKeyListener(this);
					}
				}
				//If pressed space, set speed back to 4 again.
				if(e.getKeyCode() == KeyEvent.VK_SPACE)
				{
					speed = 4;
				}
				//If pressed up, double current speed up to 32.
				if(e.getKeyCode() == KeyEvent.VK_UP)
				{
					if(Math.abs(speed) < 32)
					{
						speed *= 2;
					}
				}
				//If pressed down, half current speed down to 1 
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
				{
					if(Math.abs(speed) > 1)
					{
						speed /= 2;
					}
				}
				//If pressed right, make time go forward.
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
				//If pressed left, make time go backwards.
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
				//If released the right key, stop time.
				if(e.getKeyCode() == KeyEvent.VK_RIGHT)
				{
					if (running) {
						running = false;
					}
				}
				//If released the left key, stop time.
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
	{return speed;}
	
	public static Boolean getPlaying() 
	{return playing;}

	public static Boolean TimerRunning()
	{return running;}
	
	public static int getTurns()
	{return Turns;}
	
	//get's the Time set by the TimeControl Class/Thread. 
	public int getTime()
	{return TC.getTimeInt();}
	
	//Paints the bottom of the screen in Play mode.
	public void paintPlayBottom(Graphics g, JComponent J)
	{
		//Draws the Black Empty bar
		g.setColor(Color.BLACK);
		g.fillRect((Main.getJPanel().getWidth()/4), 240, Main.getJPanel().getWidth()/2, 120);
		
		//Draws the Yellow bar with a width corresponding to the time.
		g.setColor(Yellow);
		g.fillRect((Main.getJPanel().getWidth()/4), 240, Main.getJPanel().getWidth()*TC.getTimeInt()/Turns/4000, 120);
		
		//Draws the vertical lines which shows you when the ships are going to start their next move.
		g.setColor(Color.YELLOW);
		for (int i = 0;i<(Turns-1);i++)
		{
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 240, 2, 24);
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 288, 2, 24);
			g.fillRect(Main.getJPanel().getWidth()/4 + Main.getJPanel().getWidth()*(i+1)/(2*(Turns))-1, 336, 2, 24);
		}
	}
	
}
