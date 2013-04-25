package com.valamburi.henqueen2;

//import com.valamburi.henqueen2.AllConstants.CurrentAction;

//import com.valamburi.henqueen2.AllConstants.HenAction;

import java.util.LinkedList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameThread extends Thread implements OnTouchListener {

	Game game = null;
	SurfaceHolder holder;
	SurfaceView surfaceViewGame = null;
	Activity playScreen = null;
	Hen hen = null;
	Chick chick;
	Cat cat;
	Ant[] ant = null;
	SoundManager soundManager=new SoundManager();
	LinkedList<Integer> soundQueue=new LinkedList<Integer>();
	

	Kid kid;
	float x;
	float y;
	int i = 4;
	ScoreManager scoreManager;
	TimerCalScreen timeCalScreen;
	Coin coin;
	// boolean touched=false;
//	GestureDetector gestureDetector;


	// playScreen touch;

	GameThread(Game game) {
		this.game = game;
		holder = game.holder;
		playScreen = game.playScreenActivity;
		hen = game.hen;
		chick = game.chick;
		cat = game.cat;
		ant = game.ant;
		
		
		
		kid = game.kid;
		surfaceViewGame = game.surfaceView;
		surfaceViewGame.setOnTouchListener(this);
		timeCalScreen=game.timeCalScreen;
		coin=game.coin;
		
		// gestureDetector=new GestureDetector(this);

	}

	public void run() {
	  int count = 0;
	//	timeCalScreen.start();
		while (game.isRunning && count < 1000) 
			{
			try {
				Log.d("HEN", "Run");
				Draw();
				sleep(300);
				count++;
			} catch (Exception ex) {
				Log.d("HEN", ex.toString());
			}
		}
	   //timeCalScreen.stop();
		//Log.d("TIME UPS","time ups");
		AllConstants.SCORE=game.scoreManager.score;
		Intent scoreScreenIntent=new Intent(playScreen, ScoreScreenActivity.class);		
		playScreen.startActivity(scoreScreenIntent);
	}

	
	

	public void Draw() throws InterruptedException {
		Canvas canvas = null;

		try {
			canvas = holder.lockCanvas(null);
			synchronized (holder) {
				Draw(canvas);
				PlaySounds();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (canvas != null) {
				holder.unlockCanvasAndPost(canvas);
			}
		}
	}

	private void Draw(Canvas canvas) {
		// TODO Auto-generated method stub
		// super.onDraw(canvas);

		canvas.drawBitmap(game.bitmapBackground, 0, 0, new Paint());

		/*
		 * Bitmap henCurrentBitmap=null;
		 * if(hen.direction.equals(AllConstants.HEN_FRONT)) {
		 * henCurrentBitmap=hen.resources.drawables.get(0); } else {
		 * henCurrentBitmap=hen.resources.drawables.get(1); }
		 */

		chick.DoUpdate();
		canvas.drawBitmap(chick.NextBitmap(), chick.x, chick.y, new Paint());		
		
		cat.DoUpdate(game);
		canvas.drawBitmap(cat.NextBitmap(), cat.x, cat.y, new Paint());
		
		for(int i=0;i<4;i++)
		{
		if(ant[i].visibility)
		{
						
			
			ant[i].DoUpdate(game);
			canvas.drawBitmap(ant[i].NextBitmap(), ant[i].x, ant[i].y, new Paint());
		}
		}
		
		

		kid.DoUpdate(game);
		canvas.drawBitmap(kid.NextBitmap(), kid.x, kid.y, new Paint());

		
		hen.DoUpdate(game);
		canvas.drawBitmap(hen.NextBitmap(), hen.x, hen.y, new Paint());
		if(coin.visibility){
		coin.DoUpdate(game);
		canvas.drawBitmap(coin.NextBitmap(),coin.x,coin.y,new Paint());
		}
		

	}
	
	private void PlaySounds()
	{
		if(!soundQueue.isEmpty())
		{
			soundManager.play(playScreen.getBaseContext(),soundQueue.remove());
		}
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		
		float touched_x, touched_y;
		int action = event.getAction();
		Log.d("HEN", "touch handled");
		touched_x = event.getX();
		touched_y = event.getY();
	//	Display display = playScreen.getWindowManager().getDefaultDisplay();
	//	Point size = new Point();
	//	display.getSize(size);
		//game.screenwidth=200;
		
		if (action == MotionEvent.ACTION_DOWN)
		{
          for(int i=0;i<4;i++)
          {
			if (ant[i].istouched(touched_x, touched_y))
			{
				Log.d("HEN", "Ant touched");
				if (hen.hen_endy <= ant[i].ant_starty)
				{
					//hen.direction = AllConstants.HEN_FRONT;
					hen.henAction = AllConstants.HEN_WALK_FRONT;
					
				} 
				else if (hen.hen_starty >= ant[i].ant_starty)
				{
					//hen.direction = AllConstants.HEN_BACK;
					hen.henAction = AllConstants.HEN_WALK_BACK;
				}
				hen.targetAntIndex=i;
				hen.target=AllConstants.HEN_TARGET_ANT;			
				Log.d("HEN", "Hen Walk assigned");
				break;
			} 
			else 
			{
				Log.d("HEN", "Ant not touched");
			}
          }
		
			
			if (cat.istouched(touched_x, touched_y))
			{
				Log.d("HEN", "Cat touched");
				if (hen.hen_endy <= cat.cat_starty)
				{
					//hen.direction = AllConstants.HEN_FRONT;
					hen.henAction = AllConstants.HEN_WALK_FRONT;
				} 
				else if (hen.hen_starty >= cat.cat_starty) 
				{
					//hen.direction = AllConstants.HEN_BACK;
					hen.henAction = AllConstants.HEN_WALK_BACK;
				}
				hen.target=AllConstants.HEN_TARGET_CAT;			
				Log.d("HEN", "Hen Walk assigned");
				Log.d("HEN", hen.henAction);
				

			}
			else 
			{
				Log.d("HEN", "Cat not touched");
			}	
          
		   	
		if (kid.istouched(touched_x, touched_y))
		{
			Log.d("HEN", "kid touched");
			if (hen.hen_endy <= kid.kid_starty)
			{
				//hen.direction = AllConstants.HEN_FRONT;
				hen.henAction = AllConstants.HEN_WALK_FRONT;
			} 
			else if (hen.hen_starty >= kid.kid_starty) 
			{
				//hen.direction = AllConstants.HEN_BACK;
				hen.henAction = AllConstants.HEN_WALK_BACK;
			}
			hen.target=AllConstants.HEN_TARGET_KID;			
			Log.d("HEN", "Hen Walk assigned");
			Log.d("HEN", hen.henAction);

			} 
		else 
		{
		Log.d("HEN", "kid not touched");
	    }	
		}
	   
		
		return false;
		
	}

	

	

}
