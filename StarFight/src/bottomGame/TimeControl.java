package bottomGame;

public class TimeControl implements Runnable {
	
	@Override
	public void run() {
			Boolean TR;
			double time = 0;
		while (PlayBottom.getPlaying()) {
			TR = PlayBottom.TimerRunning();
			if (TR) 
			{
				Time1 = System.currentTimeMillis();
				time += (int)((Time1-Time2)*PlayBottom.getSpeed()*2);
				if(time > PlayBottom.getTurns()*2000)
				{
					time = PlayBottom.getTurns()*2000;
				}
				else if (time < 0)
				{
					time = 0;
				}
				Time = time;
			}
			Time2 = System.currentTimeMillis();
		}
		
	}

	private long Time1 = 0;
	private long Time2 = 0;
	private double Time = 0;
	
	public int getTimeInt()
	{
		return (int)Time;
	}
	
	public double getTime()
	{
		return Time;
	}
	
	public void reset()
	{
		Time1 = 0;
		Time2 = 0;
		Time = 0;
	}
	
	public void setTime(double Time)
	{
		this.Time = Time;
	}
	
}
