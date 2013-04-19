package com.valamburi.henqueen2;

import java.util.LinkedList;
import java.util.Random;

import android.graphics.Bitmap;
import android.util.Log;

public class Ant extends GameScreenObject {
	public String antDirection;
	int nextIndex;
	
	float ant_endx,ant_endy,ant_startx,ant_starty;
	float antWidth,antHeight;
	Hen hen;
	
	
	Ant(float x,float y,String antDirection)
	{
		this.x=x;
		this.y=y;
		this.antDirection=antDirection;
		nextIndex=0;
		
	}
	
		
	
	public void Move(Game game)
	{
		
		 if(antDirection==AllConstants.ANT_FRONT)
			{			 
				y+=5;
				if(y>game.screenHeight)
					randomize(game);
			}else if(antDirection==AllConstants.ANT_BACK)
			{	
				y-=5;
				if(y<0)
					randomize(game);
			}
			
		
	}
	public void DoUpdate(Game game)
	{
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.ANT_FRONT,0);
		antWidth=bitmap.getWidth();
		antHeight=bitmap.getHeight();
		ant_startx=x;
		ant_starty=y;
		ant_endx=x+antWidth;
		ant_endy=y+antHeight;
		Move(game);
	}
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(antDirection);
		
		
	}
	public boolean istouched(float tx,float ty){
		// TODO Auto-generated method stub
		
	
		
		Log.d("HEN", "Inside Ant istouched");
		
		if(tx>=ant_startx && tx<=ant_endx && ty>=ant_starty && ty<=ant_endy)
		{
			return true;
		}
		return false;
		
		
	}
	
	public void randomize(Game game)
	{
		Random rm=new Random();
		int random=rm.nextInt(300);
		
		if(rm.nextInt(100)>50)
		{			
			y=game.screenHeight+random;
			Log.d("nextAnt", "walking back");
			antDirection=AllConstants.ANT_BACK;			
			
		} else 
		{
			 
			y=0-random;
			Log.d("nextAnt", "walking front");
			antDirection=AllConstants.ANT_FRONT;				
		}
		visibility=true;
		
	}

}
