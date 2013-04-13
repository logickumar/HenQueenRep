package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Ant extends GameScreenObject {
	public AllConstants.AntDirection antDirection;
	int nextIndex;
	Bitmap bitmap;
	float ant_endx,ant_endy,ant_startx,ant_starty;
	float antWidth,antHeight;
	Hen hen;
	//public boolean isTouched=false;
	//float hen_startx,hen_starty,hen_endx,hen_endy;
	Ant(float x,float y,AllConstants.AntDirection antDirection)
	{
		this.x=x;
		this.y=y;
		this.antDirection=antDirection;
		nextIndex=0;
		//hen_startx=0;
		//hen_starty=0;
		//hen_endx=0;
		//hen_endy=0;
	}
	
		
	
	public void Move()
	{
		int stepsToMove=1;
		if(stepsToMove>0)
		{
			if(antDirection==AllConstants.AntDirection.ANT_FRONT)
			{
				y++;
			}else
			{
				y--;
			}
			stepsToMove++;
		}
		/*if(hen.henAction==AllConstants.HenAction.HEN_EAT_FOOD)
		{
			if(nextIndex==0)
			{
				resources.drawables.remove(nextIndex);
				nextIndex=1;
			}
			else
			{
				resources.drawables.remove(nextIndex);
			
			}
		}*/
	}
	public void DoUpdate()
	{
		Move();
	}
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext;
		if(nextIndex==0)
		{
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=1;
		}
		else
		{
			bitmapNext=resources.drawables.get(nextIndex);
			nextIndex=0;
			
		}
		return bitmapNext;
		
	}
	public boolean istouched(float tx,float ty){
		// TODO Auto-generated method stub
		
		bitmap=resources.drawables.get(0);
		antWidth=bitmap.getWidth();
		antHeight=bitmap.getHeight();
		ant_startx=x;
		ant_starty=y;
		ant_endx=x+antWidth+antHeight;
		ant_endy=y+antHeight+antWidth;
		
		if(tx>=ant_startx && tx<=ant_endx && ty>=ant_starty && ty<=ant_endy)
		{
			return true;
		}
		return false;
		
		
	}

}
