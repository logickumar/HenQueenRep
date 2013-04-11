package com.valamburi.henqueen2;

import android.graphics.Bitmap;

public class Crow extends GameScreenObject {
	public AllConstants.CrowDirection crowDirection;
	int nextIndex;
	Crow(float x,float y,AllConstants.CrowDirection crowDirection)
	{
		this.x=x;
		this.y=y;
		this.crowDirection=crowDirection;
		nextIndex=0;
	}
	public void DoUpdate()
	{
		Move();
	}
	public void Move()
	{
		//int stepsToMove=0;
		if(crowDirection==AllConstants.CrowDirection.CROW_DOWN){
			x-=7;
			y+=7;
		}
		else
		{
			y+=7;
			x-=7;
			
		}
	}
	public Bitmap NextBitmap()
	{
		Bitmap bitmapNext = null;
		if(crowDirection==AllConstants.CrowDirection.CROW_DOWN)
		{
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
		}
		/*else
		{
			if(nextIndex==2)
			{
				bitmapNext=resources.drawables.get(nextIndex);
				nextIndex=3;
			}
			else
			
			{
				bitmapNext=resources.drawables.get(nextIndex);
				nextIndex=2;
			}
		}
		*/
		return bitmapNext;
	}

}
