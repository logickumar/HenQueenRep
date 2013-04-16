package com.valamburi.henqueen2;

import java.util.LinkedList;

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
	
		
	
	public void Move()
	{
		int stepsToMove=1;
		if(stepsToMove>0)
		{
			if(antDirection==AllConstants.ANT_FRONT)
			{
				y++;
			}else
			{
				y--;
			}
			stepsToMove++;
		}
		
	}
	public void DoUpdate()
	{
		Move();
	}
	public Bitmap NextBitmap()
	{
		return GetNextBitmap(antDirection);
		
		
	}
	public boolean istouched(float tx,float ty){
		// TODO Auto-generated method stub
		
		Bitmap bitmap;
		bitmap=GetBitmapByIndex(AllConstants.ANT_FRONT,0);
		antWidth=bitmap.getWidth();
		antHeight=bitmap.getHeight();
		ant_startx=x;
		ant_starty=y;
		ant_endx=x+antWidth;
		ant_endy=y+antHeight;
		
		Log.d("HEN", "Inside Ant istouched");
		
		if(tx>=ant_startx && tx<=ant_endx && ty>=ant_starty && ty<=ant_endy)
		{
			return true;
		}
		return false;
		
		
	}

}
