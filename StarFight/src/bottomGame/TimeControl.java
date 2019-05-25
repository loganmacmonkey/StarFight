package bottomGame;

//Tells the screen what moment of time it is.
public class TimeControl implements Runnable {
	
	@Override
	//The part in the class which does stuff
	public void run() {
		//Creates a place holder for time.
		double time = 0;
		
		//Runs as long as the screen's in playing mode.
		while (PlayBottom.getPlaying()) {
			
			//If asked to to start changing the time...
			if (PlayBottom.TimerRunning()) 
			{
				//Gets the current clock (System) time in milliseconds.
				Time1 = System.currentTimeMillis();
				
				//Increases the time by the change in time of the last
				//time this loop has been computed so that no matter
				//how fast the computer is, it stays at the same speed.
				time += (int)((Time1-Time2)*PlayBottom.getSpeed()*2);
				
				//If time is greater than max time, set it to max time
				//& Vice versa for less than 0.
				if(time > PlayBottom.getTurns()*2000)
				{
					time = PlayBottom.getTurns()*2000;
				}
				else if (time < 0)
				{
					time = 0;
				}
				//After making sure the time was a valid time,
				//set the actual time variable to the placeholder.
				Time = time;
			}
			//Gets the current clock (System) time in milliseconds.
			Time2 = System.currentTimeMillis();
		}
		
	}

	//Stores the current clock (System) time in milliseconds in
	//different points in time (Time1 & Time2) & the Main Time variable (Time).
	private long Time1 = 0;
	private long Time2 = 0;
	private double Time = 0;
	
	//Gets time as an Integer.
	public int getTimeInt()
	{return (int)Time;}
	
	public double getTime()
	{return Time;}
	
	public void setTime(double Time)
	{this.Time = Time;}
	
}
