package com.valamburi.henqueen2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.Window;

public class PlayScreenctivity extends Activity implements Callback {
	SurfaceView surfaceViewGame;
	SurfaceHolder holder;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
	     getActionBar().hide();
		setContentView(R.layout.activity_play_screenctivity);
		surfaceViewGame = (SurfaceView)findViewById(R.id.surfaceViewGame);
		surfaceViewGame.setZOrderOnTop(true);
		surfaceViewGame.getHolder().addCallback(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.play_screenctivity, menu);
		return true;
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub
		 
     
		
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		Game game=new Game(this,holder,surfaceViewGame);
	     game.StartGame();
        
	}


	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub
		
	}
		 

}

