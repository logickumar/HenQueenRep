package com.valamburi.henqueen2;

import java.util.Timer;

public class TimerCalScreen {
	Timer timer=new Timer();
	 Game game;
	 TimeScreen timeScreen;
		
	 TimerCalScreen(Game game)
	 {
		 timeScreen=new TimeScreen(game);
	 }
	
	public void start()
	{
		timer.schedule(timeScreen,60000);
	}
	public void stop()
	{
		//timer.schedule(timeScreen,-1);
		timer.cancel();
	}
	
	public void Reset()
	{
		start();
	}

}
