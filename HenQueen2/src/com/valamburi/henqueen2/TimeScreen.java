package com.valamburi.henqueen2;

import java.util.TimerTask;

public class TimeScreen extends TimerTask {
	Game game;
	TimeScreen(Game game)
     {
    	this.game=game; 
     }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		game.isRunning=false;
	}

}
