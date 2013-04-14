package com.valamburi.henqueen2;
//import com.valamburi.henqueen2.AllConstants.CurrentAction;

import com.valamburi.henqueen2.AllConstants.HenAction;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class GameThread extends Thread implements OnTouchListener,OnGestureListener {
	
	Game game=null;
	SurfaceHolder holder;
	SurfaceView surfaceViewGame=null;
	Activity playScreen=null;
	Hen hen=null;
	Chick chick;
	Cat cat;
	Ant ant=null;
	AntFood antFood;
	Crow crow;
	Kid kid;
	float x;
	float y;
	boolean touched=false;
	GestureDetector gestureDetector;
	Bitmap bitmap;
	//playScreen touch;
	
	GameThread(Game game)
	{
		this.game=game;
		holder=game.holder;
		playScreen=game.playScreenActivity;
		hen=game.hen;
		chick=game.chick;
		cat=game.cat;
		ant=game.ant;
		antFood=game.antFood;
		crow=game.crow;
		kid=game.kid;
		surfaceViewGame=game.surfaceView;
		surfaceViewGame.setOnTouchListener(this);
		gestureDetector=new GestureDetector(this);
		
	}
	public void run()
	{
		int count=0;
		while(game.isRunning && count<150)
		{
			try
			{
				Log.d("HEN", "Run");
				Draw();
				sleep(300);
				count++;
			}
			catch(Exception ex)
			{
				Log.d("HEN", ex.toString());
			}
		}
	}
	public void Draw() throws InterruptedException
	{
		Canvas canvas = null;
        
		try {
            canvas = holder.lockCanvas(null);
            synchronized (holder) {
                Draw(canvas);
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
			//super.onDraw(canvas);
			
	        canvas.drawBitmap(game.bitmapBackground,0,0, new Paint()); 
	        
	        /*Bitmap henCurrentBitmap=null;
	        if(hen.direction.equals(AllConstants.HEN_FRONT))
	        {
	        	henCurrentBitmap=hen.resources.drawables.get(0);
	        }
	        else  
	        {
	        	henCurrentBitmap=hen.resources.drawables.get(1);
	        }*/
	        
	        chick.DoUpdate();
	        canvas.drawBitmap(chick.NextBitmap(), chick.x,chick.y,new Paint());
	     
	        
	        cat.DoUpdate();	        
	        canvas.drawBitmap(cat.NextBitmap(), cat.x,cat.y,new Paint());
	        
	        antFood.DoUpdate();	        
	        canvas.drawBitmap(antFood.NextBitmap(),antFood.x,antFood.y,new Paint());
	        
	        
	        ant.DoUpdate();
	        if(ant.visibility)
	        	canvas.drawBitmap(ant.NextBitmap(), ant.x,ant.y,new Paint());
	        
	        crow.DoUpdate();
	        canvas.drawBitmap(crow.NextBitmap(),crow.x,crow.y,new Paint());
	        
	        kid.DoUpdate();
	        canvas.drawBitmap(kid.NextBitmap(),kid.x,kid.y,new Paint());
	        
	        
	        hen.DoUpdate(game);	        
	        canvas.drawBitmap(hen.NextBitmap(), hen.x, hen.y, new Paint());
	        
	        
		}
		
		
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// TODO Auto-generated method stub
			float touched_x,touched_y;
			//GestureDetector.SimpleOnGestureListener mGestureDetector =new  GestureDetector.SimpleOnGestureListener()
			//{

			   // @Override
			   // public void onLongPress(MotionEvent e) {
			        // do your tasks here
			    	
			   // }
		//	};
			
			
			
		int action=event.getAction();
			Log.d("HEN","touch handled");
			touched_x=event.getX();
			touched_y=event.getY();
			Display display = playScreen.getWindowManager().getDefaultDisplay();
			Point size = new Point();
			display.getSize(size);
//			int screenWidth = size.x;
//			int screenHeight = size.y;
			if(ant.istouched(touched_x,touched_y))
			{
				Log.d("HEN", "Ant touched");
				if(hen.hen_endy<=ant.ant_starty)
				{
					hen.direction=AllConstants.HenDirection.HEN_FRONT;
				}
				else if(hen.hen_starty>=ant.ant_starty)
				{
					hen.direction=AllConstants.HenDirection.HEN_BACK;
				}
				hen.henAction=AllConstants.HenAction.HEN_WALK;
						
			}
			else
			{
				Log.d("HEN", "Ant not touched");
			}
			
        	
			
			//if(hen.y>10 && (ant.y && ant.antWidth)
			
			
			/*
			
			float midX=screenWidth/2;
			float midY=screenHeight/2;
			
			if(hen.henAction==AllConstants.HenAction.HEN_WALK)
			{
			if(touched_y<=midY && hen.direction==AllConstants.HenDirection.HEN_FRONT )
			{
				hen.direction=AllConstants.HenDirection.HEN_BACK;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			else if(touched_y>midY && hen.direction==AllConstants.HenDirection.HEN_BACK)
			{
				hen.direction=AllConstants.HenDirection.HEN_FRONT;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			}
			if(hen.henAction==AllConstants.HenAction.HEN_WALK_WITH_FOOD)
			{
			if(touched_y<=midY && hen.direction==AllConstants.HenDirection.HEN_FRONT )
			{
				hen.direction=AllConstants.HenDirection.HEN_BACK;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			else if(touched_y>midY && hen.direction==AllConstants.HenDirection.HEN_BACK)
			{
				hen.direction=AllConstants.HenDirection.HEN_FRONT;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			}
			if(hen.henAction==AllConstants.HenAction.HEN_EAT_FOOD)
			{
			if(touched_y<=midY && hen.direction==AllConstants.HenDirection.HEN_FRONT )
			{
				hen.direction=AllConstants.HenDirection.HEN_BACK;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			else if(touched_y>midY && hen.direction==AllConstants.HenDirection.HEN_BACK)
			{
				hen.direction=AllConstants.HenDirection.HEN_FRONT;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
				
			}
			}
			
			if(ant.isTouched())
			{
			if(touched_x>=ant.x && touched_y<=ant.y)
			{
				
			}
		}
			if(hen.henAction==AllConstants.HenAction.HEN_FLY)
			{
			if(touched_y<=midY && touched_x<=midX && hen.direction==AllConstants.HenDirection.HEN_FRONT)
			{
				hen.direction=AllConstants.HenDirection.HEN_BACK;
				hen.stepsToMove=0;
				//hen.x=touched_x;
				//hen.y=touched_y;
			}
			else if(touched_y>midY && touched_x<=midX && hen.direction==AllConstants.HenDirection.HEN_BACK)
			{
				hen.direction=AllConstants.HenDirection.HEN_FRONT;
				//hen.x=touched_x;
				//hen.y=touched_y;
			}
			}
			//if(hen.istouched()){
			if(hen.henAction==AllConstants.HenAction.HEN_EAT_FOOD)
			{
			
				if(hen.istouched()){
				if(touched_y<=midY && hen.direction==AllConstants.HenDirection.HEN_FRONT )
				{
					hen.direction=AllConstants.HenDirection.HEN_BACK;
					
					//hen.x=touched_x;
					//hen.y=touched_y;
					
				}
				else if(touched_y>midY && hen.direction==AllConstants.HenDirection.HEN_BACK)
				{
					hen.direction=AllConstants.HenDirection.HEN_FRONT;
					
					//hen.x=touched_x;
					//hen.y=touched_y;
					
				}
				
				
			}
			}*/
			if(action==MotionEvent.ACTION_DOWN){
//				if(hen.direction.equals(AllConstants.HEN_BACK))
//				{
//					hen.y-=10;
//				
//				}else if(hen.direction.equals(AllConstants.HEN_FRONT))
//				{
//					hen.y+=10;
//				}
//				
//				hen.henAction=AllConstants.HenAction.HEN_WALK;
//				hen.henAction=AllConstants.HenAction.HEN_EAT_FOOD;
//				hen.henAction=AllConstants.HenAction.HEN_WALK_WITH_FOOD;
				
				//mGestureDetector.onLongPress(event);	
			}
			if(action==MotionEvent.ACTION_MOVE)
			{
				
				
				//hen.x=touched_x;
				//hen.y=touched_y;
			/*if(hen.x>=touched_x)
			{
			hen.x--;	
			}*/
			//hen.stepsToMove=5;
			
			}
		
			return gestureDetector.onTouchEvent(event);
		}
		
		@Override
		public boolean onDown(MotionEvent arg0) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			Log.d("HEN","fling handled");
			hen.henAction=AllConstants.HenAction.HEN_FLY;
			
			return false;
		}
		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public void onShowPress(MotionEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return false;
		}
		
	
		

	}
	

